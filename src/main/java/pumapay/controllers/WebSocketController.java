package pumapay.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import pumapay.models.Currency;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

@EnableScheduling
@Controller
public class WebSocketController {

    private final SimpMessagingTemplate template;

    @Autowired
    public WebSocketController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @Scheduled(fixedRate = 5000)
    private void sendMsg() {
        template.convertAndSend("/msg", new Currency("EUR", "USD", getRate(), LocalDateTime.now()));
    }

    private String getRate() {
        double random = Math.random() * 0.3 + 1;
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(random);
    }
}
