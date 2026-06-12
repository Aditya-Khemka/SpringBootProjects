package kh.aditya.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//We mark this class as a repository
// now we can access it using Spring methods in other classes
@Repository
public class RunRepository {

    //list of all runs in the system
    private List<Run> runs = new ArrayList<Run>();

    //when the class is created, this method is called
    @PostConstruct
    public void init() {
        runs.add (new Run(11,"Monday Morning", LocalDateTime.now() , LocalDateTime.now().plus(1, ChronoUnit.HOURS) , 5.2, Location.INDOOR ));
        runs.add (new Run(12,"Sunday Evening", LocalDateTime.now() , LocalDateTime.now().plus(1, ChronoUnit.HOURS) , 5.2, Location.OUTDOOR ));
    }

    //return all runs in the system
    List<Run> getRuns(){
        return runs;
    }

    /*
    // Not using this as it may throw an execption if Run is not found
    Run getRun(int id){
        return runs.get(id);
    }
     */


    public Optional<Run> findById(int id) {
        for (Run run : runs) {
            if (run.id() == id) {
                return Optional.of(run);
            }
        }

        return Optional.empty();
    }

    void createRun(Run run) {
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
