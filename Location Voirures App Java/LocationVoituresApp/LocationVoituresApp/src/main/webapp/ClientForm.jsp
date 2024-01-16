<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>

<html>
<head>
    <title>Formulaire Client</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url("/LocationVoituresApp/images/backgroun.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            position: relative;
        }
        .form-container {
            background-color: #E7DFE0;
            padding: 40px;
            border-radius: 30px;
            box-shadow: 0 0 30px #2D1F30;
            text-align: center;
            width: 600px;
        }
        .form-container h2 {
            font-size: 40px;
            color: #2D1F30;
            margin-bottom: 20px;
        }
        form {
            margin-top: 10px;
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }
        .form-group {
            flex: 0 0 calc(50% - 10px);
            margin-bottom: 15px;
        }
        label {
            display: block;
            font-weight: bold;
            font-size: 20px;
            margin-top: 15px;
        }
        input[type="text"],
        input[type="password"],
        input[type="email"],
        input[type="tel"],
        input[type="date"] {
            width: 100%;
            padding: 12px;
            border: 1px solid #2D1F30;
            border-radius: 5px;
            font-size: 18px;
            margin-top: 8px;
            box-sizing: border-box;
        }
        input[type="file"] {
            margin-top: 8px;
        }
        input[type="submit"] {
            background-color: #9D5060;
            color: #fff;
            border: none;
            padding: 12px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 20px;
            margin-top: 20px;
            width: 100%;
        }
        input[type="submit"]:hover {
            background-color: #2D1F30;
        }
        button {
            background-color: #2D1F30;
            color: #fff;
            border: none;
            padding: 12px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 20px;
            margin-top: 20px;
            width: 100%;
            text-decoration: none;
            display: inline-block;
            text-align: center;
        }
        button:hover {
            background-color: #1A131C;
        }
    </style>
</head>
<body>

<header>
    
</header>

<form action="InsertClientServlet" method="post" enctype="multipart/form-data" class="form-container">
    

    <div class="form-group">
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" required>
    </div>

    <div class="form-group">
        <label for="prenom">Prénom:</label>
        <input type="text" id="prenom" name="prenom" required>
    </div>

    <div class="form-group">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>
    </div>

    <div class="form-group">
        <label for="adresse">Adresse:</label>
        <input type="text" id="adresse" name="adresse">
    </div>

    <div class="form-group">
        <label for="telephone">Téléphone:</label>
        <input type="tel" id="telephone" name="telephone">
    </div>

    <div class="form-group">
        <label for="nomUtilisateur">Nom d'utilisateur:</label>
        <input type="text" id="nomUtilisateur" name="nomUtilisateur" required>
    </div>

    <div class="form-group">
        <label for="motdepasse">Mot de passe:</label>
        <input type="password" id="motdepasse" name="motdepasse" required>
    </div>

    <div class="form-group">
        <label for="cin">CIN:</label>
        <input type="text" id="cin" name="cin" required>
    </div>

    <div class="form-group">
        <label for="dateNaissance">Date de Naissance:</label>
        <input type="date" id="dateNaissance" name="dateNaissance" required>
    </div>

    <div class="form-group">
        <label for="image">Image:</label>
        <input type="file" id="image" name="image" accept="image/*" required>
    </div>

    <input type="submit" value="Enregistrer">
    <a href="/LocationVoituresApp/TableauServlet" class="button">Retour</a>
</form>

</body>
</html>