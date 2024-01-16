<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.jpaClass.modele.client" %>
<%@ page import="java.util.Base64" %>
<%@ page import="java.text.SimpleDateFormat" %>

<!DOCTYPE html>
<html>
<head>
    
    <title>Profil client</title>
<style>
					
		body {
		    font-family: Arial, sans-serif;
		    margin: 0;
		    padding: 0;
		    background-color: #f5f5f5;
		}
		
		.header {
    	background-color: #376380; 
    	color: #fff; 
    	padding: 20px 0; 
	  }
	
	 
	  .header nav {
	    display: flex;
    	justify-content: space-between;
    	align-items: center;
	  }
	
	  .header ul {
	    list-style: none; 
	    padding: 0;
	  }
	
	  .header li {
	    display: inline;  
	    margin-left: 100px;
	  }
	  
	 

	.header span {
    margin-right: 10px; 
    font-size: 22px;
	}
	
	  .header a {
	    text-decoration: none; 
	    color: #fff; 
	    font-size: 22px; 
	  }
			
			
	  .profil {
        background-color: #F1EEF4; 
    	color: #0E050F; 
    	padding: 20px 0;
    	box-shadow: 0 0 10px #376380;
    	
    }

    .profil h1 {
        text-align: center;
        font-size: 30px;
    }

    .profil ul {
        list-style: none;
        margin-right: 50px;
    }

    .profil ul li {
        font-size: 20px;
        display: flex;
        align-items: center;
    }
	.profil ul li h3 {
        margin-right: 10px; /* Espacement entre le titre et la donnée */
        color: #376380;
    }
	
    .profil ul li:last-child {
        margin-bottom: 0;
    }

    .client-image {
        border-radius: 50%; /* Pour rendre l'image circulaire */
        width: 350px; /* Ajustez la taille de l'image selon vos besoins */
        height: 350px; /* Ajustez la taille de l'image selon vos besoins */
        display: block;
        margin: 0 auto 20px; /* Centrez l'image horizontalement et ajoutez une marge en bas */
        margin-top: -900px;
		box-shadow: 0 0 10px #376380;
        
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
		.buttons {
            margin-top: 30px;
           margin-left: 1200px;
           margin-top: -150px;
            
            
        }

        .button {
            padding: 15px 20px;
            font-size: 24px;
            background-color: #376380;
            color: #fff;
            border: none;
            border-radius: 18px;
            margin: 26px;
            text-decoration: none;
            box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3); 
            width: 250px; 
            height: 40px; 
            display: inline-block; 
            text-align: center;
            line-height: 40px; 
        }
		
			
	</style>	
</head>
<body>
    <header class="header">
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

		 <%
	client client = (client) session.getAttribute("client");
		%>

<section class="profil">
    <h1>Profil du client</h1>
    <ul>
        <li><h3>Nom : </h3><%= client.getNom_client() %></li>
        <li><h3>Prénom : </h3><%= client.getPrenom_client() %></li>
        <li><h3>Email : </h3><%= client.getEmail_client() %></li>
        <li><h3>Adresse :</h3> <%= client.getAdresse_client() %></li>
        <li><h3>Téléphone : </h3><%= client.getTelephone_client() %></li>
        <li><h3>Nom d'utilisateur : </h3><%= client.getNom_utilisateur() %></li>
        <li><h3>Mot de passe : </h3><%= client.getMotdepasse() %></li>
        <li><h3>CIN : </h3><%= client.getCIN() %></li>
        <li> <h3>Date de naissance : </h3>
                <% SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                   String formattedDate = dateFormat.format(client.getDateNaissance());
                   out.println(formattedDate);
                %></li>
        <li>
            <%
                String base64Image = Base64.getEncoder().encodeToString(client.getimage());
            %>
            <img class="client-image" src="data:image/jpeg;base64, <%= base64Image %>" alt="client"/>
        </li>
    </ul>
    <div class="buttons">
    		<a href="ModifierProfilClient.jsp" class="button">Modifier</a>
            <a href="/LocationVoituresApp//DeconnexionClient" class="button">Déconnexion</a>
        </div>
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