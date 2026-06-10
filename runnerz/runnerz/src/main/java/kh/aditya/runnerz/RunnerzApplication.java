package kh.aditya.runnerz;

import kh.aditya.runnerz.run.Location;
import kh.aditya.runnerz.run.Run;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@SpringBootApplication
public class RunnerzApplication {

	private static final Logger log = LoggerFactory.getLogger(RunnerzApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args) ;
		log.info("Welcome to RunnerzApplication");
	}

	@Bean
	CommandLineRunner runner () {
		return (args) -> {
			Run run = new Run(1 , "Test Run 1" , LocalDateTime.now() ,
					LocalDateTime.now().plus(1, ChronoUnit.HOURS) ,
					23.6 , Location.INDOOR);
			log.info("First Run" + run);
		};
	}

}
