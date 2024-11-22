package dev.linda.runnerz.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

// RestController means we expect the output to be JSON
@RestController
@RequestMapping("/api/runs") // set the 'parent' endpoint
public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepositoryToUse) {
        this.runRepository = runRepositoryToUse;
    }

    @GetMapping("")
    List<Run> findAll() {
        return runRepository.findAll();
    }

    // this is GET request
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {

        // Optional is have or dun have (null)
        Optional<Run> run = runRepository.findById(id);
        if (run.isEmpty()) {
        // if don't have, will return bad request 400
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        // if have, will return data and response 200
        return run.get();
    }

    // this is POST request
    @PostMapping("")
    // this will return status 201 so u know create works
    @ResponseStatus(HttpStatus.CREATED)
    void addRun(@RequestBody Run run) {
        runRepository.addRun(run);
    }

    @RequestMapping("/hello")
    public String home() {
        return "Hello, Runnerzs!!!!!";
    }

}
