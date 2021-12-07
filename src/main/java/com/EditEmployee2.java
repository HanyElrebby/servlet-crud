package com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EditEmployee2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String sid = req.getParameter("id");
        int id = Integer.parseInt(sid);

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String country = req.getParameter("country");

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setPassword(password);
        employee.setEmail(email);
        employee.setCountry(country);

        int status = EmployeeDao.updateEmployee(employee);
        if (status>0) {
            out.print("<p>Record saved successfully!</p>");
            req.getRequestDispatcher("index.html").include(req, resp);
        } else {
            out.println("Sorry! unable to save record");
            req.getRequestDispatcher("index.html").include(req, resp);
        }
        out.close();
    }
}
