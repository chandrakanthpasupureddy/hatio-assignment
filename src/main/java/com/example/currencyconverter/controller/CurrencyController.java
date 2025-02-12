package com.example.currencyconverter.controller;

import com.example.currencyconverter.dto.ConversionRequest;
import com.example.currencyconverter.dto.ConversionResponse;
import com.example.currencyconverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/rates")
    public Map<String, Double> getRates(@RequestParam(defaultValue = "USD") String base) {
        return currencyService.getExchangeRates(base);
    }

    @PostMapping("/convert")
    public ConversionResponse convertCurrency(@RequestBody ConversionRequest request) {
        double convertedAmount = currencyService.convertCurrency(
            request.getFrom(), request.getTo(), request.getAmount()
        );
        return new ConversionResponse(
            request.getFrom(), request.getTo(), request.getAmount(), convertedAmount
        );
    }
}
