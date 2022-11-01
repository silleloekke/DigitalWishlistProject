package com.example.a2.Model;

import javax.persistence.*;
//import org.hibernate.annotations.Table;

@Entity
@Table(name = "wishes")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 45)
    private String wish;

    @Column(nullable = false,length = 45)
    private Integer price;

    @Column(nullable = false,length = 45)
    private String link;

    public Wishlist(String wish, Integer price, String link) {
        super();
        this.wish = wish;
        this.price = price;
        this.link = link;
    }

    public Wishlist() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
