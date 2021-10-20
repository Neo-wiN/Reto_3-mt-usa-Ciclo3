package com.boat.service;

import com.boat.model.Category;
import com.boat.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  // se encarga de gestionar las operaciones de negocio más importantes a nivel de la aplicación y aglutina llamadas a varios repositorios de forma simultánea 
public class CategoryService {
    @Autowired  //se trata de la anotación que permite inyectar unas dependencias con otras dentro de Spring 
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category category) {
        if (category.getId() == null) {
            return categoryRepository.save(category);
        } else {
            Optional<Category> category1 = categoryRepository.getCategory(category.getId());
            if (category1.isEmpty()) {
                return categoryRepository.save(category);
            } else {
                return category;
            }
        }
    }
}

