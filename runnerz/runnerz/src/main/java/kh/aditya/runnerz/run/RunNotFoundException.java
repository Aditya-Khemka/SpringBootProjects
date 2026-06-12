package kh.aditya.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) //404 page
public class RunNotFoundException extends RuntimeException {

    public RunNotFoundException() {
        super ("Run not found") ;
    }
}