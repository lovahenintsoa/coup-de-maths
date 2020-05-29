<%@page import= "java.util.ArrayList" %>
<%@page import= "metier.user.Niveau" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta charset="utf-8">
		<title> Suprimer Utilisateur </title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- LINEARICONS -->
		<link rel="stylesheet" href="inscription/fonts/linearicons/style.css">

		<!-- MATERIAL DESIGN ICONIC FONT -->
		<link rel="stylesheet" href="inscription/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

		<!-- DATE-PICKER -->
		<link rel="stylesheet" href="inscription/vendor/date-picker/css/datepicker.min.css">
		
		<!-- STYLE CSS -->
		<link rel="stylesheet" href="inscription/css/style.css">
	</head>

	<body>

		<div class="wrapper">
			<div class="inner">
				<form  method="post" action="./recupSuppr">
					<h1> suprimer un profil</h1>
					<div class="form-row">
						<div class="form-wrapper">
						
							<label >Taper l'Id Utilisateur  </label>
							<input type="text" class="form-control" name="ids" placeholder="IdUtilisateur">
						</div>
						
					</div>
								
					
					
					<div class="form-row">
						
						<div class="form-wrapper">
							<button data-text="coup_de_maths">
							<span>Supprimer</span>
							</button>
						</div>
					</div>
					
													
					
				</form>
			</div>
		</div>
		
		<script src="inscription/js/jquery-3.3.1.min.js"></script>

		<!-- DATE-PICKER -->
		<script src="inscription/vendor/date-picker/js/datepicker.js"></script>
		<script src="inscription/vendor/date-picker/js/datepicker.en.js"></script>

		<script src="inscription/js/main.js"></script>
	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>