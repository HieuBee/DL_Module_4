package com.picture.service;

import com.picture.model.Feedback;

import java.util.List;

public interface IPictureService {
    List<Feedback> showList();
    boolean add(Feedback feedback);
    boolean update(int id);
    Feedback findById(int id);
}
