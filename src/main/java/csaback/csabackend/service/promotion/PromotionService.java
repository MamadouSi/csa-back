package csaback.csabackend.service.promotion;

import csaback.csabackend.modele.Promotion;

import java.util.List;

public interface PromotionService {

    Promotion creer(Promotion promotion);

    List<Promotion> lire();
}
