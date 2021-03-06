package de.brauls.example.j9modex.usermanagement;

import java.util.Optional;

import de.brauls.example.j9modex.usermanagement.dto.UserDto;
import de.brauls.example.j9modex.usermanagement.exception.UserAlreadyExistsException;
import de.brauls.example.j9modex.usermanagement.mapper.UserMapper;
import de.brauls.example.j9modex.usermanagement.persistence.UserRepository;
import de.brauls.example.j9modex.usermanagement.persistence.UserRepositoryImpl;

public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    UserService(final UserRepository userRepository, final UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public static UserService retrieveUserService() {
        final var userRepository = new UserRepositoryImpl();
        final var userMapper = new UserMapper();
        return new UserService(userRepository, userMapper);
    }

    public Optional<UserDto> findUser(final String name) {
        final var userEntity = userRepository.findByName(name);
        return userEntity.map(userMapper::userEntityToUserDto);
    }

    public void addUser(final UserDto userDto) throws UserAlreadyExistsException {
        final var userToSave = userMapper.userDtoToUserEntity(userDto);
        userRepository.save(userToSave);
    }
}
