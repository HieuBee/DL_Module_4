package com.exercise.service;

import com.exercise.model.EmailConfiguration;
import com.exercise.repository.EmailConfigurationRepositoryImpl;
import com.exercise.repository.IEmailConfigurationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmailConfigurationServiceImpl implements IEmailConfigurationService{
    private IEmailConfigurationRepository repository = new EmailConfigurationRepositoryImpl();

    @Override
    public List<EmailConfiguration> display() {
        return repository.display();
    }

    @Override
    public void update(EmailConfiguration emailConfiguration) throws Exception {
        repository.update(emailConfiguration);
    }

    @Override
    public EmailConfiguration findById(int id) {
        return repository.findById(id);
    }
}
