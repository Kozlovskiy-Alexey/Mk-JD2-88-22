package by.it.academy.Mk_JD2_88_22.vote.wiew.service;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.SavedVote;

import java.util.Comparator;

public class SavedVoteComparator implements Comparator<SavedVote> {

    @Override
    public int compare(SavedVote o1, SavedVote o2) {
        return o1.getVoteTime().compareTo(o2.getVoteTime());
    }
}
