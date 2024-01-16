<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="com.jpaClass.modele.voiture" %>
<%@ page import="java.util.Base64" %>
<html>
<head>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f0f0;
        }

        header {
            background-color: #376380;
            color: #fff;
            padding: 20px;
            text-align: center;
        }

        h1 {
            margin: 0;
            font-size:50px;
        }

        section {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            padding: 20px;
        }

        .car-container {
            border: 1px solid #ccc;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #fff;
            text-align: center;
            padding: 20px;
            width: 400px;
            margin:20px;
            
        }
        .car-container:hover{
            border: 3px solid #376380;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            background-color: #fff;
            
            
        }

        .indicator {
            font-size: 24px;
            margin-bottom: 10px;
        }

        .available {
            color: green;
        }

        .unavailable {
            color: red;
        }

        h2 {
            font-size: 20px;
            margin: 10px 0;
        }

        .car-img img {
            max-width: 100%;
            height: auto;
            border-radius: 8px;
        }

        section .return-button {
            text-align: center;
            margin-top: 20px;
        }
        
        section .add-button {
            text-align: center;
            margin-top: 20px;
        }
 		button {
			padding: 10px 20px;            
			font-size: 26px;
            background-color: #376380;
            color: #fff;
            border: none;
            border-radius: 25px;
            margin: 26px;
            text-decoration: none;
            box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3); 
            width: 100%; 
            height: 60px; 
            display: inline-block; 
            text-align: center;
            line-height: 40px;
            cursor: pointer; 
        }

     button:hover{
     	background-color: #9D5060;
            color: #fff;
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
    <h1>Liste des Voitures</h1>
</header>

<section>
    <%
    List<voiture> voitures = (List<voiture>) request.getAttribute("voitures");

    if (voitures != null) {
        for (voiture v : voitures) {
            byte[] photoBytes = v.getPhoto();
            String base64Image = Base64.getEncoder().encodeToString(photoBytes);
    %>
            <a href="/LocationVoituresApp/DetailsVoitureServlet?id=<%= v.getId_voiture() %>">
                <div class="car-container">
                    <div class="indicator <%= v.isDisponible() ? "available" : "unavailable" %>">
                        <%= v.isDisponible() ? "✔" : "✘" %>
                    </div>
                    <h2><%= v.getMarque() %> <%= v.getModele() %></h2>
                    
                    <div class="car-img">
                        <img src="data:image/jpeg;base64, <%= base64Image %>" alt="Voiture Image">
                    </div>
                </div>
            </a>
    <%
        }
    }
    %>
</section>
<section>
	<div class="return-button">
    <a href="/LocationVoituresApp/TableauServlet">
        <button>Retour au Tableau</button>
    </a>
</div>

<div class="add-button">
    <a href="/LocationVoituresApp/AjouterVoituresServlet.jsp">
        <button>Ajouter une voiture</button>
    </a>
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