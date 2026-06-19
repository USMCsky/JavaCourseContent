package com.tutorialseu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/employee/profile")
    public String employeeProfile() {
        return "Employee Profile: [Name: John Doe, Department: Sales]";
    }

    @GetMapping("/admin/employee-list")
    public String adminEmployeeList() {
        return "Employee List: [Employee 1: John Doe, Employee 2: Jane Doe]";
    }
}