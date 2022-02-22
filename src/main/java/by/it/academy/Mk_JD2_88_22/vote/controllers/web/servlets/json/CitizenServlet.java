package by.it.academy.Mk_JD2_88_22.vote.controllers.web.servlets.json;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.StudentService;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Citizen;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "CitizenServlet", urlPatterns = "/json/citizen")
public class CitizenServlet extends HttpServlet {

    private final StudentService studentService;
    private final ObjectMapper mapper;

    public CitizenServlet() {
        this.studentService = StudentService.getInstance();
        mapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setEncodingAndContentType(req, resp);

        Citizen citizen = mapper.readValue(req.getInputStream(), Citizen.class);
        studentService.putCitizenToList(citizen);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setEncodingAndContentType(req, resp);

        PrintWriter writer = resp.getWriter();
        List<Citizen> citizenFromList = studentService.getCitizenFromList();
        citizenFromList.forEach(s -> writer.write(s.toString()));
        if (citizenFromList.size() != 0) {
            String s = mapper.writeValueAsString(citizenFromList);
            writer.write(s);
        }
    }

    private void setEncodingAndContentType(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset-UTF");
    }
}
