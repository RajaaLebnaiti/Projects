<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.*, java.util.*, java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jpaClass.modele.voiture" %>
<%@ page import="java.util.Base64" %>

<!DOCTYPE html>
<html>
<head>
    <title>Modifier Voiture</title>
    <style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #E7D2CC;
        background-image: url("/LocationVoituresApp/images/backgroun.jpg");
        margin: 0;
        padding: 0;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }

    h2 {
        color: #376380;
        font-size:50px;
    }

    .form-container {
        max-width: 800px;
        margin: 0 auto;
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 20px #376380;
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
    }

    .form-column {
        flex-basis: calc(50% - 10px);
        margin-bottom: 20px;
    }

    label {
        display: block;
        margin-bottom: 5px;
        color: #2D1F30;
        font-size: 25px;
    }

    input[type="text"],
    input[type="date"],
    input[type="checkbox"] {
        width: calc(100% - 22px);
        padding: 10px;
        margin: 5px 0;
        display: inline-block;
        border: 1px solid #376380;
        border-radius: 4px;
        box-sizing: border-box;
        font-size: 22px;
    }



    input[type="submit"] {
        display: block;
        background-color: #376380;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 20px;
        margin-top: 20px;
        text-align: center;
        margin: 0 auto; /* Centre le bouton horizontalement */
    }
</style>
</head>
<body>

<%
    voiture voitureAModifier = (voiture) request.getAttribute("voiture");

    if (voitureAModifier != null) {
%>

<h2>Modifier Voiture</h2>

<form action="/LocationVoituresApp/ValiderModificationServlet" method="post" class="form-container">
    <input type="hidden" name="id" value="<%= voitureAModifier.getId_voiture() %>">
    
    <div class="form-column">
        <label for="marque">Marque:</label>
        <input type="text" id="marque" name="marque" value="<%= voitureAModifier.getMarque() %>" required>

        <label for="modele">Modèle:</label>
        <input type="text" id="modele" name="modele" value="<%= voitureAModifier.getModele() %>" required>

        <label for="annee">Année:</label>
        <input type="date" id="annee" name="annee" value="<%= new SimpleDateFormat("yyyy-MM-dd").format(voitureAModifier.getAnnee()) %>" required>
    	
    	<label for="couleur">Couleur:</label>
        <input type="text" id="couleur" name="couleur" value="<%= voitureAModifier.getCouleur() %>" required>
    </div>

    <div class="form-column">
        

       
        <label for="matricule">Matricule:</label>
        <input type="text" id="matricule" name="matricule" value="<%= voitureAModifier.getMatricule() %>" required>

        <label for="Kilométrage_prevu">Kilométrage Prévu:</label>
        <input type="text" id="Kilométrage_prevu" name="Kilométrage_prevu" value="<%= voitureAModifier.getKilometragePrevu() %>" required>

        <label for="nbPlaces">Nombre de Places:</label>
        <input type="text" id="nbPlaces" name="nbPlaces" value="<%= voitureAModifier.getNbPlaces() %>" required>
  		
  		<label for="disponible">Disponible:</label>
  		<label for="disponibleOui">Oui</label>
		<input type="radio" id="disponibleOui" name="disponible" value="true" <%= voitureAModifier.isDisponible() ? "checked" : "" %>>

         <label for="disponibleNon">Non</label>
		<input type="radio" id="disponibleNon" name="disponible" value="false" <%= !voitureAModifier.isDisponible() ? "checked" : "" %>>
		
  		
  		
   		
    </div>

    <input type="submit" value="Modifier Voiture">
</form>
<%
    }
%>
</body>

</html>