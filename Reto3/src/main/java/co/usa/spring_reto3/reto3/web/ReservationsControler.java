package co.usa.spring_reto3.reto3.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import co.usa.spring_reto3.reto3.model.Reservations;

import co.usa.spring_reto3.reto3.service.ReservationsService;

@RestController
@RequestMapping("/api/Reservations")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class ReservationsControler {

    @Autowired
    ReservationsService reservationsService;

    @GetMapping("/all")
    public List<Reservations> getReservations() {
        return reservationsService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservations> getReservations(@PathVariable("id") int id) {
        return reservationsService.getReservations(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservations saveReservations(@RequestBody Reservations m) {
        return reservationsService.save(m);
    }
}
