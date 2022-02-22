package by.it.academy.Mk_JD2_88_22.vote.wiew.service.api;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.VoteService;

import java.util.LinkedHashMap;
import java.util.List;

public interface IShowResults {


    LinkedHashMap<String, Integer> getTopSingers(VoteService voteService);

    LinkedHashMap<String, Integer> getTopGenres(VoteService voteService);

    List<String> getVoteInformation(VoteService voteService);
}
