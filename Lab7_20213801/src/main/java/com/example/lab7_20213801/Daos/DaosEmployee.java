package com.example.lab7_20213801.Daos;
import com.example.lab7_20213801.Beans.Employee;

import java.sql.*;
import java.time.Period;
import java.util.ArrayList;

public class DaosEmployee {
    private static final String url = "jdbc:mysql://localhost:3306/hr";
    private static final String username = "root";
    private static final String password = "root";

    public ArrayList<Employee> list() {
        ArrayList<Employee> lista = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "select * from employees";

        try(
        Connection conn = DriverManager.getConnection(url, username, password);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
        try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Employee employee = new Employee();
                    employee.setEmployee_id(rs.getInt(1));
                    employee.setFullname(rs.getString(2)+" "+rs.getString(3));
                    employee.setEmail(rs.getString(4));
                    employee.setPassword(rs.getString(5));
                    employee.setPhone_number(rs.getString(6));
                    employee.setHire_date(rs.getString(7));
                    employee.setJob_id(rs.getString(8));
                    employee.setSalary(rs.getBigDecimal(9));
                    employee.setCommission_pct(rs.getBigDecimal(10));
                    employee.setManager_id(rs.getInt(11));
                    employee.setDepartment_id(rs.getInt(12));
                    employee.setEnabled(rs.getInt(13));

                    lista.add(employee);
                }
            }
        } catch(
        SQLException e)

        {
            throw new RuntimeException(e);
        }
            return lista;
    }


    public void create(Employee employee) {
        String sql = "INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, salary, commission_pct, employee_id, job_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            String[] name = employee.getFullname().split(" ");
            pstmt.setString(1, name[0]);
            pstmt.setString(2, name[1]);
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, employee.getPhone_number());
            pstmt.setString(5, employee.getHire_date());
            if (employee.getSalary() == null) {
                pstmt.setNull(6, Types.DECIMAL);
            } else {
                pstmt.setBigDecimal(6, employee.getSalary());
            }
            if (employee.getCommission_pct() == null) {
                pstmt.setNull(7, Types.DECIMAL);
            } else {
                pstmt.setBigDecimal(7, employee.getCommission_pct());
            }
            pstmt.setInt(8, employee.getEmployee_id());
            pstmt.setString(9, employee.getJob_id());

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Employee SearchbyId(int id){
        Employee employee = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String sql = "select * from employees where employee_id=?";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1,id);

            try(ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    employee = new Employee();
                    employee.setEmployee_id(rs.getInt(1));
                    employee.setFullname(rs.getString(2)+" "+rs.getString(3));
                    employee.setEmail(rs.getString(4));
                    employee.setPassword(rs.getString(5));
                    employee.setPhone_number(rs.getString(6));
                    employee.setHire_date(rs.getString(7));
                    employee.setJob_id(rs.getString(8));
                    employee.setSalary(rs.getBigDecimal(9));
                    employee.setCommission_pct(rs.getBigDecimal(10));
                    employee.setManager_id(rs.getInt(11));
                    employee.setDepartment_id(rs.getInt(12));
                    employee.setEnabled(rs.getInt(13));

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employee;

    }

    public ArrayList<Employee> SearchByName(String busqueda){
        ArrayList<Employee> lista = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String sql = "select * from employees where lower(first_name) like ? or lower(last_name) like ?";
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1,"%"+busqueda+"%");
            pstmt.setString(2,"%"+busqueda+"%");

            try(ResultSet rs = pstmt.executeQuery()){
                while (rs.next()) {
                    Employee employee = new Employee();
                    employee.setEmployee_id(rs.getInt(1));
                    employee.setFullname(rs.getString(2)+" "+rs.getString(3));
                    employee.setEmail(rs.getString(4));
                    employee.setPassword(rs.getString(5));
                    employee.setPhone_number(rs.getString(6));
                    employee.setHire_date(rs.getString(7));
                    employee.setJob_id(rs.getString(8));
                    employee.setSalary(rs.getBigDecimal(9));
                    employee.setCommission_pct(rs.getBigDecimal(10));
                    employee.setManager_id(rs.getInt(11));
                    employee.setDepartment_id(rs.getInt(12));
                    employee.setEnabled(rs.getInt(13));
                    lista.add(employee);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
    public void borrar(int employee_id) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "delete from employees where employee_id = ?";

        try(Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setInt(1,employee_id);
            pstmt.executeUpdate();

        }
    }

    public void actualizar(Employee employee) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String sql = "UPDATE employees SET first_name = ?, last_name = ?, email = ?, phone_number = ?, salary = ?, commission_pct = ?, hire_date = ? WHERE employee_id = ?";
        try(Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            String[] name = employee.getFullname().split(" ");
            pstmt.setString(1, name[0]);
            pstmt.setString(2, name[1]);
            pstmt.setString(3,employee.getEmail());
            pstmt.setString(4,employee.getPhone_number());
            pstmt.setBigDecimal(5, employee.getSalary());
            if (employee.getCommission_pct() == null) {
                pstmt.setNull(6, Types.DECIMAL);
            } else {
                pstmt.setBigDecimal(6, employee.getCommission_pct());
            }
            pstmt.setString(7, employee.getHire_date());
            pstmt.setInt(8,employee.getEmployee_id());


            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int searchLastId() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        String sql = "select employee_id from employees order by employee_id desc limit 1";

        try(Connection conn = DriverManager.getConnection(url,username,password);
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()){
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }



}
