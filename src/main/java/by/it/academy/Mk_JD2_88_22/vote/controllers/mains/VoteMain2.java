package by.it.academy.Mk_JD2_88_22.vote.controllers.mains;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.ShowResults;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.VoteService;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.SavedVote;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Vote;
import org.junit.runner.Request;

import java.util.*;

public class VoteMain2 {
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

        
    }
}
