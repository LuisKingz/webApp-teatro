<%-- 
    Document   : PagoFuncion
    Created on : 12/12/2018, 08:28:59 PM
    Author     : Oscar Rodríguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<% String context = request.getContextPath();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="<%=context%>/js/scriptAsientos.js"></script>
        <link href="<%=context%>/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=context%>/css/bootstrap.css" rel="stylesheet">
        <link href="<%=context%>/font/css/all.css" rel="stylesheet">
        <link rel="stylesheet"type="text/css" href="<%=context%>/css/cssBotones.css">
        <script type="text/javascript" src="<%=context%>/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript" src="<%=context%>/js/bootstrap.bundle.js"></script>

        <script src="<%=context%>/js/jquery.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>

        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! <s:property value="beanFuncion.idFuncion"/></h1>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg-8">
                    <h1 class="h1"><center>Registrar función</center></h1>

                    <form action="registrarVenta" method="POST">
                        <div class="form-group">
                            <label for="descripcion">Nombre Funcion:</label>
                            <input disabled="" type="text" class="form-control" id="descripcion" value="<s:property value="beanFuncion.nombre"/>" name="beanVenta.descripcion" required=""/>
                        </div>
                        <div class="form-group">
                            <label for="fecha">Fecha Funcion:</label>
                            <input disabled="" type="text" class="form-control" id="fecha" name="beanVenta.fecha" value="<s:property value="beanFuncion.fechaFuncion"/>" required="" />
                        </div>
                        <div class="form-group">
                            <input hidden="" type="text" class="form-control" id="idUsuario"  name="beanVenta.idUsuario" value="<s:property value="#session.id"/>" required="">
                        </div>
                        <div class="form-group">
                            <input hidden="" type="text" class="form-control" id="idFuncion"  name="beanVenta.idFuncion" value="<s:property value="beanFuncion.idFuncion"/>" required="">
                        </div>
                        <div class="form-group">
                            <label for="costo">Precio base obra:</label>
                            <input disabled="" type="text" class="form-control" id="costo" name="beanVenta.costo" value="100.00" required="" />
                        </div>
                        <div class="form-group">
                            <label for="cantidadCompra">Cantidad de boletos:</label>
                            <input type="number" min="1" max="200" value="1" onkeyup="numBoletos()" class="form-control" id="cantidadCompra" name="beanVenta.cantidadCompra" required="" />
                        </div>
                        <div class="form-group">
                            <label for="tipoAsiento">Tipo Boleto:</label>
                            <select id="tipoAsiento" onchange="tipoBoleto()" name="beanVenta.tipoAsiento" class="form-control" required>
                                <option value="">Selecciona Tipo...</option>
                                <option value="vip">Vip</option>
                                <option value="medio">Medio</option>
                                <option value="basico">Basico</option>
                            </select>
                        </div>
                        <div class="col-lg">
                            <button class="btn btn-success btn-block" type="submit">Aceptar</button>
                        </div>
                        <div class="col-lg">
                            <a class="btn-danger btn btn-block" href="<%=context%>/consultarObrasUsuario">Cancelar</a>
                        </div>
                        <div class="col-lg"></div>
                    </form>

                </div>
                <div class="col-lg-2"></div>
            </div>
    </body>
</html>
