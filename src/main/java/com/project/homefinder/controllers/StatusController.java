package com.project.homefinder.controllers;



import com.project.homefinder.models.Status;
import com.project.homefinder.models.data.StatusDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("status")
public class StatusController {
    @Autowired
    private StatusDao statusDao;


    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("statuses", statusDao.findAll());
        model.addAttribute("title", "Status");

        return "status/index";
    }


    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Status");
        model.addAttribute("status", new Status());

        return "status/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Status status,
                      Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Status");
            return "status/add";
        }

        statusDao.save(status);
        return "redirect:";
    }


}




