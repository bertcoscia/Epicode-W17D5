package bertcoscia.Epicode_W17D5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

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
    @Column(name = "name", unique = true)
    private String name;
    private String city;
    private String address;

    public Edificio(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

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
