<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajout des voitures</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            
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
        input[type="number"],
        input[type="date"],
        input[type="checkbox"],
        input[type="image"]
         {
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
		.styled-checkbox {
		    position: relative;
		    cursor: pointer;
		    width:100px;
		    height:40px;
		    border: 1px solid #2D1F30;
	}
		
		
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Ajout des voitures</h2>
        <form action="AjoutVoituresServlet" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="marque">Marque</label>
                <input type="text" id="marque" name="marque" required>
            </div>
            <div class="form-group">
                <label for="modele">Modèle</label>
                <input type="text" id="modele" name="modele" required>
            </div>
            <div class="form-group">
                <label for="annee">Année</label>
                <input type="date" id="annee" name="annee" required>
            </div>
            <div class="form-group">
                <label for="couleur">Couleur</label>
                <input type="text" id="couleur" name="couleur" required>
            </div>
           
            <div class="form-group">
			    <label for="disponible">Disponible</label>
			    <input type="checkbox" id="disponible" name="disponible" value="true" class="styled-checkbox">
			</div>

            <div class="form-group">
                <label for="matricule">Matricule</label>
                <input type="text" id="matricule" name="matricule" required>
            </div>
            <div class="form-group">
                <label for="kilometragePrevu">Kilometrage_prevu</label>
                <input type="number" id="kilometragePrevu" name="kilometragePrevu" required>
            </div>
            <div class="form-group">
                <label for="nbPlaces">Nombre de places</label>
                <input type="number" id="nbPlaces" name="nbPlaces" required>
            </div>
            
            <div>
                <label for="image">Image:</label>
    			<input type="file" id="image" name="image" accept="image/*" required>
            </div>
            <input type="submit" value="Ajouter">
        </form>
    </div>
</body>
</html>
