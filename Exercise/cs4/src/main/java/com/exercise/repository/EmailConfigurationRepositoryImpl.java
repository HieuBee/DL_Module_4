package com.exercise.repository;

import com.exercise.model.EmailConfiguration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmailConfigurationRepositoryImpl implements IEmailConfigurationRepository{
    static Map<Integer, EmailConfiguration> list;

    static {
        list = new HashMap<>();
        list.put(1, new EmailConfiguration(1,"English", 5, false, "Thor"));
        list.put(2, new EmailConfiguration(2,"Vietnamese", 10, true, "Hieu"));
        list.put(3, new EmailConfiguration(3,"Japanese", 15, true, "Samurai"));
        list.put(4, new EmailConfiguration(4,"Chinese", 25, false, "NgoKhong"));
        list.put(5, new EmailConfiguration(5,"Vietnamese", 50, false, "Khue"));
        list.put(6, new EmailConfiguration(6,"English", 100, true, "Spider Man"));
    }


    @Override
    public List<EmailConfiguration> display() {
        return new ArrayList<>(list.values());
    }

    @Override
    public void update(EmailConfiguration emailConfiguration) throws Exception {
        if (list.containsKey(emailConfiguration.getId())) {
            list.put(emailConfiguration.getId(), emailConfiguration);
            return;
        }
        throw new Exception("Product ID not exist");
    }

    @Override
    public EmailConfiguration findById(int id) {
        return list.get(id);
    }
}
