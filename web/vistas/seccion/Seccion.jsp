<%-- 
    Document   : Seccion
    Created on : 2/12/2018, 01:03:50 PM
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
        <title>Secciones</title>
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
                    <a class="nav-link" href="<%=context%>/consultarAuditorio">| Auditorios |</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="<%=context%>/consultarSeccion">| Secciones</a>
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
                <div class="col-lg-1"></div>
                <div class="col-lg">
                    <br>
                    <h1 class="h1"><center>Lista de secciones</center></h1>
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
                                <th>Tipo De Sección</th>
                                <th>Cantidad de Asientos</th>
                                <th>Precio</th>
                                <th>Auditorio</th>
                                <th>Eliminar</th>
                                <th>Modificar</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="listaSeccion" var="lista" status="stat">
                                <tr>
                                    <td><s:property value="#stat.count"/></td>
                                    <td><s:property value="nombre"/></td>
                                    <td><s:property value="tipoSeccion"/></td>
                                    <td><s:property value="cantidadAsientos"/></td>
                                    <td>$ <s:property value="precio"/></td>
                                    <td><s:property value="auditorio.nombre"/></td>
                                    <td>
                                        <form method="post" action="eliminarSeccion">
                                            <input type="hidden" name="beanSeccion.idSeccion" value="<s:property value="idSeccion"/>">
                                            <button type="submit" class="btn btn-danger"><i class="fas fa-trash"></i></button>
                                        </form>
                                    </td>
                                    <td>
                                        <form method="post" action="consultaEspecifica">
                                            <input type="hidden" name="beanSeccion.idSeccion" value="<s:property value="idSeccion"/>">
                                            <button type="submit"  class="btn btn-secondary"><i class="far fa-edit"></i></button>
                                        </form>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                </div>
                <div class="col-lg-1"></div>
            </div>
            <div class="row">
                <div class="col-lg"></div>
                <div class="col-lg">
                    <a class="btn btn-block btn-outline-dark" href="<%=context%>/registroSeccion">Registrar sección <i class="fas fa-plus"></i></a>
                </div>
                <div class="col-lg"></div>
            </div>
        </div>

    </body>
</html>
