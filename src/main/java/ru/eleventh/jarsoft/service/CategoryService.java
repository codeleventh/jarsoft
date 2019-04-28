package ru.eleventh.jarsoft.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eleventh.jarsoft.model.Category;
import ru.eleventh.jarsoft.model.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void createCategory(Category Category) {
        categoryRepository.save(Category);
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public void updateCategory(Category c) {
        Category category = categoryRepository.getOne(c.getId());
        category.setName(c.getName());
        category.setReqName(c.getReqName());
        category.setBanners(c.getBanners()); // TODO:
        category.setDeleted(c.getDeleted());
        categoryRepository.save(c);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

}
