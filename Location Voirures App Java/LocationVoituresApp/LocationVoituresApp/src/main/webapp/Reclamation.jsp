<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.jpaClass.modele.client" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reclamation</title>
	<style>
        body {
        	font-family: Arial, sans-serif;
		    margin: 0;
		    padding: 0;
		    background-color: #f5f5f5;
        
            
            
        }

		.reclamation {
			font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            margin-top:15px;
            margin-bottom:70px;
		}
		.header {
    	background-color: #376380; 
    	color: #fff; 
    	padding: 20px 0; 
	  }
	
	 
	  .header nav {
	    display: flex;
    	justify-content: space-between;
    	align-items: center;
	  }
	
	  .header ul {
	    list-style: none; 
	    padding: 0;
	  }
	
	  .header li {
	    display: inline;  
	    margin-left: 100px;
	  }
	  
	 

	.header span {
    margin-right: 10px; 
    font-size: 22px;
	}
	
	  .header a {
	    text-decoration: none; 
	    color: #fff; 
	    font-size: 22px; 
	  }
		
        h1 {
            text-align: center;
            margin-top: 20px;
        }

        form {
            width: 50%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            
            
        }

        label {
            display: block;
            margin-top: 10px;
            font-size: 20px;
        }

        input[type="text"],
        textarea {
            width: 70%;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            font-size: 23px;
            margin-left: 80px;
            
        }

        input[type="submit"] {
            background-color: #376380;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            font-size: 18px;
             margin-left: 250px;
           
        }

        input[type="submit"]:hover {
            background-color: #344e70;
        }
        .success-message {
		    color: red; 
		    font-weight: bold; 
		    margin-top: 10px; 
		}
		
		
		footer {
		    background-color: #376380;
		    color: #fff;
		    text-align: center;
		    padding: 30px 0;
		}
		
		.footer-info p {
		    font-size: 18px;
		    margin: 5px;
		}
    </style>
</head>
<body>
<header class="header">
    <nav>
        <ul>
           
            <li><a href="/LocationVoituresApp/ProfilClient">Profil</a></li>
            <li><a href="HomePageClient.jsp">Voitures</a></li>
            <li><a href="ReservationClient.jsp">Réservations</a></li>
            <li><a href="/LocationVoituresApp/FactureServlet">Facture</a></li>
            <li><a href="APropos.jsp">Qui sommes-nous</a></li>
            <li><a href="Reclamation.jsp">Réclamation</a></li>
        </ul>
        <span>
            <% String username = (String) session.getAttribute("username"); %>
            Bienvenue, <%= username %>!
        </span>
    </nav>
</header>

		 <%
	client client = (client) session.getAttribute("client");
		%>
		<section class="reclamation">
	 <h1>Soumettre une Réclamation</h1>

    <form action="ReclamationServlet" method="post">
        <label for="sujet">Sujet de la réclamation :</label>
        <input type="text" id="sujet" name="sujet" required>
        <br>

        <label for="description">Description de la réclamation :</label>
        <textarea id="description" name="description" rows="4" cols="50" required></textarea>
        <br>

        <input type="submit" value="Envoyer la Réclamation">
        <%-- Vérifiez si l'attribut "message" existe dans la requête --%>
<% if (request.getAttribute("message") != null) { %>
    <div class="success-message">
        <%= request.getAttribute("message") %>
    </div>
<% } %>
    </form>
    </section>
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