package co.usa.spring_reto3.reto3.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.spring_reto3.reto3.model.Reservations;
import co.usa.spring_reto3.reto3.repositories.crud.ReservationsCrudRepository;

@Repository
public class ReservationsRepository {
    @Autowired
    ReservationsCrudRepository reservationsCrudRepository;

    public List<Reservations> getAll() {
        return (List<Reservations>) reservationsCrudRepository.findAll();
    }

    public Optional<Reservations> getReservations(int id) {
        return reservationsCrudRepository.findById(id);
    }

    public Reservations save(Reservations r) {
        return reservationsCrudRepository.save(r);
    }
}
