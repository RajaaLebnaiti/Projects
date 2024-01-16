<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
            background-color: #BFCAD0;
            margin: 0;
            padding: 0;
            text-align: center;
        }
         header {
            background-color: #376380;
            color: #fff;
            text-align: center;
            padding: 1em;
            font-size:30px;
        }
        table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 10px;
    border: 2px solid #333; /* Ajout de la bordure à la table */
}

th, td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
}

th {
    background-color: #f2f2f2;
    border: 2px solid #333; /* Ajout de la bordure au header de la table */
}

        h1 {
            color: #333;
        }

        .formulaire {
            margin-top: 40px;
            
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        select, input[type="date"], input[type="submit"] {
            padding: 8px;
            margin-bottom: 10px;
            width: 200px;
            font-size:18px;
            
        }

        .VoitureSHow {
            margin-top: 20px;
        }

        h2 {
            color: #333;
        }

        table {
            width: 80%;
            border-collapse: collapse;
            margin-top: 10px;
            margin: 0 auto;
            
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
            
        }

        th {
		backgound-color:#EDEEF1; 
		color:#9D5060;
		font-size:20px;
		       }

        .voiture-image {
            max-width: 100px;
            max-height: 100px;
        }

        .reserve-button {
            display: inline-block;
            padding: 8px 15px;
            background-color: #3C4C70;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            font-size:16px;
        }

        p {
            color: #777;
        }
    </style>
</head>
<body>
<header>Réservation de Voitures</header>
	 <h1></h1>
    <div class="formulaire">
        <form action="RechercheVoituresServletPersonnel" method="get">
            <div class="form-group">
                <label for="annee">Date :</label>
                <input type="date" id="annee" name="annee" required>
            </div>
<div class="form-group">
	<label for="marque">Marque :</label>
            <select name="marque" id="marque" required>
                <option value="">Sélectionnez une marque</option>
                <option value="Toyota">Toyota</option>
                <option value="BMW">BMW</option>
            </select>
</div>
            
<div>
	<input type="submit" value="Rechercher">
</div>
            
        </form>
    </div>
    
    
     <div class="VoitureSHow">
	    <h2>Les voitures disponibles sont </h2>
	    <% List<com.jpaClass.modele.voiture> voitures = (List<com.jpaClass.modele.voiture>) request.getAttribute("Voitures");
	    if (voitures != null && !voitures.isEmpty()) { %>
	        
	        <table border="1">
	            <tr>
	                <th>Marque</th>
	                <th>Modèle</th>
	                <th>Année</th>
	                <th>Couleur</th>
	                <th>Matricule</th>
	                <th>Kilométrage prévu</th>
	                <th>Nombre de places</th>
	                <th>Image</th>
	                <th>Action</th>
	                
	            </tr>
	
	            <% for (voiture v : voitures) { %>
	                <tr>
	                    <td><%= v.getMarque() %></td>
	                    <td><%= v.getModele() %></td>
	                    <td><%= v.getAnnee() %></td>
	                    <td><%= v.getCouleur() %></td>
	                    <td><%= v.getMatricule() %></td>
	                    <td><%= v.getKilometragePrevu() %></td>
	                    <td><%= v.getNbPlaces() %></td>
	                    <td><%
	                        // Convertir les données binaires en base64
	                        String base64Image = Base64.getEncoder().encodeToString(v.getPhoto());
	                        %>
	                        <img class="voiture-image" src="data:image/jpeg;base64, <%= base64Image %>" alt="Voiture"></td>
						<td>
						<a href="confirmationReservationPersonnel.jsp?modele=<%= v.getMarque() %>&annee=<%= v.getAnnee() %>" class="reserve-button">Réserver</a>
								
						        
						        
						    
						</td>
	                
	                </tr>
	            <% } %>
	        </table>
	    <% } else { %>
	        <p>Aucune voiture trouvée pour les critères de recherche.</p>
	    <% } %>

    
   </div>
   
    
</body>
</html>