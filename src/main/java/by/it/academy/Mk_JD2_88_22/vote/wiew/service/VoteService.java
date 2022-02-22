package by.it.academy.Mk_JD2_88_22.vote.wiew.service;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.IVoteService;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Vote;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.SavedVote;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VoteService implements IVoteService, Serializable {

    private List<String> artists;
    private List<String> genres;
    private List<SavedVote> votes;
    private final static VoteService instance = new VoteService();

    private VoteService() {
        this.artists = new ArrayList<>();
        this.genres = new ArrayList<>();
        this.votes = new ArrayList<>();
        this.artists.add("Фредди Меркьюри");
        this.artists.add("Марайя Кэри");
        this.artists.add("Элвис Пресли");
        this.artists.add("Майкл Джексон");

        this.genres.add("Фолк");
        this.genres.add("Кантри");
        this.genres.add("Латино");
        this.genres.add("Блюз");
        this.genres.add("Джаз");
        this.genres.add("Рок");
        this.genres.add("Хип-хоп");
        this.genres.add("Регги");
        this.genres.add("Поп");
        this.genres.add("Шансон");
    }

    public static VoteService getInstance() {
        return instance;
    }

    @Override
    public List<String> getArtist() {
        return Collections.unmodifiableList(artists);
    }

    @Override
    public List<String> getGenres() {
        return Collections.unmodifiableList(genres);
    }

    @Override
    public void addVote(Vote vote) {
        SavedVote savedVote = new SavedVote(LocalDateTime.now(), vote);
        this.addVote(savedVote);
    }

    protected void addVote(SavedVote savedVote) {
        this.votes.add(savedVote);
        this.votes.sort(SavedVote::compareTo);
    }

    @Override
    public List<SavedVote> getVotes() {
        return Collections.unmodifiableList(votes);
    }
}
