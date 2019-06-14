package de.brauls.example.j9modex.app;

import de.brauls.example.j9modex.greeting.UserService;

public class UserServiceImpl implements UserService {
    private final de.brauls.example.j9modex.usermanagement.UserService userService;

    UserServiceImpl(final de.brauls.example.j9modex.usermanagement.UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean userExists(final String userName) {
        return userService.findUser(userName).isPresent();
    }
}
