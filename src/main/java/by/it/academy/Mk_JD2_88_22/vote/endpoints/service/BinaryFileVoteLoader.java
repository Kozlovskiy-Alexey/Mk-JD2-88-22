package by.it.academy.Mk_JD2_88_22.vote.endpoints.service;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.VoteService;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.IVoteLoader;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.IVoteService;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.SavedVote;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Vote;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class BinaryFileVoteLoader implements IVoteLoader {

    private final IVoteService voteService;

    public BinaryFileVoteLoader(IVoteService voteService) {
        this.voteService = voteService;
    }

    @Override
    public void load(String filePath) {
        File file = Path.of(filePath).toFile();
        if (file.exists()) {
            if (voteService instanceof IVoteService) {
                VoteService service = (VoteService) voteService;
                try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
                    Object line = null;
                    while ((line = objectInputStream.readObject()) != null) {
                        service.addVote((Vote) line);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (EOFException ignored) {

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void upLoad(String filePath) {
        try {
            File file = Path.of(filePath).toFile();
            file.createNewFile();
            List<SavedVote> votes = voteService.getVotes();
            try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))) {
                for (SavedVote s : votes) {
                    writer.writeObject(s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
