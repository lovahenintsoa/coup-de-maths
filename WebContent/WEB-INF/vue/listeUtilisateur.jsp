
<%@page import= "java.util.ArrayList" %>
<%@page import= "metier.user.Niveau" %>
<%@page import= "metier.user.User" %>
<%@page import= "metier.user.Users" %>
<%@page import= "metier.user.Etudiant" %>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>Liste des élèves</title>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/script/bootstrap.css">
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
	</head>
<body>
	<h3 style="text-align: center;color:#34495e">Coup_de_Maths</h3>
	
		<div class="container">
				<div class="row">
				  	<form name="chercheno" method ="post" action="#">
							<div class="col-lg-9">
					
								<div class="form-group">
			 						<label for="scales">Niveau/Nom:</label><br>
									
									<select class="form-control" id="idAbonneE" name="niveau" >
							
							<!-- Remplissage de combo à partir de la classe Niveau -->
							  			<option value="niveau" selected="selected" style = "width:200px ;" >niveau</option>
        						
							 			 <% 
							
								  		for (Niveau niveau : Niveau.values()) {
								  			 %>	
								     	  		<option value ="<%=niveau.getLibNiveau() %>"> <%=niveau.getLibNiveau() %></option>
							     	 		<%} 
							      		 %>
						    		</select>
						    		</div>
						    		
						    		<div>
						    		
						  				<button class="btn btn-primary" id="modif_theme"name =" cherc" type="submit" formAction="<%=request.getContextPath() %>/connexion/afficheNivUser">Cherher</button>
								   </div>	
							
							</div>
					</form>
					
					
					 <form name="cherchenom" method ="post" action="#">
							<div class="col-lg-3">
					
			 					<div class="form-group">
			 
              					 <input type="text" name ="nom" placeholder="Nom">
             					 <button class="btn btn-primary" name="chercher" id="modif_theme" type="submit" formAction="<%=request.getContextPath() %>/connexion/afficheNomUser">Chercher</button>
          				  		</div>
				          				  	
										<!--  	<div>
											<jsp:useBean id="user"      class="metier.user.Etudiant"    scope="request" />
				   							<% if (user!= null) { %><label>Nom : <%= user.getNom() %></label> <% } %> <br />
				   							<% if (user!= null) { %><label>Prenom : <%= user.getPrenom() %></label> <% } %> <br />
				   							<% if (user!= null) { %><label>Niveau: <%= user.getNiveau() %></label> <% } %>
											</div> -->
							</div>
					</form>
					
				</div>
			
		</div>
	
   					
   			
	
					 <form method="post" action="#">
						
						<table class="table table-striped" name ="listes">
  							
  							<thead>
   			 
   			 
						   			 <tr>
						     		 	 <th scope="col">Choix</th>
						     		 	 <th scope="col">Id</th>
						     			 <th scope="col">Nom</th>
						      		 	 <th scope="col">Prénom</th>
						      		 	 <th scope="col">E-mail</th>
						      		 	 <th scope="col">Pass</th>
						      		 	 <th scope="col">Niveau</th>
						      		 	 <th scope="col">date</th>
						      		 
						      		 					      
						    		</tr>
						    		
 					     	 </thead>
 		 
  								<tbody>
  		<!-- Recuperation de l'attribut listesUser1 associé avec la liste Users -->
  		
  		
				    						<%
				    			
				    				ArrayList<User> listeUsers =(ArrayList<User>)request.getAttribute("users");
								
						    	
											for(User useri: listeUsers){
											%>
									
					
										<tr>
										
										<td><input name="choix_User" type="radio" value= <%= useri.getIdUser()%>></td>
											<td><%= useri.getIdUser() %></td>
											<td name="nom_User" value =<%= useri.getNom() %>><%= useri.getNom() %></td>
											<td><%= useri.getPrenom() %></td>
											<td><%=useri.getEmail() %></td>
											<td><%=useri.getMotPass() %></td>
											<td><%=useri.getNiveau() %></td>
											<td><%=useri.getDateNaissance() %></td>
										</tr>
										
											<%}
											%>
  		
  								</tbody>
  		
						</table>
								<div>
									<jsp:useBean id="message"      class="java.lang.String"    scope="request" />
             						<% if (message != null) { %><label><%= message %></label> <% } %> 
								</div>
						
							<button class="btn btn-primary" id="suppr_theme" formAction="<%=request.getContextPath() %>/connexion/suppressionUser" type="submit" name="supprimer">Supprimer</button>
							<button class="btn btn-primary" id="suppr_theme" formAction="<%=request.getContextPath() %>/connexion/modifierUser" type="submit" name="modifier">Modifier</button>
							<button class="btn btn-primary" id="modif_theme" formAction="<%=request.getContextPath() %>/connexion/retourListe" type="submit" name="liste">Liste</button>
							<button class="btn btn-primary" id="modif_theme" formAction="<%=request.getContextPath() %>/connexion/retour" type="submit" name="retour">Retour</button>
					  
					   </form>
					   
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
		<script src="<%=request.getContextPath() %>/script/jquery.js"></script>
		<script src="<%=request.getContextPath() %>/script/bootstrap.js"></script>
</body>
</html>