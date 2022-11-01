package com.example.a2.Controller;

import com.example.a2.Model.Wishlist;
import com.example.a2.Repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import javax.validation.Valid;
import org.springframework.web.bind.annotation.*;

@Controller
public class WishlistController {

    @Autowired
    private WishlistRepository wishlistRepository;


    @GetMapping("/")
    public String homepage(Model model){
        model.addAttribute("wishes",wishlistRepository.findAll());
        return "index";
    }


    //HMMMM?
  /*  @GetMapping("/")
    public String homepage(Wishlist wishlist, Model model) {
        model.addAttribute("wish", new Wishlist());
        return "index";
    }*/

    @GetMapping("/newwish")
    public String showWishForm() {
        return "new_wish";
    }

    @PostMapping("/addWish")
    public String addWish(Wishlist wishlist,Model model ,BindingResult res ){
        if(res.hasErrors()){
            return "new_wish";
        }
        wishlistRepository.save(wishlist);
        return "redirect:/";
    }

    @GetMapping("/rediger/{id}")
    public String editWish(@PathVariable("id") long id,Model model){
        Wishlist wishlist = wishlistRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("ID IKKE FUNDET "+id));
        model.addAttribute("wish",wishlist);
        return "update_wish";
    }


    @GetMapping("/slet/{id}")
    public String deleteWish(@PathVariable("id") long id,Model model){
        Wishlist wishlist = wishlistRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("ID IKKE FUNDET "+id));
        wishlistRepository.delete(wishlist);

        model.addAttribute("wish",wishlistRepository.findAll());
        return "index";

    }

    @PostMapping("update/{id}")
    public String updateWish(@PathVariable("id") long id,Wishlist wishlist,Model model,BindingResult res){
        if(res.hasErrors()){
            wishlist.setId(id);
            return "update_wish";
        }
        wishlistRepository.save(wishlist);
        model.addAttribute("wish",wishlistRepository.findAll());
        return "index";

    }









    //VISER FORMEN HVOR MAN SKAL INDTASTE DATA
  /*  @GetMapping("/VisØnsklllllllllllllllllllleForm")
    public String visØnskeForm(Model model){
        Wishlist wishlist = new Wishlist();
        model.addAttribute("wish",wishlist);
        return "new_wish";
    }*/

    //SKULLE GERNE GEMME LORTET
    /*@PostMapping("/GemØnske")
    public String gemØnske (@ModelAttribute("wish")Wishlist wishlist){
        wishlistRepository.save(wishlist);
        return "redirect:/";

    }*/



























      /*DET HER VIRKER ISH?
    @GetMapping("/newwish")

    public String newWish(Model model, Wishlist wishlist) {

        return "new_wish";

    }

   @GetMapping("rediger/{id}")
    public String rediger(@PathVariable("id") long id, Model model) {
        Wishlist wishlist = wishlistRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(("Invalid student Id:" + id)));
        model.addAttribute("wish", wishlist);
        return "updaterWish";


    }

    @PostMapping("updater/{id}")
    public String updaterWish(@PathVariable("id")long id, Wishlist wishlist, BindingResult result, Model model){
        if(result.hasErrors()){
            wishlist.setId(id);
            return "updaterWish";
        }
        wishlistRepository.save(wishlist);
        model.addAttribute("wishes",wishlistRepository.findAll());
        return "index";

    }
    @GetMapping("slet/{id}")
    public String deleteWish(@PathVariable("id") long id, Model model) {
        Wishlist wishlist = wishlistRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        wishlistRepository.delete(wishlist);
        model.addAttribute("wishes", wishlistRepository.findAll());
        return "index";
    }
*/






}



/*


private WishlistRepository wishlistRepository;

 @Autowired
 public WishlistController(WishlistRepository wishlistRepository){
     this.wishlistRepository = wishlistRepository;
 }

 @GetMapping("")
 public String homePage(Model model){
     model.addAttribute("wishes",wishlistRepository.findAll());
     return "index";
 }

 @PostMapping("newwish")
 public String addNewWish(@Valid WishlistModel wishlistModel, BindingResult result, Model model){
     if (result.hasErrors()) {
         return "new_wish";
     }
     wishlistRepository.save(wishlistModel);
     return "redirect:list";
 }

@GetMapping("rediger/{id}")
public String rediger(@PathVariable("id")long id,Model model){
     WishlistModel wishlistModel = wishlistRepository.findById(id).orElseThrow(()->new IllegalArgumentException(("Invalid student Id:" + id)));
     model.addAttribute("wish",wishlistModel);
     return "updaterWish";
}

@PostMapping("updater/{id}")
public String updaterWish(@PathVariable("id")long id,@Valid WishlistModel wishlistModel,BindingResult result, Model model){
    if(result.hasErrors()){
        wishlistModel.setId(id);
        return "updaterWish";
    }
    wishlistRepository.save(wishlistModel);
    model.addAttribute("wishes",wishlistRepository.findAll());
    return "index";

}
@GetMapping("slet/{id}")
 public String deleteWish(@PathVariable("id") long id, Model model){
     WishlistModel wishlistModel = wishlistRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid student Id:" + id));
     wishlistRepository.delete(wishlistModel);
     model.addAttribute("wishes",wishlistRepository.findAll());
     return "index";






 */
