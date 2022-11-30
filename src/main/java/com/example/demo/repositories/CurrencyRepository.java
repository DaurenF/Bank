package com.example.demo.repositories;

import com.example.demo.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
    Currency findTopByOrderByIdDesc();
}
