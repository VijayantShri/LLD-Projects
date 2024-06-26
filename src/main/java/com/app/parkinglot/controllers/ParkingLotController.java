package com.app.parkinglot.controllers;

import com.app.parkinglot.models.ParkingLot;
import com.app.parkinglot.services.ParkingLotService;
import com.app.parkinglot.dtos.CreateParkingLotRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

// Step1: Add RestController annotation to tell spring that this class is controller.
@RequestMapping("api/v1/parking-lot")   // Step-2: Map all the request for this URL to this controller.
@RestController
@AllArgsConstructor
public class ParkingLotController {

    // Create parking lot
    // POST

    private ParkingLotService parkingLotService;
    // Create a parking lot
    // POST
    // 1. Request validation
    // 2. Data Transformation
    @PostMapping
    public ParkingLot createParkingLot(@RequestBody CreateParkingLotRequest request) {
        validate(request);
        ParkingLot parkingLot1 = transform(request);
        return parkingLotService.create(parkingLot1);
    }

    @GetMapping("/{id}")    // Step 3: Add method level mapping.
    public ParkingLot getParkingLot(@PathVariable("id") Long id) {
        return ParkingLot.builder().id(id).build();
    }

    private void validate(CreateParkingLotRequest request) {
        if (request.getNumberOfFloors() == null) {
            throw new IllegalArgumentException("Invalid number of floors");
        }
    }

    private ParkingLot transform(CreateParkingLotRequest request) {
        return request.toParkingLot();
    }
}
