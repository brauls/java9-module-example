package de.brauls.example.j9modex.greeting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GreetingServiceTest {
    private static final String USER_NAME = "testUser";

    private UserService userService;
    private GreetingService serviceUnderTest;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        serviceUnderTest = new GreetingService(userService);
    }

    @Test
    void greet_returnsStaticGreeting() {
        final var actualGreeting = serviceUnderTest.greet();
        assertEquals("Hello there!", actualGreeting);
    }

    @Test
    void greet_whenUserNotExists_returnsStaticGreeting() {
        when(userService.userExists(USER_NAME)).thenReturn(false);

        final var actualGreeting = serviceUnderTest.greet(USER_NAME);
        assertEquals("Hello there!", actualGreeting);
    }

    @Test
    void greet_whenUserExists_returnsStaticGreeting() {
        when(userService.userExists(USER_NAME)).thenReturn(true);

        final var actualGreeting = serviceUnderTest.greet(USER_NAME);
        assertEquals(String.format("Hello %s!", USER_NAME), actualGreeting);
    }
}
