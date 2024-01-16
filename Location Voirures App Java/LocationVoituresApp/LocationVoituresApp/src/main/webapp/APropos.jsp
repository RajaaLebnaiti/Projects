<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Qui sommes-nous - LocationAutoPlus</title>
<style>

		body {
		    font-family: Arial, sans-serif;
		    margin: 0;
		    padding: 0;
		    background-color: #f5f5f5;
		}
		
		header {
    	background-color: #376380; 
    	color: #fff; 
    	padding: 20px 0; 
	  }
	
	 
	  nav {
	    display: flex;
    	justify-content: space-between;
    	align-items: center;
	  }
	
	  ul {
	    list-style: none; 
	    padding: 0;
	  }
	
	  li {
	    display: inline;  
	    margin-left: 100px;
	  }
	  
	 

	span {
    margin-right: 10px; 
    font-size: 22px;
	}
	
	  a {
	    text-decoration: none; 
	    color: #fff; 
	    font-size: 22px; 
	  }
	  span {
	    margin-right: 10px; 
	    font-size: 22px;
	}
		.content {
		    max-width: 800px;
		    margin: 0 auto;
		    padding: 20px;
		    background-color: #fff;
		    border-radius: 5px;
		    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
		    text-align: justify;
		    line-height: 1.6;
		    margin-top: 20px;
		    padding: 20px;
		}
		.content h1{
			text-align: center;
			color: #9D5060; 
		}
		
		footer {
		    background-color: #376380;
		    color: #fff;
		    text-align: center;
		    padding: 10px 0;
		}
		
		.footer-info {
		    max-width: 800px;
		    margin: 0 auto;
		    font-size: 14px;
		}
</style>
</head>
<body>
    <header>
        <nav>
            <ul>
           
            <li><a href="/LocationVoituresApp/ProfilClient">Profil</a></li>
            <li><a href="HomePageClient.jsp">Voitures</a></li>
            <li><a href="ReservationClient.jsp">Réservations</a></li>
            <li><a href="/LocationVoituresApp/FactureServlet">Facture</a></li>
            <li><a href="APropos.jsp">Qui sommes-nous</a></li>
            <li><a href="Reclamation.jsp">Réclamation</a></li>
        </ul>
        <span>
            <% String username = (String) session.getAttribute("username"); %>
            Bienvenue, <%= username %>!
        </span>
        </nav>
    </header>

    <div class="content">
         <h1>Qui sommes-nous - LocationAutoPlus</h1>
    <p>
        LocationAutoPlus est bien plus qu'une simple agence de location de voitures. Nous sommes votre partenaire de confiance pour répondre à tous vos besoins de mobilité. Notre mission est de vous fournir des voitures de qualité, un service exceptionnel et des tarifs compétitifs, afin de rendre vos déplacements plus agréables et sans tracas.
    </p>
    <p>
        Chez LocationAutoPlus, nous plaçons la satisfaction de nos clients au cœur de notre activité. Que vous ayez besoin d'une voiture pour un voyage d'affaires, des vacances en famille, un événement spécial ou toute autre occasion, vous pouvez compter sur nous pour avoir la voiture parfaite qui répondra à vos attentes.
    </p>
    <p>
        Nos véhicules sont régulièrement entretenus, propres et sûrs, pour vous offrir une expérience de conduite optimale. Notre équipe dévouée est là pour vous assister à chaque étape de votre location, de la réservation à la restitution du véhicule, et nous sommes disponibles pour répondre à toutes vos questions.
    </p>
    <p>
        Nous croyons en la simplicité et en la transparence. Aucun frais caché, des tarifs clairs et compétitifs, ainsi qu'une variété d'options de location pour s'adapter à vos besoins spécifiques.
    </p>
    </div>

    <footer>
        <div class="footer-info">
            <p>&copy; 2023 LocationAutoPlus. Tous droits réservés.</p>
            <p>Adresse : 13 Rue Centrale, Rabat</p>
            <p>Téléphone : +1 234 567 890</p>
            <p>Email : contact@LocationAutoPlus.com</p>
        </div>
    </footer>
</body>
</html>
