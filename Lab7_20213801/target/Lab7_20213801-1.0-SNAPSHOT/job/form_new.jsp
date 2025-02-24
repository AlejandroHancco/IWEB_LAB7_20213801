<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="com.example.lab7_20213801.Beans.Job" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <title>Crear trabajo</title>
</head>
<body>
<div class='container'>
    <h1 class='mb-3'>Crear un nuevo trabajo</h1>

    <form method="post" action="<%=request.getContextPath()%>/JobServlet">
        <div class="mb-3">
            <label for="id">ID del Trabajo</label>
            <input type="text" class="form-control form-control-sm" name="id" id="id">
        </div>
        <div class="mb-3">
            <label for="jobTitle">Titulo del Trabajo</label>
            <input type="text" class="form-control form-control-sm" name="jobTitle" id="jobTitle">
        </div>
        <div class="mb-3">
            <label for="minSalary">Salario Minimo</label>
            <input type="text" class="form-control form-control-sm" name="minSalary" id="minSalary">
        </div>
        <div class="mb-3">
            <label for="maxSalary">Salario Maximo</label>
            <input type="text" class="form-control form-control-sm" name="maxSalary" id="maxSalary">
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