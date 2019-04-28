package ru.eleventh.jarsoft.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.eleventh.jarsoft.BannerException;
import ru.eleventh.jarsoft.model.Banner;
import ru.eleventh.jarsoft.service.BannerService;
import ru.eleventh.jarsoft.service.RequestService;

@Controller
public class BidController {

    @Autowired
    private BannerService bannerService;
    @Autowired
    private RequestService requestService;

    @GetMapping("bid")
    public ResponseEntity getBannerText(@RequestParam("category") String category, HttpServletRequest request) {
        try {
            Banner banner = bannerService.getBannerToDisplay(category, request);
            requestService.createRequest(banner, request);
            return new ResponseEntity<>(banner.getContent(), HttpStatus.OK);
        } catch (BannerException e) {
            return new ResponseEntity<>(HttpStatus.valueOf(204));
        }
    }
}
