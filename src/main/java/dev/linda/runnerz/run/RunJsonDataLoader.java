package dev.linda.runnerz.run;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
// this inserts an array of 10runs to H2 db when application starts
public class RunJsonDataLoader implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(RunJsonDataLoader.class);
    private final RunRepositoryH2 runRepositoryH2;
    private final ObjectMapper objectMapper;

    // this is dependency injection; when it creates an instance of this class,
    // it will see that it depends on the RunRepository, Spring knows about this class
    // and injects this into the constructor for us
    // and now we have a runRepository we can use
    public RunJsonDataLoader(RunRepositoryH2 runRepositoryH2, ObjectMapper objectMapper) {
        this.runRepositoryH2 = runRepositoryH2;
        this.objectMapper = objectMapper;
    }

    // another way to insert data into H2 database when application starts.
    // don't have to do this, could do it in the RunnerzApplication.java
    @Override
    public void run(String... args) throws Exception {
        // checks if there is nothing in h2 database
        if (runRepositoryH2.count() == 0) {
        // inserts data to h2 database
                if(runRepositoryH2.count() == 0) {
                    try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/runs.json")) {
                        Runs allRuns = objectMapper.readValue(inputStream, Runs.class);
                        log.info("Reading {} runs from JSON data and saving to H2 database.", allRuns.runs().size());
                        runRepositoryH2.saveAll(allRuns.runs());
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to read JSON data", e);
                    }
                } else {
                    log.info("Not loading Runs from JSON data because the collection contains data.");
                }
        }
    }

}
