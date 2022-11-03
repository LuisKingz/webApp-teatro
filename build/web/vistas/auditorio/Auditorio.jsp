<%-- 
    Document   : Auditorio
    Created on : 1/12/2018, 09:09:00 PM
    Author     : lfern
--%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%String context = request.getContextPath();%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<%=context%>/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=context%>/css/bootstrap.css" rel="stylesheet">
        <link href="<%=context%>/css/teatro2.css" rel="stylesheet">
        <link href="<%=context%>/font/css/all.css" rel="stylesheet">
        <script type="text/javascript" src="<%=context%>/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript" src="<%=context%>/js/bootstrap.bundle.js"></script>
        <title>Auditorios</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <ul class="navbar-nav mr-auto"> 
                <li class="nav-item">
                    <p class="nav-link active">Administrador</p>
                </li>
                <li class="nav-item">
                    <a href="<%=context%>/index.jsp" class="nav-link active">| <i class="fas fa-home"></i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="<%=context%>/consultarAuditorio">| Auditorios |</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=context%>/consultarSeccion">| Secciones</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=context%>/consultarActores">| Actores</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=context%>/consultarGeneros">| Géneros</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=context%>/consultarObras">| Obras</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=context%>/consultarFunciones">| Funciones</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=context%>/consultarPromociones">| Promociones</a>
                </li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item nav justify-content-end">
                    <a class="nav-link" href="<%=context%>/cerrarSession">Cerrar sesión <i class="fas fa-sign-out-alt"></i></a>
                </li>
            </ul>
        </nav>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg">
                    <br>
                    <h1 class="h1"><center>Lista de auditorios</center></h1>
                    <center>
                        <div class="alert alert-dark col-lg-5" role="alert">
                            <s:property value="mensaje"/>
                        </div>
                    </center>
                    <table class="table table-striped table-secondary">
                        <thead class="thead-light">
                            <tr>
                                <th>No.</th>
                                <th>Nombre</th>
                                <th>Capacidad</th>
                                <th>Mobiliario</th>
                                <th>Eliminar</th>
                                <th>Modificar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="listaAuditorio" status="stat" var="lista">
                                <tr>
                                    <td><s:property value="#stat.count"/></td>
                                    <td><s:property value="nombre"/></td>
                                    <td><s:property value="capacidad"/></td>
                                    <td><s:property value="mobiliario"/></td>
                                    <td>
                                        <form method="post" action="eliminarAuditorio">
                                            <input type="hidden" name="beanAuditorio.idAuditorio" value="<s:property value="idAuditorio"/>">
                                            <button type="submit" class="btn btn-danger"><i class="fas fa-trash"></i></button>
                                        </form>
                                    </td>
                                    <td>
                                        <form method="post" action="consultarEspecificaAuditorio">
                                            <input type="hidden" name="beanAuditorio.idAuditorio" value="<s:property value="idAuditorio"/>">
                                            <button type="submit"  class="btn btn-secondary"><i class="far fa-edit"></i></button>
                                        </form>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                </div>
                <div class="col-lg-2"></div>
            </div>
            <div class="row">
                <div class="col-lg"></div>
                <div class="col-lg">
                    <a class="btn btn-block btn-outline-dark" href="<%=context%>/vistas/auditorio/AgregarAuditorio.jsp">Registrar auditorio <i class="fas fa-plus"></i></a>
                </div>
                <div class="col-lg"></div>
            </div>
        </div>
    </body>
</html>
