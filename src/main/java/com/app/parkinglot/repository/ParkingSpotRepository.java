package com.app.parkinglot.repository;

import com.app.parkinglot.models.ParkingSpot;
import com.app.parkinglot.models.VehicleType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class ParkingSpotRepository {
    List<ParkingSpot> parkingSpots = new ArrayList<>();

    public ParkingSpot save(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
        return parkingSpot;
    }

    public void saveAll(List<ParkingSpot> spots) {
        System.out.println("Parking Spots: " + spots);
        parkingSpots.addAll(spots);
        System.out.println("Parking Spots: " + parkingSpots);
    }

    public ParkingSpot findAllByParkingLotId(Long id) {
        return null;
    }

    public ParkingSpot findOneByVehicleTypeAndStatusAvailable(VehicleType vehicleType) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.getVehicleType().equals(vehicleType)) {
                return parkingSpot;
            }
        }
        return null;
    }


    public ParkingSpot update(ParkingSpot filledSpot) {
        ParkingSpot currentSpot = parkingSpots
                .stream()
                .filter(spot -> spot.getId().equals(filledSpot.getId()))
                .findFirst()
                .get();

        if (currentSpot == null) {
            throw new RuntimeException("Invalid Parking Spot");
        }

        parkingSpots.remove(currentSpot);
        parkingSpots.add(filledSpot);

        return filledSpot;
    }
}
