<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="com.example.lab7_20213801.Beans.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
    <title>Crear trabajador</title>
</head>
<body>
<div class='container'>
    <h1 class='mb-3'>Crear un nuevo trabajador</h1>

    <form method="post" action="<%=request.getContextPath()%>/home">
        <div class="mb-3">
            <label for="id">ID del empleado</label>
            <input type="text" class="form-control form-control-sm" name="id" id="id">
        </div>
        <div class="mb-3">
            <label for="firstName">Nombre</label>
            <input type="text" class="form-control form-control-sm" name="firstName" id="firstName">
        </div>
        <div class="mb-3">
            <label for="lastName">Apellido</label>
            <input type="text" class="form-control form-control-sm" name="lastName" id="lastName">
        </div>
        <div class="mb-3">
            <label>Email</label>
            <input type="text" class="form-control" name="email" id="email">
        </div>
        <div class="mb-3">
            <label>Numero de Telefono</label>
            <input type="text" class="form-control" name="phoneNumber" id="phoneNumber">
        </div>
        <div class="mb-3">
            <label>ID de Trabajo</label>
            <input type="text" placeholder="Ingrese un ID de trabajo existente" class="form-control" name="jobId" id="jobId">
        </div>
        <div class="mb-3">
            <label>Fecha de Contratación</label>
            <input type="text" class="form-control" placeholder=" AA-MM-DD HH:MM:SS" name="hireDate" id="hireDate">
        </div>
        <div class="mb-3">
            <label for="salary">Salario</label>
            <input type="text" class="form-control form-control-sm" name="salary" id="salary">
        </div>
        <div class="mb-3">
            <label for="commission">Porcentaje de Comision</label>
            <input type="text" class="form-control form-control-sm" placeholder="Ingresa valores menores que 1"  name="commission" id="commission">
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