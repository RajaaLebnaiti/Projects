<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.jpaClass.modele.voiture" %>
<%@ page import="com.jpaClass.modele.client" %>
<%@ page import="com.jpaClass.modele.reservation" %>
<%@ page import= "java.time.ZoneId" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

		.historiqueShow {
		    background-color: #FEFDFE;
		    padding: 20px;
		    border: 1px solid #ccc;
		    border-radius: 5px;
		    margin: 10px;
		}
		
		.historiqueShow h1 {
		    font-size: 24px;
		    color: #9D5060;
		    text-align: center;
		}
		
		.historiqueShow table {
		    width: 100%;
		    height:400px;
		    border-collapse: collapse;
		    margin-top: 20px;
		   text-align: center;
		   box-shadow: 0 0 3px #376380;
		    
		}
		
		.historiqueShowtable th {
		    border: 1px solid #376380;
		    padding: 8px;
		    text-align: left;
			box-shadow: 0 0 1px #376380;
		    
		}
		
		.historiqueShow table  td {
		    border: 1px solid #000;
		    padding: 8px;
		    text-align: center;
			box-shadow: 0 0 1px #376380;
		    
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
            <li><a href="/LocationVoituresApp/ReservationClient.jsp">Réservations</a></li>
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
<div class="historiqueShow">
   		 <h1>Historique des Réservations</h1>
    <table border="1">
        <tr>
        	<th>Client</th>
            <th>Date de début Réservation</th>
            <th>Date de fin Réservation</th>
            <th>DaLieu de prise</th>
            <th>Lieu de retour</th>
            <th>Statut</th>
            <th>Mode Payement</th>
        </tr>

        <% List<reservation> historiqueReservations = (List<reservation>) request.getAttribute("historiqueReservations");
           for (reservation reservation : historiqueReservations) { %>
            <tr>
            
        		<td><%= reservation.getClient().getNom_client() + " " + reservation.getClient().getPrenom_client() %></td>
                <td><%= reservation.getDate_debut() %></td>
                <td><%= reservation.getDate_fin() %></td>
                <td><%= reservation.getLieuPrise() %></td>
                <td><%= reservation.getLieuRetour() %></td>
                <td><%= reservation.getStatut() %></td>
                <td><%= reservation.getModePaiment() %></td>
                
            </tr>
        <% } %>
    </table>
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