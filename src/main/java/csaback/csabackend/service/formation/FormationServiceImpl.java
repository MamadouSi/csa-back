package csaback.csabackend.service.formation;

import csaback.csabackend.modele.Formation;
import csaback.csabackend.repository.FormationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;

    @Override
    public Formation creer(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public List<Formation> lire() {
        return formationRepository.findAll();
    }
}
