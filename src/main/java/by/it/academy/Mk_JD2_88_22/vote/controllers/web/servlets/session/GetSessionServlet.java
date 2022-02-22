package by.it.academy.Mk_JD2_88_22.vote.controllers.web.servlets.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Сервлет должен принимать 2 параметра firstName и lastName
 * если параметр передали - записывать его в сессию
 * если не передали, то читать из сессии
 * выдать ошибку если нет информации ни в параметрах, ни в сессии
 * поприветствовать пользователа, вывести имя и фамилию
 * */
@WebServlet(name = "GetSessionServlet", urlPatterns = "/condition/getSession")
public class GetSessionServlet extends HttpServlet {
    private final static String FIRST_NAME = "firstName";
    private final static String LAST_NAME = "lastName";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String firstName = getParameterFromSession(req, FIRST_NAME);
        setSessionAttribute(req, FIRST_NAME, firstName);
        String lastName = getParameterFromSession(req, LAST_NAME);
        setSessionAttribute(req, LAST_NAME, lastName);

        PrintWriter writer = resp.getWriter();
        writer.write("Привет, " + firstName + " " + lastName + "!");
    }

    public static String getParameterFromSession(HttpServletRequest req, String key) {
        String value = req.getParameter(key);
        if (value == null) {
            HttpSession session = req.getSession();
            String attribute = (String) session.getAttribute(key);
            if (attribute != null) {
                value = attribute;
            }
        }
        if (value == null) {
            throw new IllegalArgumentException("не задан обязательный параметр!");
        }
        return value;
    }

    public static void setSessionAttribute(HttpServletRequest request, String attributeName, String value) {
        HttpSession session = request.getSession();
        session.setAttribute(attributeName, value);
    }
}
