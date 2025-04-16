package lk.ijse.highwaygo_backend.service.Impl;

import lk.ijse.highwaygo_backend.dto.TicketBookingDTO;
import lk.ijse.highwaygo_backend.entity.TicketBooking;
import lk.ijse.highwaygo_backend.exception.NotFoundException;
import lk.ijse.highwaygo_backend.repo.TicketBookingRepo;
import lk.ijse.highwaygo_backend.service.TicketBookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketBookingServiceImpl implements TicketBookingService {

    @Autowired
    private TicketBookingRepo ticketBookingRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TicketBookingDTO saveTicketBooking(TicketBookingDTO ticketBookingDTO) {
        // Convert DTO to Entity
        TicketBooking ticketBooking = modelMapper.map(ticketBookingDTO, TicketBooking.class);

        // Save the ticket booking to the database
        TicketBooking savedTicketBooking = ticketBookingRepo.save(ticketBooking);

        // Convert the saved entity back to DTO and return
        return modelMapper.map(savedTicketBooking, TicketBookingDTO.class);
    }

    @Override
    public List<TicketBookingDTO> getAllTicketBookings() {
        List<TicketBooking> ticketBookings = ticketBookingRepo.findAll();

        // Convert the list of TicketBooking entities to DTOs
        return ticketBookings.stream()
                .map(ticketBooking -> modelMapper.map(ticketBooking, TicketBookingDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TicketBookingDTO> getTicketBookingById(String id) {
        Optional<TicketBooking> ticketBooking = ticketBookingRepo.findById(id);

        if (ticketBooking.isEmpty()) {
            throw new NotFoundException("TicketBooking not found for ID: " + id);
        }

        // Convert to DTO and return
        return Optional.of(modelMapper.map(ticketBooking.get(), TicketBookingDTO.class));
    }

    @Override
    public Optional<TicketBookingDTO> getTicketBookingByPassengerId(String passengerId) {
        Optional<TicketBooking> ticketBooking = ticketBookingRepo.findByPassengerId(passengerId);

        if (ticketBooking.isEmpty()) {
            throw new NotFoundException("TicketBooking not found for Passenger ID: " + passengerId);
        }

        // Convert to DTO and return
        return Optional.of(modelMapper.map(ticketBooking.get(), TicketBookingDTO.class));
    }

    @Override
    public Optional<TicketBookingDTO> getTicketBookingByRouteId(String routeId) {
        Optional<TicketBooking> ticketBooking = ticketBookingRepo.findByRouteId(routeId);

        if (ticketBooking.isEmpty()) {
            throw new NotFoundException("TicketBooking not found for Route ID: " + routeId);
        }

        // Convert to DTO and return
        return Optional.of(modelMapper.map(ticketBooking.get(), TicketBookingDTO.class));
    }

    @Override
    public Optional<TicketBookingDTO> getTicketBookingBySeatId(String seatId) {
        Optional<TicketBooking> ticketBooking = ticketBookingRepo.findBySeatId(seatId);

        if (ticketBooking.isEmpty()) {
            throw new NotFoundException("TicketBooking not found for Seat ID: " + seatId);
        }

        // Convert to DTO and return
        return Optional.of(modelMapper.map(ticketBooking.get(), TicketBookingDTO.class));
    }

    @Override
    public TicketBookingDTO updateTicketBooking(String id, TicketBookingDTO ticketBookingDTO) {
        TicketBooking existingTicketBooking = ticketBookingRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("TicketBooking not found for ID: " + id));

        // Update the fields
        if (ticketBookingDTO.getPassengerId() != null) {
            existingTicketBooking.setPasseng(ticketBookingDTO.getPassengerId());
        }
        if (ticketBookingDTO.getRouteId() != null) {
            existingTicketBooking.setRouteId(ticketBookingDTO.getRouteId());
        }
        if (ticketBookingDTO.getSeatId() != null) {
            existingTicketBooking.setSeatId(ticketBookingDTO.getSeatId());
        }
        if (ticketBookingDTO.getBookingTime() != null) {
            existingTicketBooking.setBookingTime(ticketBookingDTO.getBookingTime());
        }
        if (ticketBookingDTO.getTotalPrice() != 0) {
            existingTicketBooking.setTotalPrice(ticketBookingDTO.getTotalPrice());
        }
        if (ticketBookingDTO.getPaymentStatus() != null) {
            existingTicketBooking.setPaymentStatus(ticketBookingDTO.getPaymentStatus());
        }
        if (ticketBookingDTO.isConfirmed() != existingTicketBooking.isConfirmed()) {
            existingTicketBooking.setConfirmed(ticketBookingDTO.isConfirmed());
        }

        // Save updated ticket booking to the database
        TicketBooking updatedTicketBooking = ticketBookingRepo.save(existingTicketBooking);

        // Convert to DTO and return
        return modelMapper.map(updatedTicketBooking, TicketBookingDTO.class);
    }

    @Override
    public void deleteTicketBooking(String id) {
        TicketBooking ticketBooking = ticketBookingRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("TicketBooking not found for ID: " + id));

        // Delete the ticket booking
        ticketBookingRepo.delete(ticketBooking);
    }
}
