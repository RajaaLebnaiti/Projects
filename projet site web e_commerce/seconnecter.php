<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css">
    <title>Virtual Fashion</title>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"/>
    
</head>
<body>
<!--Barre menu-->
<section id="header">
        <a href="#"><img src="images/V.png" height="50px" width="60px" class="logo" alt="Logo"> </a>
        <div>
            <ul id="navbar">
                <li><a  href="Site Web.php">Home</a> </li>
                <li><a href="shop.php">Shop</a> </li>
                <li><a href="review.php">Review</a></li>

                <li><a href="blog.php">Blog</a> </li>
                <li><a href="about.php">About</a> </li>
                <li><a href="contact.php">Contact</a> </li>
                <li><a class="active" href="seconnecter.php">Authentification</a> </li>
                <li><a href="index.php"><i class="far fa-shopping-bag"></i> </a></li>
            </ul>
        </div>
</section>
<section>
    <div id="connect">
        <!-- zone de connexion -->
        
        <form method="POST" action="teste.php" id="forme">
        <h1>Connexion</h1>
        
        <label><b>Nom d'utilisateur</b></label>
        <input type="text" placeholder="Entrer le nom d'utilisateur" name="username" required>
        
        <label><b>Mot de passe</b></label>
        <input type="password" placeholder="Entrer le mot de passe" name="password" required>
        
        <input type="submit" id='submit' value='LOGIN' >
        <?php
    if(isset($_GET['erreur'])){
    $err = $_GET['erreur'];
    if($err==1 || $err==2)
    echo "<p style='color:red'>Utilisateur ou mot de passe incorrect</p>";
    }
    ?>
        
        </form>
        </div>
</section>


<section id="newsletter" class="section-p1 section-m1">
    <div class="newstext">
        <h4>Sign Up For Newsletter</h4>
        <p> Get Updates about out latest shop and <span>special offers.</span></p>
    </div>
    <div class="form">
        <input type="text" placeholder="Your email adress ">
        <button class="normal">Sign Up</button>
    </div>
</section>

<footer class="section-p1">
    <div class="col">
        <img class="logo" src="images/V.png" alt="" height="120px" width="130px">
        <h4>Contact</h4>
        <p><strong>Adresse :</strong> 12 Rue AL Nassr ,Rabat ,MOROCCO</p>
        <p><strong>Telephone :</strong>+2126435678 +2127435890</p>
        <p><strong>Heure :</strong> 08:30-19:00 , Mon - Sat</p>
        <div class="follow">
            <h4>Follow Us</h4>
            <div class="icon">
                <i class="fab fa-facebook-f"></i>
                <i class="fab fa-twitter"></i>
                <i class="fab fa-instagram"></i>
                <i class="fab fa-pinterest-p"></i>
                <i class="fab fa-youtube"></i>

            </div>
        </div>
    </div>


    <div class="col">
        <h4>About</h4>
        <a href="#">About Us</a>
        <a href="#">Delivery informations</a>
        <a href="#">Privacy Policy</a>
        <a href="#">Term & Conditions</a>
        <a href="#">Contact Us</a>
    </div>

    <div class="col">
        <h4>My Account</h4>
        <a href="#">Sign In</a>
        <a href="#">View Cart</a>
        <a href="#">My WishList</a>
        <a href="#">Track My Order</a>
        <a href="#">Help</a>
    </div>


    <div class="col install">
        <h4>Install App</h4>
        <p>From App Store or Google Play </p>
        <div class="row">
            <img src="images/googleplay.png"alt="" height="60" width="170">
            <img src="images/appstore.png"alt="" height="60" width="170">
        </div>
        <p>Secured Payment Gateways </p>
        <img src="images/logo.png"alt="" height="60" width="350">
        
    </div>
    <div class="copyright">
        <p>Copyright © 2023 - Fashion Virtual.com  | Privacy Policy|</p>
    </div>
</footer>
<script src="script.js"></script>




</body>
</html>