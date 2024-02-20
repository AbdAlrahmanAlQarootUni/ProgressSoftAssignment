package ps.assignment.controllers;

import jakarta.validation.Valid;
import ps.assignment.models.FxDeal;
import ps.assignment.services.FxDealService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.slf4j.Logger;

@RestController
public class FxDealController {
    private static final Logger logger =  LoggerFactory.getLogger(FxDealController.class);


    @Autowired
    private FxDealService fxDealService;

    @GetMapping("/dealForm")
    public String dealForm(Model model) {
        logger.info("Showing deal submission form.");
        model.addAttribute("fxDeal", new FxDeal());
        return "home";
    }
    @GetMapping("/deals")
    public String viewDeals(Model model) {
        logger.info("Fetching all deals.");
        List<FxDeal> deals = (List<FxDeal>) fxDealService.findAllDeals();
        model.addAttribute("deals", deals);
        return "deals";
    }
    @PostMapping("/submitDeal")
    public String submitDeal(@Valid @ModelAttribute("fxDeal") FxDeal fxDeal
                             ,BindingResult result, Model model) {
        model.addAttribute("fxDeal", new FxDeal());
        if (result.hasErrors()) {
            logger.warn("Form submission has errors.");
            return "dealForm";
        }
        fxDealService.saveDeal(fxDeal);
        logger.info("Deal successfully submitted.");
        return "home";
    }
}
