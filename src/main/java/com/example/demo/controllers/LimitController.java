package com.example.demo.controllers;

import com.example.demo.models.Limit;
import com.example.demo.services.LimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/limit")
public class LimitController {
    private final LimitService limitService;
    @Autowired
    public LimitController(LimitService limitService) {
        this.limitService = limitService;
    }
    @GetMapping("/{id}")
    public Limit getLimit(@PathVariable("id") int id){
        return limitService.getLimit(id);
    }

    @PostMapping("/new")
    public String newLimit(@RequestParam ("value") double value, @RequestParam("expense_category") String expense_category){
        Limit limit = new Limit();
        limit.setValue(value);
        limit.setCategory(expense_category);
        limit.setRemaining_usd(value);
        limit.setLimit_currency_shortname("USD");
        limit.setLimit_date_time(new Date());
        limitService.save(limit);
        return "Saved";
    }

    @GetMapping("getAll")
    @QueryMapping
    public List<Limit> getAllLimits(){
        return limitService.getAllLimits();
    }
}
