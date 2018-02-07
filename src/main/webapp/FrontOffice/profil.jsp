 <%@page import="Mapping.Utilisateur"%>
<%@page import="Service.UtilisateurDAO"%>
<%@include file="header.jsp" %>
 
 <% UtilisateurDAO user = new UtilisateurDAO(); 
    Utilisateur ut = user.findById("UTL_1");
 %>
    <body>
         <div id="content" class="team-member-detail">
            <div class="container">
                <section>
                         <p style="color:black;font-size: 30px;font-family: Brush Script Std" align='center'>Profil:</p>
                    <div class="row">
                        <div class="col-md-12">
                        <div class="col-md-8">
                            <div class="heading">
                                <h3><% out.print(ut.getNom()); %></h3>
                            </div>
                            <p>Email: <% out.print(ut.getEmail()); %></p>
                            <p>sexe: <% out.print(ut.getSexe()); %></p>
                            <p>Emploi: <% out.print(ut.getEmploi()); %></p>
                            <div class="heading">
                                <h3>Jeu: ChiliLays</h3>
                            </div>
                            <p>Score: <% out.print(ut.getScore()); %></p>
                        </div>

                        <div class="col-md-4">
                            <img class="img-responsive img-circle" alt="" src="img/<% out.print(ut.getPhoto()); %>">
                        </div>
                        </div>
                    </div>
                </section>
            </div>
     <%@include file="footer.jsp" %>