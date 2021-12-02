package com.example.warehouse.controller;

import com.example.warehouse.payload.ApiResponse;
import com.example.warehouse.payload.responce.InputDTO;
import com.example.warehouse.repository.InputRepository;
import com.example.warehouse.service.InputService;
import com.example.warehouse.utils.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping("api/input")
public class InputController {

    @Autowired
    InputRepository inputRepository;

    @Autowired
    InputService inputService;

    @PostMapping
    public HttpEntity<?> add(@RequestBody InputDTO inputDTO) throws ParseException {
        ApiResponse response = inputService.add(inputDTO);
        return ResponseEntity.ok(response);
    }


    @GetMapping("/all")
    public HttpEntity<?> getAll(@RequestParam int page, @RequestParam int size) {
        ApiResponse response = inputService.getAll(page, size);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public HttpEntity<?> getById(@PathVariable Integer id) {
        ApiResponse response = inputService.getById(id);
        return ResponseEntity.ok(response);
    }

    //from to
    @GetMapping()
    public HttpEntity<?> getAllFromTO(@RequestParam String from, @RequestParam String to) throws ParseException {
        ApiResponse response = inputService.getAllFromTo(from, to);
        return ResponseEntity.ok(response);
    }

    //kunlik haftalik oylik
    @GetMapping("/searchType") //daily monthly weekly
    public HttpEntity<?> getAllSearchType(@RequestParam String type, @RequestParam String date) throws ParseException {
        ApiResponse response = inputService.getAllSearchType(type, date);
        return ResponseEntity.ok(response);
    }

    //history hamma taminotchi uchun
    @GetMapping("/history") //daily monthly weekly
    public HttpEntity<?> getAllHistoryBySupplier(
            @RequestParam(defaultValue = "0") Integer supplierId,
            @RequestParam(defaultValue = AppConstants.BEGIN_DATE) String from,
            @RequestParam(defaultValue = AppConstants.END_DATE) String to) throws ParseException {
        ApiResponse response = inputService.getAllHistoryType(supplierId, from, to);
        return ResponseEntity.ok(response);
    }


}
