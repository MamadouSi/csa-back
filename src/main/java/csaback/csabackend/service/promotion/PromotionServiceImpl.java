package csaback.csabackend.service.promotion;

import csaback.csabackend.modele.Promotion;
import csaback.csabackend.repository.PromotionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class PromotionServiceImpl implements PromotionService {

    private final PromotionRepository promotionRepository;
    @Override
    public Promotion creer(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Override
    public List<Promotion> lire() {
        return promotionRepository.findAll();
    }
}
