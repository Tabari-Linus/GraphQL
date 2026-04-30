package com.example.demo.dtos;

import com.example.demo.entities.Expense;

import java.util.List;

public record ExpenseResult(
        Long id,
        String title,
        String description,
        List<ItemResult> itemResults
) {
    public static ExpenseResult from(Expense expense) {
        return new ExpenseResult(
                expense.getId(),
                expense.getTitle(),
                expense.getDescription(),
                expense.getItems().stream().map(ItemResult::from).toList()
        );
    }
}
