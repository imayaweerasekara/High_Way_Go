package lk.ijse.highwaygo_backend.dto;

import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor

public class PassengerDTO {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String nic;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }
}
