package co.usa.spring_reto3.reto3.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.spring_reto3.reto3.model.Skates;
import co.usa.spring_reto3.reto3.repositories.crud.SkatesCrudRepository;

@Repository
public class SkatesRepository {
    @Autowired
    SkatesCrudRepository skateCrudRepository;

    public List<Skates> getAll() {
        return (List<Skates>) skateCrudRepository.findAll();
    }

    public Optional<Skates> getSkate(int id) {
        return skateCrudRepository.findById(id);
    }

    public Skates save(Skates p) {
        return skateCrudRepository.save(p);
    }
}
