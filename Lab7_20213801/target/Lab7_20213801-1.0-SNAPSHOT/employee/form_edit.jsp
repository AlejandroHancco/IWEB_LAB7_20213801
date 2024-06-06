<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.example.lab7_20213801.Beans.Employee" %>
<jsp:useBean id="employee" type="com.example.lab7_20213801.Beans.Employee" scope="request"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <title>Editar trabajador</title>
</head>
<body>
<div class='container'>
    <h1 class='mb-3'>Editar un trabajador</h1>
    <form method="post" action="<%=request.getContextPath()%>/home?action=e">
        <input type="hidden" name="id" value="<%= employee.getEmployee_id()%>"/>
        <div class="mb-3">
            <label for="firstName">FirstName</label>
            <input type="text" class="form-control form-control-sm" name="firstName" id="firstName"
                   value="<%= employee.getFullname().split(" ")[0] == null ? "" : employee.getFullname().split(" ")[0]%>">
        </div>
        <div class="mb-3">
            <label for="firstName">LastName</label>
            <input type="text" class="form-control form-control-sm" name="LastName" id="LastName"
                   value="<%= employee.getFullname().split(" ")[1] == null ? "" : employee.getFullname().split(" ")[1]%>">
        </div>

        <div class="mb-3">
            <label for="email">Email</label>
            <input type="text" class="form-control form-control-sm" name="email" id="email"
                   value="<%= employee.getEmail() == null ? "" : employee.getEmail()%>">
        </div>
        <div class="mb-3">
            <label for="phone">Phone number</label>
            <input type="text" class="form-control form-control-sm" name="phone" id="phone"
                   value="<%= employee.getPhone_number() == null ? "" : employee.getPhone_number()%>">
        </div>
        <div class="mb-3">
            <label for="hire_date">Hire date</label>
            <input type="text" class="form-control form-control-sm" name="hire_date" id="hire_date"
                   value="<%= employee.getHire_date()== null ? "" : employee.getHire_date()%>">
        </div>
        <div class="mb-3">
            <label for="salary">Salary</label>
            <input type="text" class="form-control form-control-sm" name="salary" id="salary"
                   value="<%= employee.getSalary() == null ? "" : employee.getSalary()%>">
        </div>
        <div class="mb-3">
            <label for="commission">Commision PCT</label>
            <input type="text" class="form-control form-control-sm" name="commission" id="commission"
                   value="<%= employee.getCommission_pct() == null ? "" : employee.getCommission_pct()%>">
        </div>
        <a href="<%=request.getContextPath()%>/home" class="btn btn-danger">Regresar</a>
        <button type="submit" class="btn btn-primary">Enviar</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>