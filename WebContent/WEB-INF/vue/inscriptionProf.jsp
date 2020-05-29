
<%@page import= "java.util.ArrayList" %>
<%@page import= "metier.user.Niveau" %>


<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8">
		<title>inscription Profs</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- LINEARICONS -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/inscrit/fonts/linearicons/style.css">

		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/inscrit/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

		<!-- DATE-PICKER -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/inscrit/vendor/date-picker/css/datepicker.min.css">
		
		<!-- STYLE CSS -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/inscrit/css/style.css">
	</head>

	<body>
				
		<div class="wrapper">
			<div class="inner">
			
				<form name="methode" method="post" action="#">
					<h3>Fiche d'inscription</h3>
					
					<div class="form-row">
						<div class="form-wrapper">
							<label >Nom *</label>
							<input type="text" name ="nom" class="form-control" placeholder="Nom" required>
								
					
						</div>
						
						
             				
						<div class="form-wrapper">
							<label >Prénom *</label>
							<input type="text" name ="prenom" class="form-control" placeholder="Prénom" required>
						</div>
						
					</div>
																
						
										
					<div class="form-row">
					
						<div class="form-wrapper">
							<label >E_mail*</label>
						  <input type="email" class="form-control"  name="email" id="email" placeholder="Email" required />
						</div>		
						
						<div class="form-wrapper">
							<label >Responsable Niveau *</label>
							
							
							<!-- Remplissage de combo à partir de la classe Niveau -->
							<select class="form-control" id="idAbonneE" name="niveau">
							 	 <% 
							
								  	for (Niveau niveau : Niveau.values()) {
								  		 %>	
								     	  <option value ="<%=niveau.getLibNiveau() %>"> <%=niveau.getLibNiveau() %></option>
							     	 	<%} 
							      	 %>
						    </select>
							
							
						
							
							<i class="zmdi zmdi-chevron-down"></i>
						</div>
					</div>
					
					<div class="form-row ">
						<div class="form-wrapper">
							<label >Mot de Passe*</label>	
							<input class="form-control" type="password" name="pass" placeholder="Mot de passe" required>
							
						</div>
						
					</div>
					
					
					
					<div class="checkbox">
						<div class="label">
							<label> (* tous les champs sont obligatoires)</label>
								
								<div>
								<jsp:useBean id="message"      class="java.lang.String"    scope="request" />
             					<% if (message != null) { %><label><%= message %></label> <% } %> 
								</div>
						</div>
					</div>
					
					
					
							<button data-text="coup_de_maths" formAction="<%=request.getContextPath() %>/inscription/creerProf" type="submit" name="enreg_prof">
								<span>S'inscrire</span>
							</button>
					
						
							
					
					
				</form>
				<form method="post" action="#" > 
				
							<button data-text="coup_de_maths" formAction="<%=request.getContextPath() %>/inscription/creerRetour" type="submit" name="retour">
								<span>retour</span>
							</button>
				</form>
			</div>
		
		</div>
		
		
		<script src="<%=request.getContextPath()%>/inscrit/js/jquery-3.3.1.min.js"></script>

		<!-- DATE-PICKER -->
		<script src="<%=request.getContextPath()%>/inscrit/vendor/date-picker/js/datepicker.js"></script>
		<script src="<%=request.getContextPath()%>/inscrit/vendor/date-picker/js/datepicker.en.js"></script>

		<script src="<%=request.getContextPath()%>/inscrit/js/main.js"></script>
	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>