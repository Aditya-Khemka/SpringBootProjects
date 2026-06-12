package kh.aditya.runnerz.run;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        @NotEmpty String title,
        LocalDateTime start_time,
        LocalDateTime end_time,
        @Positive Double distance,
        Location location
) {


    //manual validation through conditional checks
    public Run {
        if (end_time.isBefore(start_time)) {
            throw new IllegalArgumentException("End time cannot be before start time");
        }
    }
}