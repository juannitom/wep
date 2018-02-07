 <%@page import="Mapping.Utilisateur"%>
<%@page import="Service.UtilisateurDAO"%>
<%@page import="Mapping.Notification"%>
<%@page import="java.util.List"%>
<%@page import="Service.NotificationDAO"%>
<%@include file="header.jsp" %> 
 <% 
     String idUser = "UTL_1";
    NotificationDAO nt = new NotificationDAO();
    List<Notification> list= nt.findById(idUser);
 %>
  <section>
            <div class="container">

                <div class="row">

                    <div class="col-md-12">
                        <div class="heading">
                            <h2>Notification</h2>
                        </div>
                        <%for (int i= 0; i<list.size(); i++)
                        {%>
                        <a href="detailPub.jsp?idPub=<% out.println(list.get(i).getIdPub()); %>">
                        <div class="alert alert-success alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                            </button>
                            <% UtilisateurDAO ut = new UtilisateurDAO();
                               Utilisateur user = ut.findById(idUser);
                            %>
                            <% out.print(user.getNom()); %> a <% out.print(list.get(i).getAction()); %> votre photo.
                        </div>
                        </a>
                        <%}%>
                    </div>
                </div>

            </div>
            <!-- /.container -->
        </section>
 <%@include file="footer.jsp" %>