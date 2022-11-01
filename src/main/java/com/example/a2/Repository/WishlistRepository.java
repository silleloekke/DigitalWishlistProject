package com.example.a2.Repository;

import com.example.a2.Model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist,Long> {
    List<Wishlist>findByWish(String wish);

}
