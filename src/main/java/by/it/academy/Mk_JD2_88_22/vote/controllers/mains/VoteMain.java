package by.it.academy.Mk_JD2_88_22.vote.controllers.mains;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.VoteService;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.ShowResults;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Vote;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.SavedVote;

import java.util.*;

public class VoteMain {
    public static void main(String[] args) {

        VoteService service = VoteService.getInstance();
        List<String> artists = service.getArtist();
        List<String> genres = service.getGenres();

        String choiceArtist1 = service.getArtist().get(new Random().nextInt(4));
        String choiceArtist2 = service.getArtist().get(new Random().nextInt(4));
        String choiceArtist3 = service.getArtist().get(new Random().nextInt(4));
        String choiceArtist4 = service.getArtist().get(new Random().nextInt(4));

        String[] choiceGenres = {"Поп", "Рок", "Джаз"};

        String about = "Привет Алексей";

        Vote vote1 = new Vote(choiceArtist1, choiceGenres, about + "1");
        Vote vote2 = new Vote(choiceArtist2, choiceGenres, about + "2");
        Vote vote3 = new Vote(choiceArtist3, choiceGenres, about + "3");
        Vote vote4 = new Vote(choiceArtist4, choiceGenres, about + "4");
        service.addVote(vote1);
        service.addVote(vote2);
        service.addVote(vote3);
        service.addVote(vote4);

        List<SavedVote> savedVotes = service.getVotes();
        for (SavedVote savedPool : savedVotes) {
            System.out.println("vote time: " + savedPool.getVoteTime() + " " + savedPool.getVote().toString());
        }

        ShowResults showResults = new ShowResults();
        LinkedHashMap<String, Integer> topSingers = showResults.getTopSingers(service);
        Set<Map.Entry<String, Integer>> entries = topSingers.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " набрал голосов: " + entry.getValue());
        }
    }
}
