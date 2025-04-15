package lk.ijse.highwaygo_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "buses")
public class Bus {

    @Id
    @Column(nullable = false, unique = true)
    private String busNumber;

    //@Column(nullable = false)
    private String busType; // e.g., AC, Non-AC, Sleeper

    //@Column(nullable = false)
    private int totalSeats;

    //@Column(nullable = false)
    private String operatorName;

    //@Column(nullable = false)
    private String contactNumber;

    //@Column(nullable = false)
    private boolean available = true;

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
