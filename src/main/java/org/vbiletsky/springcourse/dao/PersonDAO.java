package org.vbiletsky.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class PersonDAO {

    @Bean
    public Map<String, Set<String>> people() {
        Map<String, Set<String>> data = new LinkedHashMap<>();
        data.put("Alex", new HashSet<>(Arrays.asList("+79601232233")));
        data.put("Billy", new HashSet<>(Arrays.asList("+79213215566", "+79213215567", "+79213215568")));
        return data;
    }

}