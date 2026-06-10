package kh.aditya.runnerz;

import org.springframework.stereotype.Component;

@Component
public class Welcome {

    public String getWelcomeMessage() {
        return "kh.aditya.runnerz.Welcome to Runnerz!";
    }
}
