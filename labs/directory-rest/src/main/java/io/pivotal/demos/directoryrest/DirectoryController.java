package io.pivotal.demos.directoryrest;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping("/persons")
public class DirectoryController {


    private PersonRepository personRepository;

    @GetMapping
    public Iterable<Person> getPeople(){
        return this.personRepository.findAll();
    }

    @GetMapping("/{email}")
    public Person findByEmail(@PathVariable String email){
        return this.personRepository.findById(email).orElse(null);
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person){
        this.personRepository.save(person);

        final URI location = ServletUriComponentsBuilder
                .fromCurrentServletMapping()
                .path("/persons/{email}")
                .build()
                .expand(person.getEmail())
                .toUri();

        return ResponseEntity.created(location).body(person);
    }
}
