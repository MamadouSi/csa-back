package csaback.csabackend.service.etudiant;

import csaback.csabackend.modele.Etudiant;
import csaback.csabackend.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements  EtudiantService{

    private final EtudiantRepository etudiantRepository;

    @Override
    public Etudiant creer(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> lire() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant modifier(Long no_etudiant, Etudiant etudiant) {
        return etudiantRepository.findById(no_etudiant)
                .map(e-> {
                    e.setNom(etudiant.getNom());
                    e.setPrenom(etudiant.getPrenom());
                    e.setAnneePro(etudiant.getAnneePro());
                    e.setDateNaissance(etudiant.getDateNaissance());
                    e.setNoEtudiantNat(etudiant.getNoEtudiantNat());

                    return etudiantRepository.save(e);
                }).orElseThrow(()-> new RuntimeException("Etudiant non Trouvé !"));
    }

    @Override
    public String supprimer(Long no_etudiant) {
        etudiantRepository.deleteById(no_etudiant);
        return "Etudiant Supprimer avec succès";
    }
}
