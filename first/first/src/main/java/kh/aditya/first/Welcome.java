package kh.aditya.first;

import org.springframework.stereotype.Component;

@Component
public class Welcome {

    public String getWelcome() {
        return "Welcome to my first spring app";
    }
}