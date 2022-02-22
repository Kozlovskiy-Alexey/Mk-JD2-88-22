package by.it.academy.Mk_JD2_88_22.vote.controllers.web.listeners;

import by.it.academy.Mk_JD2_88_22.vote.endpoints.service.BinaryFileVoteLoader;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.VoteService;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.IVoteService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * при запуске приложения считывает голоса из файла
 * при закрытии приложения сохраняет голоса в файл
 */
public class VoteContextListener implements ServletContextListener {

    private final static String FILE_PATH_INIT_PARAM = "pathToFile";
    private final IVoteService voteService;

    public VoteContextListener() {
        this.voteService = VoteService.getInstance();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String fileForSaveInstance = sce.getServletContext().getInitParameter(FILE_PATH_INIT_PARAM);
        new BinaryFileVoteLoader(voteService).load(fileForSaveInstance);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        String fileForSaveInstance = sce.getServletContext().getInitParameter(FILE_PATH_INIT_PARAM);
        new BinaryFileVoteLoader(voteService).upLoad(fileForSaveInstance);
    }
}
