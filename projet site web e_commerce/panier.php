<?php 
   session_start();
   include_once "con_dbb.php";

   //supprimer les produits
   //si la variable del existe
   if(isset($_GET['del'])){
    $id_del = $_GET['del'] ;
    //suppression
    unset($_SESSION['panier'][$id_del]);
   }
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Panier</title>
    <link rel="stylesheet" href="style1.css">
</head>
<body class="panier">
    
    <a href="index.php" class="link">Boutique</a>
    <section>
        <table>
            <tr>
                <th></th>
                <th>Nom</th>
                <th>Prix</th>
                <th>Quantité</th>
                <th>Action</th>
            </tr>
            <?php 
              $total = 0 ;
              // liste des produits
              //récupérer les clés du tableau session
              $ids = array_keys($_SESSION['panier']);
              //s'il n'y a aucune clé dans le tableau
              if(empty($ids)){
                echo "Votre panier est vide";
              }else {
                //si oui 
                $products = mysqli_query($con, "SELECT * FROM products WHERE id IN (".implode(',', $ids).")");

                //lise des produit avec une boucle foreach
                foreach($products as $product):
                    //calculer le total ( prix unitaire * quantité) 
                    //et aditionner chaque résutats a chaque tour de boucle
                    $total = $total + $product['price'] * $_SESSION['panier'][$product['id']] ;
                ?>
                <tr>
                    <td><img src="project_images/<?=$product['img']?>"></td>
                    <td><?=$product['name']?></td>
                    <td><?=$product['price']?>€</td>
                    <td><?=$_SESSION['panier'][$product['id']] // Quantité?></td>
                    <td><a href="panier.php?del=<?=$product['id']?>"><img src="delete.png"></a></td>
                </tr>

            <?php endforeach ;} ?>

            <tr class="total">
                <th>Total : <?=$total?>€</th>
            </tr>
        </table>


    </section>
<div class="button-group">
<form method="post" action="" >
    <!-- ... Autres champs de formulaire ... -->
    <button type="submit" name="submit" class="link">Valider</button>
</form>

<a href="Site Web.php" class="link">Home</a>

<!-- Afficher le bouton de déconnexion -->
<form method="post" action="" >
    <button type="submit" name="logout" class="link">Déconnexion</button>
</form>
</div>


<style>
    .button-group {
        display: flex;
        justify-content: center;
        align-items: center;
        gap: 20px;
    }
</style>





</body>


<?php


if (isset($_POST["logout"])) {
    // Détruire la session en cours
    session_unset();
    session_destroy();

    // Rediriger vers la page de connexion
    header("Location: seconnecter.php");
    exit();
}
?>


<?php
if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST["submit"])) {
    // Le formulaire a été soumis avec succès, afficher le message
    echo "<p class='success-message'>Votre commande a été bien enregistrée !</p>";
}
?>

<style>
.success-message {
    background-color: green;
    color: white;
    padding: 10px;
    border-radius: 5px;
    
}
</style>


</html>