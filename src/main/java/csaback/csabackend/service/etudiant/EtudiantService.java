package csaback.csabackend.service.etudiant;

import csaback.csabackend.modele.Etudiant;

import java.util.List;

public interface EtudiantService {

    Etudiant creer(Etudiant etudiant);

    List<Etudiant> lire();

    Etudiant modifier(Long no_etudiant, Etudiant etudiant);

    String supprimer(Long no_etudiant);


}
