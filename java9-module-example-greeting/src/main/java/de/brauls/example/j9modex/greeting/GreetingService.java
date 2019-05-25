package de.brauls.example.j9modex.greeting;

public class GreetingService {
    public String greet() {
        return "Hello there";
    }

    public String greet(final String userName) {
        return greet();
    }
}
