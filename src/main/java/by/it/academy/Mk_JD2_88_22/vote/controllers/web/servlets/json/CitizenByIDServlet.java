package by.it.academy.Mk_JD2_88_22.vote.controllers.web.servlets.json;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.StudentService;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Citizen;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CitizenByIDServlet", urlPatterns = "/citizen/*")
public class CitizenByIDServlet extends HttpServlet {

    private final StudentService service;

    public CitizenByIDServlet() {
        this.service = StudentService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        String requestURI = req.getRequestURI();
        String id = requestURI.replaceAll("/Mk-JD2-88-22-1.0/citizen/", "");
        Citizen citizen1 = service.getCitizenFromList().stream().
                filter(student -> student.getId()
                        .equals(id))
                .findFirst()
                .get();

        writer.write(citizen1.toString());


    }
}