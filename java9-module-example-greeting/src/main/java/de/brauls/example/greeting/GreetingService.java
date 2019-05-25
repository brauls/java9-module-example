package de.brauls.example.greeting;

public class GreetingService {
    public String greet() {
        return "Hello there";
    }

    public String greet(final String userName) {
        return greet();
    }
}
