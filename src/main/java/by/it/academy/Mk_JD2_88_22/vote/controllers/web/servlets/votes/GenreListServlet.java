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

@WebServlet(name = "GenrelistServlet", urlPatterns = "/show_genre")
public class GenreListServlet extends HttpServlet {

    private final IVoteService voteService;

    public GenreListServlet() {
        this.voteService = VoteService.getInstance();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        List<String> genres = voteService.getGenres();

        writer.write("<html>");
        writer.write("<head>");
        writer.write("<title>Список жанров</title>");
        writer.write("</head>");

        writer.write("<body>");
        writer.write("<h2>Спсиок жанров для голосования:</h2><br>");
        int counter = 1;
        for (String s : genres) {
            writer.write("<h3>" + counter + ". "  + s + "</h3>");
            counter++;
        }
        writer.write("<br>");
        writer.write("<h3><a href=\"" + req.getContextPath() + "/vote_start\"" + " />Ссылка на голосование</h3>");
        writer.write("<h3><a href=\"" + req.getContextPath() + "/vote\"" + " />На главную</h3><br>");

        writer.write("</body>");
        writer.write("</html>");


    }
}
