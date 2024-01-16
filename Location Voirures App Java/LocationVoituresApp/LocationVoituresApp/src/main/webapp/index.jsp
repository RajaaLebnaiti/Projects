<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>LocationAutoPlus</title>
    <style>
        body {
           background-color: #EBEBE8; 
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            display: flex;
            align-items: flex-start;
            justify-content: space-between;
            height: 100vh;
        }

        .container {
            text-align: center;
            flex: 1; /* Le contenu occupe l'espace restant à gauche de la page */
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
        }

        h1 {
            font-size: 56px;
            color: #2D1F30;
            margin-top: 100px; /* Espacement du titre par rapport au haut */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* Ombre du texte */
        }

        h2 {
            font-size: 24px;
            color: #9D5060;
        }

        p {
            font-size: 20px;
            margin-right: 20px ;
            margin-left: 20px ;
            margin-top: 80px; /* Espacement du titre par rapport au haut */
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5); /* Ombre du texte */
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

        .image-container {
            background-image: url('/LocationVoituresApp/images/Tout-savoir-sur-la-location-de-voiture-entre-particuliers.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center;
            flex: 1; 
            width: 75%; 
            height: 75%; 
            margin-top: 5%;
            margin-right: 6%;
            border: 2px solid #376380; 
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Bienvenue dans 'LocationAutoPlus'</h1>
        <h2>Votre partenaire de location de voitures de luxe</h2>
        <div class="buttons">
            <a href="loginPersonnel.jsp" class="button">Espace personnel</a>
            <a href="loginClient.jsp" class="button">Espace client</a>
        </div>
        <div>
        <p>Découvrez notre sélection de voitures de luxe disponibles à la location.
         Profitez de la conduite dans le style et le confort ultimes.</p>
    </div>
    
    </div>
    <div class="image-container"></div>
</body>
</html>
