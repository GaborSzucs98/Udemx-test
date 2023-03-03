package App.Rental;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*:application-context.xml"})
public class RentalApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RentalApplication.class, args);
	}
}