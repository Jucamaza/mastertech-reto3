package co.usa.spring_reto3.reto3.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.spring_reto3.reto3.model.Clients;
import co.usa.spring_reto3.reto3.repositories.crud.ClientCrudRepository;

@Repository
public class ClientsRepository {
    @Autowired
    ClientCrudRepository clientCrudRepository;

    public List<Clients> getAll() {
        return (List<Clients>) clientCrudRepository.findAll();
    }

    public Optional<Clients> getClient(int id) {
        return clientCrudRepository.findById(id);
    }

    public Clients save(Clients c) {
        return clientCrudRepository.save(c);
    }
}