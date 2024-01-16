<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.jpaClass.modele.client" %>
<%@ page import="java.util.Base64" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jpaClass.modele.client" %>
<%@ page import="java.util.Base64" %>
<html>
<head>
    <title>Liste des Clients</title>
    <style>
       body {
		    font-family: 'Arial', sans-serif;
		    margin: 0;
		    padding: 0;
		    background-color: #f5f5f5;
		}
		
		header {
		    background-color: #376380;
		    color: #fff;
		    padding: 30px;
		    text-align: center;
		}
		
		h1 {
		    margin: 0;
		}
		
		section {
		    display: flex;
		    flex-wrap: wrap;
		    justify-content: center;
		    gap: 20px;
		    padding: 20px;
		}
		
		.client-container {
		    border: 1px solid #ccc;
		    border-radius: 8px;
		    overflow: hidden;
		    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
		    background-color: #fff;
		    text-align: center;
		    padding: 20px;
		    width: 400px;
		    box-sizing: border-box;
		    margin-bottom: 20px;
		    margin:30px;
		}
		.client-container:hover{
			
		    border: 1px solid #376380;

		}
		.client-info h2 {
		    font-size: 20px;
		    margin: 10px 0;
		    color: #376380;
		}
		
		.client-info p {
		    margin: 5px 0;
		    color: #555;
		}
		
		.client-img img {
		    max-width: 100%;
		    height: auto;
		    border-radius: 8px;
		    margin-top: 10px;
		    
		    
		}
		
		.action-buttons {
		    margin-top: 20px;
		}
		
		.action-buttons button {
    padding: 10px 20px;
    font-size: 16px;
    background-color: #376380;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    margin: 5px;
    text-decoration: none; /* Supprimer la ligne soulignée */
    display: inline-block;
    transition: background-color 0.3s ease;
}
.action-buttons a {
    text-decoration: none; /* Supprimer la ligne soulignée */
    color: white;
}

.action-buttons button:hover {
    background-color: #2b4b5b;
}
		
		.return-button {
		    display: block;
		    text-align: center;
		    margin-top: 20px;
		    margin-bottom:20px;
		}
		
		.return-button button {
		    padding: 10px 20px;
		    font-size: 26px;
		    background-color: #376380;
		    color: white;
		    border: none;
		    border-radius: 5px;
		    cursor: pointer;
		    transition: background-color 0.3s ease; /* Ajout de la transition */
		}
		
		.return-button button:hover {
		    background-color: #2b4b5b; /* Changement de couleur au survol */
		}
		
		footer {
		    background-color: #376380;
		    color: #fff;
		    text-align: center;
		    padding: 10px;
		}
		
		.footer-info p {
		    margin: 5px 0;
		    font-size:16px;
		}

    </style>

</head>
<body>

<header>
    <h1>Liste des Clients</h1>
</header>

<section>
    <%
        List<client> clients = (List<client>) request.getAttribute("clients");

        for (client c : clients) {
           
    %>
            <div class="client-container">
                <div class="client-info">
                    <h2><%= c.getNom_client() %> <%= c.getPrenom_client() %></h2>
                    <p>Email: <%= c.getEmail_client() %></p>
                </div>
                <div class="client-img">
                 <%String base64Image = Base64.getEncoder().encodeToString(c.getimage());%>
                    <img src="data:image/jpeg;base64, <%= base64Image %>" alt="Client Image">
                </div>
                <div class="action-buttons">
                    <button><a href="/LocationVoituresApp/reccupererClient?id=<%= c.getId_client() %>">Modifier</a></button>
                    <button><a href="/LocationVoituresApp/SupprimerClientServlet?id=<%= c.getId_client() %>">Supprimer</a></button>
                    <button><a href="/LocationVoituresApp/DetailsClientServlet?id=<%= c.getId_client() %>">Details</a></button>
                </div>
            </div>
    <%
        }
    %>
</section>

<!-- Bouton de retour -->
<a href="/LocationVoituresApp/TableauServlet" class="return-button">
    <button>Retour</button>
</a>
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