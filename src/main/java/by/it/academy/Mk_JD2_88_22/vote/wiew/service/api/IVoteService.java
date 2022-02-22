package by.it.academy.Mk_JD2_88_22.vote.wiew.service.api;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.SavedVote;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Vote;

import java.util.List;

public interface IVoteService {

    List<String> getArtist();

    List<String> getGenres();

    void addVote(Vote vote);

    public List<SavedVote> getVotes();

}
