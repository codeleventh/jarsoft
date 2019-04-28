package ru.eleventh.jarsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.eleventh.jarsoft.model.BannerRepository;

@Controller
public class ViewController {

    @Autowired
    private BannerRepository bannerRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "Hello, world!");
        return "index";
    }

}
