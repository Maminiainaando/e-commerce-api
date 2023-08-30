/*package com.example.springbootexam.controller;
import com.example.springbootexam.model.Promo;
import com.example.springbootexam.model.User;
import com.example.springbootexam.service.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;*/
/*@RestController
public class PromoController {

    private PromoService promoService;
    public PromoController(PromoService promoService){
        this.promoService=promoService;
    }
    @PostMapping("/promo")
    public Promo insertCart(@RequestBody Promo promo){
        return promoService.createPromo(promo);
    }
    @GetMapping("/promo")
    public List<Promo> getAllCart(){
        return promoService.PromoList();
    }
    @GetMapping("/promo/{promoid}")
    public Optional<Promo> CartByUser(@PathVariable int promoid){
        return Optional.ofNullable(promoService.Promonumber(promoid));
    }
    @GetMapping("/promo/{category}")
    public Optional<Promo> CartByType(@PathVariable String category){
        return Optional.ofNullable(promoService.Promocategory(category));
    }
    @DeleteMapping("/promo/{promoid}")
    public Optional<Promo> DeleteCartByType(@PathVariable int promoid){
        return promoService.deletePromo(promoid);
    }
    @PutMapping("/promo/{typecart}")
    public User UpdateTypecart(@PathVariable Date newExpiration, Date expiration){
        return promoService.UpdateDatePromo(newExpiration,expiration);
    }
}*/
package com.example.springbootexam.controller;
        import com.example.springbootexam.model.Promo;
        import com.example.springbootexam.model.User;
        import com.example.springbootexam.service.PromoService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.lang.reflect.Array;
        import java.util.ArrayList;
        import java.util.Date;
        import java.util.List;
        import java.util.Optional;
@RestController
public class PromoController {

    private  PromoService promoService;
    public PromoController(PromoService promoService){
        this.promoService=promoService;
    }
    @PostMapping("/promo")
    public Promo insertPromo(@RequestBody Promo promo){
        return promoService.createPromo(promo);
    }
    @GetMapping("/promo")
    public List<Promo> getAllPromo(){
        return promoService.PromoList();
    }
    @GetMapping("/promo/{promoid}")
    public Promo PromoById(@PathVariable int promoid){
        return promoService.Promonumber(promoid);
    }
    @GetMapping("/promo/{category}")
    public Promo PromoCategory(@PathVariable String category){
        return promoService.Promocategory(category);
    }
    @DeleteMapping("/promo/{promoid}")
    public Optional<Promo> DeletePromoById(@PathVariable int promoid){
        return promoService.deletePromo(promoid);
    }
    @PutMapping("/promo/{typecart}")
    public Promo UpdateExpirationDate(@PathVariable Date newExpiration, Date expiration){
        return promoService.UpdateDatePromo(newExpiration,expiration);
    }
}

