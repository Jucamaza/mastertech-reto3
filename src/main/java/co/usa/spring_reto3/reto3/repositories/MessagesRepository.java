package co.usa.spring_reto3.reto3.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.spring_reto3.reto3.model.Messages;
import co.usa.spring_reto3.reto3.repositories.crud.MessagesCrudRepository;

@Repository
public class MessagesRepository {
    @Autowired
    MessagesCrudRepository messagesCrudRepository;

    public List<Messages> getAll() {
        return (List<Messages>) messagesCrudRepository.findAll();
    }

    public Optional<Messages> getMessages(int id) {
        return messagesCrudRepository.findById(id);
    }

    public Messages save(Messages m) {
        return messagesCrudRepository.save(m);
    }
}
