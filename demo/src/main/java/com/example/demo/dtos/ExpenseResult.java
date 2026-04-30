package com.example.demo.dtos;

import com.example.demo.entities.Expense;

import java.math.BigDecimal;
import java.util.List;

public record ExpenseResult(
        Long id,
        String title,
        BigDecimal totalAmount,
        String description,
        List<ItemResult> itemResults
) {
    public static ExpenseResult from(Expense expense) {
        return new ExpenseResult(
                expense.getId(),
                expense.getTitle(),
                expense.getTotalAmount(),
                expense.getDescription(),
                expense.getItems().stream().map(ItemResult::from).toList()
        );
    }
}
