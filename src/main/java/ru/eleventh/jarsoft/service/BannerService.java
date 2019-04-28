package ru.eleventh.jarsoft.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eleventh.jarsoft.BannerException;
import ru.eleventh.jarsoft.model.Banner;
import ru.eleventh.jarsoft.model.BannerRepository;

@Service
public class BannerService {

    @Autowired
    private BannerRepository bannerRepository;

    @Autowired
    CategoryService categoryService;

    public Banner getBannerToDisplay(String category, HttpServletRequest request) throws BannerException {
        String ip = request.getRemoteAddr();
        String userAgent = request.getHeader("User-Agent");

        // TODO: TOP 1 in @Query
        List<Banner> banner = bannerRepository.findOneByCategoryNameOrderByPrice(category, ip, userAgent);
        if (banner.size() != 0) {
            return banner.get(0);
        } else {
            throw new BannerException("No suitable banner was found.");
        }
    }

    public void createBanner(String catName, String name, String content, Float price) {
        Long id = categoryService.getCategoryByName(catName).getId();
        createBanner(id, name, content, price);
    }

    public void createBanner(Long catId, String name, String content, Float price) {
        Banner banner = new Banner();
        banner.setName(name);
        banner.setContent(content);
        banner.setPrice(price);
        banner.setDeleted(false);
        banner.setCategory(categoryService.getCategoryById(catId));
        bannerRepository.save(banner);
    }

    public Banner getBannerById(Long id) {
        return bannerRepository.findById(id).get();
    }

    public List<Banner> getBanners() {
        return bannerRepository.findAll();
    }

    public void updateBanner(Long id, Long catId, String name, String content, Float price, Boolean deleted) {
        Banner banner = bannerRepository.getOne(id);
        banner.setName(name);
        banner.setContent(content);
        banner.setPrice(price);
        banner.setDeleted(deleted);
        banner.setCategory(categoryService.getCategoryById(catId));
        bannerRepository.save(banner);
    }

    public void deleteBanner(Long id) {
        Banner banner = bannerRepository.findById(id).get();
        banner.setDeleted(true);
        bannerRepository.save(banner);
    }

}
