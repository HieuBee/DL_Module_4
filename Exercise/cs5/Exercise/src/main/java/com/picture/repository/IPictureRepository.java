package com.picture.repository;

import com.picture.model.Feedback;

import java.util.List;

public interface IPictureRepository {
    List<Feedback> showList();
    boolean add(Feedback feedback);
    boolean update(int id);
    Feedback findById(int id);
}
