package ru.eleventh.jarsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.eleventh.jarsoft.model.Banner;
import ru.eleventh.jarsoft.model.BannerRepository;
import ru.eleventh.jarsoft.model.CategoryRepository;
import ru.eleventh.jarsoft.model.RequestRepository;

@RestController
public class ApiController {

    @Autowired
    private BannerRepository bannerRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RequestRepository requestRepository;

    @GetMapping("bid")
    public ResponseEntity getBannerText(@RequestParam("category") String category) {
        Banner banner = bannerRepository.findTopByCategoryNameOrderByPrice(category);
        if (banner != null) {
            return new ResponseEntity(banner.getContent(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.valueOf(204));
        }
    }

}
