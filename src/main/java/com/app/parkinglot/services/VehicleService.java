package com.app.parkinglot.services;

import com.app.parkinglot.models.Vehicle;
import com.app.parkinglot.models.VehicleType;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    public Vehicle findOrCreate(String vehicleNumber, VehicleType vehicleType) {
        return Vehicle
                .builder()
                .licenseNumber(vehicleNumber)
                .vehicleType(vehicleType)
                .build();
    }
}
