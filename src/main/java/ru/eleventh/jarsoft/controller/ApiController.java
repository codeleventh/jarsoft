package ru.eleventh.jarsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("banner/{id}")
    public ResponseEntity<?> getBannerById(@PathVariable Long id) {
        return new ResponseEntity<>(bannerService.getBannerById(id), HttpStatus.OK);
    }

    @GetMapping("category")
    public ResponseEntity<?> getCategories() {
        return new ResponseEntity<>(
            categoryService.getCategories(),
            HttpStatus.OK);
    }

    @GetMapping("category/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @GetMapping("request")
    public ResponseEntity<?> getRequests() {
        return new ResponseEntity<>(requestService.getRequests(), HttpStatus.OK);
    }

}
