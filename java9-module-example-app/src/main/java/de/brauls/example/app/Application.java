package de.brauls.example.app;

import de.brauls.example.greeting.GreetingService;

public class Application {

    private static final GreetingService greetingService = new GreetingService();

    public static void main(final String args[]) {
        final String greeting = greetingService.greet();
        System.out.println(greeting);
    }
}
