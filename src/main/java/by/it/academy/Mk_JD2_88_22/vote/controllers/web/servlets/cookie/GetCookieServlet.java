package by.it.academy.Mk_JD2_88_22.vote.controllers.web.servlets.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/*
 * Сервлет должен принимать 2 параметра firstName и lastName
 * если параметр передали - записывать его в cookie
 * если не передали, то читать из cookie
 * выдать ошибку если нет информации ни в параметрах, ни в cookie
 * поприветствовать пользователа, вывести имя и фамилию
 * */
@WebServlet(name = "GetCookieServlet", urlPatterns = "/condition/getCookie")
public class GetCookieServlet extends HttpServlet {
    private final static String FIRST_NAME = "firstName";
    private final static String LAST_NAME = "lastName";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String firstName = getParameter(req, FIRST_NAME);
        String lastName = getParameter(req, LAST_NAME);
        saveCookies(resp, FIRST_NAME, firstName);
        saveCookies(resp, LAST_NAME, lastName);

        PrintWriter writer = resp.getWriter();
        writer.write("Привет, " + firstName + " " + lastName + "!");

    }

    public static String getParameter(HttpServletRequest req, String key) {
        String value = req.getParameter(key);
        if (value == null) {
            Cookie[] cookies1 = req.getCookies();
            if (cookies1 != null) {
                value = Arrays.stream(cookies1)
                        .filter(s -> key.equals(s.getName()))
                        .map(Cookie::getValue)
                        .findFirst()
                        .orElse(null);
            }
        }
        if (value == null) {
            throw new IllegalArgumentException("не задан обязательный параметр!");
        }
        return value;
    }

    public static void saveCookies(HttpServletResponse response, String key, String value) {
        Cookie cookie = new Cookie(key, value);
        response.addCookie(cookie);
    }
}
