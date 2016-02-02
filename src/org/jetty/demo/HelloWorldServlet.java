package org.jetty.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -317672973911602125L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("doGet2");
        // System.out.println(req.getQueryString());
        resp.getWriter().write("hello world!");
        resp.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.out.println("doPost");
        super.doPost(req, resp);
    }
}