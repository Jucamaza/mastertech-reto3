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

import co.usa.spring_reto3.reto3.model.Messages;

import co.usa.spring_reto3.reto3.service.MessagesService;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class MessagesControler {

    @Autowired
    MessagesService messagesService;

    @GetMapping("/all")
    public List<Messages> getMessages() {
        return messagesService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Messages> getMessages(@PathVariable("id") int id) {
        return messagesService.getMessages(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Messages saveMessages(@RequestBody Messages m) {
        return messagesService.save(m);
    }
}
