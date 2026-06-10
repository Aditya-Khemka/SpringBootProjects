package kh.aditya.runnerz.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//This class acts as a router
@RestController
public class RunController {

    //we need to create an instance of the RunRepository
    private final RunRepository runs;

    /*
    //Aam Zindagi
    public RunController(RunRepository runs){
        this.runs = runs;
    }
     */

    //Mentos zindagi
    public RunController(RunRepository runs) {
        this.runs = runs;
    }
    //Spring knows that RunRepository is a repo class. It automatically creates and manages objects


    @GetMapping("/api/AllRuns")
    List<Run> findAll(){
        return runs.getRuns() ;
    }
}
