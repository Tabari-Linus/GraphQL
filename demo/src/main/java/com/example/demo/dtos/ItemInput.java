package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record ItemInput(
        @NotBlank(message = "Item Name is required")
        String name,
        @NotBlank(message = "Item quantity is required")
        @Positive(message = "Item quantity must be a positive value")
        int quantity,
        @NotBlank(message = "Item price is required")
        @Positive(message = "Item price must be a positive value")
        double price
) {
}
