package ru.eleventh.jarsoft.service;

import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eleventh.jarsoft.model.Banner;
import ru.eleventh.jarsoft.model.Request;
import ru.eleventh.jarsoft.model.RequestRepository;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public Boolean isBannerShown(Banner banner) {
        return requestRepository.countAllByBannerId(banner.getId()) != 0;
    }

    public void createRequest(Banner banner, HttpServletRequest requestEntity) {
        Request request = new Request(banner,
                                      requestEntity.getHeader("User-Agent"),
                                      requestEntity.getRemoteAddr(),
                                      LocalDate.now());
        requestRepository.save(request);
    }

    public List<Request> getRequests() {
        return requestRepository.findAll();
    }
}
