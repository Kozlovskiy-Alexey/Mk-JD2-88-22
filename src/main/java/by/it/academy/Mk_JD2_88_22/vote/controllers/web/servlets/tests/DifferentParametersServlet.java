package by.it.academy.Mk_JD2_88_22.vote.controllers.web.servlets.tests;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "DifferentParametersServlet", urlPatterns = "/dif_param")
public class DifferentParametersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String theName = parameterNames.nextElement();
            //writer.write("<h3>param name: " + req.getParameter(theName) + "</h3>");
            if (theName.startsWith("name_")) {
                writer.write("<h3>param name: " + req.getParameter(theName) + "</h3>");
            }
        }

    }
}
