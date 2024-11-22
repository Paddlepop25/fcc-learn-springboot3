package dev.linda.runnerz.run;

import jakarta.validation.Valid;
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

    @RequestMapping("/hello")
    public String home() {
        return "Hello, Runnerzs!!!!!";
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
        // if don't have, will return bad request 400
        if (run.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            // this is custom made, see RunNotFoundException.java
            throw new RunNotFoundException();
        }

        // if have, will return data and response 200
        return run.get();
    }

    // this is POST request
    @PostMapping("")
    // this will return status 201 Created so u know create works
    @ResponseStatus(HttpStatus.CREATED)
    // @Valid is making sure data is validated. see Run.java for validation
    // example if empty title, will return response '400 Bad Request.. empty string'
    void addRun(@Valid @RequestBody Run run) {
        runRepository.addRun(run);
    }

    // this is PUT request
    @PutMapping("/{id}")
    // returns status '204 No Content' so we know there's no content, update works
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void editRun(@RequestBody Run run, @PathVariable Integer id) {
        runRepository.editRun(run, id);
    }

    // this is DELETE request
    @DeleteMapping("/{id}")
    // returns status '204 No Content' so we know there's no content, update works
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteRun(@PathVariable Integer id) {
        runRepository.deleteRun(id);
    }
}
