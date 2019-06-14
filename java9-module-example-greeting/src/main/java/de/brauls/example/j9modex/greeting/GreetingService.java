package de.brauls.example.j9modex.greeting;

public class GreetingService {
    private final UserService userService;

    public GreetingService(final UserService userService) {
        this.userService = userService;
    }

    public String greet() {
        return "Hello there!";
    }

    public String greet(final String userName) {
        final boolean userExists = userService.userExists(userName);
        return userExists ? String.format("Hello %s!", userName) : greet();
    }
}
