package com.exercise.service;

import com.exercise.model.EmailConfiguration;

import java.util.List;

public interface IEmailConfigurationService {
    List<EmailConfiguration> display();
    void update(EmailConfiguration emailConfiguration) throws Exception;
    EmailConfiguration findById(int id);
}
