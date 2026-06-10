package kh.aditya.runnerz;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
//Component creates Welcome welcome = new Welcome();
public class Welcome {

    @Bean
    public String getWelcomeMessage() {
        return "kh.aditya.runnerz.Welcome to Runnerz!";
    }
}

