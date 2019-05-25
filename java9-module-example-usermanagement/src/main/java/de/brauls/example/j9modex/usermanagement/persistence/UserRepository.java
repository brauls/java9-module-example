package de.brauls.example.j9modex.usermanagement.persistence;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<UserEntity> findByName();
    List<UserEntity> findAll();

    void save(final UserEntity userEntity);
}
