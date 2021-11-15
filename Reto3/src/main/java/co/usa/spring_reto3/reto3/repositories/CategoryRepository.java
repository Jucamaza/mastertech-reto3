package co.usa.spring_reto3.reto3.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.usa.spring_reto3.reto3.model.Category;
import co.usa.spring_reto3.reto3.repositories.crud.CategoryCrudRepository;

@Repository
public class CategoryRepository {
    @Autowired
    CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll() {
        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryCrudRepository.findById(id);
    }

    public Category save(Category c) {
        return categoryCrudRepository.save(c);
    }
}
