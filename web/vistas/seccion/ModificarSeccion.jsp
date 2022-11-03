<%-- 
    Document   : ModificarSeccion
    Created on : 2/12/2018, 01:04:39 PM
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
                    <h2>Modificar sección</h2>
                    <br>
                    <form action="modificarSeccion" method="post">
                        <input type="hidden" name="beanSeccion.idSeccion" value="<s:property value="beanSeccion.idSeccion"/>"/>
                        <label for="nombre">Nombre:</label>
                        <input type="text" required="" id="nombre" name="beanSeccion.nombre" class="form-control" value="<s:property value="beanSeccion.nombre"/>"/>
                        <label for="tipoSeccion">Tipo sección:</label>
                        <select name="beanSeccion.tipoSeccion" id="tipoSeccion" class="form-control" >
                            <s:set value="beanSeccion.tipoSeccion" var="seccion"/>
                            <s:if test="%{#seccion == 'V.I.P.'}">
                                <option value="V.I.P." selected="">V.I.P.</option>
                                <option value="Media">Media</option>
                                <option value="General">General</option>
                            </s:if>
                            <s:elseif test="%{#seccion == 'Media'}">
                                <option value="V.I.P.">V.I.P.</option>
                                <option value="Media" selected="">Media</option>
                                <option value="General">General</option>
                            </s:elseif>
                            <s:elseif test="%{#seccion == 'General'}">
                                <option value="V.I.P." selected="">V.I.P.</option>
                                <option value="Media">Media</option>
                                <option value="General" selected="">General</option>
                            </s:elseif>
                        </select>
                        <br>
                        <label for="precio">Precio:</label>
                        <input type="number" required="" min="1.0" name="beanSeccion.precio" id="precio" class="form-control" value="<s:property value="beanSeccion.precio"/>"/>
                        <br>
                        <label for="auditorio">Auditorio:</label>
                        <select name="beanSeccion.auditorio.idAuditorio" id="auditorio" class="form-control" >
                            <s:set var="idAuditorio" value="beanSeccion.auditorio.idAuditorio"/>
                            <s:iterator value="listaAuditorio" var="lista" status="stat">
                                <s:set value="idAuditorio" var="idLista"/>
                                <s:if test="{#idAuditorio} == {#idLista}">
                                    <option value="<s:property value="idAuditorio"/>" selected=""><s:property value="nombre"/></option>
                                </s:if>
                                <s:else>
                                    <option value="<s:property value="idAuditorio"/>"><s:property value="nombre"/></option>
                                </s:else>
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