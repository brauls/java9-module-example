package de.brauls.example.j9modex.usermanagement.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    final List<UserEntity> users = new ArrayList<>();

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
