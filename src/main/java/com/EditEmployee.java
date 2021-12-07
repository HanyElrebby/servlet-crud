package com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class EditEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<h1>Update Employee</h1>");

        String sid = req.getParameter("id");
        int id = Integer.parseInt(sid);

        Employee employee = EmployeeDao.getEmployee(id);
        out.println("<form action='EditEmployee2' method='post'>\n" +
                "    <table>\n" +
                        "<tr><td></td><td><input type='hidden' name='id' value='"+employee.getId()+"'/></td></tr>"+
                "        <tr><td>Name:</td><td><input type='text' name='name' value='"+employee.getName()+"'/></td></tr>\n" +
                "        <tr><td>Password:</td><td><input type='password' name='password' value='"+employee.getPassword()+"'/></td></tr>\n" +
                "        <tr><td>Email:</td><td><input type='email' name='email' value='"+employee.getEmail()+"'/></td></tr>\n" +
                "        <tr><td>Country:</td><td>\n" +
                "            <select name='country' style='width:150px'>\n" +
                "                <option>India</option>\n" +
                "                <option>USA</option>\n" +
                "                <option>UK</option>\n" +
                "                <option>Other</option>\n" +
                "            </select>\n" +
                "        </td></tr>\n" +
                "        <tr><td colspan='2'><input type='submit' value='Edit Employee'/></td></tr>\n" +
                "    </table>\n" +
                "</form>\n");

        out.close();
    }
}
