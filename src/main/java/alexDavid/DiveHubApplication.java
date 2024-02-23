package alexDavid;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import alexDavid.service.InitialDataCreationService;

@SpringBootApplication
public class DiveHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiveHubApplication.class, args);
		System.out.println("********************************************************************************************************************************************************************************************************************");
		System.out.println("*                                                                                                                                                      			                          						   *");
		System.out.println("*                                                                                                                                                      			       			          					       *");
		System.out.println("*                                                                                                                                                                           		      					       *");
		System.out.println("*                                                                              		    		     ¡BIENVENIDO!                  		              		                                            	       *");
		System.out.println("*                                                                                                                                                                           		     					       *");
		System.out.println("*                                                                                                                                                      			            		     					       *");
		System.out.println("*                                                                                                                                                                          			     						   *");
		System.out.println("********************************************************************************************************************************************************************************************************************");
	}

	@Bean
	public CommandLineRunner init(InitialDataCreationService service) {
		return args -> {
			service.createFakeProducts(20);
			service.createFakeActivity(20);
		};
	}

}
