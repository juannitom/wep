 <%@page import="Mapping.Utilisateur"%>
<%@page import="Service.UtilisateurDAO"%>
<%@page import="Mapping.Message"%>
<%@page import="java.util.List"%>
<%@page import="Service.MessageDAO"%>
<%@include file="header.jsp" %> 
 <%
     MessageDAO mes = new MessageDAO();
     String destinateur="UTL_1";
     String expediteur = request.getParameter("id");
     List<Message> lm = mes.findMess(expediteur, destinateur);
     List<Message> l = mes.findMess(destinateur, expediteur);
 %>
  <section>
            <div class="container">

                <div class="row">

                    <div class="col-md-12">
                        <div class="heading">
                            <h2>Message</h2>
                        </div>
                        <%for (int i= 0; i<lm.size(); i++)
                            
                        {
                        %>
                            <div class="panel panel-primary">
                                    <div class="panel-heading">
                                        <h4 class="panel-title">

						<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">

						   <% UtilisateurDAO ute = new UtilisateurDAO(); 
                                                        Utilisateur ue = ute.findById(l.get(i).getDestinateur());
                                                    %>
                                                    <% out.print(ue.getNom()+":"+ l.get(i).getMessage()); %>.

						</a>

					    </h4>
                                    </div>
                                    <div id="collapseTwo" class="panel-collapse collapse">
                                        <div class="panel-body">
                                            <% out.print(ue.getNom()); %>.
                                            <p>Vu</p>
                                        </div>
                                    </div>
                                </div>
                        <div class="alert alert-success alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                            </button>
                            <% UtilisateurDAO ut = new UtilisateurDAO(); 
                                Utilisateur u = ut.findById(lm.get(i).getDestinateur());
                            %>
                            <% out.print(u.getNom()+":"+ lm.get(i).getMessage()); %>.
                        </div>
                        <%
                        }
                        %>
                    </div>
                </div>
                    
                    <h4 class="text-uppercase">votre reponse</h4>

                <form action="envoie.jsp" method="post">
                    <input type="hidden" name="exp" id="exp" value="<%out.print(expediteur);%>">

                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label for="comment">Messsage <span class="required">*</span>
                                </label>
                                <textarea class="form-control" id="mes" name="mes" rows="4"></textarea>
                            </div>
                        </div>
                    </div>

                        <div class="">
                            <button type="submit" class="btn btn-lg btn-template-primary">Envoyer</button>
                            <br>
                            <br>

                        </div>
                </form>

            </div>
            <!-- /.container -->
        </section>
 <%@include file="footer.jsp" %>