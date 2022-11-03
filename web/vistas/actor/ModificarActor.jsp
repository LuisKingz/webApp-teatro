<%-- 
    Document   : ModificarActor
    Created on : 1/12/2018, 05:57:08 PM
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
        <title>Actores</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-3"></div>
                <div class="col-lg">
                    <h1>Modificar Actor</h1>

                    <form action="modificarActor" method="POST">
                        <input type="text" hidden="" id="idActor" name="bean.idActor" value="<s:property value="bean.idActor"/>" />

                        <div class="row">
                            <div class="col-lg">
                                <label for="nombre">Nombre: </label>
                                <input type="text" class="form-control" id="nombre" name="bean.persona.nombre" value="<s:property value="bean.persona.nombre"/>" />
                            </div>
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-lg">
                                <label for="primerApeliido">Primer apellido:</label>
                                <input type="text" class="form-control" id="primerApeliido" name="bean.persona.primerApeliido" value="<s:property value="bean.persona.primerApeliido"/>" />
                            </div>

                            <div class="col-lg">
                                <label for="segundoApellido">Segundo apellido:</label>
                                <input type="text" class="form-control" id="segundoApellido" name="bean.persona.segundoApellido" value="<s:property value="bean.persona.segundoApellido"/>" />
                            </div>
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-lg">
                                <label for="genero">Genero: </label>
                                <select class="form-control" id="genero" name="bean.persona.genero">
                                    <option value="H">Hombre</option>
                                    <option value="M">Mujer</option>
                                </select>
                            </div>

                            <div class="col-lg">
                                <label for="fechaNacimiento">Fecha de nacimiento: </label>
                                <input type="text" class="form-control" id="fechaNacimiento" name="bean.persona.fechaNacimiento" value="<s:property value="bean.persona.fechaNacimiento"/>" />
                            </div>
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-lg">
                                <label for="direccion">Dirección: </label>
                                <input type="text" class="form-control" id="direccion" name="bean.persona.direccion" value="<s:property value="bean.persona.direccion"/>" />
                            </div>                            
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-lg">
                                <label for="correo">Correo: </label>
                                <input type="text" class="form-control" id="correo" name="bean.correo" value="<s:property value="bean.correo"/>" />
                            </div> 

                            <div class="col-lg">
                                <label for="telefono">Telefono: </label>
                                <input type="text" class="form-control" id="telefono" name="bean.telefono" value="<s:property value="bean.telefono"/>" />
                            </div> 
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-lg">
                                <label for="descripcion">Descripción: </label>
                                <input type="text" class="form-control" id="descripcion" name="bean.descripcion" value="<s:property value="bean.descripcion"/>" />
                            </div> 
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
                <div class="col-lg-3">
                <br/>
                <br/>
                </div>
            </div>
        </div>
    </body>
</html>
