package co.usa.spring_reto3.reto3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.spring_reto3.reto3.model.Clients;

import java.util.List;
import java.util.Optional;

import co.usa.spring_reto3.reto3.repositories.ClientsRepository;

@Service
public class ClientsService {

    @Autowired
    ClientsRepository clientRepository;

    public List<Clients> getAll() {
        return (List<Clients>) clientRepository.getAll();
    }

    public Optional<Clients> getClients(int id) {
        return clientRepository.getClient(id);
    }

    public Clients save(Clients m) {
        if (m.getIdClient() == null) {
            return clientRepository.save(m);
        } else {
            Optional<Clients> ClientsAdditional = clientRepository.getClient(m.getIdClient());

            if (ClientsAdditional.isEmpty()) {
                return clientRepository.save(m);
            } else {
                return m;
            }
        }
    }
}
