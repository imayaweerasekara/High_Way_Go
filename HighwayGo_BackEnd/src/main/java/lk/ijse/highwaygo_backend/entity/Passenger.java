package lk.ijse.highwaygo_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "passengers")

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String  id;

    //@Column(nullable = false, unique = true)
    private String name;

    //@Column(nullable = false)
    private String email;

    /*//@Column(nullable = false)
    private String fullName;

    //@Column(nullable = false, unique = true)
    private String email;*/

   // @Column(nullable = false, unique = true)
    private String phoneNumber;

   // @Column(nullable = false)
    private String nic;

    private boolean active = true;  // Account status

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
