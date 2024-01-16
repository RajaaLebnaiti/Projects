<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.jpaClass.modele.voiture" %>
<%@ page import="com.jpaClass.modele.client" %>
<%@ page import="com.jpaClass.modele.reservation" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Base64" %>


<!DOCTYPE html>
<html>
<head>
    <title>Accueil Client</title>
    
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
			
					
		 .reservation {
		 
			    background: url('/LocationVoituresApp/images/buick-1400243_1920.jpg') center center no-repeat; /* Définissez l'URL de votre image */
			    background-size: cover; 
			    text-align: center;
			    padding: 100px 0; 
			    margin-top: 15px
			    
		}
			
			
			
		
		.btn-reservation {
		    padding: 15px 20px;
            font-size: 26px;
            background-color: #B5E5CF;
            color: #010100 ;
            border: none;
            border-radius: 28px;
            margin: 26px;
            text-decoration: none;
            box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3); 
            width: 300px; 
            height: 50px; 
            display: inline-block; 
            text-align: center;
            line-height: 40px;
		}
		.btn-reservation:hover{
			  background-color: #E7DFE0;
		}
		
		.offres {
		    background-color: #f7f7f7;
		    padding: 30px 0;
		}
		
		.offres-container {
		    max-width: 1200px;
		    margin: 0 auto;
		    padding: 20px;
		    background-color: #fff;
		    box-shadow: 0 0 10px #376380;
		    border-radius: 5px;
		}
		
		.offres-title {
		    font-size: 24px;
		    margin-bottom: 20px;
		    color: #333;
		    text-align: center;
		}
		
		.voitures-offres {
		    display: flex;
		    flex-wrap: wrap;
		    gap: 200px;
		}
		
		.ligne-voitures {
		    margin: 10px -10px;
		}
		
		.voiture-offre {
		    flex: 25%;
		    padding: 10px;
		    text-align: center;
		    margin-left:40px;
		}
		
		.voiture-image {
		    max-width: 100%;
		    border: 1px solid #376380;
		    box-shadow: 0 0 10px #376380;
		    border-radius: 5px;
		    margin-bottom: 20px; /* Ajout de l'espace en bas des images */
		}
		
		.voiture-image:hover{
			 box-shadow: 0 0 10px #9D5060;
			
		}
		.voiture-titre {
		    margin: 10px 0;
		    font-size: 18px;
		    color: #333;
		}
		
		.disponibilite {
		    font-size: 14px;
		    color: #777;
		}
		
		@media (max-width: 768px) {
		    .voiture-offre {
		        flex: 50%;
		    }
		}

				

		section.localisation {
		    background-color: #fff;
		    text-align: center;
		    padding: 80px 0;
		    
		}
		
		.map-container {
		    max-width: 900px;
		    margin: 0 auto;
		                
		    
		}
		
		footer {
		    background-color: #376380;
		    color: #fff;
		    text-align: center;
		    padding: 30px 0;
		}
		
		.footer-info p {
		    font-size: 18px;
		    margin: 5px;
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

	<section class="reservation">
		<div class="background-image">
            <a href="ReservationClient.jsp" class="btn-reservation">Créer votre réservation</a>
        </div>
	
	</section>
        
	<section class="offres">
    <div class="offres-container">
        <h2 class="offres-title">Découvrez Nos Offres Exclusives</h2>
        <div class="voitures-offres">
            <%
            List<com.jpaClass.modele.voiture> voitures = (List<com.jpaClass.modele.voiture>) session.getAttribute("voitures");
            if (voitures != null) {
                int carCount = 0;
                for (com.jpaClass.modele.voiture car : voitures) {
                    if (carCount % 4 == 0) {
                        %><div class="ligne-voitures"><%
                    }
                    %>
                    <div class="voiture-offre">
                        <%
                        // Convertir les données binaires en base64
                        String base64Image = Base64.getEncoder().encodeToString(car.getPhoto());
                        %>
                        <img class="voiture-image" src="data:image/jpeg;base64, <%= base64Image %>" alt="Voiture">
                        <h3 class="voiture-titre"><%= car.getMarque() %> - <%= car.getModele() %></h3>
                        <p class="disponibilite"><%= car.isDisponible() ? "Disponible" : "Non disponible" %></p>
                    </div>
                    <%
                    if (carCount % 4 == 3 || carCount == voitures.size() - 1) {
                        %></div><%
                    }
                    carCount++;
                }
            }
            %>
        </div>
    </div>
</section>


    <section class="localisation">    
    	<h2>Rejoigner nous sur : </h2>
        <div class="map" id="googleMap" style="width: 100%; height: 400px;">
			<iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d13234.569619710936!2d-6.8642694!3d33.9760296!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xda76cc25e0c4533%3A0x736cf0f5b8cb34a8!2sTerminus%20Tramway%20Madinat%20Al%20Irfane!5e0!3m2!1sfr!2sma!4v1699113780003!5m2!1sfr!2sma" width="600" height="450" style="border:0;"></iframe>        </div>
   </section>

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
