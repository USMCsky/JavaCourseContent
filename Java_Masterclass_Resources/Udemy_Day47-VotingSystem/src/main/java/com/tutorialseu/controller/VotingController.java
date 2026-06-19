package com.tutorialseu.controller;

import com.tutorialseu.security.JwtUtil;
import com.tutorialseu.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class VotingController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private VotingService votingService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) throws AuthenticationException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        if (authentication.isAuthenticated()) {
            return jwtUtil.generateToken(username);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    @PostMapping("/vote")
    public String vote(@RequestParam String candidate, @RequestHeader("Authorization") String token) {
//        String username = jwtUtil.extractUsername(token.substring(7));
        votingService.castVote(candidate);
        return "Vote cast successfully!";
    }

    @GetMapping("/results")
    public Map<String, Integer> getResults(@RequestHeader("Authorization") String token) {
//        String username = jwtUtil.extractUsername(token.substring(7));
        return votingService.getResults();
    }
}
