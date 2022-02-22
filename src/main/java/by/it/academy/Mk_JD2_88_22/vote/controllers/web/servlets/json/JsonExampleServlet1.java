package by.it.academy.Mk_JD2_88_22.vote.controllers.web.servlets.json;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.VoteService;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Vote;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "JsonExampleServlet1", urlPatterns = "/test/jason_1")
public class JsonExampleServlet1 extends HttpServlet {

    private final VoteService voteService;
    private ObjectMapper mapper;

    public JsonExampleServlet1() {
        this.voteService = VoteService.getInstance();
        this.mapper = new ObjectMapper();
        System.out.println("Вызов конструктора JsonExampleServlet1()");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset-UTF-8");
        resp.setCharacterEncoding("UTF-8");

        Vote vote = mapper.readValue(req.getInputStream(), Vote.class);
        this.voteService.addVote(vote);
        PrintWriter writer = resp.getWriter();
        writer.write(vote.toString());
    }
}


















