package ru.eleventh.jarsoft.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Category {

    @Id
    @GeneratedValue
    public Long id;

    private String name;

    private String reqName;

    @OneToMany
    private List<Banner> banners;

    private Boolean isDeleted;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName;
    }

    public List<Banner> getBanners() {
        return banners;
    }

    public void setBanners(List<Banner> banners) {
        this.banners = banners;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Category() {
    }

    public Category(String name, String reqName) {
        this.name = name;
        this.reqName = reqName;
        this.isDeleted = false;
    }
}
