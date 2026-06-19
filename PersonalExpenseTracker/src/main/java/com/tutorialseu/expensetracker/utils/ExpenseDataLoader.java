package com.tutorialseu.expensetracker.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorialseu.expensetracker.model.Expense;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.io.InputStream;
import java.util.List;

@Component
public class ExpenseDataLoader {

    private static List<Expense> expenses;

    @PostConstruct
    public void init() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getResourceAsStream("/expenses.json");
            expenses = mapper.readValue(is, new TypeReference<List<Expense>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Expense> getExpenses() {
        return expenses;
    }
}