package lk.ijse.highwaygo_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "ticket_bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TicketBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id; // Assuming ID is String, can be changed to Long if needed

    @Column(name = "passenger_id", nullable = false)
    private String passengerId; // Passenger ID (String)

    @Column(name = "route_id", nullable = false)
    private String routeId; // Route ID (String)

    @Column(name = "seat_id", nullable = false)
    private String seatId; // Seat ID (String)

    @Column(name = "booking_time", nullable = false)
    private Date bookingTime;

    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    @Column(name = "payment_status", nullable = false)
    private String paymentStatus; // Example: "PAID", "PENDING"

    @Column(name = "is_confirmed", nullable = false)
    private boolean isConfirmed;

    // Getters and setters for all the fields are automatically generated due to @Getter and @Setter annotations


    public void setPasseng(String passengerId) {
        this.passengerId = passengerId;
    }
}
