package by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto;

import java.io.Serializable;
import java.util.Arrays;

public class Vote implements Serializable {
    private String artist;
    private String[] genres;
    private String about;

    public Vote() {
    }

    public Vote(String artist, String[] genres, String about) {
        this.artist = artist;
        this.genres = genres;
        this.about = about;
    }

    public String getArtist() {
        return artist;
    }

    public String[] getGenres() {
        return genres;
    }

    public String getAbout() {
        return about;
    }

    @Override
    public String toString() {
        return "Pool{" +
                "artist='" + artist + '\'' +
                ", genres=" + Arrays.toString(genres) +
                ", about='" + about + '\'' +
                '}';
    }
}
