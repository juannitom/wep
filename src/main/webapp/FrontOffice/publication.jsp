
<%@page import="Mapping.UserConnecte"%>
<%@page import="Mapping.Commentaire"%>
<%@page import="Mapping.Utilisateur"%>
<%@include file="header.jsp" %>
<%@ page import="Service.*" %>
<%@page import="Mapping.Publication"%>
<%@page import="java.util.List"%>
                             <% 
                                try {
                                        PublicationDAO ut = new PublicationDAO();
                                        UserConnecteDAO usc = new UserConnecteDAO();
                                        List<Publication> rep = ut.list();
                                        List<UserConnecte> userC = usc.list();
                                        %>

            <div id="content">
                <div class="container">
                    <div class="row">
                        <!-- *** LEFT COLUMN ***
                             _________________________________________________________ -->

                        <div class="col-md-9" id="blog-listing-big">

                            <section class="post">
                                <h2><a href="post.htmls">Actualité</a></h2>
                                <%for(int i = 0; i< rep.size(); i++)
                                {
                                  //List<Utilisateur> user = utilisateur.findById(rep.get(i).getIdUser());
                                    
                                  //out.println(user.get(0).getNom());
                                %>
                                <p class="intro">Poster le <a href="detailPub.jsp?idPub=<% out.println(rep.get(i).getId()); %>"><i class="fa fa-calendar-o"></i><% out.println(rep.get(i).getDaty()); %></a></p>
                                <div class="image">
                                    <a href="detailPub.jsp?idPub=<% out.println(rep.get(i).getId()); %>">
                                        <img src="img/<% out.println(rep.get(i).getPhoto()); %>" class="img-responsive" alt="Example blog post alt">
                                    </a>
                                </div>
                                   <div class="row">
                                    <div class="col-sm-6">
                                        <p class="author-category">By <a href="#">
                                                <% UtilisateurDAO util = new UtilisateurDAO(); 
                                                   Utilisateur utl  = util.findById(rep.get(i).getIdUser());
                                                
                                                %>
                                            </a> in <a href="profile.jsp?id=<% out.print(utl.getId()); %>"><% out.println(utl.getNom()); %></a>
                                        </p>
                                    </div>
                                    <div class="col-sm-6">
                                        <p class="date-comments">
                                            <% JaimeDAO j = new JaimeDAO();
                                               String idPub = rep.get(i).getId();
                                               int nombre = j.findCount(idPub);
                                               String idUser = "UTL_1";
                                               int jm = j.findJaime(idPub, idUser);
                                               CommentaireDAO com = new CommentaireDAO();
                                               List<Commentaire> list = com.findByIdPub(idPub);
                                               
                                               PartageDAO pg = new PartageDAO();
                                               int nbPartage = pg.findCount(idPub);
                                               if(jm == 0)
                                               {
                                            %>
                                            <a href="jaime.jsp?idPub=<% out.println(rep.get(i).getId()); %>"><i class="fa fa-like"></i><% out.println(nombre); %> Jaime</a>
                                            <%}else { %>
                                            <a href="deleteJaime.jsp?idPub=<% out.println(rep.get(i).getId()); %>"><i class="fa fa-like"></i><% out.println(nombre); %> je n'aime plus</a>
                                            <%}%>
                                            <a href="detailPub.jsp?idPub=<% out.println(rep.get(i).getId()); %>"><i class="fa fa-comment-o"></i><% out.println(list.size()); %>Comments</a>
                                            <a href="partage.jsp?idPub=<% out.println(rep.get(i).getId()); %>"><i class="fa fa-sign-in"></i><%out.print(nbPartage); %> Partage</a>
                                        </p>
                                    </div>
                                         <div class="col-sm-6">
                                        <p class="intro"><% out.println(rep.get(i).getDescription()); %></p>
                                    </div>
                                </div>
                                <%}%>
                                
                            </section>


                            

                            <ul class="pager">
                                <li class="previous"><a href="#">&larr; Retour</a>
                                </li>
                                <li class="next disabled"><a href="#">Next &rarr;</a>
                                </li>
                            </ul>


                        </div>
                        <!-- /.col-md-9 -->

                        <!-- *** LEFT COLUMN END *** -->

                        <!-- *** RIGHT COLUMN ***
                             _________________________________________________________ -->

                        <div class="col-md-3">

                            <!-- *** MENUS AND WIDGETS ***
     _________________________________________________________ -->
                            <div class="panel panel-default sidebar-menu">

                                <div class="panel-heading">
                                    <h3 class="panel-title">publication</h3>
                                </div>

                                <div class="panel-body text-widget">
                                    <p>Poster votre photo, ou publication, cela s'affichera sur l'actualité</p>
                                    <form action="insertPub.jsp">
                                      <div class="">
                                        <button type="submit" class="btn btn-sm btn-success">Publier</button>
                                    </div>
                                    </form>
                                </div>
                            </div>

                            <div class="panel panel-default sidebar-menu">

                                <div class="panel-heading">
                                    <h3 class="panel-title">Rechercher</h3>
                                </div>

                                <div class="panel-body">
                                    <form role="search">
                                        <div class="input-group">
                                            <input type="text" class="form-control" placeholder="Search">
                                            <span class="input-group-btn">

                                                <button type="submit" class="btn btn-template-main"><i class="fa fa-search"></i></button>

                                            </span>
                                        </div>
                                    </form>
                                </div>
                            </div>

                            <div class="panel panel-default sidebar-menu">

                                <div class="panel-heading">
                                    <h3 class="panel-title">Amis en ligne</h3>
                                </div>
                                <div class="panel-body text-widget">
                                    <ul class="nav nav-pills nav-stacked">
                                        <% for(int i = 0; i<userC.size(); i++)
                                        {
                                            UtilisateurDAO util = new UtilisateurDAO();
                                            Utilisateur us = util.findById(userC.get(i).getIdUser());
                                        %>
                                        <li><a href="profile.jsp?id=<% out.print(us.getId()); %>"><img width="15%" src="img/<% out.print(us.getPhoto());%>" alt="" class="img-circle"><% out.print(us.getNom());%></a>
                                        </li>
                                        <%}%>
                                    </ul>
                                </div>
                            </div>

                            <!-- *** MENUS AND FILTERS END *** -->

                        </div>
                        <!-- /.col-md-3 -->

                        <!-- *** RIGHT COLUMN END *** -->

                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container -->
            </div>
                                <%
                                   
                                     } catch (Exception e) {
                                         System.out.println(e.getMessage());
                                     }
                                %>
  <%@include file="footer.jsp" %>