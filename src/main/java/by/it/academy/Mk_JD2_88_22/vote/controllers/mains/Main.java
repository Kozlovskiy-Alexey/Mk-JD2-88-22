package by.it.academy.Mk_JD2_88_22.vote.controllers.mains;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.VoteService;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.ShowResults;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Vote;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        String[] genres = {"Рок", "Фолк", "Латино"};
         Vote vote = new Vote("Марайя Кэри", genres, "Я проголосовал");
         Vote vote2 = new Vote("Майкл Джексон", genres, "Ура");
        VoteService voteService = VoteService.getInstance();
        voteService.addVote(vote);
        voteService.addVote(vote2);

        ShowResults showResults = new ShowResults();
        List<String> voteInformation = showResults.getVoteInformation(voteService);

        for (String s: voteInformation) {
            System.out.println(s);
        }
    }
}
