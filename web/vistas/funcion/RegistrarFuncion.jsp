<%-- 
    Document   : RegistrarFuncion
    Created on : 2/12/2018, 12:25:58 PM
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
        <title>Funciones</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-4"></div>
                <div class="col-lg-4">
                    <h1 class="h1"><center>Registrar función</center></h1>

                    <form action="registrarFuncion" method="POST">
                        <div class="form-group">
                            <label for="nombre">Nombre Funcion:</label>
                            <input type="text" class="form-control" id="nombre" placeholder="Ej. Funcion Noche" name="beanFuncion.nombre" required=""/>
                        </div>
                        <div class="form-group">
                            <label for="fechaFuncion">Fecha Funcion:</label>
                            <input type="text" class="form-control" id="fechaFuncion"  name="beanFuncion.fechaFuncion" placeholder="Ej. 2018-12-01" required="" />
                        </div>
                        <div class="form-group">
                            <label for="horaInicio">Hora Inicio:</label>
                            <input type="text" class="form-control" id="horaInicio"  name="beanFuncion.horaInicio" placeholder="Ej. 01:20:00" minlength="8" maxlength="8" required="">
                        </div>
                        <div class="form-group">
                            <label for="horaFin">Hora Fin</label>
                            <input type="text" class="form-control" id="horaFin"  name="beanFuncion.horaFin" placeholder="Ej. 03:00:00" minlength="8" maxlength="8" required="">
                        </div>
                        <div class="form-group">
                            <label for="obra">Obra:</label>
                            <select id="obra" name="beanFuncion.obra.idObra" class="form-control" required>
                                <option value="null">Selecciona...</option>
                                <s:iterator value="listaObra" status="stat" var="lista">
                                    <option value="<s:property value="idObra"/>"><s:property value="nombre"/></option>
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
