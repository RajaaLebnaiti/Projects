<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jpaClass.modele.reservation" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter Facture</title>
    <style>
        body {
    background-image: url("/LocationVoituresApp/images/backgroun.jpg");
    font-family: 'Arial', sans-serif;
    background-color: #f4f4f4;
    margin: 20px;
}

h1 {
    color: #333;
}

form {
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    max-width: 400px;
    margin: 0 auto;
}

label {
    display: block;
    margin-bottom: 10px;
    color: #555;
}

input,
select {
    width: calc(100% - 16px);
    padding: 10px;
    margin-bottom: 15px;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 5px;
}

button {
    background-color: #4caf50;
    color: white;
    padding: 12px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
}
   
        .error-message {
		    color: red; 
		    font-weight: bold; 
		    margin-top: 10px; 
		}
button:hover {
    background-color: #45a049;
}
    </style>
</head>
<body>



<form action="/LocationVoituresApp/AjouterFacture" method="post">
    <label for="montant">Montant :</label>
    <input type="text" name="montant" required><br>

    <label for="dateFacturation">Date de Facturation :</label>
    <input type="date" name="dateFacturation" required><br>

    <label for="idReservation">ID de Réservation :</label>
    <select name="idReservation" required>

        <% List<reservation> reservations = (List<reservation>) request.getAttribute("reservations");
        for (reservation res : reservations) { %>
        
            <option value="<%= res.getId_reservation() %>"><%= res.getId_reservation() %></option>
        <% } %>

    </select><br>
     <button><a href="/LocationVoituresApp/TableauServlet">Retourner</a></button>
    <button type="submit">Ajouter Facture</button>
</form>
  <div class="error-message">
    			<%
				String message=(String) request.getAttribute("message");
			if(message!=null){
				out.print(message);
			}
			%>
			</div>
</body>
</html>