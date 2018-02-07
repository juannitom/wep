 <%@page import="Mapping.Utilisateur"%>
<%@page import="Service.UtilisateurDAO"%>
<%@page import="Mapping.Message"%>
<%@page import="java.util.List"%>
<%@page import="Service.MessageDAO"%>
<%@include file="header.jsp" %> 
 <%
     MessageDAO mes = new MessageDAO();
     String destinateur="UTL_1";
     List<Message> lm = mes.findMessage(destinateur, destinateur);
 %>
  <section>
            <div class="container">

                <div class="row">

                    <div class="col-md-12">
                        <div class="heading">
                            <h2>Message</h2>
                        </div>
                        <%for (int i= 0; i<lm.size(); i++)
                        {%>
                        <a href="envoieMessage.jsp?id=<%out.print(lm.get(i).getExpediteur());%>">
                        <div class="alert alert-success alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                            </button>
                            <% UtilisateurDAO ut = new UtilisateurDAO(); 
                                Utilisateur u = ut.findById(lm.get(i).getExpediteur());
                            %>
                            <% out.print(u.getNom()+":"+ lm.get(i).getMessage()); %>.
                        </div>
                        </a>
                        <%}%>
                    </div>
                </div>

            </div>
            <!-- /.container -->
        </section>
 <%@include file="footer.jsp" %>