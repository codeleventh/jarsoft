package ru.eleventh.jarsoft;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.time.LocalDate;
import java.util.ArrayList;
import org.hibernate.validator.constraints.EAN.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.eleventh.jarsoft.model.Banner;
import ru.eleventh.jarsoft.model.BannerRepository;
import ru.eleventh.jarsoft.model.Category;
import ru.eleventh.jarsoft.model.CategoryRepository;
import ru.eleventh.jarsoft.model.Request;
import ru.eleventh.jarsoft.model.RequestRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories
public class ApiTests {

    private MockMvc mockMvc;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BannerRepository bannerRepository;

    @Autowired
    RequestRepository requestRepository;

    @Before
    public void before() {
    }

    @Test
    public void fooTest() {
    }

}
