package lk.ijse.highwaygo_backend.entity;

import jakarta.persistence.*;
import lk.ijse.highwaygo_backend.Enum.BookingStatus;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticketBooking")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class TicketBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    private Bus bus;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @Column(nullable = false)
    private LocalDateTime bookingTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookingStatus status; // CONFIRMED, CANCELED, PENDING

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Payment payment;

}
