package vn.kunjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class KunjavaSampleCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KunjavaSampleCodeApplication.class, args);
	}

}
