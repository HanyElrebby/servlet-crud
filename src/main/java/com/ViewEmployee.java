package com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ViewEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String sPage = request.getParameter("page");
        int page = Integer.parseInt(sPage);
        int total = 3;

        out.println("<a href='index.html'>Add New Employee</a>");
        out.println("<h1>Employees List</h1>");

        List<Employee> list = EmployeeDao.getEmployees(page, total);

        out.print("<table border='1' width='100%'");
        out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th> " +
                "<th>Edit</th><th>Delete</th></tr>");
        for(Employee e:list){
            out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td> <td>"+e.getEmail()+"</td><td>"+e.getCountry()+"</td><td><a href='EditEmployee?id="+e.getId()+"'>edit</a></td> <td><a href='DeleteEmployee?id="+e.getId()+"'>delete</a></td></tr>");
        }
        out.print("</table>");

        out.print("<a href='ViewEmployee?page=1'>1</a> ");
        out.print("<a href='ViewEmployee?page=2'>2</a> ");
        out.print("<a href='ViewEmployee?page=3'>3</a> ");

        out.close();
    }
}
