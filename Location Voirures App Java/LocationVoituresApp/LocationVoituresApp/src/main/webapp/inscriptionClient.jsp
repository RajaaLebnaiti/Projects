<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inscription</title>
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
            color: #333;
            font-size:40px;
            color: #2D1F30
        }
        form {
            margin-top: 10px;
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }
        .form-group {
            flex: 0 0 calc(50% - 10px);
            margin-bottom: 10px;
        }
        label {
            display: block;
            font-weight: bold;
            font-size: 20px;
            margin-top:10px;
        }
        input[type="text"],
        input[type="password"],
        input[type="email"],
        input[type="tel"],
        input[type="date"] {
            width: 90%;
            padding: 10px;
            border: 1px solid #2D1F30;
            border-radius: 5px;
            font-size: 20px;
        }
        input[type="submit"] {
            background-color: #9D5060;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 23px;
            margin-top: 28px;
            width: 60%;
            margin-left: 20%;
        }
        input[type="submit"]:hover {
            background-color: #2D1F30;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Inscription</h2>
        <form action="InscriptionClientServlet" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="nom_client">Nom</label>
                <input type="text" id="nom_client" name="nom_client" required>
            </div>
            <div class="form-group">
                <label for="prenom_client">Prénom</label>
                <input type="text" id="prenom_client" name="prenom_client" required>
            </div>
            <div class="form-group">
                <label for="email_client">Email</label>
                <input type="email" id="email_client" name="email_client" required>
            </div>
            <div class="form-group">
                <label for="adresse_client">Adresse</label>
                <input type="text" id="adresse_client" name="adresse_client" required>
            </div>
            <div class="form-group">
                <label for="telephone_client">Téléphone</label>
                <input type="tel" id="telephone_client" name="telephone_client" required>
            </div>
            <div class="form-group">
                <label for="nom_utilisateur">Nom d'utilisateur</label>
                <input type="text" id="nom_utilisateur" name="nom_utilisateur" required>
            </div>
            <div class="form-group">
                <label for="motdepasse">Mot de passe</label>
                <input type="password" id="motdepasse" name="motdepasse" required>
            </div>
            <div class="form-group">
                <label for="CIN">CIN</label>
                <input type="text" id="CIN" name="CIN" required>
            </div>
            <div class="form-group">
                <label for="DateNaissance">Date de Naissance</label>
                <input type="date" id="DateNaissance" name="DateNaissance" required>
            </div>
            <div>
                <label for="image">Image:</label>
    			<input type="file" id="image" name="image" accept="image/*" required>
            </div>
            <input type="submit" value="S'inscrire">
        </form>
    </div>
</body>
</html>
