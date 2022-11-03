<%-- 
    Document   : EliminarGenero
    Created on : 1/12/2018, 11:09:43 AM
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
                <div class="col-lg"></div>
                <div class="col-lg">
                    <h1>Modificar género</h1>
                    <form action="modificarGenero" method="post" class="form-group">
                        <br>
                        <input type="hidden" name="beanGenero.idGenero" value="<s:property value="beanGenero.idGenero"/>">
                        <label for="nombre">Nombre:</label>
                        <input type="text" name="beanGenero.nombre" id="nombre" class="form-control" required="" value="<s:property value="beanGenero.nombre"/>" />
                        <br>
                        <label for="descripcion">Descripcion:</label>
                        <input type="text" name="beanGenero.descripcion" id="descripcion" class="form-control"  required="" value="<s:property value="beanGenero.descripcion"/>">
                        <br/>
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

