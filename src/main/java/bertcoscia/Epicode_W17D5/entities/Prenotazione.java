package bertcoscia.Epicode_W17D5.entities;

import bertcoscia.Epicode_W17D5.enums.PostazioneTipo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "prenotazioni")
public class Prenotazione {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    @Column(name = "id")
    private UUID idPrenotazione;
    @Column(name = "data_prenotazione")
    private LocalDateTime dataPrenotazione;
    @Column(name = "data_fine_prenotazione")
    private LocalDateTime dataFinePrenotazione;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @ManyToOne
    @JoinColumn(name = "id_postazione")
    private Postazione postazione;

    public Prenotazione(String dataPrenotazione, User user, Postazione postazione) {
        LocalDate dataPrenotazioneParse = LocalDate.parse(dataPrenotazione);
        LocalTime orarioInizioPrenotazione = LocalTime.of(8, 30);
        this.dataPrenotazione = LocalDateTime.of(dataPrenotazioneParse, orarioInizioPrenotazione);
        this.dataFinePrenotazione = this.dataPrenotazione.plusHours(9);
        this.user = user;
        this.postazione = postazione;
    }
}
