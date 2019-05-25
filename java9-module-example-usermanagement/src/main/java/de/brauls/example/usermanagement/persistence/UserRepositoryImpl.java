package de.brauls.example.usermanagement.persistence;

import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public Optional<UserEntity> findByName() {
        return Optional.empty();
    }

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public void save(final UserEntity userEntity) {

    }
}
