package com.exercise2.service;

import com.exercise2.model.MusicFIle;

import java.util.List;

public interface IMusicFileService {
    List<MusicFIle> display();
    void add(MusicFIle file);
}
