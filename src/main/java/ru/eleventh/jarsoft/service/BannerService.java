package ru.eleventh.jarsoft.service;

import java.util.List;
import java.util.Optional;
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

    public void createBanner(Banner banner) {
        bannerRepository.save(banner);
    }

    public Optional<Banner> getBannerById(Long id) {
        return bannerRepository.findById(id);
    }

    public List<Banner> getBanners() {
        return bannerRepository.findAll();
    }

    public void updateBanner(Banner b) {
        Banner banner = bannerRepository.getOne(b.getId());
        banner.setName(b.getName());
        banner.setPrice(b.getPrice());
        banner.setContent(b.getContent());
        banner.setDeleted(b.getDeleted());
        bannerRepository.save(b);
    }

    public void deleteBanner(Long id) {
        bannerRepository.deleteById(id);
    }

}
