<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Page d'accueil</title>
		<link href="https://fonts.googleapis.com/css?family=Poppins:500&display=swap"
		rel="stylesheet"><!--   police choisie a partir de google font -->
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/accueil.css">

	</head>
	<body>
		<header>
			<div class="logo-conteneur">
				<img alt="logo" src="<%=request.getContextPath()%>/image/logo3.png">
				<h2 class="titre-logo" >Coup_de_Maths</h2>
			</div>
			
						
			<nav>
				<ul class="nav-links">
					<li ><a class="nav-link" href="#">Credits</a></li>
				<li><p class="inscrit">Inscription</p> <p class="nav-link"><a class="nav-link" href="<%=request.getContextPath()%>/inscription/professeur">Professeur</a>/ <a class="nav-link" href="<%=request.getContextPath()%>/inscription/etudiant">Etudiant</a></p></li>
					<li ><a class="nav-link" href="<%=request.getContextPath()%>/connexion/pass" >Mon Compte</a></li>
				</ul>
			</nav>
		</header>
		
		<main>
			
			<section>
				<div class="partie1">
				
					<div class="text1">
						<p class="marge">Bienvenue sur Coup_de_Maths, le site répond à  toutes vos
							questions mathématiques. il propose un suivi particulier des élèves
							et des réponses personnalisés à  leurs questions. Vous y trouverez
							des <strong>cours de maths en ligne gratuit</strong>, des <strong>évaluations de mathématiques
							</strong>gratuites.
						</p>
					</div>
					<div class="image1">
						<img alt="logo" src="<%=request.getContextPath()%>/image/calculette.jpg">
					</div>
					
				</div>
				
				<div class="partie2">
				
					<div class="text2">
						<p class="marge">Inscrivez-vous pour poser vos <strong> questions mathématiques</strong>. Gagner
							des crédits pour pouvoir poser plus de questions. Dès votre
							inscription on vous offre des crédits qui vous permet de poser des
							questions, vous pouvez gagner des crédits en vous évaluant sur notre
							site, il y a aussi la possibilité d'acheter des crédits en ligne.
						</p>
					</div>
					<div class="image2">
						<img alt="logo" src="<%=request.getContextPath()%>/image/stylo.jpg">
					</div>
					
				</div>
				
				
				<div class="partie3">
				
					<div class="text2">
						<div class="texte">
							<h1 class="titre">Evaluation de Mathématiques gratuite......</h1>
							<p> Vous avez acces ici à  une evaluation gratuite pour avoir des crédits ! Lancez-vous...</p>
						</div>
						<div class="btn">
							<button class="btnselect"> Evaluation</button>
						</div>
					</div>
					
					<div class="cours">
						<h1 >Support de cours gratuit (clicker)</h1><br/>
						<ul class="listes">
							<li><p>
								> <a class="liste" href="#">Calculs</a>
							</p></li>
							<li><p>
								> <a class="liste" href="#">Fonction</a>
							</p></li>
							<li><p>
								> <a class="liste" href="#">Equation</a>
							</p></li>
							<li><p>
								> <a class="liste" href="#">Volume</a>
							</p></li>
							<li><p>
								> <a class="liste" href="#">Vecteur</a>
							</p></li>
							<li><p>
								> <a class="liste" href="#">Fraction</a>
							</p></li>
							<li><p>
								> <a class="liste" href="#">Translation</a>
							</p></li>
					</ul>

				</div>
					
				</div>
				
			
			</section>
			<img class="eclipse" alt ="eclipse" src="<%=request.getContextPath()%>/image/beclipse.png">
			<img class="eclipse1" alt ="eclipse" src="<%=request.getContextPath()%>/image/mdeclipse.png">
		
		
		</main>

	</body>
</html>