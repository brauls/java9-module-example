package de.brauls.example.j9modex.usermanagement.testutil;

import de.brauls.example.j9modex.usermanagement.dto.UserDto;
import de.brauls.example.j9modex.usermanagement.persistence.UserEntity;

public class UserGenerator {
    private static final String DEFAULT_MAIL_ADDRESS = "user@example.com";

    public static UserEntity generateUserEntity(final String name) {
        return generateUserEntity(name, DEFAULT_MAIL_ADDRESS);
    }

    public static UserEntity generateUserEntity(final String name, final String mailAddress) {
        return new UserEntity(name, mailAddress);
    }

    public static UserDto generateUserDto(final String name, final String mailAddress) {
        return new UserDto(name, mailAddress);
    }
}
