package com.app.parkinglot.services;

import com.app.parkinglot.models.ParkingLot;
import com.app.parkinglot.models.ParkingSpot;
import com.app.parkinglot.models.VehicleType;
import com.app.parkinglot.repository.ParkingSpotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ParkingSpotService {

    private ParkingSpotRepository parkingSpotRepository;

    public void createParkingSpots(ParkingLot lot) {
        List<ParkingSpot> parkingSpots = lot.getFloors()
                .stream()
                .flatMap(floor -> floor.getSpots().stream())
                .collect(Collectors.toList());
        parkingSpotRepository.saveAll(parkingSpots);
    }

    public ParkingSpot allocateSpot(Long parkingLotId, VehicleType vehicleType) {
        return parkingSpotRepository.findOneByVehicleTypeAndStatusAvailable(vehicleType);
    }

    public ParkingSpot updateParkingSpot(ParkingSpot parkingSpot) {
        return parkingSpotRepository.update(parkingSpot);
    }
}
