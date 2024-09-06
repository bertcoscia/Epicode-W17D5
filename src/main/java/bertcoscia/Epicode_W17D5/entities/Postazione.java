package bertcoscia.Epicode_W17D5.entities;

import bertcoscia.Epicode_W17D5.enums.PostazioneTipo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "postazioni")
@NoArgsConstructor
@Getter
@Setter
public class Postazione {
    @Id
    @GeneratedValue
    @Column(name = "id")
    @Setter(AccessLevel.NONE)
    private UUID idPostazione;
    private String description;
    @Enumerated(EnumType.STRING)
    private PostazioneTipo tipoPostazione;
    private int maxPax;
    @ManyToOne
    @JoinColumn(name = "id_edificio", nullable = false)
    private Edificio edificio;

    public Postazione(String description, PostazioneTipo tipoPostazione, Edificio edificio) {
        this.description = description;
        this.tipoPostazione = tipoPostazione;
        this.edificio = edificio;
        if (this.tipoPostazione == PostazioneTipo.PRIVATO) {
            this.maxPax = 1;
        } else if (this.tipoPostazione == PostazioneTipo.OPENSPACE) {
            this.maxPax = 5;
        } else {
            this.maxPax = 10;
        }
    }
}
