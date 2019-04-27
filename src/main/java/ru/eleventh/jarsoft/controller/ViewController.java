package ru.eleventh.jarsoft.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.eleventh.jarsoft.model.Banner;
import ru.eleventh.jarsoft.model.BannerRepository;

@Controller
public class ViewController {

    @Autowired
    BannerRepository bannerRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "Hello, world!");
        return "index";
    }

}
