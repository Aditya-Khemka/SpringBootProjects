package kh.aditya.runnerz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class RunnerzApplication {

	public static void main(String[] args) {


		//SpringApplication.run(RunnerzApplication.class, args) ;

		/*
		//Aam Zindagi
		var Welcome = new Welcome();
		System.out.println(Welcome.getWelcomeMessage());
		*/


		//Mentos Zindagi

		//This scans the app for all @Component (creates their objects and stores them)
		ConfigurableApplicationContext context = SpringApplication.run(RunnerzApplication.class, args);
		//The variable context represents the container in which all the objects are stored


		//bean is just an instance of the class using some metadata managed by spring itself
		// get an object using bean
		Object obj = context.getBean("welcome"); // this gets the bean of class Welcome
		// unlike java, obj does not represent an object of class Welcome

		//option 1 : typecast to get an object
		Welcome welcome1 = (Welcome) context.getBean("welcome");
		System.out.println(welcome1.getWelcomeMessage());

		//option 2 : same as option 1 but cleaner
		Welcome welcome2 = context.getBean(Welcome.class);
		System.out.println(welcome2.getWelcomeMessage());

		//note that bean is lowercase by default. Welcome will throw an error (we can force it to use Welcome, but that for later)

		//also check
		System.out.println(welcome1 == welcome2); //true
		//because Spring returns the same object by default.

	}

}
