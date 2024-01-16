<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page de Paiement</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
           
            
        }

        .formulaire {
		  margin: 60px auto;
		  padding: 20px;
		  width: 40%;
		  background-color: #f9f9f9;
		  border: 1px solid #ccc;
		  border-radius: 5px;
		  box-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3); 
		  
		}

        h1 {
            text-align: center;
            color: #333;
        }

        label {
            display: block;
            margin: 10px 0 5px;
            color: #555;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        img {
            display: block;
            margin: 0 auto 20px;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
        .success-message {
		  margin-top: 10px;
		  padding: 10px;
		  background-color: #4caf50; 
		  color: red; 
		  border: 1px solid #388e3c; 
		  border-radius: 5px;
		}
		
		 .buttons {
            margin-top: 30px;
            
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
<body>
 <%-- Afficher le message d'erreur --%>
    <%
        String errorMessage = (String) session.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
        <div style="color: red;"><%= errorMessage %></div>
    <%
            // Effacez le message d'erreur de la session une fois affiché
            session.removeAttribute("errorMessage");
        }
    %>
    <div class="formulaire"> 
    <form action="processPayment" method="post">
        <!-- Image de PayPal -->
        <img src="/LocationVoituresApp/images/paypal.png" alt="PayPal Logo">

        <!-- Nom sur la carte -->
        <label for="cardHolderName">Nom sur la carte :</label>
        <input type="text" id="cardHolderName" name="cardHolderName" required>

        <!-- Nom de la carte -->
        <label for="cardName">Nom de la carte :</label>
        <input type="text" id="cardName" name="cardName" required>

        <!-- Numéro de la carte -->
        <label for="cardNumber">Numéro de carte :</label>
        <input type="number" id="cardNumber" name="cardNumber" required>

        <!-- Date d'expiration -->
        <label for="expirationDate">Date d'expiration :</label>
        <input type="date" id="expirationDate" name="expirationDate" placeholder="MM/YYYY" required>

        <!-- Bouton Valider -->
        <input type="submit" value="Valider">

    </form>
    </div>
<div class="content">
        <%-- Affichez le message de succès si disponible --%>
        <%
            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
        %>
            <div class="success-message">
                <%= successMessage %>
              
        <%
            }
        %>
        
    </div>
      
            </div>
            <div class="buttons">
            <a href="/LocationVoituresApp/HistoriqueReservation" class="button">Historique</a>
        </div>
</body>
</html>