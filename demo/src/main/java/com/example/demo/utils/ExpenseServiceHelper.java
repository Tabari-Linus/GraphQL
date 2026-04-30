package com.example.demo.utils;

import com.example.demo.exception.InputValidationException;
import com.example.demo.repositories.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExpenseServiceHelper {

    private final ExpenseRepository expenseRepository;

    public  void validateUniqueExpenseTitle(String title){
        if (expenseRepository.existsByTitleIgnoreCase(title)){
            throw new InputValidationException(
                    "An expense with the name '%S' already exists".formatted(title));
        }
    }


}
