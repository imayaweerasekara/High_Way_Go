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
    private String id;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
