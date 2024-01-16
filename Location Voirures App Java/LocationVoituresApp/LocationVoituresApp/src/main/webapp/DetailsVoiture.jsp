<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jpaClass.modele.voiture" %>
<%@ page import="java.util.Base64" %>

<html>
<head>
    <title>Détails Voiture</title>
    <style>
    header {
            background-color: #376380;
            color: #fff;
            text-align: center;
            padding: 1em;
            font-size:30px;
        }

.car-details-container {
    display: flex;
    align-items: center;
    margin-bottom: 20px;
    padding: 20px;
    background-color: #fff;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width:90%;
    height:500px;
    margin: 0 auto;
}

.car-details-img img {
    max-width: 100%;
    height: 400px;
    border-radius: 8px;
    margin-right: 20px; /* Ajustez cette valeur selon votre préférence */
}

.car-details-info {
    flex: 1; /* Utilisez tout l'espace disponible */
}


.car-details-info h2 {
    color: #376380;
    font-size: 44px;
    margin-bottom: 10px;
    text-align:center;

}

.car-details-info p {
    color: #555;
    font-size: 26px;
    margin-bottom: 8px;
    text-align:center;
}

.form-container {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top: 20px;
}

.form-container button {
    background-color: #376380;
    color: #fff;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 20px;
    margin-right: 10px;
}

.form-container button:hover {
    background-color: #0056b3;
}

    </style>
</head>
<body>

<%
    voiture v = (voiture) request.getAttribute("voiture");

    if (v != null) {
        byte[] photoBytes = v.getPhoto();
        String base64Image = Base64.getEncoder().encodeToString(photoBytes);
%>

<header>Details voitures</header>

<div class="car-details-container">
    <div class="car-details-img">
        <img src="data:image/jpeg;base64, <%= base64Image %>" alt="Voiture Image">
    </div>
    <div class="car-details-info">
        <h2><%= v.getMarque() %> <%= v.getModele() %></h2>
        <p>Année: <%= v.getAnnee() %></p>
        <p>Couleur: <%= v.getCouleur() %></p>
        <p>Matricule: <%= v.getMatricule() %></p>
        <p>Kilométrage Prévu: <%= v.getKilometragePrevu() %> km</p>
        <p>Nombre de Places: <%= v.getNbPlaces() %></p>
        <p>Disponibilité: <%= v.isDisponible() ? "Disponible" : "Non Disponible" %></p>
    </div>
</div>

<div class="form-container">
    <button onclick="window.location.href='/LocationVoituresApp/recupereVoitureServlet?id=<%= v.getId_voiture() %>'">Modifier</button>
    <button onclick="window.location.href='ServletVoitureSupprimer?id=<%= v.getId_voiture() %>'">Supprimer</button>
    <button onclick="window.location.href='/LocationVoituresApp/VoitureServlet'">Retourner</button>
</div>

<%
    }
%>

</body>
</html>