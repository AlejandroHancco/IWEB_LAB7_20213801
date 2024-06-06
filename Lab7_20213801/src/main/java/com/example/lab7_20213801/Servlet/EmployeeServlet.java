package com.example.lab7_20213801.Servlet;

import com.example.lab7_20213801.Beans.Employee;
import com.example.lab7_20213801.Daos.DaosEmployee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.math.BigDecimal;

@WebServlet(name = "home", value = "/home")
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        DaosEmployee employeeDao = new DaosEmployee();
        switch (action) {
            case "lista":
                ArrayList<Employee> list = employeeDao.list();
                request.setAttribute("lista", list);
                RequestDispatcher rd = request.getRequestDispatcher("employee/lista.jsp");

                rd.forward(request, response);
                break;

            case "new":
                request.getRequestDispatcher("employee/form_new.jsp").forward(request, response);
                break;
            case "edit":
                if (request.getParameter("id") != null) {
                    String employeeIdString = request.getParameter("id");
                    int employeeId = 0;
                    try {
                        employeeId = Integer.parseInt(employeeIdString);
                    } catch (NumberFormatException ex) {
                        response.sendRedirect("home");

                    }

                    Employee emp = employeeDao.SearchbyId(employeeId);

                    if (emp != null) {
                        request.setAttribute("employee", emp);
                        RequestDispatcher view = request.getRequestDispatcher("employee/form_edit.jsp");
                        view.forward(request, response);
                    } else {
                        response.sendRedirect("home");
                    }

                } else {
                    response.sendRedirect("home");
                }

                break;
            case "del":
                int idd = Integer.parseInt(request.getParameter("id"));
                Employee employee1 = employeeDao.SearchbyId(idd);

                if (employee1 != null) {
                    try {
                        employeeDao.borrar(idd);
                    } catch (SQLException e) {
                        System.out.println("Log: excepcion: " + e.getMessage());
                    }
                }
                response.sendRedirect(request.getContextPath() + "/home?");
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        DaosEmployee employeeDao = new DaosEmployee();

        String action = request.getParameter("action") == null ? "crear" : request.getParameter("action");

        switch (action){
            case "crear":
                int employee_id = Integer.parseInt(request.getParameter("id"));
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String email = request.getParameter("email");
                String phone_number = request.getParameter("phoneNumber");
                String job_id = request.getParameter("jobId");
                String hire_date = request.getParameter("hireDate");

                    Employee employee = new Employee();
                    employee.setEmployee_id(employee_id);
                    employee.setFullname(firstName+" "+lastName);
                    employee.setEmail(email);
                    employee.setPhone_number(phone_number);
                    employee.setHire_date(hire_date);
                    employee.setSalary(request.getParameter("salary").equals("") ? null :new BigDecimal(request.getParameter("salary")));
                    employee.setCommission_pct(request.getParameter("commission").equals("") ? null : new BigDecimal(request.getParameter("commission")));
                    employee.setJob_id(request.getParameter("jobId"));
                    employee.setEmployee_id(Integer.parseInt(request.getParameter("id")));

                    employeeDao.create(employee);
                    response.sendRedirect(request.getContextPath()+"/home");


                break;
            case "e":
                Employee employee2 = new Employee();
                String fullname = request.getParameter("firstName") + " " + request.getParameter("LastName");
                employee2.setFullname(fullname);
                employee2.setEmail(request.getParameter("email"));
                employee2.setPhone_number(request.getParameter("phone"));
                employee2.setHire_date(request.getParameter("hire_date"));
                employee2.setSalary(request.getParameter("salary").equals("") ? null :new BigDecimal(request.getParameter("salary")));
                employee2.setCommission_pct(request.getParameter("commission").equals("") ? null : new BigDecimal(request.getParameter("commission")));
                employee2.setJob_id(request.getParameter("job_id"));
                employee2.setEmployee_id(Integer.parseInt(request.getParameter("id")));
                employeeDao.actualizar(employee2);

                response.sendRedirect(request.getContextPath() + "/home");

                break;
            case "s":

                String textBuscar = request.getParameter("textoBuscar");
                ArrayList<Employee> lista = employeeDao.SearchByName(textBuscar);
                request.setAttribute("lista",lista);
                request.setAttribute("busqueda",textBuscar);
                request.getRequestDispatcher("employee/lista.jsp").forward(request,response);
                request.getRequestDispatcher("index.jsp").forward(request,response);
                break;
        }
    }

}
