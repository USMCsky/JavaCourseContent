package com.tutorialseu.expensetracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Expense {

    @JsonProperty("expenseType")
    private int expenseType; // 1 for Income, 0 for Expenditure

    @JsonProperty("date")
    private String date; // Format: YYYY-MM-DD

    @JsonProperty("amount")
    private double amount;

    @JsonProperty("category")
    private String category;

    @JsonProperty("account")
    private String account;

    @JsonProperty("note")
    private String note; // Optional
}