package kh.aditya.runnerz.run;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

//This class acts as a router
@RestController
@RequestMapping("/api")  // localhost:5050/api is the default URL for all CRUD related operations from now
public class RunController {

    private final RunRepository runs;

    public RunController(RunRepository runs) {
        this.runs = runs;
    }
    //Spring knows that RunRepository is a repo class. It automatically creates and manages objects


    @GetMapping("/AllRuns")
    List<Run> findAll(){
        return runs.getRuns() ;
    }

    @GetMapping("{id}")
    Run findByID(@PathVariable int id){
        Optional<Run> run = runs.findById(id);
        if (run.isPresent()) {
            return run.get();
        }
        return null ;
    }
}
