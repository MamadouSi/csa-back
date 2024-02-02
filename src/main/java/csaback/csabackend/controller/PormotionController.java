package csaback.csabackend.controller;

import csaback.csabackend.modele.Etudiant;
import csaback.csabackend.modele.Promotion;
import csaback.csabackend.service.promotion.PromotionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promotion")
@AllArgsConstructor
public class PormotionController {
    private final PromotionService promotionService;


    @PostMapping("/create")
    public Promotion create (@RequestBody Promotion promotion){
        return promotionService.creer(promotion);
    }

    @GetMapping("/read")
    public List<Promotion> read (){
        return promotionService.lire();
    }






}
