package com.app.parkinglot.services;

import com.app.parkinglot.dtos.CreateTicketRequest;
import com.app.parkinglot.exceptions.SlotNotAvailableException;
import com.app.parkinglot.models.ParkingSpot;
import com.app.parkinglot.models.SpotStatus;
import com.app.parkinglot.models.Ticket;
import com.app.parkinglot.models.Vehicle;
import com.app.parkinglot.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class TicketService {

    private ParkingSpotService parkingSpotService;
    private VehicleService vehicleService;
    private TicketRepository ticketRepository;

    public Ticket createTicket(CreateTicketRequest ticketRequest) {
        // Spot allocation if available.
        // If spot not available will throw an error.
        ParkingSpot parkingSpot = parkingSpotService.allocateSpot(
                ticketRequest.getParkingLotId(),
                ticketRequest.getVehicleType()
        );

        if (parkingSpot == null) {
            throw new SlotNotAvailableException(ticketRequest.getVehicleType());
        }

        // Update the spot status - FILLED
        parkingSpot.setSpotStatus(SpotStatus.OCCUPIED);

        // Save it in the database.
        ParkingSpot updatedSpot = parkingSpotService.updateParkingSpot(parkingSpot);

        // Fetch or create Vehicle
        // If vehicle number and vehicleType present, use it.
        // else create a new vehicle.
        Vehicle vehicle = vehicleService.findOrCreate(
                ticketRequest.getVehicleNumber(),
                ticketRequest.getVehicleType()
        );

        // Create a ticket and save it.
        Ticket ticket = Ticket
                .builder()
                .entryTime(LocalDateTime.now())
                .parkingSpot(updatedSpot)
                .vehicle(vehicle)
                .entryGateId(ticketRequest.getEntryGateId())
                .build();

        return ticketRepository.save(ticket);
    }
}
