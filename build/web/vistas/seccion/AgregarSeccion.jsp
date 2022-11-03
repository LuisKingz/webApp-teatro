<%-- 
    Document   : AgregarSeccion
    Created on : 2/12/2018, 01:04:48 PM
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
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg"></div>
                <div class="col-lg">
                    <h2>Registrar nueva sección</h2>
                    <br>
                    <form action="agregarSeccion" method="post" class="form-group">
                        <label for="nombre">Nombre:</label>
                        <input type="text" placeholder="Ej. Sección 1" required="" id="nombre" class="form-control" name="beanSeccion.nombre">
                        <label for="tipoSeccion">Tipo sección:</label>
                        <select id="tipoSeccion" name="beanSeccion.tipoSeccion" required="" class="form-control">
                            <option>Selecciona...</option>
                            <option value="V.I.P.">V.I.P.</option>
                            <option value="Media">Media</option>
                            <option value="General">General</option>
                        </select>
                        <label for="precio">Precio:</label>
                        <input type="number" placeholder="Ej. 1000" required="" id="precio" min="1.0" class="form-control" name="beanSeccion.precio">
                        <label for="auditorio">Auditorio:</label>
                        <select id="auditorio" name="beanSeccion.auditorio.idAuditorio" required="" class="form-control">
                            <option>Selecciona...</option>
                            <s:iterator value="listaAuditorio" var="lista" status="stat">
                                <option value="<s:property value="idAuditorio"/>"><s:property value="nombre"/></option>
                            </s:iterator>
                        </select>
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
