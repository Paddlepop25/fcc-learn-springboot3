package dev.linda.runnerz.run;

import java.time.LocalDateTime;

// a Record is immutable. we can get the values but not set / change them
public record Run(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        Integer miles,
        Location location
) {}
