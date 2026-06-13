package kh.aditya.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RunController {
    //Again create an instance of RunRepository
    private final RunRepository runRepository;

    //Initalise it
    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    //And get all the runs using the findAll function
    @GetMapping("/allRuns")
    List<Run> findAll() {
        return runRepository.findAll();
    }

}
