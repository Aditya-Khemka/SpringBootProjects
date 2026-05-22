package kh.aditya.first;

import kh.aditya.first.run.Location;
import kh.aditya.first.run.Run;
import kh.aditya.first.run.RunRepository;
import kh.aditya.first.user.User;
import kh.aditya.first.user.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.TimeZone;

@SpringBootApplication
public class FirstApplication {

	private static final Logger log = LoggerFactory.getLogger(FirstApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}

	/*
	@Bean
    CommandLineRunner runner(UserRestClient client) {
		return args -> {
            List<User> users = client.findAll() ;
		//  System.out.println(users);
			System.out.println(client.findById(3));
		};
	}
	*/


	/*
	@Bean
	CommandLineRunner runner(RunRepository runRepository) {
		return args -> {
			Run run = new Run(13,"Test Run 1", LocalDateTime.now() ,
					LocalDateTime.now().plus(1, ChronoUnit.HOURS) , 5.2, Location.INDOOR );
			runRepository.create(run);
			log.info(run.toString());
		};
	}
	 */

	/*
	Create and test the run class
	@Bean
	CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			Run run = new Run(13,"Test Run 1", LocalDateTime.now() ,
								LocalDateTime.now().plus(1, ChronoUnit.HOURS) , 5.2, Location.INDOOR );

			log.info(run.toString());
			System.out.println(run.toString()) ;

		};
	}
	*/

	/*
	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(FirstApplication.class, args);

		//Aam zindagi : the java method
		//kh.aditya.first.Welcome welcomeMessage = new kh.aditya.first.Welcome();
		//System.out.println(welcomeMessage.getWelcome());

		//Mentos Zindagi : the springboot method (either of the two)
		//Object welcome = context.getBean("welcome");
		Welcome welcome = context.getBean(Welcome.class); //recommended
		System.out.println(welcome.getWelcome());


		//Logger
		log.info(welcome.getWelcome());
	}
	*/
}