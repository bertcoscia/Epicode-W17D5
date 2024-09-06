package bertcoscia.Epicode_W17D5.services;

import bertcoscia.Epicode_W17D5.entities.Prenotazione;
import bertcoscia.Epicode_W17D5.exceptions.NotFoundException;
import bertcoscia.Epicode_W17D5.exceptions.ValidationException;
import bertcoscia.Epicode_W17D5.repositories.PrenotazioniRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Slf4j
public class PrenotazioniService {
    @Autowired
    PrenotazioniRepository prenotazioniRepository;

    public void save(Prenotazione prenotazione) {
        if (prenotazioniRepository.existsByDataPrenotazioneAndUser(prenotazione.getDataPrenotazione(), prenotazione.getUser())) {
            throw new ValidationException("L'utente con email " + prenotazione.getUser().getEmail() + " ha già una prenotazione per il giorno " + prenotazione.getDataPrenotazione());
        }
        prenotazioniRepository.save(prenotazione);
        log.info("Prenotazione n. {} salvata correttamente", prenotazione.getIdPrenotazione());
    }

    public Prenotazione findById(String id) {
        UUID uuid = UUID.fromString(id);
        return prenotazioniRepository.findById(uuid).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(String id) {
        Prenotazione found = this.findById(id);
        prenotazioniRepository.delete(found);
        log.info("Prenotazione n. {} cancellata correttamente", found.getIdPrenotazione());
    }

    public void findByIdAndUpdate(String id, Prenotazione updatedPrenotazione) {
        Prenotazione found = this.findById(id);
        found.setUser(updatedPrenotazione.getUser());
        found.setPostazione(updatedPrenotazione.getPostazione());
        found.setDataPrenotazione(updatedPrenotazione.getDataPrenotazione());
        this.save(found);
        log.info("Prenotazione n. {} aggiornata correttamente.", found.getIdPrenotazione());
    }


    }

