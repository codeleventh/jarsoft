package ru.eleventh.jarsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eleventh.jarsoft.service.BannerService;
import ru.eleventh.jarsoft.service.CategoryService;
import ru.eleventh.jarsoft.service.RequestService;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    BannerService bannerService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    RequestService requestService;

    @GetMapping("banner")
    public ResponseEntity<?> getBanners() {
        return new ResponseEntity<>(
            bannerService.getBanners(),
            HttpStatus.OK);
    }

    @PostMapping("banner")
    public ResponseEntity<?> createBanner(Long catId, String name, String content, Float price, Boolean deleted) {
        bannerService.createBanner(catId, name, content, price);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("banner/{id}")
    public ResponseEntity<?> getBannerById(@PathVariable Long id) {
        return new ResponseEntity<>(bannerService.getBannerById(id), HttpStatus.OK);
    }

    @PutMapping("banner/{id}")
    public ResponseEntity<?> updateBanner(@PathVariable Long id, Long catId, String name, String content, Float
        price, Boolean deleted) {
        bannerService.updateBanner(id, catId, name, content, price, deleted);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("banner/{id}")
    public ResponseEntity<?> deleteBanner(@PathVariable Long id) {
        bannerService.deleteBanner(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("category")
    public ResponseEntity<?> createCategory(String name, String reqName) {
        categoryService.createCategory(name, reqName);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("category")
    public ResponseEntity<?> getCategories() {
        return new ResponseEntity<>(
            categoryService.getCategories(),
            HttpStatus.OK);
    }

    @PutMapping("category/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable Long id, String name, String reqName, Boolean deleted) {
        categoryService.updateCategory(id, name, reqName, deleted);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("category/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @DeleteMapping("category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("request")
    public ResponseEntity<?> getRequests() {
        return new ResponseEntity<>(requestService.getRequests(), HttpStatus.OK);
    }

}
