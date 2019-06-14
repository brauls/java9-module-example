package de.brauls.example.j9modex.usermanagement.mapper;

import de.brauls.example.j9modex.usermanagement.dto.UserDto;
import de.brauls.example.j9modex.usermanagement.persistence.UserEntity;

public class UserMapper {
    public UserDto userEntityToUserDto(final UserEntity userEntity) {
        return new UserDto(userEntity.getName(), userEntity.getMailAddress());
    }

    public UserEntity userDtoToUserEntity(final UserDto userDto) {
        return new UserEntity(userDto.getName(), userDto.getMailAddress().orElse(null));
    }
}
