package csaback.csabackend.controller;


import csaback.csabackend.modele.Etudiant;
import csaback.csabackend.service.etudiant.EtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiant")
@AllArgsConstructor
public class EtudiantController {
    private final EtudiantService etudiantService;

    @PostMapping("/create")
    public Etudiant create (@RequestBody Etudiant etudiant){
        return etudiantService.creer(etudiant);
    }

    @GetMapping("/read")
    public List<Etudiant> read (){
        return etudiantService.lire();
    }


}
