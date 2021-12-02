package com.example.warehouse.service;

import com.example.warehouse.entity.Measurement;
import com.example.warehouse.payload.ApiResponse;
import com.example.warehouse.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    MeasurementRepository measurementRepository;

    //Add new Measurement
    public ApiResponse addMeauserement(Measurement measurement) {
        boolean byName = measurementRepository.existsByName(measurement.getName());

        if (byName)
            return new ApiResponse("Given Measurement is already added", false);

        measurementRepository.save(measurement);
        return new ApiResponse("Measurement successfully added", true);
    }

    //Get one Measurement
    public Measurement getOne(Integer id) {
        Optional<Measurement> byId = measurementRepository.findById(id);
        return byId.orElseGet(Measurement::new);
    }

    //Get all Measurement
    public List<Measurement> getAll() {
        return measurementRepository.findAll();
    }


    public ApiResponse edit(Measurement dto, Integer id) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (optionalMeasurement.isPresent()) {

            Measurement measurement = optionalMeasurement.get();
            measurement.setName(dto.getName());

            measurementRepository.save(measurement);
            return new ApiResponse("The Measurement edited", true);

        }

        return new ApiResponse("The Measurement not found", false);
    }

    public ApiResponse delete(Integer id) {
        Optional<Measurement> byId = measurementRepository.findById(id);
        if (byId.isPresent()) {
            Measurement measurement = byId.get();
            measurement.setActive(false);
            measurementRepository.save(measurement);
            return new ApiResponse("Measurement deactivated", true);
        }
        return new ApiResponse("Measurement not found", false);
    }
}
