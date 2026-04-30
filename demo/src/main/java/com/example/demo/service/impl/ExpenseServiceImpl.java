package com.example.demo.service.impl;

import com.example.demo.dtos.CreateExpenseInput;
import com.example.demo.dtos.ExpenseResult;
import com.example.demo.entities.Expense;
import com.example.demo.repositories.ExpenseRepository;
import com.example.demo.service.ExpenseService;
import com.example.demo.utils.ExpenseServiceHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final ExpenseServiceHelper expenseServiceHelper;

    @Override
    public ExpenseResult createExpense(CreateExpenseInput createExpenseInput) {
        expenseServiceHelper.validateUniqueExpenseTitle(createExpenseInput.title());
        Expense newExpense = Expense.builder()
                .title(createExpenseInput.title())
                .description(createExpenseInput.description())
                .totalAmount(createExpenseInput.totalAmount())
                .build();
        Expense savedExpense = expenseRepository.save(newExpense);
        return  ExpenseResult.from(savedExpense);
    }
}
