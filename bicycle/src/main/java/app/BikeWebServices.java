package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan({"components", "controllers", "services"})
@SpringBootApplication
public class BikeWebServices {
	
	public static void main(String ... args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(BikeWebServices.class, args);
		ApplicationContextProvider.setContext(context);
		
	}

}
