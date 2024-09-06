package bertcoscia.Epicode_W17D5.services;

import bertcoscia.Epicode_W17D5.entities.Postazione;
import bertcoscia.Epicode_W17D5.entities.Prenotazione;
import bertcoscia.Epicode_W17D5.enums.PostazioneTipo;
import bertcoscia.Epicode_W17D5.exceptions.NotFoundException;
import bertcoscia.Epicode_W17D5.repositories.PostazioniRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class PostazioniService {
    @Autowired
    PostazioniRepository postazioniRepository;

    public void save(Postazione postazione) {
        postazioniRepository.save(postazione);
        log.info("Postazione {} salvata correttamente.", postazione.getIdPostazione());
    }

    public Postazione findById(String id) {
        UUID uuid = UUID.fromString(id);
        return postazioniRepository.findById(uuid).orElseThrow(() -> new NotFoundException(id));
    }

    public List<Postazione> filterByCity(String city) {
        List<Postazione> list = postazioniRepository.filterByCity(city);
        if (list.isEmpty()) log.info("Non ci sono postazioni per la città richiesta");
        return list;
    }

    public List<Postazione> filterByType(PostazioneTipo postazioneTipo) {
        List<Postazione> list = postazioniRepository.filterByType(postazioneTipo);
        if (list.isEmpty()) log.info("Non ci sono postazioni per il tipo richiesto");
        return list;
    }

    public void findByIdAndDelete(String id) {
        postazioniRepository.delete(this.findById(id));
        log.info("Postazione con id {} correttamente eliminata", id);
    }

    public void findByIdAndUpdate(String id, Postazione updatedPostazione) {
        Postazione found = this.findById(id);
        found.setDescription(updatedPostazione.getDescription());
        found.setTipoPostazione(updatedPostazione.getTipoPostazione());
        found.setEdificio(updatedPostazione.getEdificio());
        found.setMaxPax(updatedPostazione.getMaxPax());
        postazioniRepository.save(found);
    }


}
