package com.exercise2.service;

import com.exercise2.model.MusicFIle;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileMusicServiceImpl implements IMusicFileService{
    private static List<MusicFIle> service = new ArrayList<>();
    static {
        service.add(new MusicFIle(1, "BIG BANG", "K-POP", "Link file" ));
        service.add(new MusicFIle(2, "Hoa Minz", "V-POP", "Link file" ));
        service.add(new MusicFIle(3, "BIG BANG", "K-POP", "Link file" ));
    }

    @Override
    public List<MusicFIle> display() {
        return service;
    }

    @Override
    public void add(MusicFIle file) {
        service.add(file);
    }
}
