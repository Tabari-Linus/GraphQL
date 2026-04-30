package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record CreateExpenseInput(
        @NotBlank(message = "Expense Title is required")
        String title,
        String description,
        @NotNull(message = "Total amount is required expense")
        @Positive(message = "Total amount  for expense must be a positive value")
        BigDecimal totalAmount,
        List<ItemInput> itemInputs
) {
}
