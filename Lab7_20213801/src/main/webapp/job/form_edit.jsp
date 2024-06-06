<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.example.lab7_20213801.Beans.Job" %>
<jsp:useBean id="job" type="com.example.lab7_20213801.Beans.Job" scope="request"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <title>Editar trabajo</title>
</head>
<body>
<div class='container'>
    <h1 class='mb-3'>Editar un trabajo</h1>
    <form method="post" action="<%=request.getContextPath()%>/JobServlet?action=e">
        <input type="hidden" name="id" value="<%= job.getJob_id()%>"/>

        <div class="mb-3">
            <label for="jobTitle">Titulo del trabajo</label>
            <input type="text" class="form-control form-control-sm" name="jobTitle" id="jobTitle"
                   value="<%= job.getJob_title() == null ? "" : job.getJob_title()%>">
        </div>
        <div class="mb-3">
            <label for="minSalary">Salario Minimo</label>
            <input type="text" class="form-control form-control-sm" name="minSalary" id="minSalary"
                   value="<%= job.getMin_salary() == 0 ? "0" : job.getMin_salary()%>">
        </div>
        <div class="mb-3">
            <label for="maxSalary">Salario Maximo</label>
            <input type="text" class="form-control form-control-sm" name="maxSalary" id="maxSalary"
                   value="<%= job.getMax_salary() == 0 ? "0" : job.getMax_salary()%>">
        </div>


        <a href="<%=request.getContextPath()%>/JobServlet" class="btn btn-danger">Regresar</a>
        <button type="submit" class="btn btn-primary">Enviar</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>