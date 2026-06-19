package com.tutorialseu.userprofileapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserProfileController {

    // List to store user profiles
    private List<UserProfile> profiles;

    // Initialize the user profiles on application start
    @PostConstruct
    public void init() {
        profiles = new ArrayList<>();
        profiles.add(new UserProfile("johndoe", 30, "johndoe@example.com", "USA"));
        profiles.add(new UserProfile("janedoe", 25, "janedoe@example.com", "Canada"));
        profiles.add(new UserProfile("alexsmith", 35, "alexsmith@example.com", "UK"));
    }

    // Get user profile by username
    @GetMapping("/users/{username}")
    public ResponseEntity<String> getUserProfileByUsername(@PathVariable String username) {
        // Find user by username
        UserProfile profile = profiles.stream()
                .filter(p -> p.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElse(null);

        // Return user details or error message
        if (profile != null) {
            return new ResponseEntity<>("Username: " + profile.getUsername() + ", Age: " + profile.getAge() +
                    ", Email: " + profile.getEmail() + ", Country: " + profile.getCountry(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

    // List profiles filtered by age
    @GetMapping("/users")
    public ResponseEntity<String> listProfilesByAge(@RequestParam(required = false) Integer age) {
        List<UserProfile> filteredProfiles;

        // Filter by age if provided
        if (age != null) {
            filteredProfiles = profiles.stream()
                    .filter(p -> p.getAge() == age)
                    .collect(Collectors.toList());
        } else {
            filteredProfiles = profiles;
        }

        // Build and return a string response
        StringBuilder response = new StringBuilder();
        for (UserProfile profile : filteredProfiles) {
            response.append("Username: ").append(profile.getUsername())
                    .append(", Age: ").append(profile.getAge())
                    .append(", Email: ").append(profile.getEmail())
                    .append(", Country: ").append(profile.getCountry())
                    .append("\n");
        }

        return !response.isEmpty() ? new ResponseEntity<>(response.toString(), HttpStatus.OK)  : new ResponseEntity<>("No users found", HttpStatus.NOT_FOUND);
    }
}