package bertcoscia.Epicode_W17D5.repositories;

import bertcoscia.Epicode_W17D5.entities.Edificio;
import bertcoscia.Epicode_W17D5.entities.Postazione;
import bertcoscia.Epicode_W17D5.entities.Prenotazione;
import bertcoscia.Epicode_W17D5.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazione, UUID> {

    @Query("SELECT p FROM Prenotazione p WHERE p.postazione.edificio = :edificio")
    List<Prenotazione> findByEdificio(@Param("edificio") Edificio edificio);

    @Query("SELECT p FROM Prenotazione p WHERE p.user.idUser = :idUser")
    List<Prenotazione> findByUserId(@Param("idUser") String idUser);

    boolean existsByDataPrenotazioneAndUser(LocalDate dataPrenotazione, User user);

    boolean existsByDataPrenotazioneAndPostazione(LocalDate dataPrenotazione, Postazione postazione);
}
