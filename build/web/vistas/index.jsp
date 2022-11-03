<%-- 
    Document   : index
    Created on : 1/12/2018, 05:58:26 PM
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
        <link href="<%=context%>/css/teatro.css" rel="stylesheet">
        <link href="<%=context%>/font/css/all.css" rel="stylesheet">
        <script type="text/javascript" src="<%=context%>/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript" src="<%=context%>/js/bootstrap.bundle.js"></script>
        <title>Teatro</title>
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
                    <a class="nav-link" href="<%=context%>/cerrarSesion">Cerrar sesión <i class="fas fa-sign-out-alt"></i></a>
                </li>
            </ul>
        </nav>
                <h1><center>BIENVENIDO!</center></h1>
        <div class="container-fluid">
        </div>
    </body>
</html>
