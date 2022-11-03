<%-- 
    Document   : AgregarGenero
    Created on : 1/12/2018, 11:09:23 AM
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
        <title>Géneros</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg">

                    <h1>Registrar nuevo género</h1>
                    <br>
                    <form action="agregarGenero" method="post" class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input type="text"  placeholder="Ej. Suspenso" id="nombre" name="beanGenero.nombre" required="" class="form-control"/>
                        <br>
                        <label for="descripcion">Descripcion:</label>
                        <input type="text" placeholder="Ej. Tensión" id="" name="beanGenero.descripcion"  required="" class="form-control"/>
                        <br>
                        <div class="row">
                            <div class="col-lg">
                                <button class="btn btn-success btn-block" type="submit"><i class="far fa-save"></i> Guardar</button>
                            </div>
                            <div class="col-lg">
                                <a class="btn-danger btn btn-block" href="<%=context%>/consultarActores">Cancelar <i class="far fa-times-circle"></i></a>
                            </div>
                            <div class="col-lg"></div>
                        </div>
                    </form>
                </div>
                <div class="col-lg-3"></div>
            </div>
        </div>
    </body>
</html>
