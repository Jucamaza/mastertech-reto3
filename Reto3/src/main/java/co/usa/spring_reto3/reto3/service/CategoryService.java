package co.usa.spring_reto3.reto3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.usa.spring_reto3.reto3.model.Category;

import java.util.List;
import java.util.Optional;

import co.usa.spring_reto3.reto3.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return (List<Category>) categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category c) {
        if (c.getId() == null) {
            return categoryRepository.save(c);
        } else {
            Optional<Category> categoriaAdditional = categoryRepository.getCategory(c.getId());

            if (categoriaAdditional.isEmpty()) {
                return categoryRepository.save(c);
            } else {
                return c;
            }
        }
    }
}
