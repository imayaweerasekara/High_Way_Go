package lk.ijse.highwaygo_backend.entity;

import jakarta.persistence.*;
import lk.ijse.highwaygo_backend.Enum.SeatType;
import lombok.*;

@Entity
@Table(name = "seats")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    private Bus bus;

    @Column(nullable = false)
    private String seatNumber; // Example: A1, A2, B1, B2

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatType seatType; // Example: REGULAR, WINDOW, VIP

    @Column(nullable = false)
    private boolean isBooked = false;

}
