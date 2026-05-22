package kh.aditya.first.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

public record Run(
        @Id Integer id,
        @NotEmpty String title,
        LocalDateTime start_time,
        LocalDateTime end_time,
        @Positive Double distance,
        Location location,
        @Version Integer version
) {

    public Run {
        if (end_time.isBefore(start_time)) {
            throw new IllegalArgumentException("End time cannot be before start time");
        }
    }
}