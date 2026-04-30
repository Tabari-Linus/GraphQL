package com.example.demo.repositories;

import com.example.demo.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    boolean existsByTitleIgnoreCase(String title);
}
