<%-- 
    Document   : ModificarObra
    Created on : 2/12/2018, 10:58:55 AM
    Author     : Oscar Rodríguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%String context = request.getContextPath();%>
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
                    <h1 class="h1"><center>Modificar obra</center></h1>

                    <form action="modificarObra" method="POST" class="form form-group">
                        <input type="hidden" name="beanObra.idObra"  value="<s:property value="beanObra.idObra"/>">
                        <div class="form-group">
                            <label for="nombre">Nombre Obra:</label>
                            <input type="text" class="form-control" id="nombre" name="beanObra.nombre" value="<s:property value="beanObra.nombre"/>">
                        </div>
                        <div class="form-group">
                            <label for="duracion">Duracion:</label>
                            <input type="text" class="form-control" id="duracion"  name="beanObra.duracion" minlength="8" maxlength="8" required value="<s:property value="beanObra.duracion"/>">
                        </div>
                        <div class="form-group">
                            <label for="genero">Genero:</label>
                            <select id="genero" name="beanObra.genero.idGenero" class="form-control">
                                <option value="<s:property value="beanObra.genero.idGenero"/>"><s:property value="beanObra.genero.nombre"/></option>
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
