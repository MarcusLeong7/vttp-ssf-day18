package vttp.ssf.day18.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vttp.ssf.day18.model.Carpark;
import vttp.ssf.day18.services.CarparkService;

import java.util.List;

@Controller
@RequestMapping("/api/carparks")
public class CarparkController {

    @Autowired
    private CarparkService carparkSvc;

    @GetMapping
    public String getCarparks(Model model) {

        // Fetch data from the service
        List<Carpark> carparks = carparkSvc.getCarparks();

        // Add data to the model
        model.addAttribute("carparkData", carparks);

        // Return the name of the Thymeleaf template
        return "carparks";
    }
}
