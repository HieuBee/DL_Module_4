package com.exercise2.model;

public class MusicFIle {
    private int id;
    private String name;
    private String listSong;
    private String file;

    public MusicFIle() {
    }

    public MusicFIle(int id, String name, String listSong, String file) {
        this.id = id;
        this.name = name;
        this.listSong = listSong;
        this.file = file;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getListSong() {
        return listSong;
    }

    public void setListSong(String listSong) {
        this.listSong = listSong;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
