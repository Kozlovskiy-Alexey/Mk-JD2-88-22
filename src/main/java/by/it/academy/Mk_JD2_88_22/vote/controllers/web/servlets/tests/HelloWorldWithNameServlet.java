package by.it.academy.Mk_JD2_88_22.vote.controllers.web.servlets.tests;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "HelloWorldWithNameServlet", urlPatterns = "/hello_with_name")
public class HelloWorldWithNameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        if (firstName != null && lastName != null) {
            Cookie cookie1 = new Cookie("firstName", firstName);
            Cookie cookie2 = new Cookie("lastName", lastName);
            cookie1.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
            cookie2.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
            resp.addCookie(cookie1);
            resp.addCookie(cookie2);
        } else {
            Cookie[] cookies = req.getCookies();
            firstName = cookies[0].getValue();
            lastName = cookies[1].getValue();
        }
        HttpSession session = req.getSession();

        if (firstName == null) {
            firstName = (String) session.getAttribute("firstName");
            if (firstName == null) {
                throw new IllegalArgumentException("Нет параметра firstName!");
            }
        } else {
            session.setAttribute("firstName", firstName);
        }

        if (lastName == null) {
            lastName = (String) session.getAttribute("lastName");
            if (lastName == null) {
                throw new IllegalArgumentException("Нет параметра lastName!");
            }
        } else {
            session.setAttribute("lastName", lastName);
        }


        PrintWriter writer = resp.getWriter();
        writer.write("<h1><span style='color: blue'>Hello, " + firstName + " " + lastName + "!</span></h1>");

    }
}
