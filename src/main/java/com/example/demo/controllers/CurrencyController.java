package com.example.demo.controllers;

import com.example.demo.models.Currency;
import com.example.demo.repositories.CurrencyRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@RestController
public class CurrencyController {
    private final CurrencyRepository currencyRepository;
    @Autowired
    public CurrencyController(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @PostMapping("/getCurrency")
    public String getCurrency() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.apilayer.com/currency_data/live?source=USD&currencies=KZT&apikey=EkWPLY28tzq1PGrQnJUTsZnAZXZYz8pL";
        String response = restTemplate.getForObject(url, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode =  objectMapper.readTree(response);
        Currency currency = new Currency();

        String result = jsonNode.get("quotes").get("USDKZT").toString();
        currency.setValue(Double.parseDouble(result));
        currency.setDate_of_value(new Date());
        System.out.println("Current price of USD by KZT: " + result);
        currencyRepository.save(currency);
        return result;
    }
}
