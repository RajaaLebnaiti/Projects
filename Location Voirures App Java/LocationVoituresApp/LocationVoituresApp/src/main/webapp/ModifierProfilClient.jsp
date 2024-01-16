<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.jpaClass.modele.client" %>
<%@ page import="java.util.Base64" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
    <title>Modifier le profil client</title>
    <style>
       
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .profil {
            background-color: #fff;
            padding: 5px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            margin: 20px;
        }

        h1 {
            color: #9D5060;
            text-align: center;
            font-size: 26px;
        }

        ul {
            list-style-type: none;
            padding: 10px;
        }

        li {
            margin-bottom: 10px;
            display: inline-block; /* Display elements horizontally */
            width: 45%; /* Set the width to fit two elements per line */
            padding: 20px; /* Add padding for spacing */
            margin-left: 30px;
        }

        h3 {
            color:#376380;
            font-size: 20px;
        }

        input[type="text"],
        input[type="email"],
        input[type="tel"],
        input[type="password"],
        input[type="date"],
        input[type="file"] {
            width: 70%;
            padding: 10px 20px 10px;
            border: 2px solid #376380;
            border-radius: 10px;
            font-size:16px;
            
        }

        input[type="submit"] {
            background-color: #376380;
            color: #fff;
            padding: 20px 20px;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            font-size:18px;
            margin-left: 550px;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <section class="profil">
	     <%client client = (client) session.getAttribute("client");%>
	     <h1>Modifier le profil du client</h1>
		<form action="ModifierProfilServlet" method="post" enctype="multipart/form-data">

            <ul>
                <li>
                    <h3>Nom : </h3>
                    <input type="text" name="nom_client" value="<%= client.getNom_client() %>">
                </li>
                <li>
                    <h3>Prénom : </h3>
                    <input type="text" name="prenom_client" value="<%= client.getPrenom_client() %>">
                </li>
                <li>
                    <h3>Email : </h3>
                    <input type="email" name="email_client" value="<%= client.getEmail_client() %>">
                </li>
                <li>
                    <h3>Adresse :</h3>
                    <input type="text" name="adresse_client" value="<%= client.getAdresse_client() %>">
                </li>
                <li>
                    <h3>Téléphone : </h3>
                    <input type="tel" name="telephone_client" value="<%= client.getTelephone_client() %>">
                </li>
                <li>
                    <h3>Nom d'utilisateur : </h3>
                    <input type="text" name="nom_utilisateur" value="<%= client.getNom_utilisateur() %>">
                </li>
                <li>
                    <h3>Mot de passe : </h3>
                    <input type="password" name="motdepasse" value="<%= client.getMotdepasse() %>">
                </li>
                <li>
				    <h3>CIN : </h3>
				    <input type="text" name="CIN" value="<%= client.getCIN() %>">
				</li>

					<% System.out.println(client.getCIN()); %>
                <li>
                    <h3>Date de naissance : </h3>
                    <input type="date" name="DateNaissance" value="<%= new SimpleDateFormat("yyyy-MM-dd").format(client.getDateNaissance()) %>">
                </li>
                <li>
                    <h3>Image : </h3>
			        <%String base64Image = Base64.getEncoder().encodeToString(client.getimage());%>
        			<img class="client-image" src="data:image/jpeg;base64, <%= base64Image %>" alt="client"/>
					<input type="file" name="image">
    			</li>
            </ul>
            <input type="submit" value="Enregistrer les modifications">
        </form>
    </section>
   
    
</body>
</html>
