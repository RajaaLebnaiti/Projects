<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css">
    <title>Cart</title>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"/>
</head>
<body>
    <!--Barre menu-->
    <section id="header">
        <a href="#"><img src="images/V.png" height="50px" width="60px" class="logo" alt="Logo"> </a>
        <div>
            <ul id="navbar">
                <li><a  href="Site Web.php">Home</a> </li>
                <li><a  href="shop.php">Shop</a> </li>
                <li><a  href="blog.php">Blog</a> </li>
                <li><a  href="about.php">About</a> </li>
                <li><a href="contact.php">Contact</a> </li>
                <li><a href="seconnecter.php">Authentification</a> </li>

                <li><a class="active"  href="cart.php"><i class="far fa-shopping-bag"></i> </a></li>
            </ul>
        </div>
    </section>
    <!--Page 1-->

    <section id="page-header" class="about-headr">
        <h2>#Let's_Talk</h2>
        <br>
        <h4>Leave a message.We love to hear from you!</h4>
    </section>

    <section id="cart" class="section-p1">
        <table width="100%">
            <thead>
                <tr>
                    <td>Remove</td>
                    <td>Image</td>
                    <td>Product</td>
                    <td>Price</td>
                    <td>Quantity</td>
                    <td>SubTotal</td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><a href="#"><i class="far fa-times-circle"></i></a></td>
                    <td><img src="images/images3.jpg"></td>
                    <td>Manteau Beige</td>
                    <td>350 DHS</td>
                    <td><input type="number" value="1"></td>
                    <td>350 DHS</td>
                </tr>

                <tr>
                    <td><a href="#"><i class="far fa-times-circle"></i></a></td>
                    <td><img src="images/img7.jpg"></td>
                    <td>Manteau Beige</td>
                    <td>350 DHS</td>
                    <td><input type="number" value="1"></td>
                    <td>350 DHS</td>
                </tr>

                <tr>
                    <td><a href="#"><i class="far fa-times-circle"></i></a></td>
                    <td><img src="images/image4.jpg"></td>
                    <td>Manteau Beige</td>
                    <td>350 DHS</td>
                    <td><input type="number" value="1"></td>
                    <td>350 DHS</td>
                </tr>

                <tr>
                    <td><a href="#"><i class="far fa-times-circle"></i></a></td>
                    <td><img src="images/image5.jpg"></td>
                    <td>Manteau Beige</td>
                    <td>350 DHS</td>
                    <td><input type="number" value="1"></td>
                    <td>350 DHS</td>
                </tr>

                <tr>
                    <td><a href="#"><i class="far fa-times-circle"></i></a></td>
                    <td><img src="images/images2.jpg"></td>
                    <td>Manteau Beige</td>
                    <td>350 DHS</td>
                    <td><input type="number" value="1"></td>
                    <td>350 DHS</td>
                </tr>
            </tbody>

        </table>
    </section>

    <section id="cart-add" class="section-p1">
        <div id="coupon">
            <h3>Apply coupon</h3>
            <div>
                <input type="text" placeholder="Enter Your Coupon">
                <button class="normal">Apply</button>
            </div>
        </div>

        <div id="subtotal">
            <h3>Veuillez verifier votre commande avant de valider!!</h3>
            
            <button class="normal" >Confirm </button>

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
            <img src="images/googleplay.png"alt="" height="60" width="220">
            <img src="images/appstore.png"alt="" height="60" width="220">
        </div>
        <p>Secured Payment Gateways </p>
        <img src="images/logo.png"alt="" height="60" width="450">
        
    </div>
    <div class="copyright">
        <p>Copyright © 2023 - Fashion Virtual.com  | Privacy Policy|</p>
    </div>
</footer>


    <script src="script.js"></script>

    
</body>
</html>