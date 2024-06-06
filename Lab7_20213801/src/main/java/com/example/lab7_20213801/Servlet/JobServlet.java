package com.example.lab7_20213801.Servlet;


import com.example.lab7_20213801.Beans.Job;
import com.example.lab7_20213801.Daos.DaosJob;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "JobServlet", value = "/JobServlet")
public class JobServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");
        DaosJob jobDao = new DaosJob();

        switch (action) {
            case "lista":
                ArrayList<Job> list = jobDao.list();
                request.setAttribute("lista", list);
                RequestDispatcher rd = request.getRequestDispatcher("job/lista.jsp");
                rd.forward(request, response);
                break;

            case "new":
                request.getRequestDispatcher("job/form_new.jsp").forward(request, response);
                break;
            case "edit":
                if (request.getParameter("id") != null) {
                    String jobId = request.getParameter("id");


                    Job job = jobDao.SearchbyId(jobId);

                    if (job != null) {
                        request.setAttribute("job", job);
                        RequestDispatcher view = request.getRequestDispatcher("job/form_edit.jsp");
                        view.forward(request, response);
                    } else {
                        response.sendRedirect("JobServlet");
                    }

                } else {
                    response.sendRedirect("JobServlet");
                }

                break;
            case "del":
                String idd = request.getParameter("id");
                Job job = jobDao.SearchbyId(idd);

                if (job != null) {
                    try {
                        jobDao.borrar(idd);
                    } catch (SQLException e) {
                        System.out.println("Log: excepcion: " + e.getMessage());
                    }
                }
                response.sendRedirect(request.getContextPath() + "/JobServlet?");
                break;

        }


    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        DaosJob jobDao = new DaosJob();

        String action = request.getParameter("action") == null ? "crear" : request.getParameter("action");

        switch (action){
            case "crear":

                Job job = new Job();
                job.setJob_id(request.getParameter("id"));
                job.setJob_title(request.getParameter("jobTitle"));
                job.setMin_salary(Integer.parseInt(request.getParameter("minSalary")));
                job.setMax_salary(Integer.parseInt(request.getParameter("maxSalary")));

                jobDao.crear(job);
                response.sendRedirect(request.getContextPath()+"/JobServlet");

                break;

            case "e":
                Job job1 = new Job();
                job1.setJob_id(request.getParameter("id"));
                job1.setJob_title(request.getParameter("jobTitle"));
                job1.setMin_salary(Integer.parseInt(request.getParameter("minSalary")));
                job1.setMax_salary(Integer.parseInt(request.getParameter("maxSalary")));

                jobDao.actualizar(job1);

                response.sendRedirect(request.getContextPath() + "/JobServlet");

                break;
            case "s":

                String textBuscar = request.getParameter("textoBuscar");
                ArrayList<Job> lista = jobDao.SearchByName(textBuscar);
                request.setAttribute("lista",lista);
                request.setAttribute("busqueda",textBuscar);
                request.getRequestDispatcher("job/lista.jsp").forward(request,response);
                break;
        }
    }


}
