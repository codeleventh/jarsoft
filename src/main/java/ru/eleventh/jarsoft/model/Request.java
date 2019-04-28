package ru.eleventh.jarsoft.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Request {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Banner banner;

    private String userAgent;

    private String ip;

    private LocalDate date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Banner getBanner() {
        return banner;
    }

    public void setBanner(Banner banner) {
        this.banner = banner;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Request() {
    }

    public Request(Banner banner, String userAgent, String ip, LocalDate date) {
        this.banner = banner;
        this.userAgent = userAgent;
        this.ip = ip;
        this.date = date;
    }
}
