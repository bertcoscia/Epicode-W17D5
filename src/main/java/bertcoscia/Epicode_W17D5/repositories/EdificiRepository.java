package bertcoscia.Epicode_W17D5.repositories;

import bertcoscia.Epicode_W17D5.entities.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EdificiRepository extends JpaRepository<Edificio, UUID> {

    boolean existsByName(String name);

    @Query(value = "SELECT * FROM edifici", nativeQuery = true)
    List<Edificio> findAll();

    List<Edificio> findByCityIgnoreCase(String city);
}
