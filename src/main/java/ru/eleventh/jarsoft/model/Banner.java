package ru.eleventh.jarsoft.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Banner {

    @Id
    @GeneratedValue
    public Long id;

    @ManyToOne
    @JoinColumn
    private Category category;

    @OneToMany
    private List<Request> requests;

    private String name;

    private Float price;

    private String content;

    private Boolean isDeleted;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Banner() {
    }

    public Banner(Category category, String name, Float price, String content) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.content = content;
        this.isDeleted = false;
    }
}
