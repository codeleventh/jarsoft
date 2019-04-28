package ru.eleventh.jarsoft;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.eleventh.jarsoft.model.BannerRepository;
import ru.eleventh.jarsoft.model.CategoryRepository;
import ru.eleventh.jarsoft.model.RequestRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories
public class ApiTests {

    private MockMvc mockMvc;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BannerRepository bannerRepository;

    @Autowired
    private RequestRepository requestRepository;

    @Before
    public void before() {
    }

    @Test
    public void fooTest() {
    }

}
