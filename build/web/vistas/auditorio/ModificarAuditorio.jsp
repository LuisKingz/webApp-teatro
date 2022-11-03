<%-- 
    Document   : ModificarAuditorio
    Created on : 1/12/2018, 09:09:26 PM
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
                    <h2>Modificar auditorio</h2>
                    <br>
                    <form method="post" action="modificarAuditorio" >
                        <input type="hidden" name="beanAuditorio.idAuditorio" value="<s:property value="beanAuditorio.idAuditorio"/>">
                        <label>Nombre:</label>
                        <input type="text" name="beanAuditorio.nombre" id="nombre" class="form-control" value="<s:property value="beanAuditorio.nombre"/>"/>
                        <br>
                        <input type="number" hidden="" name="beanAuditorio.capacidad" value="<s:property value="beanAuditorio.capacidad"/>"/>
                        <br>
                        <label>Mobiliario:</label>
                        <input type="text" name="beanAuditorio.mobiliario" id="mobiliario" class="form-control" value="<s:property value="beanAuditorio.mobiliario"/>"/>
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