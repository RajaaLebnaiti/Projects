<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Page de Connexion</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url("/LocationVoituresApp/images/background.jpg");
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

        body::before {
            content: "";
            background-image: url("/LocationVoituresApp/images/background.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center;
            filter: blur(2px); /* Appliquer le flou uniquement à cet élément */
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            z-index: -1;
        }

        .login-container {
              background-color: #fff;
            padding: 29px;
            border-radius: 15px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.8);
            text-align: center;
            margin-right: 30%;
            width: 590px; /* Ajuster la largeur */
            height: auto; /* Ajuster la hauteur */
            max-width: 80%; /* Largeur maximale pour la responsivité */
        }

        .login-box img {
            width: 140px;
            height: 140px;
        }

        .login-box h2 {
            color: #376380;
        }

        form {
            margin-top: 20px;
        }

        label {
            display: block;
            margin-top: 16px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"] {
            width: 70%;
            padding: 10px;
            border: 3px solid #2D1F30;
            border-radius: 8px;
            margin-top: 5px;
            font-size: 20px; 
        }

        input[type="submit"] {
            background-color: #376380;
            color: #fff;
            border: none;
            padding: 15px 20px;
            border-radius: 10px;
            cursor: pointer;
            font-size: 20px;
            margin-top: 26px;
        }

        input[type="submit"]:hover {
            background-color: #007bff;
        }

        a {
            text-decoration: none;
            color: #376380;
            font-size: 18px; 
        }
        
        .error-message {
		    color: red; 
		    font-weight: bold; 
		    margin-top: 10px; 
		}
    </style>
</head>
<body>
    <div class="login-container">
        <div class="login-box">
            <img src="/LocationVoituresApp/images/user.png" alt="User Icon">
            <h2>Bienvenue</h2>
            <form action="AuthentificationClientServlet" method="post">
                <label for="username">Nom d'utilisateur</label>
                <input type="text" id="username" name="username" required>

                <label for="password">Mot de passe</label>
                <input type="password" id="password" name="password" required>

                <input type="submit" value="Se Connecter">

                <p>Vous n'avez pas de compte? <a href="inscriptionClient.jsp">Veuillez S'inscrire</a></p>
                <p><a href="RecuperationDonnesClient.jsp">Nom d'utilisateur ou mot de passe oublié ?</a></p>
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
    </div>
</body>
</html>
