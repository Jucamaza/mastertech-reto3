package co.usa.spring_reto3.reto3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.spring_reto3.reto3.model.Reservations;

import java.util.List;
import java.util.Optional;

import co.usa.spring_reto3.reto3.repositories.ReservationsRepository;

@Service
public class ReservationsService {

    @Autowired
    ReservationsRepository reservationsRepository;

    public List<Reservations> getAll() {
        return (List<Reservations>) reservationsRepository.getAll();
    }

    public Optional<Reservations> getReservations(int id) {
        return reservationsRepository.getReservations(id);
    }

    public Reservations save(Reservations r) {
        if (r.getIdReservations() == null) {
            return reservationsRepository.save(r);
        } else {
            Optional<Reservations> ReservationsAdditional = reservationsRepository
                    .getReservations(r.getIdReservations());
            if (ReservationsAdditional.isEmpty()) {
                return reservationsRepository.save(r);
            } else {
                return r;
            }
        }
    }
}