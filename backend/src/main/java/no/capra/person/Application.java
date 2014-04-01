package no.capra.person;

import org.springframework.boot.SpringApplication;

public class    Application {

    public static void main(String[] args) {
        System.setProperty("spring.profiles.default", "production");
        SpringApplication.run(ApplicationConfig.class, args);
    }

}
