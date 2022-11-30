package com.example.demo.repositories;

import com.example.demo.models.Currency;
import com.example.demo.models.Transaction;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    Transaction findTopByOrderByIdDesc();
    List<Transaction> findAllByExceededTrue();
}
