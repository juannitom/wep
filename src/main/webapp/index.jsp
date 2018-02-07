<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="robots" content="all,follow">
        <meta name="googlebot" content="index,follow,snippet,archive">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Connect to WEPLAY</title>

        <meta name="keywords" content="">

        <link href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800' rel='stylesheet' type='text/css'>

        <!-- Bootstrap and Font Awesome css -->
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

        <!-- Css animations  -->
        <link href="css/animate.css" rel="stylesheet">

        <!-- Theme stylesheet, if possible do not edit this stylesheet -->
        <link href="css/style.default.css" rel="stylesheet" id="theme-stylesheet">

        <!-- Custom stylesheet - for your changes -->
         <link href="css/bootstrap.css" rel="stylesheet">

        <!-- Responsivity for older IE -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

        <!-- Favicon and apple touch icons-->
        <link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon" />
        <link rel="apple-touch-icon" href="img/apple-touch-icon.png" />
        <link rel="apple-touch-icon" sizes="57x57" href="img/apple-touch-icon-57x57.png" />
        <link rel="apple-touch-icon" sizes="72x72" href="img/apple-touch-icon-72x72.png" />
        <link rel="apple-touch-icon" sizes="76x76" href="img/apple-touch-icon-76x76.png" />
        <link rel="apple-touch-icon" sizes="114x114" href="img/apple-touch-icon-114x114.png" />
        <link rel="apple-touch-icon" sizes="120x120" href="img/apple-touch-icon-120x120.png" />
        <link rel="apple-touch-icon" sizes="144x144" href="img/apple-touch-icon-144x144.png" />
        <link rel="apple-touch-icon" sizes="152x152" href="img/apple-touch-icon-152x152.png" />
    </head>
    <style>
        #heading-breadcrumbs2 {
            background-color : #4fbfa8;
            padding: 20px 0;
            margin-bottom: 40px;
        }
        #heading-breadcrumbs2.no-mb {
            margin-bottom: 0;
        }
        #heading-breadcrumbs2 h1 {
            color: #333333;
            text-transform: uppercase;
            font-size: 30px;
            font-weight: 700;
            letter-spacing: 0.08em;
        }
        @media (max-width: 991px) {
            #heading-breadcrumbs2 h1 {
                text-align: center;
            }
        }
        #heading-breadcrumbs2 ul.breadcrumb {
            margin-top: 5px;
            margin-bottom: 0;
        }
    </style>
    <body>
        <br> <br> <br> <br> <br>
            <div id="content" background="img/a.jpg">
                <div class="container">

                    <div class="row">
                         <div class="col-md-2"></div>
                         <div class="col-md-4">
                            <div class="box" style="padding-left: 20px;padding-right:20px">
                                <div align="center">
                                <h2 class="text-uppercase">Connexion</h2>

                                <p class="lead">Deja membre?</p>

                                <hr>

                                <form action="FrontOffice/connexionMembre.jsp" method="post">
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input type="text" class="form-control" id="nom" name="nom">
                                    </div>
                                    <div class="form-group">
                                        <label for="password">Password</label>
                                        <input type="password" class="form-control" id="mdp" name="mdp">
                                    </div>
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-sm btn-success"><i class="fa fa-sign-in"></i> Log in</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                         </div>

                      
                          <div class="col-md-4">
                            <div class="box" style="padding-left: 20px;padding-right:20px">
                                <div align="center">
                                <h2 class="text-uppercase">Inscription</h2>

                                <p class="lead">Pas encore membre?</p>
                                <hr>

                                <form action="fcustomer-orders.jsp" method="post">
                                    <div class="form-group">
                                        <label for="name-login">nom</label>
                                        <input type="text" class="form-control" id="name-login">
                                    </div>
                                    <div class="form-group">
                                        <label for="email-login">Email</label>
                                        <input type="text" class="form-control" id="email-login">
                                    </div>
                                    <div class="form-group">
                                        <label for="password-login">Password</label>
                                        <input type="password" class="form-control" id="password-login">
                                    </div>
                                    <div class="form-group">
                                        <label for="password-login">Confirmation Password</label>
                                        <input type="password" class="form-control" id="password-login">
                                    </div>
                                      <div class="form-group">
                                        <label for="sexe-login">Sexe</label>
                                    	<select class="form-control" name="" id="">
						<option name="" id="" value="">Femme</option>
                                                <option name="" id="" value="">Homme</option>
                                                <option name="" id="" value="">Autre</option>
                                        </select>
                                        </div>
                                    <div class="form-group">
                                        <label for="name-login">Emploi</label>
                                        <input type="text" class="form-control" id="name-login">
                                    </div
                                    <div class="text-center">
                                        <button type="submit" class="btn btn-sm btn-success"><i class="fa fa-user-md"></i>Inscription</button>
                                    </div>
                                </form>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                    <!-- /.row -->

                </div>
                <!-- /.container -->
            </div>
           

        </div>
        <!-- /#all -->


        <!-- #### JAVASCRIPT FILES ### -->

        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <script>
            window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')
        </script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

        <script src="js/jquery.cookie.js"></script>
        <script src="js/waypoints.min.js"></script>
        <script src="js/jquery.counterup.min.js"></script>
        <script src="js/jquery.parallax-1.1.3.js"></script>
        <script src="js/front.js"></script>





    </body>

</html>