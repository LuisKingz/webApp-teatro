<%-- 
    Document   : RegistrarObra
    Created on : 2/12/2018, 10:42:14 AM
    Author     : Oscar Rodríguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<% String context = request.getContextPath();%>
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
        <title>Obras</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-4"></div>
                <div class="col-lg-4">
                    <h1 class="h1"><center>Registrar obra</center></h1>

                    <form action="registrarObra" method="POST">
                        <div class="form-group">
                            <label for="nombre">Nombre Obra:</label>
                            <input type="text" class="form-control" id="nombre" placeholder="Ej. Como quieras... ¡Perro Ámame!" name="beanObra.nombre" required="">
                        </div>
                        <div class="form-group">
                            <label for="duracion">Duracion:</label>
                            <input type="text" class="form-control" id="duracion"  name="beanObra.duracion" placeholder="Ej. 01:20:00" minlength="8" maxlength="8" required="">
                        </div>
                        <div class="form-group">
                            <label for="genero">Genero:</label>
                            <select id="genero" name="beanObra.genero.idGenero" class="form-control" required>
                                <option value="null">Selecciona...</option>
                                <s:iterator value="listaGenero" status="stat" var="lista">
                                    <option value="<s:property value="idGenero"/>"><s:property value="nombre"/></option>
                                </s:iterator>
                            </select>
                        </div>
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
                <div class="col-lg-4"></div>
            </div>
        </div>
    </body>
</html>
