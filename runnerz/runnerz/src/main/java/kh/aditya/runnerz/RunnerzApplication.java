package kh.aditya.runnerz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RunnerzApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args) ;

		//Aam Zindagi
		var Welcome = new Welcome();
		System.out.println(Welcome.getWelcomeMessage());
	}

}
