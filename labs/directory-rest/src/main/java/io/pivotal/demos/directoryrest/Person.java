package io.pivotal.demos.directoryrest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

    @Id
    private String email;
    private String name;
    private String phone;

}
