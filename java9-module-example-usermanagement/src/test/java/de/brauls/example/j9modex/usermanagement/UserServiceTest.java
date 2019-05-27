package de.brauls.example.j9modex.usermanagement;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import de.brauls.example.j9modex.usermanagement.dto.UserDto;
import de.brauls.example.j9modex.usermanagement.exception.UserAlreadyExistsException;
import de.brauls.example.j9modex.usermanagement.persistence.UserEntity;
import de.brauls.example.j9modex.usermanagement.persistence.UserRepository;

public class UserServiceTest {
    private static String USER_NAME = "userA";
    private static String MAIL_ADDRESS = "userA@example.com";

    private UserRepository userRepository;
    private UserMapper userMapper;

    private UserService userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userMapper = mock(UserMapper.class);
        userService = new UserService(userRepository, userMapper);
    }

    @Test
    void addUser_callsUserRepositorySave() throws Exception {
        when(userMapper.userDtoToUserEntity(userDto())).thenReturn(userEntity());

        userService.addUser(userDto());
        verify(userRepository).save(userEntity());
    }

    @Test
    void addUser_rethrowsUserAlreadyExistsException() throws Exception {
        when(userMapper.userDtoToUserEntity(userDto())).thenReturn(userEntity());
        doThrow(UserAlreadyExistsException.class).when(userRepository).save(userEntity());

        assertThrows(UserAlreadyExistsException.class, () -> userService.addUser(userDto()));
    }

    @Test
    void findUser_returnsUserFoundInRepository() {
        when(userRepository.findByName(USER_NAME)).thenReturn(Optional.of(userEntity()));
        when(userMapper.userEntityToUserDto(userEntity())).thenReturn(userDto());

        final var foundUser = userService.findUser(USER_NAME);
        assertTrue(foundUser.isPresent());
        assertEquals(userDto(), foundUser.get());
    }

    private static UserDto userDto() {
        return new UserDto(USER_NAME, MAIL_ADDRESS);
    }

    private static UserEntity userEntity() {
        return new UserEntity(USER_NAME, MAIL_ADDRESS);
    }
}
