package ru.eleventh.jarsoft.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eleventh.jarsoft.model.Category;
import ru.eleventh.jarsoft.model.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void createCategory(String name) {
        Category category = new Category();
        category.setName(name);
        category.setReqName(name);
        categoryRepository.save(category);
    }

    public void createCategory(String name, String reqName) {
        Category category = new Category();
        category.setName(name);
        category.setReqName(reqName);
        categoryRepository.save(category);
    }

    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public void updateCategory(Long id, String name, String reqName, Boolean deleted) {
        Category category = categoryRepository.getOne(id);
        category.setName(name);
        category.setReqName(reqName);
        category.setDeleted(deleted);
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).get();
        category.setDeleted(true);
        categoryRepository.save(category);
    }

}
