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

import co.usa.spring_reto3.reto3.model.Skates;

import co.usa.spring_reto3.reto3.service.SkatesService;

@RestController
@RequestMapping("/api/Skate")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class SkatesControler {

    @Autowired
    SkatesService skateService;

    @GetMapping("/all")
    public List<Skates> getSkate() {
        return skateService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Skates> getSkate(@PathVariable("id") int id) {
        return skateService.getSkate(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Skates saveSkate(@RequestBody Skates p) {
        return skateService.save(p);
    }
}
