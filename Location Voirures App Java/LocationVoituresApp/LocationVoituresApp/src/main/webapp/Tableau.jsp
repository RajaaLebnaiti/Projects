<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jpaClass.modele.personnel" %>
<%@ page import="java.util.Base64" %>

<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tableau de bord</title>
   
    <link rel="stylesheet" type="text/css" href="styles.css"> <!-- Ajoutez votre fichier CSS -->
    <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }

        header {
            background-color: #376380;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        #admin-image img {
            border-radius: 50%;
            max-width: 150px;
            max-height: 150px;
        }

        #admin-username {
            font-size: 28px;
           
        }

        main {
            display: flex;
            justify-content: space-between;
            flex: 1;
        }

        #left-panel{
            box-sizing: border-box;
            width: 48%;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-left:-200px;
        }
        
        #right-panel {
            box-sizing: border-box;
            width: 48%;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-right:-200px;
        }
	
		
        .left-buttons, .right-buttons {
            display: flex;
            flex-direction: column;
            width: 50%;
            
        }

        .button {
    display: block;
    margin-bottom: 10px;
    padding: 10px;
    background-color: #333;
    color: #fff;
    text-decoration: none;
    text-align: center;
    border-radius: 5px;
    margin-top: 20px;
    font-size: 24px;
    height: 40px;
    line-height: 40px; /* Assure le centrage vertical du texte */

        }
.button:hover{
	background-color:#376380;
}
        section.statistique {
            flex: 1;
            padding: 20px;
            background-color: #fff;
            color: #333;
            text-align: center;
            margin-top:20px;
        }


		.statistique p {
		    font-size: 20px;
		    line-height: 1.6;
		    color: blacK;
		    margin-top: 40px;
		}

/* Si vous voulez ajouter un style particulier au nom du personnel, vous pouvez le faire ainsi */
.statistique p span {
    font-weight: bold;
    color: #007bff; /* Couleur bleue, vous pouvez ajuster selon vos préférences */
}
        footer {
            background-color: #376380;
            color: #fff;
            text-align: center;
            padding: 10px;
            ;
        }

        .footer-info p {
            margin: 5px 0;
            font-size:18px;
        }
        
           blockquote {
        position: relative;
        
        margin: 0;
        padding-left: 10px;
    }

    blockquote::before,
    blockquote::after {
        content: ",,";
        position: absolute;
        color: #333;
        font-size: 9.5em;
    }

    blockquote::before {
        top: -1.5em;
        left: -0.5em;
    }

    blockquote::after {
        bottom: -0.5em;
        right: -0.5em;
    }

    blockquote p {
        margin-top: 0;
    }
    </style>
</head>
<body>

<%
    List<personnel> personnels = (List<personnel>) request.getAttribute("personnels");
    personnel premierPersonnel = personnels.get(0); 
    String base64Image = Base64.getEncoder().encodeToString(premierPersonnel.getImage());
%>

<header>
    <%-- Afficher l'image du personnel --%>
    <div id="admin-image">
        <img src="data:image/png;base64, <%= base64Image %>" alt="Image de l'admin">
    </div>
    <div id="admin-username"><%= premierPersonnel.getNom_personnel() %> <%= premierPersonnel.getPrenom_personnel() %></div>
</header>

<main>
    <div id="left-panel">
        <div class="left-buttons">
            <a href="/LocationVoituresApp/StatistiquesServlet" class="button">Tableau de bord</a>
            <a href="/LocationVoituresApp/VoitureServlet" class="button">Nos Voitures</a>
            <a href="/LocationVoituresApp/ListeClientsServlet" class="button">Nos Clients</a>
            <a href="ClientForm.jsp" class="button">Créer un compte</a>
            <a href="/LocationVoituresApp/HistoriqueServlet" class="button">Historique</a>
        </div>
    </div>

    <section class="statistique">
        <p>Bienvenue  <span class="highlight"><%= premierPersonnel.getNom_personnel() %> <%= premierPersonnel.getPrenom_personnel() %></span>  !
<blockquote>
        <p>Rappelle-toi, chaque interaction compte. Ton service attentionné et ton engagement envers nos clients font de chaque location une expérience mémorable. Merci de contribuer à la réussite de notre mission.</p>
        
        <p>Prends soin de toi et continue de faire de chaque location une aventure inoubliable !</p>
    </blockquote>
    </section>

    <div id="right-panel">
        <div class="right-buttons">
            <a href="/LocationVoituresApp/ReclamationServletPersonnel" class="button">Reclamation</a>
            <a href="/LocationVoituresApp/FacturationServlet" class="button">Facturation</a>
            <a href="/LocationVoituresApp/ReservationPersonnel.jsp" class="button">Réservation</a>
            <a href="/LocationVoituresApp/ParametreServlet?id=<%= premierPersonnel.getId_personnel() %>" class="button">Parametre</a>
            <a href="Deconnexion.jsp" class="button">Déconnexion</a>
        </div>
    </div>
</main>


	 <footer>
        <div class="footer-info">
            <p>&copy; 2023 LocationAutoPlus. Tous droits réservés.</p>
            <p>Adresse : 13 Rue Centrale, Rabat</p>
            <p>Téléphone : +1 234 567 890</p>
            <p>Email : contact@LocationAutoPlus.com</p>
       </div>
    </footer>
</body>
</html>
