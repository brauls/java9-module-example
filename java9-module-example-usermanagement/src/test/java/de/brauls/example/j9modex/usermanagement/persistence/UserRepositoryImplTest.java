package de.brauls.example.j9modex.usermanagement.persistence;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import de.brauls.example.j9modex.usermanagement.exception.UserAlreadyExistsException;
import static de.brauls.example.j9modex.usermanagement.testutil.UserGenerator.generateUserEntity;

class UserRepositoryImplTest {
    private static String[] USER_NAMES = {"userA", "userB", "userC"};

    private UserRepositoryImpl userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepositoryImpl();
    }

    @Test
    void findAll_noUsersExist_returnsEmptyList() {
        final var savedUsers = userRepository.findAll();
        assertEquals(0, savedUsers.size());
    }

    @Test
    void findByName_noUsersExist_returnsEmptyOptional() {
        final var savedUser = userRepository.findByName(USER_NAMES[0]);
        assertFalse(savedUser.isPresent());
    }

    @Test
    void save_noUsersExist_savesUserSuccessfully() throws Exception {
        final var testUser = saveUser(USER_NAMES[0]);

        final var savedUsers = userRepository.findAll();
        assertEquals(1, savedUsers.size());

        final var savedUser = savedUsers.get(0);
        assertEquals(testUser, savedUser);
    }

    @Test
    void save_usersExist_savesUserWithDifferentNameSuccessfully() throws Exception {
        final var testUserA = saveUser(USER_NAMES[0]);
        final var testUserB = saveUser(USER_NAMES[1]);

        final var savedUsers = userRepository.findAll();
        assertEquals(2, savedUsers.size());

        final var savedUserA = savedUsers.get(0);
        assertEquals(testUserA, savedUserA);
        final var savedUserB = savedUsers.get(1);
        assertEquals(testUserB, savedUserB);
    }

    @Test
    void findByName_userExists_returnsOptionalOfThatUser() throws Exception {
        final var testUserA = saveUser(USER_NAMES[0]);
        final var testUserB = saveUser(USER_NAMES[1]);
        final var testUserC = saveUser(USER_NAMES[2]);

        final var savedUser = userRepository.findByName(USER_NAMES[1]);
        assertTrue(savedUser.isPresent());
        assertEquals(testUserB, savedUser.get());
    }

    @Test
    void save_addUserWithAlreadyExistingName_throwsException() throws Exception {
        final var testUserA = saveUser(USER_NAMES[0]);

        assertThrows(UserAlreadyExistsException.class, () -> userRepository.save(testUserA));
    }

    private UserEntity saveUser(final String name) throws Exception {
        final var testUser = generateUserEntity(name);
        userRepository.save(testUser);
        return testUser;
    }
}
