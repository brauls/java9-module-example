package de.brauls.example.j9modex.usermanagement.persistence;

import java.util.List;
import java.util.Optional;

import de.brauls.example.j9modex.usermanagement.exception.UserAlreadyExistsException;

public interface UserRepository {
    Optional<UserEntity> findByName(final String name);
    List<UserEntity> findAll();

    void save(final UserEntity userToSave) throws UserAlreadyExistsException;
}
