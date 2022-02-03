package org.vbiletsky.springcourse.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.vbiletsky.springcourse.exeptions.CustomErrorException;
import org.vbiletsky.springcourse.models.Person;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Service
public class PersonService {

    private final Map<String, Set<String>> people;

    public PersonService(Map<String, Set<String>> people) {
        this.people = people;
    }

    public Map<String, Set<String>> index() {
        return new LinkedHashMap<>(this.people);
    }

    public Set<String> show(String name) {
        if(people.get(name)==null){
            throw new CustomErrorException(HttpStatus.BAD_REQUEST,"Customer is not exist");
        }
        else return people.get(name);
    }

    public void save(Person person) {
        people.put(person.getName(), person.getPhoneNumber());
    }

    public void update(String name, String phone) {
        Set<String> personPhones = people.get(name);
        if (personPhones.contains(phone)){
            throw new CustomErrorException(HttpStatus.BAD_REQUEST,"Phone exist");
        }
        else if(phone==null){
            throw new CustomErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"Phone is null");
        }
        else
            personPhones.add(phone);
    }

    public Set<String> delete(Person person) {
        for (Map.Entry<String, Set<String>> entry : people.entrySet()) {
            if (entry.getKey().contains(person.getName())) {
                return people.remove(person.getName());
            }
        }
        throw new CustomErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Person is not exist");
    }
}