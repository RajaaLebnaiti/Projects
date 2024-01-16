<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.jpaClass.modele.voiture" %>
<%@ page import="com.jpaClass.modele.client" %>
<%@ page import="com.jpaClass.modele.reservation" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Base64" %>
<%@ page import="com.jpaClass.modele.facturation" %>

<!DOCTYPE html>
<html>
<head>
    <title>Accueil Client</title>
    
	<style>
					
		body {
		    font-family: Arial, sans-serif;
		    margin: 0;
		    padding: 0;
		    background-color: #f5f5f5;
		}
		
		header {
    	background-color: #376380; 
    	color: #fff; 
    	padding: 20px 0; 
	  }
	
	 
	  nav {
	    display: flex;
    	justify-content: space-between;
    	align-items: center;
	  }
	
	  ul {
	    list-style: none; 
	    padding: 0;
	  }
	
	  li {
	    display: inline;  
	    margin-left: 100px;
	  }
	  
	 

	span {
	    margin-right: 10px; 
	    font-size: 22px;
	}
	
	  a {
	    text-decoration: none; 
	    color: #fff; 
	    font-size: 22px; 
	    
	  }

	.content h1 {
	    text-align: center;
	    color: #333;
	}

	 .content table {
	    width: 90%;
	    border-collapse: collapse;
	    margin-left: 60px;
	}

 .content th, td {
    border: 1px solid #000;
    padding: 10px;
    text-align: center;
	}
	.content  a{
    color: #333;
    text-align: center;
    
	}
	
	.content  a:hover{
    color: red;
    text-align: center;
	}

	.content tr:nth-child(even) {
    	background-color: #F1EEF4;	
	}
	</style>	
</head>
<body>
    <header>
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
	<div class="content">
        <h1>Factures</h1>
      <table border="1">
        <tr>
            <th>Numéro de facture</th>
            <th>Montant</th>
            <th>Date de Facturation</th>
             <th>Facture</th>
        </tr>
        <%
    List<facturation> factures = (List<facturation>) request.getAttribute("factures");
    if (factures != null) {
        int count = 0; 
        for (facturation facture : factures) {
            count++; 
%>
            <tr>
                <td><%= count %></td>
                <td><%= facture.getMontant() %></td>
                <td><%= facture.getDate_facturation() %></td>
                <td><button><a href="/LocationVoituresApp/TelechargementServlet?idFacture=<%= facture.getId_facture() %>">Telecharger</a></button></td>
            </tr>
<%
        }
    }
%>
    </table>
    </div>
    
    
</body>
</html>