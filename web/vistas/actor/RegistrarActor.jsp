<%-- 
    Document   : RegistrarActor
    Created on : 1/12/2018, 05:56:51 PM
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
                    <h1>Registrar nuevo actor</h1>

                    <form action="registrarActor" method="POST">

                        <div class="row">
                            <div class="col-lg">
                                <label for="nombre">Nombre: </label>
                                <input type="text" pattern="" required="" class="form-control" placeholder="Ej. David" id="nombre" name="bean.persona.nombre" />
                            </div>
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-lg">
                                <label for="primerApeliido">Primer apellido:</label>
                                <input type="text" required="" class="form-control" placeholder="Ej. Benitez" id="primerApeliido" name="bean.persona.primerApeliido" />
                            </div>

                            <div class="col-lg">
                                <label for="segundoApellido">Segundo apellido:</label>
                                <input type="text" required="" class="form-control" placeholder="Ej. Juarez" id="segundoApellido" name="bean.persona.segundoApellido" />
                            </div>
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-lg">
                                <label for="genero">Genero: </label>
                                <select class="form-control" required="" id="genero" name="bean.persona.genero">
                                    <option>Seleccione...</option>
                                    <option value="H">Hombre</option>
                                    <option value="M">Mujer</option>
                                </select>
                            </div>

                            <div class="col-lg">
                                <label for="fechaNacimiento">Fecha de nacimiento: </label>
                                <input type="text" required="" class="form-control" placeholder="AAAA-MM-DD" id="fechaNacimiento" name="bean.persona.fechaNacimiento" />
                            </div>
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-lg">
                                <label for="direccion">Dirección: </label>
                                <input type="text" required="" class="form-control" placeholder="Ej. DIaz crúz #12" id="direccion" name="bean.persona.direccion" />
                            </div>                            
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-lg">
                                <label for="correo">Correo: </label>
                                <input type="text" required="" class="form-control" placeholder="Ej. algo@hotmail.com" id="correo" name="bean.correo" />
                            </div> 

                            <div class="col-lg">
                                <label for="telefono">Telefono: </label>
                                <input type="text" required="" class="form-control" placeholder="Ej. 7772226480" id="telefono" name="bean.telefono" />
                            </div> 
                        </div>
                        <br/>
                        <div class="row">
                            <div class="col-lg">
                                <label for="descripcion">Descripción: </label>
                                <input type="text" required="" class="form-control" placeholder="Ej. Actor principal..." id="descripcion" name="bean.descripcion" />
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
                <div class="col-lg-3"></div>
            </div>
        </div>
    </body>
</html>
