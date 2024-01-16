<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jpaClass.modele.facturation" %>
<%@ page import="com.jpaClass.modele.reservation" %>
<%@ page import="com.jpaClass.modele.client" %>

<html>
<head>
    <title>Liste des Facturations</title>
    <style>
        button.add-button {
    background-color: #3498db;
    color: #fff;
    padding: 12px 24px;
    border: 2px solid #2980b9;
    border-radius: 5px;
    cursor: pointer;
    margin-top: 20px;
    margin-right: 10px;
    text-decoration: none;
    display: inline-block;
    transition: background-color 0.3s, border-color 0.3s, color 0.3s;
    font-size: 16px;
}

button.add-button:hover {
    background-color: #2980b9;
    border-color: #3498db;
    color: #fff;
    transform: scale(1.05);
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

        header {
            background-color: #376380;
            color: #fff;
            text-align: center;
            padding: 1em;
        }

        table {
            width: 80%;
            margin: 2em auto;
            background-color: #fff;
            border-collapse: collapse;
            border: 1px solid #ddd;
        }

        th, td {
            padding: 15px;
            text-align: center;
            border-bottom: 3px solid #ddd;
        }

        th {
            background-color: #376380;
            color: white;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        button {
            background-color: #3C4C70;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
        }
        
         button:hover {
            background-color: #DCA1B0;
            
        }
        a{
        	text-decoration:none;
        	color:white;
        	font-size:16px;
        }
    </style>
</head>
<body>

<header>
    <h1>Liste des Facturations</h1>
</header>

<div>
    <table>
        <thead>
            <tr>
                <th>ID Facture</th>
                <th>Montant</th>
                <th>Date Facturation</th>
                <th>ID Réservation</th>
                <th>ID Client</th> 
                <th>Nom Client</th> 
                <th>Actions</th> <!-- Nouvelle colonne pour les actions -->
            </tr>
        </thead>
       <tbody>
    <% List<facturation> facturations = (List<facturation>) request.getAttribute("facturations");
    for (facturation facturation : facturations) { %>
        <tr>
            <td><%= facturation.getId_facture() %></td>
            <td><%= facturation.getMontant() %></td>
            <td><%= facturation.getDate_facturation() %></td>
            <td><%= facturation.getReservation().getId_reservation() %></td>
            <td><%= facturation.getReservation().getClient().getId_client() %></td> <!-- Ajout de l'ID Client -->
            <td><%= facturation.getReservation().getClient().getNom_client() %>
                <%= facturation.getReservation().getClient().getPrenom_client() %>
            </td>
            <td>
                <button><a href="/LocationVoituresApp/supprimerFacture?id=<%= facturation.getId_facture() %>">Supprimer</a></button>
                <button><a href="/LocationVoituresApp/Recuperationfacture?id=<%= facturation.getId_facture() %>">Modifier</a></button>
                <button><a href="/LocationVoituresApp/TelechargementServlet?idFacture=<%= facturation.getId_facture() %>">Telecharger</a></button>
                <button><a href="/LocationVoituresApp/selectionneReservation?id=<%= facturation.getId_facture() %>">Ajouter</a></button>
            </td>
        </tr>
    <% } %>
</tbody>

    </table>
</div>


<button><a href="/LocationVoituresApp/TableauServlet">Retourner</a></button>


</body>
</html>