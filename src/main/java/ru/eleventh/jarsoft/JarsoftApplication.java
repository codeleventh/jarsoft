package ru.eleventh.jarsoft;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import ru.eleventh.jarsoft.service.BannerService;
import ru.eleventh.jarsoft.service.CategoryService;

@SpringBootApplication
public class JarsoftApplication {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BannerService bannerService;

    @Component
    public class DataLoader {
        @PostConstruct
        public void initDb() {
            categoryService.createCategory("music");
            categoryService.createCategory("food");
            categoryService.createCategory("hardware");

            bannerService.createBanner("music", "bon jovi", "New album was released!", 3f);
            bannerService.createBanner("music", "aurora aksnes", "New EP!", 3.2f);
            bannerService.createBanner("music", "oakenford", "Live at MTV show.", 2.45f);

            bannerService.createBanner("food", "hot-dog", "Taste hot-dog!", 0.45f);
            bannerService.createBanner("food", "pie", "Taste pie!", 1f);
            bannerService.createBanner("food", "cola", "Fresh Cola!", 1.2f);
            bannerService.createBanner("food", "whiskey", "Get drunk!", 3f);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(JarsoftApplication.class, args);
    }

}
