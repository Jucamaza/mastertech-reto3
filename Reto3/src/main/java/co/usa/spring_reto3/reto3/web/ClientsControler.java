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

import co.usa.spring_reto3.reto3.model.Clients;

import co.usa.spring_reto3.reto3.service.ClientsService;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class ClientsControler {

    @Autowired
    ClientsService clientsService;

    @GetMapping("/all")
    public List<Clients> getClients() {
        return clientsService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Clients> getClients(@PathVariable("id") int id) {
        return clientsService.getClients(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Clients saveClients(@RequestBody Clients m) {
        return clientsService.save(m);
    }
}
