<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jpaClass.modele.reclamation" %>

<html>
<head>
    <title>Liste des Réclamations</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #376380;
            color: #fff;
            text-align: center;
            padding: 1em;
        }

        .reclamation-container {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            border: 2px solid #ddd;
            box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            overflow: hidden;
            page-break-inside: avoid;
            margin-top:40px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            
        }

        th, td {
            padding: 15px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #325980;
            color: white;
            font-size:20px;
            
        }

        tr:hover {
            background-color: #D9A1A0;
        }

        button {
            background-color: #376380;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
            display: block;
            margin: 0 auto;
            margin-top:30px;
        	color:white;
        	font-size:20px;
        }
        a{
        text-decoration:none;
        }
    </style>
</head>
<body>

<header>
    <h1>Liste des Réclamations</h1>
</header>

<%
    List<reclamation> reclamations = (List<reclamation>) request.getAttribute("reclamations");
    for (reclamation reclamation : reclamations) {
%>
    <div class="reclamation-container">
        <table>
            <thead>
                <tr>
                    <th>ID Réclamation</th>
                    <th>Sujet</th>
                    <th>Description</th>
                    <th>Date Soumission</th>
                    <th>Client</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><%= reclamation.getId_reclamation() %></td>
                    <td><%= reclamation.getSujet() %></td>
                    <td><%= reclamation.getDescription() %></td>
                    <td><%= reclamation.getDateSoumission() %></td>
                    <td><%= reclamation.getClient().getNom_client()%>
                    	<%= reclamation.getClient().getPrenom_client()%>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
<%
    }
%>

<a href="/LocationVoituresApp/TableauServlet" class="return-button">
    <button>Retour</button>
</a>

</body>
</html>