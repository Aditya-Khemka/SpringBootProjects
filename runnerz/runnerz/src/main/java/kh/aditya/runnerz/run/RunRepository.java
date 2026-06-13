package kh.aditya.runnerz.run;

import jakarta.annotation.PostConstruct;
import org.slf4j.ILoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//We mark this class as a repository
// now we can access it using Spring methods in other classes
@Repository
public class RunRepository {

    //Spring will autoconfigure JDBC so we can talk to a DB
    private final JdbcClient jdbcClient;
    public RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    //List all runs (this time get data from a db)
    public List<Run> findAll() {
        return jdbcClient.sql("select * from run") //Run the SQL command
                .query(Run.class) //get the result (and map to Run type)
                .list(); //convert it to list
    }


}
