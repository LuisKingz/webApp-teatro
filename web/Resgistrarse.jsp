<%@taglib prefix="s" uri="/struts-tags" %>
<%String context = request.getContextPath();%>
<html>  
    <head>
        <link href="<%=context%>/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=context%>/css/bootstrap.css" rel="stylesheet">
        <link href="<%=context%>/css/textarea.css" rel="stylesheet">
        <script type="text/javascript" src="<%=context%>/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript" src="<%=context%>/js/bootstrap.bundle.js"></script>


        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Sign Up Form</title>
    </head>
    <body>       
        <div class="container">
            <div class="row">
                <div class="col-lg-2"></div>
                <div class="col-lg">
                    <form class="form-group" method="post" action="registrarse">
                        <div class="row">
                            <div class="col-lg">
                                <div class="form-group">
                                    <fieldset>
                                        <legend>Datos Personales:</legend>
                                        <input type="text" class="form-control" required="" name="bean.persona.nombre" placeholder="Nombre"/>
                                        <input type="text" class="form-control" required="" name="bean.persona.primerApeliido" placeholder="Primer Apellido">
                                        <input type="text" class="form-control" required="" name="bean.persona.segundoApellido" placeholder="Segundo Apellido">
                                        <label>Sexo:</label>
                                        <label><input id="ch1" required="" type="radio" class="form-check-inline" name="bean.persona.genero" value="H">Hombre</label>
                                        <label><input id="ch2"  required="" type="radio" class="form-check-inline " name="bean.persona.genero" value="M">Mujer</label>
                                        <input type="date" pattern="((19|20)[0-9]{2})/((0?[1-9])|1[012])/((0?[1-9])|(1[0-9])|(3[01]))" max="2000" class="form-control" required="" c name="bean.persona.fechaNacimiento" placeholder="Fecha de Nacimiento">
                                        <input type="text" class="form-control" required="" name="bean.persona.direccion" placeholder="Dirección">          
                                    </fieldset>
                                </div> 
                            </div>
                            <div class="col-lg">
                                <div class="form-group">
                                    <fieldset>
                                        <legend>Datos de Usuario:</legend>
                                        <input pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" type="email" class="form-control" required="" name="bean.correo" placeholder="Correo"/>
                                        <input id="pass1" type="password" class="form-control" required="" name="bean.contrasena"  placeholder="Contraseña">
                                        <input id="pass2" type="password" class="form-control" required=""  placeholder="Repetir Contraseña">
                                        <input type="text" class="form-control" required="" name="bean.cp" placeholder="Código Postal">
                                        <label for="s">Municipio:</label>
                                        <select id="s" class="form-control" required="" name="bean.municipio">
                                            <option>Seleccione...</option>
                                            <option value="Cuernavaca">Cuernavaca</option>
                                            <option value="Amacuzac">Amacuzac</option>
                                            <option value="Atlatlahuacan">Atlatlahuacan</option>
                                            <option value="Axochiapan">Axochiapan</option>
                                            <option value="Ayala">Ayala</option>
                                            <option value="Coatlán del Río">Coatlán del Río</option>
                                            <option value="Cuautla">Cuautla</option>
                                            <option value=" Emiliano Zapata">Emiliano Zapata</option>
                                            <option value="Huitzilac">Huitzilac</option>
                                            <option value="Jantetelco">Jantetelco</option>
                                            <option value="Jiutepec">Jiutepec</option>
                                            <option value="Jojutla">Jojutla</option>
                                            <option value="Jonacatepec">Jonacatepec</option>
                                            <option value="Mazatepec">Mazatepec</option>
                                            <option value="Miacatlán">Miacatlán</option>
                                            <option value="Ocuituco">Ocuituco</option>
                                            <option value="Puente de Ixtla">Puente de Ixtla</option>
                                            <option value="Temixco">Temixco</option>
                                            <option value="Temoac">Temoac</option>
                                            <option value="Tepalcingo">Tepalcingo</option>
                                            <option value="Tepoztlán">Tepoztlán</option>
                                            <option value="Tetecala">Tetecala</option>
                                            <option value="Tetela del Volcán">Tetela del Volcán</option>
                                            <option value="Tlalnepantla">Tlalnepantla</option>
                                            <option value="Tlaltizapán de Zapata">Tlaltizapán de Zapata</option>
                                            <option value="Tlaquiltenango">Tlaquiltenango</option>
                                            <option value="Tlayacapan">Tlayacapan</option>
                                            <option value="Totolapan">Totolapan</option>
                                            <option value="Xochitepec">Xochitepec</option>
                                            <option value="Yautepec">Yautepec</option>
                                            <option value="Yecapixtla">Yecapixtla</option>
                                            <option value="Zacatepec">Zacatepec</option>
                                            <option value="Zacualpan de Amilpas">Zacualpan de Amilpas</option>
                                        </select>
                                        <label>Términos y condiciones:</label>
                                        <textarea disabled="" id="TC" class="form-control"></textarea>
                                        <label><input required="" type="checkbox" name="bean.estado" onclick="validarCheck(this)">Aceptar términos</label>
                                        <br>
                                        <label>¿Desea recibir promociones?</label>
                                        <br>

                                        <label><input required="" type="radio" class="form-check-inline" name="bean.estado" value="1">Si</label>
                                        <label><input required="" type="radio" class="form-check-inline" name="bean.estado" value="0">No</label>

                                        <br>
                                        <input id="boton" type="submit" class="btn btn-primary btn-block" value="Registrarse" >
                                    </fieldset>
                                </div> 
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-lg-2"></div>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="<%=context%>/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="<%=context%>/js/abc.js"></script>
</html>