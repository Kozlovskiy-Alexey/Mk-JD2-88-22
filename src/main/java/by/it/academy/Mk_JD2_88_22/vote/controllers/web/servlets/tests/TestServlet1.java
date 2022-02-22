package by.it.academy.Mk_JD2_88_22.vote.controllers.web.servlets.tests;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet1", urlPatterns = "/test_servlet", initParams = {@WebInitParam(name = "ExampleNameInitParam", value = "SomeValue")})
public class TestServlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String str = getServletConfig().getInitParameter("ExampleNameInitParam");
        PrintWriter writer = resp.getWriter();
        writer.write("Hello!");
        writer.write(str);
    }
}
