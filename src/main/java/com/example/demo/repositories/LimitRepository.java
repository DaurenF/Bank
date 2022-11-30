package com.example.demo.repositories;
import com.example.demo.models.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LimitRepository extends JpaRepository<Limit, Integer> {
    Limit findTopByOrderByIdDesc();
    List<Limit> findByCategory(String expense_category);
}
