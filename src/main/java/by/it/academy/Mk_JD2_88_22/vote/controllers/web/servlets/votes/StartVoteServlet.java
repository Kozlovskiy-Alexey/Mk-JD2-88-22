package by.it.academy.Mk_JD2_88_22.vote.controllers.web.servlets.votes;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.VoteService;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.ShowResults;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.IShowResults;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Vote;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "StartVoteServlet", urlPatterns = "/vote_start")
public class StartVoteServlet extends HttpServlet {

    private final VoteService service;
    private final IShowResults results;

    public StartVoteServlet() {
        service = VoteService.getInstance();
        results = new ShowResults();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>Голосование</title>");
        writer.write("</head>");

        writer.write("<body>");

        String artistValue = req.getParameter("artist");
        String[] artistsValues = req.getParameterValues("artist");
        String[] genresValues = req.getParameterValues("genre");
        String about = req.getParameter("about");

        if (artistsValues == null) {
            writer.write("<h1>Проголосуйте за артиста!</h1>");
        } else if (artistsValues.length > 1) {
            writer.write("<h1>Разрешено голосовать только за одного артиста!</h1>");
        } else if (genresValues == null) {
            writer.write("<h1>Выберите от 3 до 5 жанров!</h1>");
        } else if (genresValues.length < 3) {
            writer.write("<h1>Выберите не менее 3 жанров!</h1>");
        } else if (genresValues.length > 5) {
            writer.write("<h1>Выберите не более 5 жанров!</h1>");
        } else {
            Vote vote = new Vote(artistValue, genresValues, about);
            service.addVote(vote);
            LinkedHashMap<String, Integer> topSingers = results.getTopSingers(service);
            writer.write("<h3>ТОП артистов:</h3>");
            for (Map.Entry<String, Integer> entry : topSingers.entrySet()) {
                if (entry.getKey() != null) {
                    writer.write("<p>" + entry.getKey() + ", количество голосов: " + entry.getValue() + "</p>");
                }
            }

            writer.write("<h3>ТОП жанров:</h3>");
            LinkedHashMap<String, Integer> topGenres = results.getTopGenres(service);
            for (Map.Entry<String, Integer> entry2 : topGenres.entrySet()) {
                if (entry2.getKey() != null) {
                    writer.write("<p>" + entry2.getKey() + ", количество голосов: " + entry2.getValue() + "</p>");
                }
            }

            writer.write("<br>");
            List<String> voteInformation = results.getVoteInformation(service);
            writer.write("<h3>Информация по голосованию:</h3>");
            for (String s : voteInformation) {
                writer.write("<p>" + s + "</p>");
            }
            writer.write("<br>");
        }

        writer.write("<h3><a href=\"" + req.getContextPath() + "/show_artist\"" + " />Список артистов</h3>");
        writer.write("<h3><a href=\"" + req.getContextPath() + "/show_genre\"" + " />Список жанров</h3>");
        writer.write("<h3><a href=\"" + req.getContextPath() + "/vote\"" + " />На главную</h3><br>");
        writer.write("</body>");
        writer.write("</html>");
    }
}
