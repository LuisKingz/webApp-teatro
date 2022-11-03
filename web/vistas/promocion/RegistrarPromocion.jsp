<%-- 
    Document   : RegistrarPromociones
    Created on : 1/12/2018, 05:57:39 PM
    Author     : RAGAd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String context = request.getContextPath();%>
<%@taglib  prefix="s" uri="/struts-tags" %>
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
        <title>Promociones</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg">
                    <h1>Registrar nuevo promoción</h1>

                    <form action="registrarPromocion" method="POST">

                        <div class="row">
                            <div class="col-lg">
                                <label for="descripcion">Descripción: </label>
                                <input type="text" required="" class="form-control" placeholder="Ej. Por sección" id="descripcion" name="bean.descripcion" />
                            </div>
                            <div class="col-lg">
                                <label for="codigo">Código:</label>
                                <input type="text" required="" class="form-control" placeholder="Ej. 154856" id="codigo" name="bean.codigo" />
                            </div>
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-lg">
                                <label for="fechaInicio">Fecha de inicio:</label>
                                <input type="text" required="" class="form-control" placeholder="AAAA-MM-DD" id="fechaInicio" name="bean.fechaInicio" />
                            </div>
                            <div class="col-lg">
                                <label for="fechaFin">Fecha de Fin:</label>
                                <input type="text" required="" class="form-control" placeholder="AAAA-MM-DD" id="fechaFin" name="bean.fechaFin" />
                            </div>
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-lg-2"></div>
                            <div class="col-lg">
                                <label for="estado">Estado: </label>
                                <select class="form-control" required="" id="estado" name="bean.estado">
                                    <option>Seleccione...</option>
                                    <option value="true">Activo</option>
                                    <option value="false">Inactivo</option>
                                </select>
                            </div>
                            <div class="col-lg-2"></div>
                        </div>
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
                <div class="col-lg-3"></div>
            </div>
        </div>
    </body>
</html>
