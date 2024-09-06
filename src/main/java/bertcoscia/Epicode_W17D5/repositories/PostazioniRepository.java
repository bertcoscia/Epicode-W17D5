package bertcoscia.Epicode_W17D5.repositories;

import bertcoscia.Epicode_W17D5.entities.Postazione;
import bertcoscia.Epicode_W17D5.enums.PostazioneTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostazioniRepository extends JpaRepository<Postazione, UUID> {

    @Query("SELECT p FROM Postazione p WHERE TO LOWER(p.edificio.city) = :city")
    List<Postazione> filterByCity(String city);

    @Query("SELECT p FROM Postazione p WHERE p.tipoPostazione = :tipoPostazione")
    List<Postazione> filterByType(PostazioneTipo postazioneTipo);
}
