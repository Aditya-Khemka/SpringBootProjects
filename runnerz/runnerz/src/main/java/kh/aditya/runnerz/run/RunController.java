package kh.aditya.runnerz.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//This class acts as a router
@RestController
public class RunController {

    //GET will return a string of this type
    @GetMapping("/hello")
    String home (){
        return "Hello World";
    }
}
