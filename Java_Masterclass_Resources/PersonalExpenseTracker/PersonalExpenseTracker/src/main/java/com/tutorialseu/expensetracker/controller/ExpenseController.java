package com.tutorialseu.expensetracker.controller;

import com.tutorialseu.expensetracker.model.Expense;
import com.tutorialseu.expensetracker.utils.ExpenseDataLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ExpenseController {

    /**
     * Get all expenses for a particular day.
     *
     * @param date The date in YYYY-MM-DD format.
     * @return List of expenses matching the date.
     */
    @GetMapping("/expenses/day/{date}")
    public List<Expense> getExpensesByDay(@PathVariable String date) {
        return ExpenseDataLoader.getExpenses().stream()
                .filter(expense -> expense.getDate().equals(date))
                .collect(Collectors.toList());
    }

    /**
     * Get all expenses for a particular category in a given month.
     *
     * @param category The category of the expense (case-insensitive).
     * @param month    The month in YYYY-MM format.
     * @return List of expenses matching the category and month.
     */
    @GetMapping("/expenses/category/{category}/month")
    public List<Expense> getExpensesByCategoryAndMonth(@PathVariable String category,
                                                       @RequestParam String month) {
        return ExpenseDataLoader.getExpenses().stream()
                .filter(expense -> expense.getCategory().equalsIgnoreCase(category)
                        && expense.getDate().startsWith(month))
                .collect(Collectors.toList());
    }

    /**
     * Get all available expense categories.
     *
     * @return List of distinct categories.
     */
    @GetMapping("/expenses/categories")
    public List<String> getAllExpenseCategories() {
        return ExpenseDataLoader.getExpenses().stream()
                .map(Expense::getCategory)
                .distinct()
                .collect(Collectors.toList());
    }
}