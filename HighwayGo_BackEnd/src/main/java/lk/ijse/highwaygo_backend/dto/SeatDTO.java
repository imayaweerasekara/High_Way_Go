package lk.ijse.highwaygo_backend.dto;

import lk.ijse.highwaygo_backend.Enum.SeatType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor

public class SeatDTO {
    private String id;
    private String busNumber;
    private String seatNumber;
    private SeatType seatType;
    private boolean isBooked;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
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
