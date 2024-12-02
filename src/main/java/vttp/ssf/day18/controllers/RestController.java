package vttp.ssf.day18.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vttp.ssf.day18.model.Carpark;
import vttp.ssf.day18.services.CarparkService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping
public class RestController {

    @Autowired
    private CarparkService carparkSvc;

    @GetMapping
    public ResponseEntity<List<Carpark>> getAllCarparks() {
        try {
            List<Carpark> carparks = carparkSvc.getCarparks();
            return ResponseEntity.ok(carparks);
        } catch (Exception e) {
            // Handle exceptions (e.g., log and return an appropriate error response)
            e.printStackTrace();
            return ResponseEntity.status(500).body(null); // Internal Server Error
        }
    }
}
