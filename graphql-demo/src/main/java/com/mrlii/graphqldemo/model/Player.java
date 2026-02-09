package com.mrlii.graphqldemo.model;

public record Player(
        Integer id,
        String name,
        Team team
) {
}
