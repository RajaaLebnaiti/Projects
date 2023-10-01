<?php 
 session_start() ;
 // initialize the "panier" array in the session if it is not already set
if (!isset($_SESSION['panier'])) {
    $_SESSION['panier'] = array();}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Boutique</title>
    <link rel="stylesheet" href="style1.css">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"/>

</head>
<body>

    <!-- afficher le nombre de produit dans le panier -->
    <a href="panier.php" class="link">Panier<span><?=array_sum($_SESSION['panier'])?></span></a>
    <section class="products_list">
        <?php 
        //inclure la page de connexion
        include_once "con_dbb.php";
        //afficher la liste des produits
         $req = mysqli_query($con, "SELECT * FROM products");
         while($row = mysqli_fetch_assoc($req)){ 
        ?>
        <form action="" class="product">
            <div class="image_product">
                <img src="project_images/<?=$row['img']?>">
            </div>
            <div class="content">
                <h4 class="name"><?=$row['name']?></h4>
                <br>
                <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                <h2 class="price"><?=$row['price']?> DHS</h2>
                <a href="ajouter_panier.php?id=<?=$row['id']?>" class="id_product">Ajouter au panier</a>
            </div>
        </form>

        <?php } ?>
       
    </section>
</body>
</html>