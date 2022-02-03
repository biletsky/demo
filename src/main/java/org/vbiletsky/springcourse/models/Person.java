package org.vbiletsky.springcourse.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Person {

    private String name;
    private Set<String> phoneNumber;

}
