package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"servidor"})
public class BancoDistribuidoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoDistribuidoApplication.class, args);
	}
}
