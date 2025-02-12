package com.example.currencyconverter.service;

import com.example.currencyconverter.exception.CurrencyConversionException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService {

    private final Map<String, Double> mockRates = new HashMap<>() {{
        put("USD", 1.0);
        put("EUR", 0.94);
        put("GBP", 0.82);
        put("JPY", 147.0);
    }};


    public Map<String, Double> getExchangeRates(String base) {
        base = base.toUpperCase();
        
        if (!mockRates.containsKey(base)) {
            throw new CurrencyConversionException("Unsupported base currency: " + base);
        }

        double baseRate = mockRates.get(base);
        Map<String, Double> convertedRates = new HashMap<>();
        for (Map.Entry<String, Double> entry : mockRates.entrySet()) {
            convertedRates.put(entry.getKey(), entry.getValue() / baseRate);
        }

        return convertedRates;
    }


    public double convertCurrency(String from, String to, double amount) {
        from = from.toUpperCase();
        to = to.toUpperCase();

        if (amount <= 0) {
            throw new CurrencyConversionException("Amount must be greater than zero.");
        }

        Map<String, Double> rates = getExchangeRates(from);
        
        if (!rates.containsKey(to)) {
            throw new CurrencyConversionException("Invalid target currency: " + to);
        }

        return amount * rates.get(to);
    }
}
