package by.it.academy.Mk_JD2_88_22.vote.wiew.service;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.IShowResults;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.SavedVote;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class ShowResults implements IShowResults {
    private VoteService service = VoteService.getInstance();


    @Override
    public LinkedHashMap<String, Integer> getTopSingers(VoteService voteService) {
        Map<String, Integer> topSingers = new HashMap<>();
        List<SavedVote> savedVotes = voteService.getVotes();
        for (SavedVote savedVote : savedVotes) {
            topSingers.merge(savedVote.getVote().getArtist(), 1, Integer::sum);
        }
        for (String s: service.getArtist()) {
            topSingers.putIfAbsent(s, 0);
        }

        return topSingers.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors
                        .toMap(stringIntegerEntry -> stringIntegerEntry.getKey(),
                                stringIntegerEntry1 -> stringIntegerEntry1.getValue(),
                                (e1, e2) -> e1,
                                () -> new LinkedHashMap<>()));
    }

    @Override
    public LinkedHashMap<String, Integer> getTopGenres(VoteService voteService) {
        List<SavedVote> savedVotes = voteService.getVotes();
        Map<String, Integer> genresMap = new HashMap<>();

        for (SavedVote savedVote : savedVotes) {
            String[] genres = savedVote.getVote().getGenres();
            for (String s : genres) {
                if (genresMap.containsKey(s)) {
                    genresMap.put(s, genresMap.get(s) + 1);
                } else {
                    genresMap.put(s, 1);
                }

            }
        }


        for (String s2 : service.getGenres()) {
            genresMap.putIfAbsent(s2, 0);
        }

        return genresMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(Collectors
                        .toMap(stringIntegerEntry -> stringIntegerEntry.getKey(),
                                stringIntegerEntry -> stringIntegerEntry.getValue(),
                                (e1, e2) -> e1,
                                () -> new LinkedHashMap<>()));
    }

    @Override
    public LinkedList<String> getVoteInformation(VoteService voteService) {
        //SavedVoteComparator comparator = new SavedVoteComparator();
        LinkedList<String> voteList = new LinkedList<>();

        List<SavedVote> savedVotes = voteService.getVotes();
        // savedVotes.sort(comparator);

        for (SavedVote savedVote : savedVotes) {
            LocalDateTime voteTime = savedVote.getVoteTime();
            String artist = savedVote.getVote().getArtist();
            String genres = Arrays.toString(savedVote.getVote().getGenres());
            String about = savedVote.getVote().getAbout();
            voteList.add(voteTime + " Артист: " + artist + ", жанры музыки: " + genres + ", информация о себе: " + about);
        }
        return voteList;
    }
}
