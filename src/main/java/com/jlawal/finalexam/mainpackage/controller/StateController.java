package com.jlawal.finalexam.mainpackage.controller;

import com.jlawal.finalexam.mainpackage.model.Citizen;
import com.jlawal.finalexam.mainpackage.model.State;
import com.jlawal.finalexam.mainpackage.serviceimplementation.ConcreteCitizenService;
import com.jlawal.finalexam.mainpackage.serviceimplementation.ConcreteStateService;
import com.jlawal.finalexam.mainpackage.utility.AppHelper;
import com.jlawal.finalexam.mainpackage.utility.AppValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class StateController {
    @Autowired
    ConcreteCitizenService concreteCitizenService;

    @Autowired
    ConcreteStateService concreteStateService;

    @GetMapping(value = {"/wakanda/citizens", "/wakanda/citizens/list"})
    public ModelAndView viewCitizens(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageTitle", "List of Citizens");
        modelAndView.addObject("pageLinks", AppHelper.pageLinks);
        modelAndView.addObject("citizens", concreteCitizenService.getAllCitizens(page));
        modelAndView.addObject("totalNationalYearlyIncome", concreteCitizenService.getTotalNationalYearlyIncomeAsMoney());
        modelAndView.addObject("currentPageNo", page);
        modelAndView.setViewName(AppValues.VIEW_CITIZENS_PAGE.val());
        return modelAndView;
    }

    @GetMapping(value = {"/wakanda/citizens/new"})
    public ModelAndView getNewCitizenRegistrationPage() {
        Citizen citizen = new Citizen();
        citizen.setState(new State());

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addAllObjects(getModelMap());
        modelAndView.addObject("citizen", citizen);
        modelAndView.setViewName(AppValues.NEW_CITIZEN_PAGE.val());
        return modelAndView;
    }

    @PostMapping(value = {"/wakanda/citizens/new"})
    public String registerNewCitizen(@Valid @ModelAttribute("citizen") Citizen citizen, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            try {
                //register the citizen
                String stateCode = citizen.getState().getStateCode();
                State stateOfOrigin = concreteStateService.getStateByStateCode(stateCode).get();

                citizen.setState(stateOfOrigin);

                stateOfOrigin.addCitizen(citizen);

                concreteStateService.saveState(stateOfOrigin);

                return AppValues.REDIRECT.val() + AppHelper.pageLinks.get("viewCitizens");
            } catch (Exception ex) {
                model.addAttribute("creationException", "Failed! An Error Occurred While Trying To Register This Citizen");
                return AppValues.NEW_CITIZEN_PAGE.val();
            }
        } else {
            System.out.println(bindingResult.getAllErrors());

            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAllAttributes(getModelMap());

            return AppValues.NEW_CITIZEN_PAGE.val();
        }
    }

    private Map<String, Object> getModelMap() {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("pageTitle", "Register A New Citizen");
        modelMap.put("pageLinks", AppHelper.pageLinks);
        modelMap.put("states", concreteStateService.getAllStates());
        return modelMap;
    }
}
