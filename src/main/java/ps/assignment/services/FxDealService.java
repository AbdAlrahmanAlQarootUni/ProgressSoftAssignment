package ps.assignment.services;

import ps.assignment.models.FxDeal;
import ps.assignment.repositories.FxDealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FxDealService {

    @Autowired
    private FxDealRepository fxDealRepository;

    public FxDeal saveDeal(FxDeal fxDeal) {
        // Additional validation logic can go here
        return fxDealRepository.save(fxDeal);
    }
    public Iterable<FxDeal> findAllDeals() {
        return fxDealRepository.findAll();
    }
}
