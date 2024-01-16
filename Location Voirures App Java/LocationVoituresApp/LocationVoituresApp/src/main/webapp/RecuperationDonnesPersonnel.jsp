<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Récupération des données du client</title>
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
            color: #2D1F30;
        }
        
        .form-container h4 {
            color: #2D1F30;
            font-size:20px;
           
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
            margin-top:20px;
        }
        input[type="text"],
        input[type="date"] {
            width: 90%;
            padding: 10px;
            border: 1px solid #2D1F30;
            border-radius: 5px;
            font-size: 20px;
        }
        .image-container {
            flex: 0 0 calc(50% - 10px);
        }
        img {
            width: 80%;
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
        
        .error-message {
		    color: red; 
		    font-weight: bold; 
		    margin-top: 10px; 
		}
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Retrouver votre compte</h2>
        <h4>Veuillez entrer votre CIN(carte d'identité nationale) et votre date de naissance pour rechercher 
        votre compte.</h4>
        <form action="RecuperationComptePersonnel" method="post">
            <div class="form-group">
                <label for="CIN">CIN</label>
                <input type="text" id="CIN" name="CIN" required>
            
                <label for="DateNaissance">Date de Naissance</label>
                <input type="date" id="DateNaissance" name="DateNaissance" required>
            </div>
            <div class="image-container">
                <img src="/LocationVoituresApp/images/shield.png" alt="secure Icon">
            </div>
            <input type="submit" value="valider">
        </form>
        <div class="error-message">
    			<%
				String message=(String) request.getAttribute("message");
			if(message!=null){
				out.print(message);
			}
			%>
			</div>
    </div>
</body>
</html>
>