package csaback.csabackend.service.formation;

import csaback.csabackend.modele.Formation;
import csaback.csabackend.modele.Promotion;

import java.util.List;

public interface FormationService {

    Formation creer(Formation formation);

    List<Formation> lire();
}
