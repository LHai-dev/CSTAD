package co.hai.microservices.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServiceApplication.class, args);
	}

	@Value("${spring.cloud.config.server.native.search-locations}")
	private String PATH;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello "+ PATH);
	}
}
