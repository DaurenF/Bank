package com.example.demo;

import com.example.demo.models.Limit;
import com.example.demo.services.LimitService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LimitTests {
    @Autowired
    private  LimitService limitService;


    @Test
    public void checkLimitValue()  {
        Limit limit = limitService.getLimit(2);
        assertEquals(2000.0, limit.getValue());
    }

    @Test
    public void checkCurrencyShortName() {
        Limit limit = limitService.getLimit(2);
        assertEquals("USD", limit.getLimit_currency_shortname());
    }

    @Test
    public void saveAndCheckLimitValue() {
        Limit limit = new Limit(2500,new Date(), "USD", 2000, "product");
        limitService.save(limit);


        assertEquals(2500, limit.getValue());
    }

}
