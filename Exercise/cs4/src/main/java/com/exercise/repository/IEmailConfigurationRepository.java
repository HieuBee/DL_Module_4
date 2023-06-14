package com.exercise.repository;

import com.exercise.model.EmailConfiguration;

import java.util.List;

public interface IEmailConfigurationRepository {
    List<EmailConfiguration> display();
    void update(EmailConfiguration emailConfiguration) throws Exception;
    EmailConfiguration findById(int id);
}
