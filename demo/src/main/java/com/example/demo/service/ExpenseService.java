package com.example.demo.service;

import com.example.demo.dtos.CreateExpenseInput;
import com.example.demo.dtos.ExpenseResult;

public interface ExpenseService {

    ExpenseResult createExpense(CreateExpenseInput createExpenseInput);
}
