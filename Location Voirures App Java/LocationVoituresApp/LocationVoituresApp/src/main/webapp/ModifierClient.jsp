<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="java.io.*, java.util.*, java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jpaClass.modele.client" %>
<%@ page import="java.util.Base64" %>

<!DOCTYPE html>
<html>
<head>
    <title>Modifier Client</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
        background-image: url("/LocationVoituresApp/images/backgroun.jpg");
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
     	.form-container {
		    max-width: 1000px;
		    margin: 0 auto;
		    background-color: #fff;
		    padding: 20px;
		    border-radius: 5px;
		    box-shadow: 0 0 20px #376380;
		    display: grid;
		    grid-template-columns: 1fr 1fr;
		    gap: 20px;
		    color: #376380;
		}
		
		.form-group {
		    box-sizing: border-box;
		}
		
		
		
		label {
		    display: block;
		    margin-bottom: 10px;
		    color:#9D5060;
		    font-size:25px;
		    padding:10px;
		    		    margin-left:50px;
		    
		}
		
		input[type="text"],
		input[type="number"],
		input[type="date"],
		input[type="file"],
		input[type="submit"] {
		    width: 80%;
		    padding: 10px;
		    margin-bottom: 10px;
		    border: 1px solid #376380;
		    border-radius: 4px;
		    box-sizing: border-box;
		    font-size: 19px;
		    color: black;
		    margin-left:50px;
		    
		}
		
		input[type="submit"] {
		    background-color: #376380;
		    color: white;
		    cursor: pointer;
		    margin-left:-250px;
		    font-size: 26px;
		}
		
		input[type="submit"]:hover {
		    background-color: #005F99;
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
		    margin-top:10px;
		    
		}
		
		.return-button button:hover {
		    background-color: #2b4b5b;
		}
    </style>
</head>
<body>

<div class="container">
   

    <%
        client clientAModifier = (client) request.getAttribute("client");
        if (clientAModifier != null) {
    %>

    <form action="/LocationVoituresApp/ModifierClientServlet" method="post" enctype="multipart/form-data" class="form-container">
        <input type="hidden" name="id" value="<%= clientAModifier.getId_client() %>">
        
        <div class="form-group">
            <label for="nom_client">Nom Client:</label>
            <input type="text" id="nom_client" name="nom_client" value="<%= clientAModifier.getNom_client() %>"  >
        </div>
	<div class="form-group">
	    <label for="prenom_client">Prenom Client:</label>
	    <input type="text" id="prenom_client" name="prenom_client" value="<%= clientAModifier.getPrenom_client() %>" ><br>
	</div>
	<div class="form-group">
	    <label for="DateNaissance">Date de Naissance:</label>
    	<input type="date" id="DateNaissance" name="DateNaissance" value="<%= new SimpleDateFormat("yyyy-MM-dd").format(clientAModifier.getDateNaissance()) %>"><br>
	</div>
	<div class="form-group">
    	<label for="adresse_client">Adresse Client:</label>
    	<input type="text" id="adresse_client" name="adresse_client" value="<%= clientAModifier.getAdresse_client()%>" ><br>
	</div>
	<div class="form-group">
    	<label for="telephone_client">Telephone Client:</label>
   	 	<input type="number" id="telephone_client" name="telephone_client" value="<%= clientAModifier.getTelephone_client()%>"  ><br>
	</div>
	<div class="form-group">
    	<label for="nom_utilisateur">Nom Utilisateur:</label>
    	<input type="text" id="nom_utilisateur" name="nom_utilisateur" value="<%= clientAModifier.getNom_utilisateur() %>"><br>
	</div>
	<div class="form-group">
   	 	<label for="motdepasse">Mot de Passe:</label>
    	<input type="text" id="motdepasse" name="motdepasse" value="<%= clientAModifier.getMotdepasse() %>"><br>
	</div>
	<div class="form-group">
    	<label for="CIN">CIN:</label>
    	<input type="text" id="CIN" name="CIN" value="<%= clientAModifier.getCIN() %>"><br>
	</div>
	<div class="form-group">
    	<label for="email_client">Email Client:</label>
    	<input type="text" id="email_client" name="email_client" value="<%= clientAModifier.getEmail_client()%>" ><br>
 	</div>

 	
	
 <div class="form-group">
         <h3>Image : </h3>
		 <%String base64Image = Base64.getEncoder().encodeToString(clientAModifier.getimage());%>
        <img class="client-image" src="data:image/jpeg;base64, <%= base64Image %>" alt="client"/>
		<input type="file" name="image">
    </div>

        <input type="submit" value="Modifier"> 
    
</form>
</div>
<a href="/LocationVoituresApp/ListeClientsServlet" class="return-button">
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