package com.example.a2;

import static org.assertj.core.api.Assertions.assertThat;
import com.example.a2.Model.Wishlist;
import com.example.a2.Repository.WishlistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import javax.persistence.PersistenceContext;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class WishlistRepositoryTest {
 

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void testWishlist(){
        Wishlist wishlist = new Wishlist();
        wishlist.setWish("Iphone");
        wishlist.setPrice(7500);
        wishlist.setLink("iphonehjemmeside.dk");

       Wishlist saveWishlist = wishlistRepository.save(wishlist);

       Wishlist existWishlist = entityManager.find(Wishlist.class,saveWishlist.getId());

       assertThat(existWishlist.getWish()).isEqualTo(wishlist.getWish());


    }
}
