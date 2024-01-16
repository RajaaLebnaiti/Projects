<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style> 
	body{
	
	background-color:#C6B79B
	}
	h1 {
	  font-size: 35px;
	  text-align: center;
	  color: #9D5060;
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
		
		/* Style pour les étiquettes des champs de formulaire */
		label {
		  display: block;
		  margin-top: 10px;
		  font-weight: bold;
		  font-size:24px;
		  color:#2D1F30;
		  text-align:center;
		}
		
		/* Style pour les champs de formulaire */
		input[type="date"],
		input[type="text"] {
		  width: 100%;
		  padding: 5px;
		  margin: 10px 0;
		  border: 1px solid #ccc;
		  border-radius: 3px;
		  font-size:20px;
		  text-align:center;
		}
		
		
		input[type="submit"] {
		  margin: 10px;
		  background-color: #376380;
		  color: #fff; 
		  padding: 10px 20px;
		  border: none;
		  border-radius: 3px;
		  cursor: pointer;
		  font-size:25px;
		  text-align:center;
		  margin-left:150px;
		  
		}
		
		input[type="submit"]:hover {
		  background-color: #9D5060; 
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
 <h1>Confirmation de Réservation</h1>
  <div class="formulaire"> 
    <form action="TraitementReservationServletPersonnel" method="post">
        
        <!-- Autres champs du formulaire pour la confirmation de réservation -->
        <label for="date_debut">Date de début :</label>
        <input type="date" id="date_debut" name="date_debut" required>
        
        <label for="date_fin">Date de fin :</label>
        <input type="date" id="date_fin" name="date_fin" required>
        
        <label for="lieuPrise">Lieu de prise :</label>
        <input type="text" id="lieuPrise" name="lieuPrise" required>
        
        <label for="lieuRetour">Lieu de retour :</label>
        <input type="text" id="lieuRetour" name="lieuRetour" required>
        
        <label for="modePaiement">Mode de paiement :</label>
        <input type="text" id="modePaiement" name="modePaiement" required>
        
        <label for="statut">Statut :</label>
        <input type="text" id="statut" name="statut" required value="en cours de traitement">
        
        <!-- le personnel va saisir le cin du client puisque cin est unique -->
        <label for="cin">CIN :</label>
        <input type="text" id="cin" name="cin" required>
        
        <input type="submit" value="Confirmer la réservation">
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
    
     <%-- Afficher le message de confirmation de reservation --%>
    <div>
        <% String message = (String) request.getAttribute("message");
           if (message != null) { %>
            <p><%= message %></p>
        <% } %>
    </div>
      <div class="buttons">
            <a href="/LocationVoituresApp/TableauServlet" class="button">Home</a>
        </div>
            </div>
</body>
</html>