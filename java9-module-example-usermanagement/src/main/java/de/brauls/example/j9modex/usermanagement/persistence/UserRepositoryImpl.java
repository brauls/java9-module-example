package de.brauls.example.j9modex.usermanagement.persistence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import de.brauls.example.j9modex.usermanagement.exception.UserAlreadyExistsException;

public class UserRepositoryImpl implements UserRepository {
    private final List<UserEntity> users = new ArrayList<>();

    @Override
    public Optional<UserEntity> findByName(final String name) {
        return users.stream().filter(user -> user.getName().equals(name)).findFirst();
    }

    @Override
    public List<UserEntity> findAll() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public void save(final UserEntity userToSave) throws UserAlreadyExistsException {
        final var userAlreadyExists = users
            .stream().anyMatch(existingUser -> existingUser.getName().equals(userToSave.getName()));
        if (userAlreadyExists) {
            throw new UserAlreadyExistsException(
                String.format("A user with name %s already exists", userToSave.getName()));
        }

        users.add(userToSave);
    }
}
