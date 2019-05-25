package de.brauls.example.j9modex.app;

import de.brauls.example.j9modex.greeting.GreetingService;

public class Application {

    private static final GreetingService greetingService = new GreetingService();

    public static void main(final String args[]) {
        final String greeting = greetingService.greet();
        System.out.println(greeting);
    }
}
