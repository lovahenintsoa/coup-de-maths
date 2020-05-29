<%@page import= "java.util.ArrayList" %>
<%@page import= "metier.user.Niveau" %>
<%@page import= "metier.user.User" %>
<%@page import= "metier.user.Etudiant" %>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8">
		<title>Modifier ou suprimer profs</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- LINEARICONS -->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/inscrit/fonts/linearicons/style.css">

		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/inscrit/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

		<!-- DATE-PICKER -->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/inscrit/vendor/date-picker/css/datepicker.min.css">
		
		<!-- STYLE CSS -->
		<link rel="stylesheet" href="<%=request.getContextPath() %>/inscrit/css/style.css">
	</head>

	<body>

		<div class="wrapper">
			<div class="inner">
				<form  method="post" action="#">
					<h1>Modifier Utilisateur</h1>
					
						
			 			
						
						<div class="form-row">
								<jsp:useBean id="user1"      class="metier.user.Etudiant"    scope="request" />
						
								<div class="form-wrapper">
							
							
							
							
										<label >Id Utilisateur </label>
								
								       						
           						             
           					    	          					    		
								
										<%{ %>	<input type="text" class="form-control" value=<%=user1.getIdUser() %> name ="id" readonly> <% } %>
								</div>
							
							
							
								<div class="form-wrapper">
									<label >Nom *</label>
								<%{ %>	<input type="text" name ="nom" class="form-control" value=<%= user1.getNom() %> readonly>  <% } %>
												
								</div>
							
							
													
						</div>
						
						
					
						<div class="form-row ">
						
								<div class="form-wrapper">
									<label >Niveau* </label>
							
									<select class="form-control" id="idAbonneE" name="niveau" >
							 	 	<% 
							
								  		for (Niveau niveau : Niveau.values()) {
								  			 %>	
								     	 	 <option  value ="<%=niveau.getLibNiveau() %>"> <%=niveau.getLibNiveau() %></option>
							     	 		<%} 
							      		 %>
						    		</select>
								<i class="zmdi zmdi-chevron-down"></i>
								</div>
						
						
						
								<div class="form-wrapper">
						 				 <label >E_mail*</label>
						 			<%{ %>	 <input type="email" class="form-control"  name="email" id="email" value=<%=user1.getEmail() %> required /> <% } %>
								</div>
						
						</div>
						
						<div class="form-row ">
								<div class="form-wrapper">
										<label > Mot de passe *</label>
									<%{ %>	<input type="text" class="form-control" value=<%=user1.getMotPass() %> name="passe" required><% } %>
								</div>
						</div>
					
					
					
				
					<div class="label">
							<label> (* tous les champs sont obligatoires)</label>
					</div>
								<div>
									<jsp:useBean id="message"      class="java.lang.String"    scope="request" />
             						<% if (message != null) { %><label><%= message %></label> <% } %> 
								</div>
								
				   <div class="form-row ">
						<div class="form-wrapper">
							<button data-text="coup_de_maths"  formAction="<%=request.getContextPath() %>/connexion/modifEnreg" type="submit">
							<span>Modifier</span>
							</button>
						</div>
					</div>	
				</form>
			</div>
		</div>
		
		<script src="inscription/js/jquery-3.3.1.min.js"></script>

		<!-- DATE-PICKER -->
		<script src="<%=request.getContextPath() %>/inscrit/vendor/date-picker/js/datepicker.js"></script>
		<script src="<%=request.getContextPath() %>/inscrit/vendor/date-picker/js/datepicker.en.js"></script>

		<script src="<%=request.getContextPath() %>/inscrit/js/main.js"></script>
	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>