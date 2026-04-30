package com.example.demo.dtos;

import com.example.demo.entities.Item;

public record ItemResult(
        Long id,
        String name,
        int quantity,
        double price
) {
    public static ItemResult from(Item item) {
        return new ItemResult(
                item.getId(),
                item.getName(),
                item.getQuantity(),
                item.getPrice());
    }
}
