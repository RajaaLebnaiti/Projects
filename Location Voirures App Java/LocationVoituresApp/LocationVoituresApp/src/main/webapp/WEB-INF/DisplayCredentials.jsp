<!DOCTYPE html>
<html>
<head>
    <title>Vos identifiants</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            text-align: center;
            margin-top: 200px;
        }
        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 15px;
            box-shadow: 0 0 15px #376380;
        }
        h1 {
            font-size:40px;
            color: #2D1F30;
           
        }
        h3 {
            font-size:25px;
            color: #9D5060;
        }
        p {
            color: #2D1F30;
            font-size: 18px;
            
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
    <div class="container">
        <h1>Vos identifiants</h1>
        <h3>Nom d'utilisateur :</h3><p> <%= request.getAttribute("username") %></p>
        <h3>Mot de passe :</h3><p> <%= request.getAttribute("password") %></p>
        <div class="buttons">
            <a href="loginClient.jsp" class="button">Se connecter</a>
        </div>
    </div>
</body>
</html>
