<%-- 
    Document   : AgregarAuditorio
    Created on : 1/12/2018, 09:09:13 PM
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
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg"></div>
                <div class="col-lg">
                    <h2>Registrar nuevo auditorio</h2>
                    <br>
                    <form method="post" action="agreagarAuditorio" class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input type="text" name="beanAuditorio.nombre" required="" id="nombre" class="form-control" placeholder="Ej. Auditorio 1"/>
                        <br>
                        <input hidden="" type="number" id="capacidad" required="" name="beanAuditorio.capacidad" value="200"/>
                        <br>
                        <label for="mobiliario">Mobiliario:</label>
                        <input type="text" name="beanAuditorio.mobiliario" required="" id="mobiliario" class="form-control" placeholder="Ej. Dos pantallas..."/>
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
                <div class="col-lg"></div>
            </div>
        </div>
    </body>
</html>
