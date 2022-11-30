package com.example.demo;

import com.example.demo.models.Currency;
import com.example.demo.models.Limit;
import com.example.demo.models.Transaction;
import com.example.demo.repositories.CurrencyRepository;
import com.example.demo.repositories.LimitRepository;
import com.example.demo.services.LimitService;
import com.example.demo.services.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionTest {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private LimitRepository limitRepository;
    @Autowired
    private CurrencyRepository currencyRepository;


    @Test
    public void checkTransactionValue()  {
        Transaction transaction = transactionService.getTransactionById(1);
        assertEquals(150000, transaction.getSum());
    }



    @Test
    public void saveAndCheckLimitValue(){
        Transaction transaction = new Transaction(2500, 1234569784,1234567891,"KZT",
                "product", new Date());

        List<Limit> limits =  limitRepository.findByCategory(transaction.getExpense_category());
        Limit limit = limits.get(limits.size()-1);
        transaction.setLimit(limit);
        //Получаем последний курс доллара
        Currency latest_currency = currencyRepository.findTopByOrderByIdDesc();
        //отнимаем от остатка лимита сумму конвертируя тенге в доллары
        limit.setRemaining_usd(limit.getRemaining_usd()-transaction.getSum()/latest_currency.getValue());
        if(limit.getRemaining_usd()<0){
            transaction.setExceeded(true);
        }
        else{
            transaction.setExceeded(false);
        }
        transactionService.save(transaction);
        assertEquals(2500, transaction.getSum());
    }

}