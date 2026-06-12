package kh.aditya.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    Run findByID(@PathVariable int id){
        Optional<Run> run = runs.findById(id);
        if (run.isPresent()) {
            return run.get();
        }
        throw new RunNotFoundException();
    }

    @ResponseStatus(HttpStatus.CREATED) //Sends 201 everytime we hit /add successfully (NOT ADD SUCCESS)
    @PostMapping("/add")
    void create(@RequestBody Run run) { //accept a JSON object and add a run to the list
        runs.createRun(run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT) //Random Response code for debugging only
    @PutMapping("/{id}")
    void update(@RequestBody Run run, @PathVariable Integer id) {
        runs.update(run, id);
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @DeleteMapping("/{ID}") //same as findByID , depends if update , delete or get
    void delete(@PathVariable Integer ID) {
        runs.delete(ID);
    }
}
