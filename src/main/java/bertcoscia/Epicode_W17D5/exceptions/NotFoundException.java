package bertcoscia.Epicode_W17D5.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String id) {
        System.out.println("Record con id " + id + " non trovato");
    }
}
