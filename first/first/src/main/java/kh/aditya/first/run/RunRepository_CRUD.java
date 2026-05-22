package kh.aditya.first.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository_CRUD {

    //Get
    private List<Run> runs = new ArrayList<Run>();

    //populate the initial list
    @PostConstruct
    public void init() {
//        runs.add (new Run(11,"Monday Morning", LocalDateTime.now() , LocalDateTime.now().plus(1, ChronoUnit.HOURS) , 5.2, Location.INDOOR ));
//        runs.add (new Run(12,"Sunday Evening", LocalDateTime.now() , LocalDateTime.now().plus(1, ChronoUnit.HOURS) , 5.2, Location.OUTDOOR ));
    }

    public List<Run> findAll() {
        return runs;
    }

    public Optional<Run> findById(int id) {
        for (Run run : runs) {
            if (run.id() == id) {
                return Optional.of(run);
            }
        }

        return Optional.empty();
    }

    //Create a new run (ie post)
    void create (Run run) {
        runs.add(run);
    }

    void update (Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete (Integer id) {
        Optional<Run> run = findById(id);
        if (run.isPresent()) {
            runs.remove(run.get());
            return;
        }
    }
}
