
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.logging.StreamHandler" %>
<%@ page import="java.util.random.RandomGenerator" %>
<%@ page import="com.example.lab7_20213801.Beans.Job" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%ArrayList<Job>lista=(ArrayList<Job>) request.getAttribute("lista");%>
<html>
<head>
    <title>Trabajos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="clearfix mt-3 mt-2">
        <a href="<%=request.getContextPath()%>/JobServlet">
            <h1 class="float-start link-dark">Trabajos</h1>
        </a>
        <a class="btn btn-primary float-end mt-1" href="<%=request.getContextPath() %>/JobServlet?action=new">Crear trabajos</a>
        <a class="btn btn-primary float-end mt-1" style="margin-right: 10px"   href="<%=request.getContextPath() %>/home">Ver vista de empleados</a>

    </div>
    <hr/>
    <form method="post" action="<%=request.getContextPath()%>/JobServlet?action=s">
        <div class="form-floating mt-3">
            <input type="text" class="form-control" id="floatingInput"
                   placeholder="Por Job_Id" name="textoBuscar" value="<%= request.getAttribute("busqueda") != null ? request.getAttribute("busqueda") : "" %>">
            <label for="floatingInput">Buscar trabajo por ID</label>
        </div>
    </form>
    <table class="table table-striped mt-3">
        <tr class="table-primary">
            <th>ID</th>
            <th>Titulo</th>
            <th>Salario Minimo</th>
            <th>Salario Maximo</th>
            <th></th>
            <th></th>
        </tr>
        <% for (Job job : lista) { %>
        <tr>
            <td><%=job.getJob_id()  %>
            </td>

            <td><%=job.getJob_title()%>
            </td>

            <td><%=job.getMin_salary()%>
            </td>

            <td><%=job.getMax_salary()%></td>


            <td><a class="btn btn-success" href="<%=request.getContextPath()%>/JobServlet?action=edit&id=<%= job.getJob_id() %>">Editar</a></td>
            <td><a onclick="return confirm('¿Esta seguro de borrar?')" class="btn btn-danger" href="<%=request.getContextPath()%>/JobServlet?action=del&id=<%= job.getJob_id() %>">Borrar</a></td>
        </tr>
        <% } %>
    </table>
</div>
</body>
</html>