package ru.eleventh.jarsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.eleventh.jarsoft.service.BannerService;
import ru.eleventh.jarsoft.service.CategoryService;

@Controller
public class ViewController {

    @Autowired
    private BannerService bannerService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("banner/{id}")
    public String index(Model model, @PathVariable Long id) {
        model.addAttribute("banners", bannerService.getBanners());
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("banner", bannerService.getBannerById(id));
        // TODO: exception handling
        return "banner";
    }

}
