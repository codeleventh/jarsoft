package ru.eleventh.jarsoft.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Request {

    @Id
    @GeneratedValue
    public Long id;

    @JoinColumn
    @ManyToOne
    private Banner banner;

    private String useragent;

    private String ip;

    private LocalDate date;

    public Banner getBanner() {
        return banner;
    }

    public void setBanner(Banner banner) {
        this.banner = banner;
    }

    public String getUseragent() {
        return useragent;
    }

    public void setUseragent(String useragent) {
        this.useragent = useragent;
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

    public Request(Banner banner, String useragent, String ip, LocalDate date) {
        this.banner = banner;
        this.useragent = useragent;
        this.ip = ip;
        this.date = date;
    }
}
