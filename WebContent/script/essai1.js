/* Pour ajouter un nouveau fichier javasript new+ Javascript Source file
 Voici la fonction javascript qui change la propriété "display"
pour afficher ou non le div selon que ce soit "none" ou "block". 
creation du fichier dans script */

function Masquer()
{
divInfo = document.getElementById('fiche');
 
divInfo.style.display = 'none';

 }


function ProfInscription() {
	
	divInfo = document.getElementById('tete');
	divInfo.style.display = 'none';
	
	divInfo1 = document.getElementById('fiche');
	divInfo1.style.display = 'block';
	
	divInfo2 = document.getElementById('datenaiss');
	divInfo2.style.display = 'none';
	
	divInfo2 = document.getElementById('modif');
	divInfo2.style.display = 'none';
	
}

function EtudInscription() {
	
	divInfo = document.getElementById('tete');
	divInfo.style.display = 'none';
	
	divInfo1 = document.getElementById('fiche');
	divInfo1.style.display = 'block';
	
	divInfo2 = document.getElementById('modif');
	divInfo2.style.display = 'none';
		
}


function Modif() {
	
	divInfo = document.getElementById('tete');
	divInfo.style.display = 'none';
	
	divInfo1 = document.getElementById('fiche');
	divInfo1.style.display = 'block';
	
	divInfo2 = document.getElementById('datenaiss');
	divInfo2.style.display = 'none';
	
	divInfo2 = document.getElementById('mail');
	divInfo2.style.display = 'none';
	
	divInfo2 = document.getElementById('pass');
	divInfo2.style.display = 'none';
	
	divInfo2 = document.getElementById('check');
	divInfo2.style.display = 'none';
	
	divInfo2 = document.getElementById('inscrip');
	divInfo2.style.display = 'none';
	
}



	



