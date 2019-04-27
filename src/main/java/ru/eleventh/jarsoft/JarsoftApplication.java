package ru.eleventh.jarsoft;

import java.time.LocalDate;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import ru.eleventh.jarsoft.model.Banner;
import ru.eleventh.jarsoft.model.BannerRepository;
import ru.eleventh.jarsoft.model.Category;
import ru.eleventh.jarsoft.model.CategoryRepository;
import ru.eleventh.jarsoft.model.Request;
import ru.eleventh.jarsoft.model.RequestRepository;

@SpringBootApplication
public class JarsoftApplication {

    private CategoryRepository categoryRepository;
    private BannerRepository bannerRepository;
    private RequestRepository requestRepository;

    @Component
    public class DataLoader {

        @PostConstruct
        public void initDb() {
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(JarsoftApplication.class, args);
    }

}
