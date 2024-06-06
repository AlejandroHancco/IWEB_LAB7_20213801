package com.example.lab7_20213801.Daos;

import com.example.lab7_20213801.Beans.Job;

import java.sql.*;
import java.util.ArrayList;

public class DaosJob {
    private static final String url = "jdbc:mysql://localhost:3306/hr";
    private static final String username = "root";
    private static final String password = "root";

    public ArrayList<Job> list() {
        ArrayList<Job> lista = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "select * from jobs";

        try(
                Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Job job = new Job();
                    job.setJob_id(rs.getString(1));
                    job.setJob_title(rs.getString(2));
                    job.setMin_salary(rs.getInt(3));
                    job.setMax_salary(rs.getInt(4));

                    lista.add(job);
                }
            }
        } catch(
                SQLException e)

        {
            throw new RuntimeException(e);
        }
        return lista;
    }


    public void crear(Job job) {
        String sql = "INSERT INTO jobs (job_id, job_title, min_salary, max_salary) VALUES (?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, job.getJob_id());
            pstmt.setString(2, job.getJob_title());
            pstmt.setInt(3, job.getMin_salary());
            pstmt.setInt(4, job.getMin_salary());

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Job SearchbyId(String id){
        Job job = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String sql = "select * from jobs where job_id=?";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,id);

            try(ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    job = new Job();
                    job.setJob_id(rs.getString(1));
                    job.setJob_title(rs.getString(2));
                    job.setMin_salary(rs.getInt(3));
                    job.setMax_salary(rs.getInt(4));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return job;

    }

    public ArrayList<Job> SearchByName(String busqueda){
        ArrayList<Job> lista = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String sql = "select * from jobs where lower(job_id) like ? ";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,"%"+busqueda+"%");

            try(ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    Job job = new Job();
                    job.setJob_id(rs.getString(1));
                    job.setJob_title(rs.getString(2));
                    job.setMin_salary(rs.getInt(3));
                    job.setMax_salary(rs.getInt(4));
                    lista.add(job);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    public void borrar(String job_id) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "DELETE FROM jobs WHERE job_id = ?";

        try(Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,job_id);
            pstmt.executeUpdate();

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void actualizar(Job job) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql ="UPDATE jobs SET job_title = ?, min_salary = ?, max_salary = ? WHERE job_id = ?";
        try(Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, job.getJob_title());
            pstmt.setInt(2, job.getMin_salary());
            pstmt.setInt(3, job.getMax_salary());
            pstmt.setString(4, job.getJob_id());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





}
