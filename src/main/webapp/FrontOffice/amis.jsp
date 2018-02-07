 <%@page import="Mapping.Utilisateur"%>
<%@page import="java.util.List"%>
<%@page import="Service.UtilisateurDAO"%>
<%@include file="header.jsp" %>
  <div id="content">
 <div class="container">
 <section>

                    <!-- /.row -->
                    <%
                        UtilisateurDAO user = new UtilisateurDAO();
                        List<Utilisateur> list = user.list();
                        for(int i = 0; i<list.size(); i++)
                        {
                    %>

                    <div class="row">
                        <div class="col-md-2 col-sm-3">
                            <div class="team-member" data-animate="fadeInDown">
                                <div class="image">
                                    <a href="team-member.html">
                                        <img src="img/<% out.print(list.get(i).getPhoto()); %>" alt="" class="img-responsive img-circle">
                                    </a>
                                </div>
                                <h3><a href="team-member.html"><% out.print(list.get(i).getNom()); %></a></h3>
                                <p class="role"><% out.print(list.get(i).getEmploi()); %></p>
                            </div>
                            <!-- /.team-member -->
                        </div>
                       <%}%>
                    </div>
                    <!-- /.row -->

                </section>
 </div>
  </div>
  <%@include file="footer.jsp" %>