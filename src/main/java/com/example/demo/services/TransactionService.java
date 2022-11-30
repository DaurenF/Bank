package com.example.demo.services;

import com.example.demo.models.Currency;
import com.example.demo.models.Limit;
import com.example.demo.models.Transaction;
import com.example.demo.repositories.CurrencyRepository;
import com.example.demo.repositories.LimitRepository;
import com.example.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final CurrencyRepository currencyRepository;
    private final LimitRepository limitRepository;
    @Autowired
    public TransactionService(TransactionRepository transactionRepository, CurrencyRepository currencyRepository, LimitRepository limitRepository) {
        this.transactionRepository = transactionRepository;
        this.currencyRepository = currencyRepository;
        this.limitRepository = limitRepository;
    }

    @Transactional
    public void save(Transaction transaction, int limit_id){
        Limit limit =  limitRepository.findById(limit_id).orElse(null);
        transaction.setLimit(limit);
        Currency latest_currency = currencyRepository.findTopByOrderByIdDesc();
        limit.setRemaining_usd(limit.getValue()-latest_currency.getValue()/transaction.getSum());
        if(limit.getRemaining_usd()<0){
            transaction.setExceeded(true);
        }
        else{
            transaction.setExceeded(false);
        }
        transactionRepository.save(transaction);
    }
    @Transactional
    public void save(Transaction transaction){
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
        transactionRepository.save(transaction);
    }
    //Вернуть все транзакций вне лимита
    public List<Transaction> getAllOffLimitTransactions(){
        return transactionRepository.findAllByExceededTrue();
    }
    public Transaction getTransactionById(int id){
        return transactionRepository.findById(id).orElse(null);
    }
}
