package lk.ijse.highwaygo_backend.service;

import lk.ijse.highwaygo_backend.dto.TicketBookingDTO;

import java.util.List;
import java.util.Optional;

public interface TicketBookingService {

    // Method to save a new ticket booking
    TicketBookingDTO saveTicketBooking(TicketBookingDTO ticketBookingDTO);

    // Method to get all ticket bookings
    List<TicketBookingDTO> getAllTicketBookings();

    // Method to find a ticket booking by its ID
    Optional<TicketBookingDTO> getTicketBookingById(String id);

    // Method to find a ticket booking by passenger ID
    Optional<TicketBookingDTO> getTicketBookingByPassengerId(String passengerId);

    // Method to find a ticket booking by route ID
    Optional<TicketBookingDTO> getTicketBookingByRouteId(String routeId);

    // Method to find a ticket booking by seat ID
    Optional<TicketBookingDTO> getTicketBookingBySeatId(String seatId);

    // Method to update ticket booking (e.g., confirm booking, change status, etc.)
    TicketBookingDTO updateTicketBooking(String id, TicketBookingDTO ticketBookingDTO);

    // Method to delete a ticket booking by its ID
    void deleteTicketBooking(String id);
}
