package by.it.academy.Mk_JD2_88_22.vote.controllers.web.servlets.votes;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.VoteService;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.IVoteService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "VoteIndexPageServlet", urlPatterns = "/vote")
public class VoteIndexPageServlet extends HttpServlet {

    private final IVoteService voteService;

    public VoteIndexPageServlet() {
        this.voteService = VoteService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        List<String> artists = voteService.getArtist();

        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>Старотовая страница</title>");
        writer.write("</head>");

        writer.write("<body>");
        writer.write("<h2>Приглашаем принять участие в нашем голосовании за звание лучшего артиста и лучший жанр 2022:</h2><br>");
        writer.write("<h3><a href=\"" + req.getContextPath() + "/show_artist\"" + " />Список артистов</h3>");
        writer.write("<h3><a href=\"" + req.getContextPath() + "/show_genre\"" + " />Список жанров</h3>");
        writer.write("<h3><a href=\"" + req.getContextPath() + "/vote_start\"" + " />Проголосовать</h3>");

        writer.write("</body>");
        writer.write("</html>");
    }
}
