package pl.oskarpolak.springsec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import pl.oskarpolak.springsec.models.DistanceModel;
import pl.oskarpolak.springsec.models.nothing.User;
import pl.oskarpolak.springsec.models.services.DistanceService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

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
        for (DistanceModel.Rows rows : model.getRows()) {
            for (DistanceModel.DistanceElement distanceElement : rows.getElements()) {
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


    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        if(!file.getContentType().contains("text/plain")){
            return "Brak zapisu! Bledny format";
        }

        Files.write(new File("C:\\test\\" + file.getOriginalFilename()).toPath(), file.getBytes(), StandardOpenOption.CREATE);

        return new String(file.getBytes());
    }


}
