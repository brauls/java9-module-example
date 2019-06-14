package de.brauls.example.j9modex.app;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import de.brauls.example.j9modex.usermanagement.UserService;
import de.brauls.example.j9modex.usermanagement.dto.UserDto;

class UserServiceImplTest {
    private static final String USER_NAME = "testUser";

    private UserService userServiceInUserManagement;
    private UserServiceImpl serviceUnderTest;

    @BeforeEach
    void setUp() {
        userServiceInUserManagement = mock(UserService.class);
        serviceUnderTest = new UserServiceImpl(userServiceInUserManagement);
    }

    @Test
    void userExists_whenNotExistsInUserManagement_returnsFalse() {
        when(userServiceInUserManagement.findUser(USER_NAME)).thenReturn(Optional.empty());
        assertFalse(serviceUnderTest.userExists(USER_NAME));
    }

    @Test
    void userExists_whenExistsInUserManagement_returnsTrue() {
        final var user = new UserDto(USER_NAME);
        when(userServiceInUserManagement.findUser(USER_NAME)).thenReturn(Optional.of(user));
        assertTrue(serviceUnderTest.userExists(USER_NAME));
    }
}
