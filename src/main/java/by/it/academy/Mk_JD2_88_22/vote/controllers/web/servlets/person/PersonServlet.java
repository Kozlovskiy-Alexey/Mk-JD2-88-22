package by.it.academy.Mk_JD2_88_22.vote.controllers.web.servlets.person;

import by.it.academy.Mk_JD2_88_22.vote.endpoints.service.SelectedFromHeaderStorage;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.IStorageService;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PersonServlet", urlPatterns = "/person")
public class PersonServlet extends HttpServlet {

    private final static String HEADER_CHOOSE_CONDITION = "chooseCondition";
    private final static String CHOOSE_SESSION = "session";
    private final static String CHOOSE_COOKIE = "cookie";
    private final static String FIRST_NAME = "firstName";
    private final static String LAST_NAME = "lastName";
    private final static String AGE = "age";
    private final static String PERSON = "person";

    private IStorageService selectedStorage;

    public PersonServlet() {
        this.selectedStorage = new SelectedFromHeaderStorage();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        String ageRaw = req.getParameter(AGE);

        if (firstName == null || lastName == null || ageRaw == null) {
            throw new IllegalArgumentException("Не задан обязательный параметр");
        }
        int age = Integer.parseInt(req.getParameter(AGE));

        Person person = new Person(firstName, lastName, age);

        selectedStorage.addToStorage(person, req, resp);

        Person personFromStorage = selectedStorage.getFromStorage(req, resp);

        PrintWriter writer = resp.getWriter();
        writer.write(personFromStorage.toString());
    }
}
