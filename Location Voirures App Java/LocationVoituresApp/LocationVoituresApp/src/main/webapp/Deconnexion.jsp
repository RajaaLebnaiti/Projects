<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Déconnexion</title>
</head>
<body>
    <%
        // Code de déconnexion (par exemple, détruire la session)
        session.invalidate();
    %>

    <h1>Déconnexion réussie</h1>
    <p>Vous avez été déconnecté avec succès.</p>

    <!-- Redirection vers la page loginPersonne.jsp après quelques secondes -->
    <script>
        setTimeout(function() {
            window.location.href = "index.jsp";
        }, 0); 
    </script>
</body>
</html>