package de.brauls.example.j9modex.usermanagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import de.brauls.example.j9modex.usermanagement.dto.UserDto;
import de.brauls.example.j9modex.usermanagement.mapper.UserMapper;
import de.brauls.example.j9modex.usermanagement.persistence.UserEntity;

class UserMapperTest {
    private static final String NAME = "userA";
    private static final String MAIL_ADDRESS = "userA@example.com";

    private UserMapper userMapper;

    @BeforeEach
    void setUp() {
        userMapper = new UserMapper();
    }

    @Test
    void userEntityToUserDto() {
        final var mappedUserDto = userMapper.userEntityToUserDto(userEntity());
        assertEquals(userDto(), mappedUserDto);
    }

    @Test
    void userDtoToUserEntity() {
        final var mappedUserEntity = userMapper.userDtoToUserEntity(userDto());
        assertEquals(userEntity(), mappedUserEntity);
    }

    private static UserEntity userEntity() {
        return new UserEntity(NAME, MAIL_ADDRESS);
    }

    private static UserDto userDto() {
        return new UserDto(NAME, MAIL_ADDRESS);
    }
}
