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
		


		.formulaire {
		    background-color: #f2f2f2; /* Couleur de fond */
		    padding: 20px; /* Marge intérieure pour l'espace autour du formulaire */
		    border: 1px solid #ccc; /* Bordure autour du formulaire */
		    border-radius: 5px; /* Coins arrondis */
		    width: 300px; /* Largeur du formulaire */
		    margin: 0 auto; /* Centre le formulaire horizontalement sur la page */
		}
		
		.formulaire form {
		    display: flex;
		    flex-direction: column;
		}
		
		.formulaire label {
		    font-weight: bold; 
		    margin-bottom: 5px; 
		    font-size: 18px;
		}
		
		.formulaire select {
		    font-weight: bold; 
		    margin-bottom: 10px; 
		    font-size: 18px;
		}
		.formulaire input[type="text"] {
		    width: 100%; 
		    padding: 5px; 
		    margin-bottom: 10px; 
		    border: 1px solid #376380; 
		    border-radius: 3px; 
		    font-size: 18px;
		}
		
		.formulaire input[type="submit"] {
		    background-color: #376380; 
		    color: #fff; 
		    padding: 10px 10px;
		    border: none; 
		    border-radius: 5px; 
		    cursor: pointer; 
		    font-size: 18px;
		}
		
		.formulaire input[type="submit"]:hover {
		    background-color: #0056b3; 
		}

		h1{
			color:#9D5060;
			text-align:center;
		}
		.VoitureSHow {
		    background-color: #FEFDFE;
		    padding: 20px;
		    border: 1px solid #ccc;
		    border-radius: 5px;
		    margin: 10px;
		}
		
		.VoitureSHow h2 {
		    font-size: 24px;
		    color: #9D5060;
		    text-align: center;
		    margin-top:70px;
		}
		
		.VoitureSHow table {
		    width: 100%;
		    border-collapse: collapse;
		    margin-top: 20px;
		   text-align: center;
		    
		}
		
		.VoitureSHow table th {
		    border: 1px solid #000;
		    padding: 8px;
		    text-align: left;
			box-shadow: 0 0 10px #376380;
		    
		}
		
		.VoitureShow table  td {
		    border: 1px solid #000;
		    padding: 8px;
		    text-align: center;
			box-shadow: 0 0 10px #376380;
		    
		}
		
		.VoitureSHow .voiture-image {
		    max-width: 150px;
		    max-height: 150px;
		    border: 1px solid #ccc;
		}
		
		.VoitureSHow p {
		    font-style: italic;
		    color: #999;
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
		
		.reserve-button {
		    background-color: #376380; /* Couleur de fond */
		    color: #E7DFE0; 
		    padding: 8px 16px; /* Rembourrage intérieur du bouton */
		    border: none; /* Supprime les bordures par défaut */
		    border-radius: 4px; /* Coins arrondis */
		    text-decoration: none; /* Supprime la soulignement du texte (si le bouton est un lien) */
		    display: inline-block;
		    cursor: pointer; /* Curseur de type main (pointeur) lors du survol */
		}
		
		.reserve-button:hover {
		    background-color: #9D5060; /* Couleur de fond lors du survol */
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

<header>
    <nav>
        <ul>
           
            <li><a href="/LocationVoituresApp/ProfilClient">Profil</a></li>
            <li><a href="HomePageClient.jsp">Voitures</a></li>
            <li><a href="#">Réservations</a></li>
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
<body>
    <h1>Réservation de Voitures</h1>
    <div class="formulaire">
        <form action="RechercheVoituresServlet" method="get">
            <div class="form-group">
                <label for="annee">Date :</label>
                <input type="date" id="annee" name="annee" required>
            </div>

            <label for="marque">Marque :</label>
            <select name="marque" id="marque" required>
                <option value="">Sélectionnez une marque</option>
                <option value="Toyota">Toyota</option>
                <option value="BMW">BMW</option>
            </select>

            <input type="submit" value="Rechercher">
        </form>
    </div>
    
    
    
		
   <div class="buttons">
            <a href="/LocationVoituresApp/HistoriqueReservation" class="button">Historique</a>
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
						<a href="confirmationReservation.jsp?modele=<%= v.getMarque() %>&annee=<%= v.getAnnee() %>" class="reserve-button">Réserver</a>
								
						        
						        
						    
						</td>
	                
	                </tr>
	            <% } %>
	        </table>
	    <% } else { %>
	        <p>Aucune voiture trouvée pour les critères de recherche.</p>
	    <% } %>

    
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
