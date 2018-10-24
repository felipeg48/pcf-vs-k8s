package io.pivotal.demos.directoryrest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectoryConfig {

    @Bean
    public CommandLineRunner init(PersonRepository personRepository){
        return args -> {
            personRepository.save(new Person("mike@example.com","Mike","1-800-JAVA"));
        };
    }
}
