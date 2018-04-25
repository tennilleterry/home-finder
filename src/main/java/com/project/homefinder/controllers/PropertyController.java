package com.project.homefinder.controllers;

import com.project.homefinder.models.Location;
import com.project.homefinder.models.Property;
import com.project.homefinder.models.Status;
import com.project.homefinder.models.User;
import com.project.homefinder.models.data.PropertyDao;
import com.project.homefinder.models.data.StatusDao;
import com.project.homefinder.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("property")
public class PropertyController {

    @Autowired
    UserDao userDao;

    @Autowired
    PropertyDao propertyDao;

    @Autowired
    StatusDao statusDao;

    // Request path: /property
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("properties", propertyDao.findAll());
        model.addAttribute("title", "My Properties");

        return "property/index";
    }






   /* @RequestMapping(value = "view/{newUserId}", method = RequestMethod.GET)
    public String view(Model model, @PathVariable int newUserId) {

        User user = userDao.findOne(newUserId);
        model.addAttribute("title", user.getName());

        model.addAttribute("id", user.getId());
        return "property/add";
    }*/






    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddPropertyForm(Model model) {
        model.addAttribute("title", "Add a Property");
        model.addAttribute(new Property());
        model.addAttribute("statuses", statusDao.findAll());


        model.addAttribute("users", userDao.findAll());


        return "property/add";
    }





    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddPropertyForm(@ModelAttribute @Valid Property newProperty,
                                         Errors errors, @RequestParam int statusId, @RequestParam int userId, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Property");
            model.addAttribute("statuses", statusDao.findAll());



            model.addAttribute("users", userDao.findAll());


            return "property/add";
        }

        Status stat = statusDao.findOne(statusId);
        newProperty.setStatus(stat);
        propertyDao.save(newProperty);


        User theUser = userDao.findOne(userId);
        newProperty.setUser(theUser);
        propertyDao.save(newProperty);


        return "redirect:";
    }




    /*@RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddPropertyForm(@ModelAttribute @Valid Property newProperty,
                                         Errors errors, @RequestParam int userId, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Property");
            model.addAttribute("users", userDao.findAll());
            return "property/add";
        }

        User user = userDao.findOne(userId);
        newProperty.setUser(user);

        propertyDao.save(newProperty);
        return "redirect:";
    }*/




    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemovePropertyForm(Model model) {
        model.addAttribute("properties", propertyDao.findAll());
        model.addAttribute("title", "Remove Property");
        return "property/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemovePropertyForm(@RequestParam int[] ids) {

        for (int id : ids) {
            propertyDao.delete(id);
        }
        return "redirect:";
    }

    @RequestMapping(value = "status", method = RequestMethod.GET)
    public String status(Model model, @RequestParam int id) {
        Status stat = statusDao.findOne(id);
        List<Property> properties = stat.getProperties();
        model.addAttribute("properties", properties);
        model.addAttribute("title", "Property Status: " + stat.getName());
        return "property/index";

    }






    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String user(Model model, @RequestParam int id) {
        User theUser = userDao.findOne(id);
        List<Property> properties = theUser.getProperties();
        model.addAttribute("properties", properties);
        model.addAttribute("title", "User: " + theUser.getName());
        return "property/index";

    }

}
