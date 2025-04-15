package lk.ijse.highwaygo_backend.entity;

import jakarta.persistence.*;
import lk.ijse.highwaygo_backend.Enum.PaymentStatus;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="payments")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private TicketBooking booking;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String paymentMethod; // Example: CREDIT_CARD, DEBIT_CARD, PAYPAL

    @Column(nullable = false)
    private LocalDateTime paymentTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status; // SUCCESS, FAILED, PENDING
}
