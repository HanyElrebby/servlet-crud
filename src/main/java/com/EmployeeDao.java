package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sonoo", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static int saveEmployee(Employee employee) {
        int status = 0;
        try{
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "insert into user905(name,password,email,country) values (?,?,?,?)");
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getPassword());
            statement.setString(3, employee.getEmail());
            statement.setString(4, employee.getCountry());
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int updateEmployee(Employee employee) {
        int status = 0;
        try{
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "update user905 set name = ?, password = ?, email = ?, country = ? where id = ?");
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getPassword());
            statement.setString(3, employee.getEmail());
            statement.setString(4, employee.getCountry());
            statement.setInt(5, employee.getId());
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static int deleteEmployee(int id) {
        int status = 0;
        try{
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "delete from user905 where id = ?");
            statement.setInt(1, id);
            status = statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static Employee getEmployee(int id) {
        Employee employee = new Employee();
        try{
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "select * from user905 where id = ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                employee.setId(resultSet.getInt(1));
                employee.setName(resultSet.getString(2));
                employee.setPassword(resultSet.getString(3));
                employee.setEmail(resultSet.getString(4));
                employee.setCountry(resultSet.getString(5));
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        try{
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "select * from user905");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt(1));
                employee.setName(resultSet.getString(2));
                employee.setPassword(resultSet.getString(3));
                employee.setEmail(resultSet.getString(4));
                employee.setCountry(resultSet.getString(5));
                employees.add(employee);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static List<Employee> getEmployees(int start, int total) {
        List<Employee> employees = new ArrayList<>();
        try{
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "select * from user905 limit "+(start-1)+","+total);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt(1));
                employee.setName(resultSet.getString(2));
                employee.setPassword(resultSet.getString(3));
                employee.setEmail(resultSet.getString(4));
                employee.setCountry(resultSet.getString(5));
                employees.add(employee);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employees;
    }
}
