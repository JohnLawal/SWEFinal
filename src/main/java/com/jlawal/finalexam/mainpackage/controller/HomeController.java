package com.jlawal.finalexam.mainpackage.controller;

import com.jlawal.finalexam.mainpackage.utility.AppHelper;
import com.jlawal.finalexam.mainpackage.utility.AppValues;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
    @GetMapping(value = {"/", "/wakanda", "/wakanda/home"})
    public ModelAndView displayHomePage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageTitle", "Welcome To Wakanda Republic DPR System");
        modelAndView.addObject("pageLinks", AppHelper.pageLinks);
        modelAndView.setViewName(AppValues.HOME_PAGE.val());
        return modelAndView;
    }
}
