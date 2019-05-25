package de.brauls.example.usermanagement;

import java.util.Optional;

import de.brauls.example.usermanagement.dto.UserDto;

public class UserService {
    public Optional<UserDto> findUser(final String name) {
        return Optional.empty();
    }

    public void addUser(final String name, final String mailAddress) {

    }
}
