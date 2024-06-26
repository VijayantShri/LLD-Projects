package com.app.parkinglot.services;

import com.app.parkinglot.models.ParkingLot;
import com.app.parkinglot.models.ParkingSpot;
import com.app.parkinglot.repository.ParkingLotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ParkingLotService {

    private ParkingSpotService  parkingSpotService;
    private ParkingLotRepository parkingLotRepository;

    public ParkingSpot createParkingSpot(ParkingSpot parkingSpot) {
        return  null;
    }

    public ParkingLot create(ParkingLot parkingLot) {
        ParkingLot persistedLot = parkingLotRepository.save(parkingLot);
        parkingSpotService.createParkingSpots(persistedLot);
        return persistedLot;
    }
}
