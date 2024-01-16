<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.jpaClass.modele.client" %>
<%@ page import="java.util.Base64" %>

<html>
<head>
    <title>Détails du Client</title>
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
		
		.details-container {
		    max-width: 600px;
		    margin: 20px auto;
		    background-color: #fff;
		    border: 1px solid #ddd;
		    border-radius: 8px;
		    padding: 20px;
		    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
		    
		}
		
		.details-container h3 {
		    font-size: 20px;
		    margin: 10px 0;
		    text-align:center;
		}
		
		.client-img img {
		    display: block; /* Pour éviter les espaces vides autour de l'image */
    max-width: 100%;
    height: 30%;
    border-radius: 8px;
    margin-top: 20px;
    margin-left: auto;
    margin-right: auto;
		    
		}
		
		.return-button {
		    display: block;
		    text-align: center;
		    margin-top: 20px;
		    margin-bottom: 20px;
		}
		
		.return-button button {
		    padding: 10px 20px;
		    font-size: 26px;
		    background-color: #376380;
		    color: #fff;
		    border: none;
		    border-radius: 5px;
		    cursor: pointer;
		    text-decoration: none;
		    display: inline-block;
		    transition: background-color 0.3s ease;
		    
		}
		
		.return-button button:hover {
		    background-color: #2b4b5b;
		}
    </style>
</head>
<body>
    <header>
        <h1>Détails du Client</h1>
    </header>

    <div class="details-container">
        <h3>Nom : <%= ((client)request.getAttribute("clientDetails")).getNom_client() %></h3>
        <h3>Prénom : <%= ((client)request.getAttribute("clientDetails")).getPrenom_client() %></h3>
        <h3>Email : <%= ((client)request.getAttribute("clientDetails")).getEmail_client() %></h3>
        <h3>Adresse : <%= ((client)request.getAttribute("clientDetails")).getAdresse_client() %></h3>
        <h3>Téléphone : <%= ((client)request.getAttribute("clientDetails")).getTelephone_client() %></h3>
        <h3>Nom d'utilisateur : <%= ((client)request.getAttribute("clientDetails")).getNom_utilisateur() %></h3>
        <h3>Mot de passe : <%= ((client)request.getAttribute("clientDetails")).getMotdepasse() %></h3>
        <h3>CIN : <%= ((client)request.getAttribute("clientDetails")).getCIN() %></h3>
        <h3>Date de Naissance : <%= ((client)request.getAttribute("clientDetails")).getDateNaissance() %></h3>

        <div class="client-img">
            <img src="data:image/jpeg;base64, <%= Base64.getEncoder().encodeToString(((client)request.getAttribute("clientDetails")).getimage()) %>" alt="Client Image">
        </div>
    </div>
    <a href="/LocationVoituresApp/ListeClientsServlet" class="return-button">
    <button>Retour</button>
</a>
    
</body>
</html>