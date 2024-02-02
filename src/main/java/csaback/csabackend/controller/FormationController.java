package csaback.csabackend.controller;

import csaback.csabackend.modele.Formation;
import csaback.csabackend.modele.Promotion;
import csaback.csabackend.service.formation.FormationService;
import csaback.csabackend.service.promotion.PromotionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/formation")
public class FormationController {

    private final FormationService formationService;


    @PostMapping("/create")
    public Formation create (@RequestBody Formation formation){
        return formationService.creer(formation);
    }

    @GetMapping("/read")
    public List<Formation> read (){
        return formationService.lire();
    }
}
