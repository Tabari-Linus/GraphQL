package com.example.demo.controller;

import com.example.demo.dtos.ApiResponse;
import com.example.demo.dtos.CreateExpenseInput;
import com.example.demo.dtos.ExpenseResult;
import com.example.demo.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @MutationMapping("createExpense")
    public ApiResponse<ExpenseResult> createExpense(@Argument CreateExpenseInput input){
        return ApiResponse.success(expenseService.createExpense(input));
    }
}
