<%-- 
    Document   : Actores
    Created on : 1/12/2018, 05:56:35 PM
    Author     : RAGAd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String context = request.getContextPath();%>
<%@taglib  prefix="s" uri="/struts-tags" %>
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
        <script type="text/javascript" src="<%=context%>/js/teatroJS.js"></script>
        <title>Actores</title>
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
                    <a class="nav-link" href="<%=context%>/consultarSeccion">| Secciones</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="<%=context%>/consultarActores">| Actores</a>
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
                <div class="col-lg">
                    <br>
                    <h1 class="h1"><center>Lista de actores</center></h1>
                    <center>
                        <div class="alert alert-dark col-lg-5" role="alert">
                            <s:property value="mensaje"/>
                        </div>
                    </center>
                    <table class="table table-striped table-secondary">
                        <thead class="thead-light">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Primer apellido</th>
                                <th>Segundo apellido</th>
                                <th>Genero</th>
                                <th>Fecha de nacimiento</th>
                                <th>Direccion</th>
                                <th>Correo</th>
                                <th>Telefono</th>
                                <th>Descripcio</th>
                                <th>Eliminar</th>
                                <th>Modificar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="listaActores" status="stat" var="lista">
                                <tr>
                                    <td><s:property value="#stat.count" /></td>
                                    <td><s:property value="persona.nombre"/></td>
                                    <td><s:property value="persona.primerApeliido"/></td>
                                    <td><s:property value="persona.segundoApellido"/></td>
                                    <td><s:property value="persona.genero"/></td>
                                    <td><s:property value="persona.fechaNacimiento"/></td>
                                    <td><s:property value="persona.direccion"/></td>
                                    <td><s:property value="correo"/></td>                        
                                    <td><s:property value="telefono"/></td>                        
                                    <td><s:property value="descripcion"/></td>                        
                                    <td>
                                        <form action="eliminarActor" method="POST">
                                            <input type="hidden" name="bean.idActor" value="<s:property value="idActor"/>" />                                        
                                            <button type="submit" class="btn btn-danger"><i class="fas fa-trash"></i></button>
                                        </form>
                                    </td>
                                    <td>
                                        <form action="consultarActorId" method="POST">
                                            <input type="hidden" name="bean.idActor" value="<s:property value="idActor"/>" />                                        
                                            <button type="submit"  class="btn btn-secondary"><i class="far fa-edit"></i></button>
                                        </form>
                                    </td>
                                </tr>
                            </s:iterator>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row">
                <div class="col-lg"></div>
                <div class="col-lg">
                    <a class="btn btn-block btn-outline-dark" href="<%=context%>/vistas/actor/RegistrarActor.jsp">Registrar Actor <i class="fas fa-plus"></i></a>
                </div>
                <div class="col-lg"></div>
            </div>
        </div>
    </body>
</html>
