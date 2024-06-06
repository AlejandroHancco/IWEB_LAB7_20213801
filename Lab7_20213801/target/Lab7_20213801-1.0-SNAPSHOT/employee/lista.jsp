
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.lab7_20213801.Beans.Employee" %>
<%@ page import="java.util.logging.StreamHandler" %>
<%@ page import="java.util.random.RandomGenerator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%ArrayList<Employee>lista=(ArrayList<Employee>) request.getAttribute("lista");%>
<html>
<head>
    <title>Trabajadores</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="clearfix mt-3 mt-2">
        <a href="<%=request.getContextPath()%>/home">
            <h1 class="float-start link-dark">Empleados</h1>
        </a>
        <a class="btn btn-primary float-end mt-1" href="<%=request.getContextPath() %>/home?action=new">Crear trabajador</a>
        <a class="btn btn-primary float-end mt-1" style="margin-right: 10px"   href="<%=request.getContextPath() %>/JobServlet">Ver vista de trabajos</a>

    </div>
    <hr/>
    <form method="post" action="<%=request.getContextPath()%>/home?action=s">
        <div class="form-floating mt-3">
            <input type="text" class="form-control" id="floatingInput"
                   placeholder="Por ID o por nombre" name="textoBuscar" value="<%= request.getAttribute("busqueda") != null ? request.getAttribute("busqueda") : "" %>">
            <label for="floatingInput">Buscar trabajador</label>
        </div>
    </form>
    <table class="table table-striped mt-3">
        <tr class="table-primary">
            <th>N°Id</th>
            <th>Nombre Completo</th>
            <th>Email</th>
            <th>Numero</th>
            <th>Salario</th>
            <th></th>
            <th></th>
        </tr>
        <% for (Employee employee : lista) { %>
        <tr>
            <td><%=employee.getEmployee_id()  %>
            </td>

            <td><%=employee.getFullname()%>
            </td>

            <td><%=employee.getEmail()%>
            </td>

            <td><%=employee.getPhone_number()%></td>


            <td><%=employee.getSalary()%> </td>

            <td><a class="btn btn-success" href="<%=request.getContextPath()%>/home?action=edit&id=<%= employee.getEmployee_id() %>">Editar</a></td>
            <td><a onclick="return confirm('¿Esta seguro de borrar?')" class="btn btn-danger" href="<%=request.getContextPath()%>/home?action=del&id=<%= employee.getEmployee_id() %>">Borrar</a></td>
        </tr>
        <% } %>
    </table>
</div>
</body>
</html>