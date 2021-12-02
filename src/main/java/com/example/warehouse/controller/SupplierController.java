package com.example.warehouse.controller;

import com.example.warehouse.entity.Supplier;
import com.example.warehouse.payload.ApiResponse;
import com.example.warehouse.payload.SupplierDTO;
import com.example.warehouse.repository.SupplierRepository;
import com.example.warehouse.service.SupplierServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
//@PreAuthorize(value="hasAuthority(' READ_PRODUCT')")
public class SupplierController {

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    SupplierServise supplierServise;

    @PostMapping
    public HttpEntity<?> add(@RequestBody SupplierDTO supplier) {
        ApiResponse apiResponse = supplierServise.add(supplier);
        return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
    }

    @GetMapping
    public HttpEntity<?> getAll() {
        return ResponseEntity.ok(supplierRepository.findAll());
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        ApiResponse response = supplierServise.getOne(id);
        return ResponseEntity.status(response.isSuccess() ? 200 : 404).body(response);
    }

    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id, @RequestBody Supplier supplier) {
        ApiResponse response = supplierServise.edit(id, supplier);
        return ResponseEntity.status(response.isSuccess() ? 200 : 404).body(response);
    }

    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id) {
        if (!supplierRepository.existsById(id)) return ResponseEntity.ok("Not found!");

        supplierRepository.deleteById(id);
        return ResponseEntity.ok("OK");
    }

    //aupplierId boyicha history

}
