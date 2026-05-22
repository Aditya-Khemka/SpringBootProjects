package kh.aditya.first.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/runs-crud") //by default, all links are api/runs/xxxx
public class RunController_CRUD {

    private final RunRepository_CRUD runs ; //list of all runs in our system, get it from the RunRepository class
    public RunController_CRUD(RunRepository_CRUD runs) {
        this.runs = runs;
    }

    @GetMapping() //why? cause api/runs is already set as default
    public List<Run> findAll() { //Returns the list of all runs in our system
        return runs.findAll(); //OOPS in java
    }

    @GetMapping("/hello") //now the link is  /api/runs/hello
    String home(){
        return "Hello World";
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runs.findById(id);
        if (run.isPresent()) {
            return run.get();
        }
        throw new RunNotFoundException();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    void create(@Valid @RequestBody Run run) { //accept a JSON object and add a run to the list
        runs.create(run);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody Run run, @PathVariable Integer id) {
        runs.update(run, id);
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @DeleteMapping("/{ID}")
    void delete(@PathVariable Integer ID) {
        runs.delete(ID);
    }
}
