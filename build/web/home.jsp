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
                    </div>
                    <div class="col-4 d-flex justify-content-end align-items-center">
                        <!--                        <a class="text-muted" href="#">
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="mx-3"><circle cx="10.5" cy="10.5" r="7.5"></circle><line x1="21" y1="21" x2="15.8" y2="15.8"></line></svg>
                                                </a>-->
                        <a class="btn btn-sm btn-outline-secondary" href="<%=context%>/login.jsp">Iniciar sesión</a>
                        <a  class="btn btn-sm btn-outline-primary" href="<%=context%>/Resgistrarse.jsp">Registrarse</a>
                    </div>
                </div>
            </header>

            <div class="nav-scroller py-1 mb-2">
                <nav class="nav d-flex justify-content-between">
                    <!--     
                                        <a class="p-2 text-muted" href="#">U.S.</a>
                                        <a class="p-2 text-muted" href="#">Travel</a>-->
                </nav>
            </div>
            <center>
                <div>
                    <img src="<%=context%>/img/banner1.jpg">
                </div>
            </center>
            <hr>
            <div class="row mb-2">
                <div class="col-md-6">
                    <div class="card flex-md-row mb-4 box-shadow h-md-250">
                        <div class="card-body d-flex flex-column align-items-start">
                            <strong class="d-inline-block mb-2 text-primary">Mundial</strong>
                            <h3 class="mb-0">
                                El cartero (Il postino)
                            </h3>
                            <div class="mb-1 text-muted">Próximamente</div>
                            <p class="card-text mb-auto">El cartero aborda la historia de la amistad que surge entre Pablo Neruda y su cartero Mario. Neruda y sus poemas ayudarán a Mario a conquistar a Beatriz</p>
                        </div>
                        <img  src="<%=context%>/img/catero2.jpg" width="200" height="500" class="card-img-right flex-auto d-none d-md-block"   alt="Card image cap">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card flex-md-row mb-4 box-shadow h-md-250">
                        <div class="card-body d-flex flex-column align-items-start">
                            <strong class="d-inline-block mb-2 text-success">Nacional</strong>
                            <h3 class="mb-0">
                                Atracción Fatal
                            </h3>
                            <div class="mb-1 text-muted">Próximamente</div>
                            <p class="card-text mb-auto">Dan Gallagher tiene una vida perfecta al lado de su familia; hasta que conoce a una hermosa mujer, Alex. Y en un arrebato de pasión lo arriesga todo</p>
                        </div>
                        <img  src="<%=context%>/img/af.jpg" width="200" height="500" class="card-img-right flex-auto d-none d-md-block"   alt="Card image cap">
                    </div>
                </div>
            </div>
            <div class="row mb-2">
                <div class="col-md-6">
                    <div class="card flex-md-row mb-4 box-shadow h-md-250">
                        <div class="card-body d-flex flex-column align-items-start">
                            <strong class="d-inline-block mb-2 text-primary">Mundial</strong>
                            <h3 class="mb-0">
                                Las tres hermanas
                            </h3>
                            <div class="mb-1 text-muted">Próximamente</div>
                            <p class="card-text mb-auto">Las hermanas Prózorov viven con su hermano Andréi en Rusia. Un año después de la muerte del padre inician una nueva vida en Moscú</p>
                        </div>
                        <img  src="<%=context%>/img/las-tres-hermanas-milan.jpg" width="200" height="500" class="card-img-right flex-auto d-none d-md-block"   alt="Card image cap">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card flex-md-row mb-4 box-shadow h-md-250">
                        <div class="card-body d-flex flex-column align-items-start">
                            <strong class="d-inline-block mb-2 text-success">Nacional</strong>
                            <h3 class="mb-0">
                                La dama de negro
                            </h3>
                            <div class="mb-1 text-muted">Próximamente</div>
                            <p class="card-text mb-auto">Arthur Kipps ha vivido aterrado a partir de una experiencia que enfrentó en su juventud</p>
                        </div>
                        <img  src="<%=context%>/img/Ladamajpg.jpg" width="200" height="500" class="card-img-right flex-auto d-none d-md-block"   alt="Card image cap">
                    </div>
                </div>
            </div>
        </div>
        <main role="main" class="container">
            <div class="row">


            </div>

        </main>

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


