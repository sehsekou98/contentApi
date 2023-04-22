package Contentapi;

import Contentapi.model.Content;
import Contentapi.model.Status;
import Contentapi.model.Type;
import Contentapi.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ContentApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(ContentApiApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository repository) {
		return args -> {
			 Content content = new Content(null,
					 "Spring in Action",
					 "Learning Spring",
					 Status.IDEA,
					 Type.COURSE,
					 LocalDateTime.now(),
					 null,
					 "");

			 repository.save(content);
		};
	}

}
