package dev.linda.runnerz.run;

// see constraints for more kinds of validation
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

// a Record is immutable. we can get the values but not set / change them
public record Run(
        Integer id,
        @NotEmpty // cannot be empty string
        String title,
        LocalDateTime startedOn,
        LocalDateTime completedOn,
        @Positive // cannot be negative miles
        Integer miles,
        Location location
) {

    // created for validating 'completedOn'
    // it must be after startedOn
    public Run {
        if (!completedOn.isAfter(startedOn)) {
            // this return response '400 Bad Request'
            throw new IllegalArgumentException(("completedOn must be after startedOn"));
        }
    }

}


