<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.jpaClass.modele.personnel" %>
<%@ page import="java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Modifier Personnel</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }

        h1 {
            color: #333;
            text-align: center;
        }

        form {
            width: 50%;
            margin: 20px auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            color: #555;
        }

        input, select {
            width: 100%;
            padding: 8px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        button {
            background-color: #4caf50;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<h1>Modifier Personnel</h1>

<%
List<personnel> personnels = (List<personnel>) request.getAttribute("personnels");
for (personnel p : personnels) { 
%>
<form action="/LocationVoituresApp/ModifierPersonnelServlet?id=<%= p.getId_personnel()%>" method="post" enctype="multipart/form-data">
 <label for="nomPersonnel">ID</label>
<input type="text" name="idPersonnel" value="<%= p.getId_personnel()%>">

    <label for="nomPersonnel">Nom :</label>
    <input type="text" name="nomPersonnel" value="<%= p.getNom_personnel()%>" required>

    <label for="prenomPersonnel">Prénom :</label>
    <input type="text" name="prenomPersonnel" value="<%= p.getPrenom_personnel() %>" required>

    <label for="emailPersonnel">Email :</label>
    <input type="email" name="emailPersonnel" value="<%= p.getEmail_personnel() %>" required>

    <label for="postePersonnel">Poste :</label>
    <input type="text" name="postePersonnel" value="<%= p.getPoste_personnel() %>">

    <label for="nom_utilisateur">Nom d'utilisateur :</label>
    <input type="text" name="nom_utilisateur" value="<%= p.getNom_utilisateur()%>" required>

    <label for="motDePasse">Mot de passe :</label>
    <input type="password" name="motDePasse" value="<%= p.getMotdepasse() %>" required>

    <label for="cin">CIN :</label>
    <input type="text" name="cin" value="<%= p.getCIN() %>" required>

    <label for="dateNaissance">Date de Naissance :</label>
    <input type="date" name="dateNaissance" value="<%= p.getDateNaissance() %>" required>
    <%
    String base64Image = Base64.getEncoder().encodeToString(p.getImage());
   %>
   <div id="admin-image">
        <img src="data:image/png;base64, <%= base64Image %>" alt="Image de l'admin">
    </div>
    <label for="image">Image :</label>
    <input type="file" name="image">

    <button type="submit">Enregistrer les modifications</button>
</form>
<%
}
%>

</body>
</html>