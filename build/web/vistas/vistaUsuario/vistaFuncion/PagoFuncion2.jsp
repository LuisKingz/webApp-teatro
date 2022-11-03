<%-- 
    Document   : PagoFuncion2
    Created on : 12/12/2018, 10:05:54 PM
    Author     : Oscar Rodríguez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="s" uri="/struts-tags" %>
<% String context = request.getContextPath();%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="<%=context%>/ja/scriptAsientos.js"></script>
        <link href="<%=context%>/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=context%>/css/bootstrap.css" rel="stylesheet">
        <link href="<%=context%>/font/css/all.css" rel="stylesheet">
        <link rel="stylesheet"type="text/css" href="<%=context%>/css/cssBotones.css">
        <script type="text/javascript" src="<%=context%>/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript" src="<%=context%>/js/bootstrap.bundle.js"></script>

        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
        <link href="<%=context%>/css/estilos.css" rel="stylesheet">
        <script src="<%=context%>/js/jquery.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <title>Paso 2:</title>
    </head>
    <body>
        <input hidden="" type="text" class="form-control" id="cantidadCompra" value="<s:property value="beanVenta.cantidadCompra"/>"/>
        <input hidden="" type="text" class="form-control" id="tipoAsiento" value="<s:property value="beanVenta.tipoAsiento"/>"/>
        <input hidden="" type="text" class="form-control" id="idFuncion" value="<s:property value="beanVenta.idFuncion"/>"/>
    <center><div class="container">
            <header class="blog-header py-3">
                <div class="row flex-nowrap justify-content-between align-items-center">
                    <div class="col-4 text-center">
                        <h3><s:property value="#session.nombre"/></h3>
                    </div>
                    <div class="col-4 d-flex justify-content-end align-items-center">
                        <a class="btn btn-sm btn-outline-secondary" href="<%=context%>/cerrarSession">Cerrar sesión</a>

                    </div>
                </div>
            </header>
            <br>
            <h1>Selecciona tus asientos: <s:property value="beanVenta.idFuncion"/></h1>
            <br>
            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg-8">
                    <s:iterator value="asientos" status="stat" var="lista">
                        <%boolean bandera = true;%>
                        <s:set value="idAsiento" var="asiento"/>
                        <s:set value="tipoAsiento" var="tAsiento"/>
                        <s:iterator value="listaAsientosF" status="stat1" var="lista1">
                            <s:set value="Asiento" var="asientoOcupado"/>
                            <s:if test="{#asiento} == {#asientoOcupado}">
                                <button disabled="" class="btn btn-circle btn-danger" name="vip" value="<s:property value="idAsiento"/>" id="<s:property value="nombreAsiento"/>" onclick="asignarAsiento(<s:property value="nombreAsiento"/>)"> </button>
                                <%bandera = false;%>
                            </s:if>
                        </s:iterator>
                        <%if (bandera) {%>
                        <s:if test="#stat.count <= 50">
                            <button class="btn btn-circle btn-outline-warning" name="vip" value="<s:property value="idAsiento"/>" id="<s:property value="nombreAsiento"/>" onclick="asignarAsiento(<s:property value="nombreAsiento"/>)"> </button>
                        </s:if>
                        <s:elseif test="#stat.count > 50 && #stat.count <= 100">
                            <button class="btn btn-circle btn-outline-primary" name="med" value="<s:property value="idAsiento"/>" id="<s:property value="nombreAsiento"/>" onclick="asignarAsiento(<s:property value="nombreAsiento"/>)"></button>
                        </s:elseif>
                        <s:else>
                            <button class="btn btn-circle btn-outline-dark" name="bac" value="<s:property value="idAsiento"/>" id="<s:property value="nombreAsiento"/>" onclick="asignarAsiento(<s:property value="nombreAsiento"/>)"></button>
                        </s:else>
                        <%}%>
                        <s:if test="#stat.count == 25 || #stat.count == 75 || #stat.count == 125 || #stat.count == 150 || #stat.count == 175 ">
                            <div class="row"></div>
                        </s:if>
                        <s:if test="#stat.count == 50 || #stat.count == 100">
                            <hr>
                        </s:if>
                    </s:iterator>
                </div>
                <div class="col-lg-2"></div>
            </div>
            <br><br>
            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg-8">
                    <button class="btn btn-block btn-success" onclick="registrarAsientos()">Seleccionar</button>
                </div>
                <div class="col-lg-2"></div>
            </div>
            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg-8">
                    <form action="registrarVenta" method="POST">
                        <div class="form-group">
                            <label for="numTarjeta">Numero Tarjeta</label>
                            <input type="text" class="form-control" id="numTarjeta" name="beanTarjeta.numTarjeta" required=""/>
                        </div>
                        <div class="form-group">
                            <label for="cvv">CVV:</label>
                            <input type="text" class="form-control" id="cvv" name="beanTarjeta.cvv" required="" />
                        </div>
                        <div class="form-group">
                            <label for="">Fecha Vencimiento</label>
                            <input type="date" class="form-control" id="cantidadCompra" required="" />
                        </div>
                        <div class="col-lg">
                            <button class="btn btn-success btn-block" type="submit">Pagar</button>
                        </div>
                        <div class="col-lg">
                            <a class="btn-danger btn btn-block" href="<%=context%>/consultarObrasUsuario">Cancelar</a>
                        </div>
                        <div class="col-lg"></div>
                    </form>
                </div>
                <div class="col-lg-2"></div>
            </div>
        </div></center>
</body>
</html>
