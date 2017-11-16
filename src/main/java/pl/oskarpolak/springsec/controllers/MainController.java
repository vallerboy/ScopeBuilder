package pl.oskarpolak.springsec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.oskarpolak.springsec.models.nothing.User;

@Controller
public class MainController {


    User user;

    @Value("${google.distancematrix.key}")
    String googleKey;

    @Autowired
    public MainController(User user) {
        this.user = user;
    }

    @GetMapping("/")
    @ResponseBody
    public String index(){
        return googleKey;
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
