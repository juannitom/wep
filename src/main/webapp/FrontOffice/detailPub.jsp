
<%@page import="Mapping.Jaime"%>
<%@page import="Mapping.Commentaire"%>
<%@page import="Mapping.Utilisateur"%>
<%@include file="header.jsp" %>
<%@ page import="Service.*" %>
<%@page import="Mapping.Publication"%>
<%@page import="java.util.List"%>
                             <% 
                                try {
                                        String idPub = request.getParameter("idPub");
                                        PublicationDAO ut = new PublicationDAO();
                                        Publication repos = ut.findById(idPub);
                                        %>

<div id="content">
    <div class="container">
        <div class="row">
            <!-- *** LEFT COLUMN ***
                 _________________________________________________________ -->

            <div class="col-md-9" id="blog-listing-big">
                  <section class="post">
                                <h2><a href="post.htmls">Actualité</a></h2>
                                <p class="intro">Poster le <a href="detailPub.jsp?idPub=<% out.println(repos.getId()); %>"><i class="fa fa-calendar-o"></i><% out.println(repos.getDaty()); %></a></p>
                                <div class="image">
                                    <a href="detailPub.jsp?idPub=<% out.println(repos.getId()); %>">
                                        <img src="img/<% out.println(repos.getPhoto()); %>" class="img-responsive" alt="Example blog post alt">
                                    </a>
                                </div>
                                   <div class="row">
                                    <div class="col-sm-6">
                                        <p class="author-category">By <a href="#">
                                                <% UtilisateurDAO util = new UtilisateurDAO(); 
                                                   Utilisateur utl  = util.findById(repos.getIdUser());
                                                
                                                %>
                                            </a> in <a href="profile.jsp?id=<% out.print(utl.getId()); %>"><% out.println(utl.getNom()); %></a>
                                        </p>
                                    </div>
                                    <div class="col-sm-6">
                                        <p class="date-comments">
                                            <% JaimeDAO j = new JaimeDAO();
                                               int nombre = j.findCount(idPub);
                                               List<Jaime> ls = j.findById(idPub);
                                               String idUser = "UTL_1";
                                               int jm = j.findJaime(idPub, idUser);
                                               CommentaireDAO com = new CommentaireDAO();
                                               List<Commentaire> list = com.findByIdPub(idPub);
                                               PartageDAO pg = new PartageDAO();
                                               int nbPartage = pg.findCount(idPub);
                                               if(jm == 0)
                                               {
                                            %>
                                            <a href="jaime.jsp?idPub=<% out.println(repos.getId()); %>"><i class="fa fa-like"></i><% out.println(nombre); %> Jaime</a>
                                            <%}else { %>
                                            <a href="deleteJaime.jsp?idPub=<% out.println(repos.getId()); %>"><i class="fa fa-like"></i><% out.println(nombre); %> je n'aime plus</a>
                                            <%}%>
                                            <a href="detailPub.jsp?idPub=<% out.println(repos.getId()); %>"><i class="fa fa-comment-o"></i><% out.println(list.size()); %>Comments</a>
                                            <a href="detailPub.jsp?idPub=<% out.println(repos.getId()); %>"><i class="fa fa-sign-in"></i><%out.print(nbPartage); %> Partage</a>
                                        </p>
                                    </div>
                                </div>

                    <div class="panel-heading">
                        <h3 class="panel-title">Commentaire</h3>
                    </div>

                    <% for (int i = 0; i < list.size(); i++) {
                     UtilisateurDAO u = new UtilisateurDAO();
                     Utilisateur user = u.findById(list.get(i).getIdUser());
                    %>
                    <div class="box" style="padding-left: 20px;padding-right:20px">
                        <p class="author-category">By <a href="profile.jsp?id=<% out.print(user.getId()); %>"><% out.println(user.getNom()); %>: </a><% out.println(list.get(i).getCommentaire()); %></p>
                    </div>
                    <%
                                    }%>
                    <div id="comment-form">
                        <form method="post" action="insertCommentaire.jsp">
                            <div class="form-group">
                                <label for="comment">Commenter <span class="required">*</span>
                                </label>
                                <textarea class="form-control" id="commentaire" name="commentaire" rows="4"></textarea>
                                <input type="hidden" name="idPub" value='<% out.print(repos.getId()); %>'>
                            </div>
                            <button type="submit" class="btn btn-lg btn-template-primary">Commenter</button>
                        </form>
                    </div>

                </section>


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
                        <h3 class="panel-title">Vos amis qui ont aimé cette publication</h3>
                    </div>

                    <div class="panel-body">
                        <ul class="nav nav-pills nav-stacked">
                            <% 
                                for (int i = 0; i < ls.size(); i++) {
                                    UtilisateurDAO u = new UtilisateurDAO();
                                    Utilisateur user = u.findById(ls.get(i).getIdUser());
                                    
                            %>
                            <li><a href="profile.jsp?id=<% out.print(user.getId()); %>"><img width="15%" src="img/<% out.print(user.getPhoto()); %>" alt="" class="img-circle"><% out.print(user.getNom()); %></a>
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