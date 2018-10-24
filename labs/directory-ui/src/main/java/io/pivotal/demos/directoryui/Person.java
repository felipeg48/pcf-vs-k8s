package io.pivotal.demos.directoryui;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {

    private String email;
    private String name;
    private String phone;

}