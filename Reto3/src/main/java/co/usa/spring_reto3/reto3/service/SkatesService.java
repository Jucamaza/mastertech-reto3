package co.usa.spring_reto3.reto3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.spring_reto3.reto3.model.Skates;

import java.util.List;
import java.util.Optional;

import co.usa.spring_reto3.reto3.repositories.SkatesRepository;

@Service
public class SkatesService {

    @Autowired
    SkatesRepository skatesRepository;

    public List<Skates> getAll() {
        return (List<Skates>) skatesRepository.getAll();
    }

    public Optional<Skates> getSkate(int id) {
        return skatesRepository.getSkate(id);
    }

    public Skates save(Skates p) {
        if (p.getId() == null) {
            return skatesRepository.save(p);
        } else {
            Optional<Skates> skateAdditional = skatesRepository.getSkate(p.getId());

            if (skateAdditional.isEmpty()) {
                return skatesRepository.save(p);
            } else {
                return p;
            }
        }
    }
}
