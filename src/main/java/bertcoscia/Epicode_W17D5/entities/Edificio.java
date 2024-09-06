package bertcoscia.Epicode_W17D5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity(name = "edifici")
public class Edificio {
    @Id
    @GeneratedValue
    @Column(name = "id")
    @Setter(AccessLevel.NONE)
    private UUID idEdificio;
    private String name;
    private String city;
    private String address;

    @Override
    public String toString() {
        return "Edificio{" +
                "id=" + idEdificio +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
