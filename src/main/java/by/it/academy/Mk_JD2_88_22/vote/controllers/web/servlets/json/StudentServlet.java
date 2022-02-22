package by.it.academy.Mk_JD2_88_22.vote.controllers.web.servlets.json;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.StudentService;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/json/student")
public class StudentServlet extends HttpServlet {

    private final StudentService studentService;
    private final ObjectMapper mapper;

    public StudentServlet() {
        this.studentService = StudentService.getInstance();
        this.mapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setEncodingAndContentType(req, resp);
        Student student = mapper.readValue(req.getInputStream(), Student.class);
        studentService.putStudentToList(student);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setEncodingAndContentType(req, resp);

        PrintWriter writer = resp.getWriter();
        List<Student> studentFromList = studentService.getStudentFromList();
        if (studentFromList.size() != 0) {
            String jsonString = this.mapper.writeValueAsString(studentFromList);
            writer.write(jsonString);
        }
    }

    private void setEncodingAndContentType(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset-UTF");
    }
}
