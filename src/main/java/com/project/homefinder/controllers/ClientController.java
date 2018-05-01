package com.project.homefinder.controllers;

import com.project.homefinder.models.Client;
import com.project.homefinder.models.Location;
import com.project.homefinder.models.Property;
import com.project.homefinder.models.data.ClientDao;
import com.project.homefinder.models.data.LocationDao;
import com.project.homefinder.models.data.PropertyDao;
import com.project.homefinder.models.forms.AddClientItemForm;
import com.project.homefinder.models.forms.AddLocationItemForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "client")
public class ClientController {

    @Autowired
    private PropertyDao propertyDao;

    @Autowired
    private ClientDao clientDao;

    @RequestMapping(value = "")
    private String index(Model model){

        model.addAttribute("title", "Clients");
        model.addAttribute("clients", clientDao.findAll());
        return "client/index";

    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    private String add(Model model){

        model.addAttribute("title", "Add Client");
        model.addAttribute(new Client());
        return "client/add";

    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    private String addClient(@ModelAttribute @Valid Client newClient,
                               Errors errors, Model model){

        if (errors.hasErrors()){
            model.addAttribute("title", "Clients");
            return "client/add";
        }

        clientDao.save(newClient);
        return "redirect:view/" + newClient.getId();
    }

    @RequestMapping(value="view/{id}", method = RequestMethod.GET)
    public String viewClient(Model model, @PathVariable int id){

        Client client = clientDao.findOne(id);
        model.addAttribute("title", client.getName());


        model.addAttribute("properties",client.getProperties());
        model.addAttribute("id", client.getId());

        return "client/view";
    }
    @RequestMapping(value="add-item/{id}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable int id) {
        Client client = clientDao.findOne(id);

        AddClientItemForm form = new AddClientItemForm(propertyDao.findAll(), client);

        model.addAttribute("title", client.getName());
        model.addAttribute("form", form);
        return "client/add-item";
    }


    //Adds the property item to client
    @RequestMapping(value="add-item", method = RequestMethod.POST)
    public String addItem(Model model,
                          @ModelAttribute @Valid AddClientItemForm form, Errors errors){

        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "client/add-item";
        }

        Property theProperty = propertyDao.findOne(form.getPropertyId());
        Client theClient = clientDao.findOne(form.getId());
        theClient.addItem(theProperty);
        clientDao.save(theClient);

        return "redirect:view/" + theClient.getId();
    }



    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveClientForm(Model model) {
        model.addAttribute("clients", clientDao.findAll());
        model.addAttribute("title", "Remove Client");
        return "client/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveClientForm(@RequestParam int[] ids) {

        for (int id : ids) {
            clientDao.delete(id);
        }
        return "redirect:";
    }

}
