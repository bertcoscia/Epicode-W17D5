package bertcoscia.Epicode_W17D5.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    @Setter(AccessLevel.NONE)
    private UUID idUser;
    private String name;
    private String surname;
    private String username;
    private String email;

}
