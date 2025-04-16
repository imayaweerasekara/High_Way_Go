package lk.ijse.highwaygo_backend.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class TicketBookingDTO {

    private String id;  // ID as String
    private String passengerId;  // Passenger ID as String
    private String routeId;      // Route ID as String
    private String seatId;       // Seat ID as String
    private LocalDateTime bookingTime;
    private double totalPrice;
    private String paymentStatus;
    private boolean isConfirmed;

    // Constructors, Getters, and Setters

    public TicketBookingDTO() {}

    public TicketBookingDTO(String id, String passengerId, String routeId, String seatId, LocalDateTime bookingTime, double totalPrice, String paymentStatus, boolean isConfirmed) {
        this.id = id;
        this.passengerId = passengerId;
        this.routeId = routeId;
        this.seatId = seatId;
        this.bookingTime = bookingTime;
        this.totalPrice = totalPrice;
        this.paymentStatus = paymentStatus;
        this.isConfirmed = isConfirmed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }
}
