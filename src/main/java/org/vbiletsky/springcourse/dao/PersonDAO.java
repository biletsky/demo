package org.vbiletsky.springcourse.dao;

import org.springframework.stereotype.Repository;
import org.vbiletsky.springcourse.model.Person;

import java.util.*;

@Repository
public class PersonDAO {

    Map<String, Set<String>> people = new LinkedHashMap<>();

    {

        people.put("Alex", new HashSet<>(Arrays.asList("+79601232233")));
        people.put("Billy", new HashSet<>(Arrays.asList("+79213215566", "+79213215567", "+79213215568")));

    }

    public Map<String, Set<String>> index() {
        return new LinkedHashMap<>(this.people);
    }

    public Set<String> show(String name) {
       return people.get(name);
    }

    public void save(Person person) {
        people.put(person.getName(), person.getPhoneNumber());
    }

    public void update(String name, String phone) {
        Set<String> personPhones = people.get(name);
            personPhones.add(phone);
    }

    public Set<String> delete(Person person) {
      return people.remove(person.getName());
    }
}