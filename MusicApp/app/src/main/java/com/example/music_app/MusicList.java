package com.example.music_app;

import android.net.Uri;

public class MusicList {
    private String artist, title, duration;
    private boolean isPlaying;
    private Uri musicFile;

    public MusicList(String artist, String title, String duration, boolean isPlaying, Uri musicFile) {
        this.artist = artist;
        this.title = title;
        this.duration = duration;
        this.isPlaying = isPlaying;
        this.musicFile = musicFile;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public Uri getMusicFile() {
        return musicFile;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }
}
