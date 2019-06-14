package de.brauls.example.j9modex.app;

import de.brauls.example.j9modex.greeting.GreetingService;
import de.brauls.example.j9modex.usermanagement.UserService;
import de.brauls.example.j9modex.usermanagement.dto.UserDto;
import de.brauls.example.j9modex.usermanagement.exception.UserAlreadyExistsException;

public final class Application {
    private static final String USER_A = "Beatrix";

    private static UserService userServiceInUserManagement;
    private static GreetingService greetingService;

    public static void main(final String args[]) {
        initServices();

        try {
            createInitialUsers();
        } catch (UserAlreadyExistsException e) {
            System.out.println("Could not create initial users");
        }

        System.out.println(greetingService.greet());
        System.out.println(greetingService.greet(USER_A));
    }

    private static void initServices() {
        userServiceInUserManagement = UserService.retrieveUserService();

        final var userServiceForGreeting = new UserServiceImpl(userServiceInUserManagement);
        greetingService = new GreetingService(userServiceForGreeting);
    }

    private static void createInitialUsers() throws UserAlreadyExistsException {
        final var userA = new UserDto(USER_A);
        userServiceInUserManagement.addUser(userA);
    }
}
