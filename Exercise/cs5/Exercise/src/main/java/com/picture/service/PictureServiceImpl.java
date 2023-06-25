package com.picture.service;

import com.picture.model.Feedback;
import com.picture.repository.IPictureRepository;
import com.picture.repository.PictureRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureServiceImpl implements IPictureService{
    @Autowired
    private IPictureRepository pictureRepository;

    @Override
    public List<Feedback> showList() {
        return pictureRepository.showList();
    }

    @Override
    public boolean add(Feedback feedback) {
        return pictureRepository.add(feedback);
    }

    @Override
    public boolean update(int id) {
        return pictureRepository.update(id);
    }

    @Override
    public Feedback findById(int id) {
        return pictureRepository.findById(id);
    }
}
