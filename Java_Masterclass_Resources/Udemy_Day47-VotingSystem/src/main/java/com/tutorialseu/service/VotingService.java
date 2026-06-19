package com.tutorialseu.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VotingService {

    private Map<String, Integer> votes = new HashMap<>();

    public VotingService() {
        votes.put("Candidate1", 0);  // Initialize the candidates with 0 votes
        votes.put("Candidate2", 0);
    }

    public void castVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
    }

    public Map<String, Integer> getResults() {
        return votes;
    }
}