package co.usa.spring_reto3.reto3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.spring_reto3.reto3.model.Messages;

import java.util.List;
import java.util.Optional;

import co.usa.spring_reto3.reto3.repositories.MessagesRepository;

@Service
public class MessagesService {

    @Autowired
    MessagesRepository messagesRepository;

    public List<Messages> getAll() {
        return (List<Messages>) messagesRepository.getAll();
    }

    public Optional<Messages> getMessages(int id) {
        return messagesRepository.getMessages(id);
    }

    public Messages save(Messages m) {
        if (m.getId() == null) {
            return messagesRepository.save(m);
        } else {
            Optional<Messages> messagesAdditional = messagesRepository.getMessages(m.getId());

            if (messagesAdditional.isEmpty()) {
                return messagesRepository.save(m);
            } else {
                return m;
            }
        }
    }
}
