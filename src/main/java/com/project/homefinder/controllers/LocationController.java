package com.project.homefinder.controllers;




import com.project.homefinder.models.Location;
import com.project.homefinder.models.Property;
import com.project.homefinder.models.data.LocationDao;
import com.project.homefinder.models.data.PropertyDao;
import com.project.homefinder.models.forms.AddLocationItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "location")
public class LocationController {

    @Autowired
    private PropertyDao propertyDao;

    @Autowired
    private LocationDao locationDao;

    @RequestMapping(value = "")
    private String index(Model model){

        model.addAttribute("title", "Locations");
        model.addAttribute("locations", locationDao.findAll());
        return "location/index";

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    private String add(Model model){

        model.addAttribute("title", "Add Location");
        model.addAttribute(new Location());
        return "location/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    private String addLocation(@ModelAttribute @Valid Location newLocation,
                           Errors errors, Model model){

        if (errors.hasErrors()){
            model.addAttribute("title", "Locations");
            return "location/add";
        }

        locationDao.save(newLocation);
        return "redirect:view/" + newLocation.getId();
    }

    @RequestMapping(value="view/{id}", method = RequestMethod.GET)
    public String viewLocation(Model model, @PathVariable int id){

        Location location = locationDao.findOne(id);
        model.addAttribute("title", location.getName());
        model.addAttribute("properties",location.getProperties());
        model.addAttribute("id", location.getId());

        return "location/view";
    }
    @RequestMapping(value="add-item/{id}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable int id) {
        Location location = locationDao.findOne(id);

        AddLocationItemForm form = new AddLocationItemForm(propertyDao.findAll(), location);

        model.addAttribute("title", "Add property to: " + location.getName());
        model.addAttribute("form", form);
        return "location/add-item";
    }


    //Adds the property item to location
    @RequestMapping(value="add-item", method = RequestMethod.POST)
    public String addItem(Model model,
                          @ModelAttribute @Valid AddLocationItemForm form, Errors errors){

        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "location/add-item";
        }

        Property theProperty = propertyDao.findOne(form.getPropertyId());
        Location theLocation = locationDao.findOne(form.getId());
        theLocation.addItem(theProperty);
        locationDao.save(theLocation);

        return "redirect:view/" + theLocation.getId();
    }

}
