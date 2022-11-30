package com.example.demo.controllers;

import com.example.demo.models.Transaction;
import com.example.demo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/*


EkWPLY28tzq1PGrQnJUTsZnAZXZYz8pL

*/
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable("id") int id, Model model){
        return transactionService.getTransactionById(id);
    }

    @PostMapping("/new_manual")
    public String createNewTransaction(@RequestParam("sum") double sum,
                                     @RequestParam("account_from") int account_from,
                                     @RequestParam("account_to") int account_to,
                                     @RequestParam("expense_category") String expense_category,
                                     @RequestParam("limit_id") int limit_id
                                     ){
        Transaction transaction = new Transaction();
        transaction.setSum(sum);
        transaction.setDate_of_transaction(new Date());
        transaction.setAccount_from(account_from);
        transaction.setAccount_to(account_to);
        transaction.setCurrency_shortname("KZT");
        transaction.setExpense_category(expense_category);
        transactionService.save(transaction,limit_id);

        return "Saved";
    }

    @PostMapping("/new")
    public void createNewTransactionWithoutId(@RequestParam("sum") double sum,
                                     @RequestParam("account_from") int account_from,
                                     @RequestParam("account_to") int account_to,
                                     @RequestParam("expense_category") String expense_category

    ){
        Transaction transaction = new Transaction();
        transaction.setSum(sum);
        transaction.setDate_of_transaction(new Date());
        transaction.setAccount_from(account_from);
        transaction.setAccount_to(account_to);
        transaction.setCurrency_shortname("KZT");
        transaction.setExpense_category(expense_category);
        transactionService.save(transaction);
    }

    @GetMapping("/getOffLimit")
    public List<Transaction> getAllOffLimitTransactions(){
        return transactionService.getAllOffLimitTransactions();
    }

}
