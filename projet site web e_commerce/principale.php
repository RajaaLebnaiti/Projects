<!--La page suivante s'affiche pour 3secondes lorsque l'utilisateur se connecte à son compte-->
<html>
 <head>
 <meta charset="utf-8">
 <!-- importer le fichier de style -->
 <link rel="stylesheet" href="style.css" media="screen" type="text/css" />
 </head>
 <body style='background:#fff;'>
 <div id="content">
 <!-- tester si l'utilisateur est connecté -->
 <?php
 session_start();
 if($_SESSION['username'] !== ""){
 $user = $_SESSION['username'];
 // afficher un message
 
 echo "Bonjour $user, vous êtes connecté";
 header('Refresh: 2; URL=panier.php'); // Redirection vers autre_page.php après 3 secondes
} else {
  header('Location: seconnecter.php'); // Redirection vers la page de connexion si l'utilisateur n'est pas connecté
  exit();
}
?>
 
 </div>
 </body>
</html>