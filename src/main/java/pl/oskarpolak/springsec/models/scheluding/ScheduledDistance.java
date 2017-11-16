package pl.oskarpolak.springsec.models.scheluding;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.oskarpolak.springsec.models.DistanceModel;
import pl.oskarpolak.springsec.models.services.DistanceService;

@EnableScheduling
@Component
public class ScheduledDistance {

    @Autowired
    DistanceService distanceService;

    @Scheduled(cron = "* 0/5 10-18 * * *")
    public void log(){
        for (DistanceModel.Rows rows : distanceService.getDistance("Kraków", "Warszawa").getRows()) {
            for (DistanceModel.DistanceElement distanceElement : rows.getElements()) {
                System.out.println(distanceElement.getDistance().getText());
            }
        }
    }

}
