package kh.aditya.first.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/runs") // by default, all links are api/runs/xxxx
public class RunController {

    // list of all runs in our system,
    // get it from the RunRepository class
    private final RunRepository runs;

    public RunController(RunRepository runs) {
        this.runs = runs;
    }

    @GetMapping("")
    public List<Run> findAll() {
        return runs.findAll();
    }

    @GetMapping("/{id}")
    public Run findById(@PathVariable Integer id) {
        return runs.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Run not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void save(@Valid @RequestBody Run run) {

        // accept a JSON object
        // and add a run to the list
        runs.save(run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(
            @Valid @RequestBody Run run,
            @PathVariable Integer id
    ) {

        if (!runs.existsById(id)) {
            throw new RuntimeException("Run not found");
        }

        runs.save(run);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        runs.deleteById(id);
    }

    @GetMapping("/location/{location}")
    public List<Run> findByLocation(
            @PathVariable Location location
    ) {

        return runs.findByLocation(location);
    }
}