package com.example.warehouse.service;

import com.example.warehouse.entity.Currency;
import com.example.warehouse.payload.ApiResponse;
import com.example.warehouse.payload.responce.CurrencyDto;
import com.example.warehouse.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    public ApiResponse add(CurrencyDto currencyDto) {
        if (currencyRepository.existsByName(currencyDto.getName())) {
            return new ApiResponse("Bunday Currency mavjud!", false);
        }

        Currency currency = new Currency();
        currency.setName(currencyDto.getName());
        currency.setActive(currencyDto.isActive());
        currencyRepository.save(currency);
        return new ApiResponse("Saved", true);

    }

    public ApiResponse edit(Integer id, CurrencyDto currencyDto) {
        if (!currencyRepository.existsById(id)) {
            return new ApiResponse("Not Found ", false);
        }

        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        optionalCurrency.get().setName(currencyDto.getName());
        optionalCurrency.get().setActive(currencyDto.isActive());
        Currency save = currencyRepository.save(optionalCurrency.get());
        return new ApiResponse("Edited", true);

    }
}
