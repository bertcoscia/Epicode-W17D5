package bertcoscia.Epicode_W17D5.services;

import bertcoscia.Epicode_W17D5.entities.Edificio;
import bertcoscia.Epicode_W17D5.exceptions.NotFoundException;
import bertcoscia.Epicode_W17D5.exceptions.ValidationException;
import bertcoscia.Epicode_W17D5.repositories.EdificiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class EdificiService {
    @Autowired
    EdificiRepository edificiRepository;


    public void save(Edificio edificio) {
        if (edificiRepository.existsByName(edificio.getName())) throw new ValidationException("Esiste gia un edificio con lo stesso nome");
        else edificiRepository.save(edificio);
        log.info("Edificio {} salvato correttamente.", edificio.getName());
    }

    public Edificio findById(String id) {
        UUID uuid = UUID.fromString(id);
        return edificiRepository.findById(uuid).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(String id) {
        Edificio found = this.findById(id);
        edificiRepository.delete(found);
        log.info("Edificio {} eliminato correttamente.", found.getName());
    }

    public void findByIdAndUpdate(String id, Edificio updatedEdificio) {
        Edificio found = this.findById(id);
        found.setName(updatedEdificio.getName());
        found.setCity(updatedEdificio.getCity());
        found.setAddress(updatedEdificio.getAddress());
        edificiRepository.save(found);
        log.info("Edificio {} aggiornato correttamente", found.getName());
    }

    public boolean existsByName(String name) {
        boolean exists = edificiRepository.existsByName(name);
        if (exists) {
            log.info("L'edificio cercato esiste");
        } else {
            log.info("L'edificio cercato non esiste");
        }
        return exists;
    }



}
