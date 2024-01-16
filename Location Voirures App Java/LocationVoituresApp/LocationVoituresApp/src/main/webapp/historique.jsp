<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jpaClass.modele.reservation" %>
<%@ page import="com.jpaClass.modele.client" %>

<html>
<head>
    <title>Historique des Réservations</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: white;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #376380;
            color: #fff;
            text-align: center;
            padding: 1em;
        }

        table {
            width: 90%;
            border-collapse: collapse;
            border: 3px solid #2D1F30;
            margin: 0 auto;
            margin-top:30px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #333;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .actions {
            display: flex;
            justify-content: space-between;
        }

        .confirm, .reject {
            padding: 8px 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .confirm {
            background-color: #4CAF50;
            color: #fff;
        }
	.confirm a{
		text-decoration:none;
		color:white;
		font-size:16px;
	}
        .reject {
            background-color: #FF5733;
            color: #fff;
        }
.reject a{
		text-decoration:none;
		color:white;
		font-size:16px;
	}
        .status-icon {
            width: 20px;
            height: 20px;
        }
        
        .status-icon img {
            max-width: 100%;
            max-height: 100%;
        }

        .back {
            text-align: right;
        }
	.back button{
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
		    margin-top:20px;
		    margin-right:50px;
		    
		}
		.back button a{
			text-decoration:none;
			color:white;
		}
		.back button:hover {
		    background-color: #2b4b5b;
		}
    </style>
</head>
<body>

<header>
    <h1>Historique des Réservations</h1>
</header>

<div>
    <table>
        <thead>
            <tr>
                <th>ID Réservation</th>
                <th>Date Début</th>
                <th>Date Fin</th>
                <th>Lieu Prise</th>
                <th>Lieu Retour</th>
                <th>Mode Paiement</th>
                <th>Client</th>
                <th>Statut</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <% List<reservation> reservations = (List<reservation>) request.getAttribute("reservations");
               if (reservations != null) {
                   for (reservation res : reservations) { %>
                       <tr>
                           <td><%= res.getId_reservation() %></td>
                           <td><%= res.getDate_debut() %></td>
                           <td><%= res.getDate_fin() %></td>
                           <td><%= res.getLieuPrise() %></td>
                           <td><%= res.getLieuRetour() %></td>
                           <td><%= res.getModePaiment() %></td>
                           <td><%= res.getClient().getNom_client() %>
                           <%= res.getClient().getPrenom_client() %></td>
                           <td><%= res.getStatut().equals("Confirmé") ? "✔" : (res.getStatut().equals("en cours de traitement") ? "━" : "✘") %></td>

                           <td class="actions">
                               <button class="confirm"><a href="/LocationVoituresApp/confirmReservation?id=<%= res.getId_reservation() %>">Confirmer</a></button>
                               <button class="reject"><a href="/LocationVoituresApp/rejectReservation?id=<%= res.getId_reservation() %>">Rejeter</a></button>
                           </td>
                       </tr>
            <%     }
               } else {
                   out.println("Aucune réservation disponible.");
               }
            %>
        </tbody>
    </table>
</div>
<div class="back">
<button><a href="TableauServlet">Back</a></button>
</div>


</body>
</html>