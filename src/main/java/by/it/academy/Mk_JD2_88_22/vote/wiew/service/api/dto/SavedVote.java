package by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SavedVote implements Comparable<SavedVote>, Serializable {
    private final LocalDateTime voteTime;
    private final Vote vote;

    public SavedVote(LocalDateTime voteTime, Vote vote) {
        this.voteTime = voteTime;
        this.vote = vote;
    }

    public LocalDateTime getVoteTime() {
        return voteTime;
    }

    public Vote getVote() {
        return vote;
    }

    @Override
    public int compareTo(SavedVote o) {
        return this.getVoteTime().compareTo(o.getVoteTime());
    }
}
