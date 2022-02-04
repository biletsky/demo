package org.vbiletsky.springcourse.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.vbiletsky.springcourse.dao.PersonDAO;
import org.vbiletsky.springcourse.exeption.CustomErrorException;
import org.vbiletsky.springcourse.model.Person;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Service
public class PersonService {

    PersonDAO personDAO;

    public PersonService(@Lazy PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public Map<String, Set<String>> index() {
        return new LinkedHashMap<>(personDAO.index());
    }

    public Set<String> show(String name) {

        if(personDAO.show(name)==null){
            throw new CustomErrorException("Customer is not exist");
        }
        else return personDAO.show(name);
    }

    public void save(Person person) {
        personDAO.save(person);
    }

    public void update(String name, String phone) {
        Set<String> personPhones = personDAO.show(name);
        if (personPhones.contains(phone)){
            throw new CustomErrorException("Phone exist");
        }
        else if(phone==null){
            throw new CustomErrorException("Phone is null");
        }
        else
            personDAO.update(name,phone);
    }

   public Set<String> delete(Person person) {
       if(personDAO.delete(person)==null){
           throw new CustomErrorException("Customer is not exist");
       }
       else return personDAO.delete(person);
   }
}