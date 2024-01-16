<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*, java.util.*, java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jpaClass.modele.facturation" %>
<%@ page import="java.util.Base64" %>

<!DOCTYPE html>
<html>
<head>
    <title>Modifier Facture</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
        background-image: url("/LocationVoituresApp/images/backgroun.jpg");
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
        form {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top:120px;
        }
        input[type="text"], input[type="number"], input[type="date"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #3C4C70;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size:20px;
            margin-left:200px;
            margin-top:30px;
        }
        input[type="submit"]:hover {
            background-color: #45a049;
        }

  a{
    text-decoration: none;
    color: white;
    
    
}


    </style>
</head>
<body>

<div class="container">
   

    <%
    facturation facturations = (facturation) request.getAttribute("facturations");
        if (facturations != null) {
    %>

    <form action="/LocationVoituresApp/ModifierFacturationServlet" method="post">
        <input type="hidden" name="id" value="<%= facturations.getId_facture() %>">
        
        

    

    <label for="DateNaissance">Date de facturation:</label>
    <input type="date" id="DateNaissance" name="DateReservation" value="<%= new SimpleDateFormat("yyyy-MM-dd").format(facturations.getDate_facturation()) %>" required><br>

    

    <label for="CIN">ID_Reservation:</label>
    <input type="text" id="CIN" name="ID_Reservation" value="<%= facturations.getReservation().getId_reservation() %>" required><br>

    <label for="email_client">Montant de reservation:</label>
    <input type="text" id="email_client" name="montant" value="<%= facturations.getMontant()%>" required><br>

    <input type="submit" value="Modifier">
    
</form>
<a href="/LocationVoituresApp/FacturationServlet" class="return-button">
    <button>Retour</button>
</a>

<%
    }
    // Sinon, afficher un message d'erreur
    else {
%>
    <p>Client non trouvé.</p>
<%
    }
%>

</body>
</html>