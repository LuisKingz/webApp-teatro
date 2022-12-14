<%-- 
    Document   : home
    Created on : 6/12/2018, 12:00:51 AM
    Author     : lfern
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%String context = request.getContextPath();%>

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="<%=context%>/img/teatro (1).png">

        <title>Tratro</title>
        <link href="<%=context%>/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=context%>/css/bootstrap.css" rel="stylesheet">
        <script type="text/javascript" src="<%=context%>/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript" src="<%=context%>/js/bootstrap.bundle.js"></script>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        <!-- Bootstrap core CSS -->
        <!-- Custom styles for this template -->
        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
        <link href="<%=context%>/css/estilos.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <header class="blog-header py-3">
                <div class="row flex-nowrap justify-content-between align-items-center">
                    <div class="col-4 pt-1">
                        <!--                        <a class="text-muted" href="#">Subscribe</a>-->
                    </div>
                    <div class="col-4 text-center">
                        <strong><h1>Bienvenido</h1></strong>
                        <h1><s:property value="#session.nombre"/></h1>
                    </div>
                    <div class="col-4 d-flex justify-content-end align-items-center">
                        <a class="btn btn-sm btn-outline-secondary" href="<%=context%>/cerrarSession">Cerrar sesi??n</a>
                    </div>
                </div>
            </header>

            <div class="nav-scroller py-1 mb-2">
                <nav class="nav d-flex justify-content-between">
                    <!--                    <a class="p-2 text-muted" href="#">World</a>
                                        <a class="p-2 text-muted" href="#">Travel</a>-->
                </nav>
            </div>
            <center>
                <div>
              
                    <img src="<%=context%>/img/banner1.jpg">
                </div>
            </center>
            <hr>

            <div class="row">
                <s:iterator value="listaObras" var="lista" status="stat">
                    <div class="col-md-6">
                        <div class="card flex-md-row mb-4 box-shadow h-md-250">
                            <div class="card-body d-flex flex-column align-items-start">
                                <strong class="d-inline-block mb-2 text-primary">Obras para este a??o</strong>
                                <h3 class="mb-0">
                                    <s:property value="nombre"/>
                                </h3>
                                <div class="mb-1 text-muted">Activas</div>
                                <p class="card-text mb-auto">Duraci??n:</p>
                                <p class="card-text mb-auto"><s:property value="duracion"/></p>
                                <p class="card-text mb-auto">G??nero;</p>
                                <p class="card-text mb-auto"><strong><s:property value="genero.nombre"/></strong></p>
                                <form method="post" action="consultaEspecificaFuncion">
                                    <input type="hidden" name="beanFuncion.obra.idObra" value="<s:property value="idObra"/>">
                                    <button type="submit" class="btn btn-outline-info">Funciones</button>
                                </form>
                            </div>
                          
                        </div>
                    </div>
                </s:iterator>

            </div>

        </div>
        <main role="main" class="container">
            <div class="row">

            </div><!-- /.blog-main -->

            <!--                <aside class="col-md-4 blog-sidebar">
                                <div class="p-3 mb-3 bg-light rounded">
                                    <h4 class="font-italic">About</h4>
                                    <p class="mb-0">Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
                                </div>-->

            <!--                    <div class="p-3">
                                    <h4 class="font-italic">Archives</h4>
                                    <ol class="list-unstyled mb-0">
                                        <li><a href="#">March 2014</a></li>
                                        <li><a href="#">February 2014</a></li>
                                        <li><a href="#">January 2014</a></li>
                                        <li><a href="#">December 2013</a></li>
                                        <li><a href="#">November 2013</a></li>
                                        <li><a href="#">October 2013</a></li>
                                        <li><a href="#">September 2013</a></li>
                                        <li><a href="#">August 2013</a></li>
                                        <li><a href="#">July 2013</a></li>
                                        <li><a href="#">June 2013</a></li>
                                        <li><a href="#">May 2013</a></li>
                                        <li><a href="#">April 2013</a></li>
                                    </ol>
                                </div>
            
                                <div class="p-3">
                                    <h4 class="font-italic">Elsewhere</h4>
                                    <ol class="list-unstyled">
                                        <li><a href="#">GitHub</a></li>
                                        <li><a href="#">Twitter</a></li>
                                        <li><a href="#">Facebook</a></li>
                                    </ol>
                                </div>-->
        </aside><!-- /.blog-sidebar -->

    </div><!-- /.row -->

</main><!-- /.container -->

<footer class="blog-footer">
    <p>
        <a href="#">Back to top</a>
    </p>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="../../assets/js/vendor/popper.min.js"></script>
<script src="../../dist/js/bootstrap.min.js"></script>  
<script src="../../assets/js/vendor/holder.min.js"></script>
<script>
    Holder.addTheme('thumb', {
        bg: '#55595c',
        fg: '#eceeef',
        text: 'Thumbnail'
    });
</script>
<div>Icons made by <a href="https://www.flaticon.es/autores/pixel-buddha" title="Pixel Buddha">Pixel Buddha</a> from <a href="https://www.flaticon.es/" 			    title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" 			    title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
</body>
</html>


