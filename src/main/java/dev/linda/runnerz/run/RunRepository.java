package dev.linda.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    // method to find all runs
    List<Run> findAll() {
        return runs;
    }

    // Optional is have or dun have (null)
    Optional<Run> findById(Integer id) {
        return runs.stream().filter(r -> r.id() == id).findFirst();
    }

    // create new run
    void addRun(@RequestBody Run runEntry) {
        runs.add(runEntry);
    }

    // update/edit an existing run by it's id
    void editRun(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        // this isPresent method is from Optional
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    // delete run
    void deleteRun(Integer id) {
            runs.removeIf(run -> run.id() == id);
    }

    // this will do some initialization in this Class
    // this will add 2 runs at initialization of this Class
    @PostConstruct
    private void init() {
        // gives [] coz empty at first
//        System.out.println(">>> " + runs);

        runs.add(new Run(
                1,
                "Monday morning run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(3, ChronoUnit.HOURS),
                27,
                Location.INDOOR
                )
        );
        runs.add(new Run(
                2,
                "Wednesday evening run",
                LocalDateTime.now(),
                LocalDateTime.now().plus(55, ChronoUnit.HOURS),
                8,
                Location.OUTDOOR
                )
        );
    }
}
