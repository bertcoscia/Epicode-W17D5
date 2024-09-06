package bertcoscia.Epicode_W17D5.services;

import bertcoscia.Epicode_W17D5.entities.User;
import bertcoscia.Epicode_W17D5.exceptions.NotFoundException;
import bertcoscia.Epicode_W17D5.exceptions.ValidationException;
import bertcoscia.Epicode_W17D5.repositories.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class UsersService {
    @Autowired
    UsersRepository usersRepository;

    public void save(User user) {
        if (usersRepository.existsByEmail(user.getEmail())) throw new ValidationException("Email già esistente");
        if (usersRepository.existsByUsername(user.getUsername())) throw new ValidationException("Username già esistente");
        usersRepository.save(user);
        log.info("Utente con email {} salvato correttamente.", user.getEmail());
    }

    public User findById(String id) {
        UUID uuid = UUID.fromString(id);
        return usersRepository.findById(uuid).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(String id) {
        User found = this.findById(id);
        usersRepository.delete(found);
        log.info("Utente con email {} eliminato correttamente", found.getEmail());
    }

    public void findByIdAndUpdate(String id, User updatedUser) {
        User found = this.findById(id);
        found.setName(updatedUser.getName());
        found.setSurname(updatedUser.getSurname());
        found.setEmail(updatedUser.getEmail());
        found.setUsername(updatedUser.getUsername());
        usersRepository.save(found);
        log.info("Utente con email {} aggiornato correttamente", found.getEmail());
    }
}
