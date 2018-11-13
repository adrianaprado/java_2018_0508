<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no,">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link rel="stylesheet" href="css/flex_web.css">
    
    <title>Flexbox layout</title>
</head>
<body>
        <div class="contenedor">
        	<div class="cabecera">
        	
                <header>                       
                    <div class="logo">
                        <img src="images/logo.png" width="150" alt="logo html5">
                        <h1><a href="#">FalconMasters</a></h1>
                    </div>
         
                    <nav class="nav-main">
                        <a class="btn-link" href="index.jsp">Inicio</a>
                        <a class="btn-link" href="#">Blog</a>
                        <a class="btn-link" href="#">Proyectos</a>
                        <a class="btn-link" href="#">Contacto</a>
                    </nav>
                    <!-- <a href="#" class="btn-open" onclick="openMenu()">&#9776;</a>
                    <div class="content-menu-mobile" id="menu-mobile">
                            
            
                            <div  class="overlay">
            
                                <a href="#" class="btn-close" onclick="closeMenu()">&times;</a>
            
                                <div class="overlay-content">
                                    <nav class="nav-main-mobile">
                                        <a href="#">Inicio</a>
                                        <a href="#">Blog</a>
                                        <a href="#">Proyectos</a>
                                        <a href="#">Contacto</a>
                                    </nav>
                                </div>
                                
                            </div>
                            
                        </div>
                         -->
                        
                        <!-- <script>
                        
                            var menu = document.getElementById('menu-mobile');
                            
                            function openMenu(){
                                console.log('abriendo Menu');
                                menu.style.display = "block";
                                
                                //menu.style.width = '100%';

                                console.log('abrierto');
                                console.log( menu.style.display);
                            }
                            function closeMenu(){
                                console.log('cerrando Menu');
                                menu.style.display = 'none';
                                //menu.style.width = "0";
                            }
                        
                        </script> -->
            
                </header>
             </div>
         	<div class="cuerpo">
                <section class="main">
                    <article>
                        <h2 class="titulo">Lorem ipsum dolor sit amet.</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                        quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                        consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                        cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                        proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                    </article>
         
                    <article>
                        <h2 class="titulo">Lorem ipsum dolor sit amet.</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                        quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                        consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                        cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                        proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                    </article>
                </section>
         
                <aside>
                    <div class="widget">
                        <div class="imagen"></div>
                    </div>
         
                    <div class="widget">
                        <div class="imagen"></div>
                    </div>
                </aside>
         </div>
         
                <footer>
                    <section class="nav-links">
                        <a class="btn-link" href="index.jsp">Inicio</a>
                        <a class="btn-link" href="#">Blog</a>
                        <a class="btn-link" href="#">Proyectos</a>
                        <a class="btn-link" href="#">Contacto</a>
                    </section>
         
                    <div class="nav-social">
                        <a href="#"><i class="fab fa-facebook-square fa-2x"></i></a>
                        <a href="#"><i class="fab fa-twitter fa-2x"></i></a>
                    </div>
                </footer>
            </div>
            
</body>
</html>