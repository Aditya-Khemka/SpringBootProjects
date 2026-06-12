package kh.aditya.runnerz.run;

import java.time.LocalDateTime;

public record Run(
        Integer id,
        String title,
        LocalDateTime start_time,
        LocalDateTime end_time,
        Double distance,
        Location location,
        Integer version
) {

    //manual validation through conditional checks
    public Run {
        if (end_time.isBefore(start_time)) {
            throw new IllegalArgumentException("End time cannot be before start time");
        }
    }
}