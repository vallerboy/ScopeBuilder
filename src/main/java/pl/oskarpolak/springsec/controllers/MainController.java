package pl.oskarpolak.springsec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.oskarpolak.springsec.models.DistanceElement;
import pl.oskarpolak.springsec.models.DistanceModel;
import pl.oskarpolak.springsec.models.Rows;
import pl.oskarpolak.springsec.models.nothing.User;
import pl.oskarpolak.springsec.models.services.DistanceService;

@Controller
public class MainController {


    private User user;
    private DistanceService distanceService;


    @Autowired
    public MainController(User user, DistanceService service) {
        this.distanceService = service;
        this.user = user;
    }

    @GetMapping("/")
    @ResponseBody
    public String index(){
        DistanceModel model = distanceService.getDistance("Kraków", "Warszawa");
        for (Rows rows : model.getRows()) {
            for (DistanceElement distanceElement : rows.getElements()) {
                System.out.println(distanceElement.getDistance().getText());
            }
        }
        return "poszło";
    }


    @GetMapping("/distance")
    @ResponseBody
    public String distance(){
        return "Tutaj bedzie distance";
    }


    @GetMapping("/change")
    @ResponseBody
    public String change(){
        user.setName("Oskar");
        return "Zmieniłem name usera na Oskar";
    }

    @GetMapping("/change1")
    @ResponseBody
    public String change1(){
        user.setName("Damian");
        return "Zmieniłem name usera na Damian";
    }



}
