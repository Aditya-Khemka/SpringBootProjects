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
)
{

}
