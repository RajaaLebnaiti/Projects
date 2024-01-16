<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.jpaClass.modele.personnel" %>
<%@ page import="java.util.Base64" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profil Personnel</title>
    <style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f5f5f5;
        
    }
    
    .header {
    background-color: #376380; 
    color: #fff; 
    padding: 20px 0; 
    text-align: center; /* Ajout de cette ligne pour centrer le texte */
}

.header span {
    
    font-size: 22px;
    display: inline-block; /* Ajout de cette ligne pour centrer le span */
 	margin-left: 550px;
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
                
    .profil {
        background-color: #F1EEF4; 
        color: #0E050F; 
        padding: 20px 0;
        box-shadow: 0 0 10px #376380;
       
    }

    .profil h1 {
        text-align: center;
        font-size: 30px;
    }

    .profil ul {
        list-style: none;
        margin-right: 50px;
    }

    .profil ul li {
        font-size: 20px;
        display: flex;
        align-items: center;
    }
    .profil ul li h3 {
        margin-right: 10px;
        color: #376380;
    }
    
    .profil ul li:last-child {
        margin-bottom: 0;
    }

    .client-image {
        border-radius: 20%;
        width: 350px;
        height: 350px;
        display: block;
        margin: 0 auto 20px;
        margin-top: -800px;
        box-shadow: 0 0 10px #376380;
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
    .buttons {
        margin-top: 30px;
       margin-left: 1200px;
       margin-top: -150px;
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
    <header class="header">
        <nav>
            <span>
                <%
                    List<personnel> personnels = (List<personnel>) request.getAttribute("personnels");
                    if (personnels != null && !personnels.isEmpty()) {
                    	personnel p = personnels.get(0);
               
                        
                    }
                %>
                <h1>Profil du Personnel</h1>
            </span>
        </nav>
    </header>
    <section class="profil">
        
        <ul>
            <%
                if (personnels != null && !personnels.isEmpty()) {
                    personnel p = personnels.get(0); 
            %>
                    <li><h3>Nom : </h3><%= p.getNom_utilisateur() %></li>
                    <li><h3>Prénom : </h3><%= p.getPrenom_personnel() %></li>
                    <li><h3>Email : </h3><%= p.getEmail_personnel() %></li>
       				 <li><h3>Poste :</h3> <%= p.getPoste_personnel() %></li>
       				 <li><h3>Nom d'utilisateur : </h3><%= p.getNom_utilisateur() %></li>
        			<li><h3>Mot de passe : </h3><%= p.getMotdepasse() %></li>
        			<li><h3>CIN : </h3><%= p.getCIN() %></li>
        			<li><h3>Date de naissance : </h3><%= p.getDateNaissance() %></li>
                    <li>
                        <%
                            String base64Image = Base64.getEncoder().encodeToString(p.getImage());
                        %>
                        <img class="client-image" src="data:image/jpeg;base64, <%= base64Image %>" alt="client"/>
                    </li>
            <%
                }
            %>
        </ul>
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