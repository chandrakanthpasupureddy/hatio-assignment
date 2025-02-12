package com.example.currencyconverter.dto;

import lombok.Data;

@Data
public class ConversionRequest {
    private String from;
    private String to;
    private double amount;
}