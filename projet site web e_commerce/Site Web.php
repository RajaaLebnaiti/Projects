<?php
session_start();
if(isset($_POST['username']) && isset($_POST['password']))
{
 // connexion à la base de données
 $db_username = 'root';
 $db_password = '';
 $db_name = 'ecommerce';
 $db_host = 'localhost';
 $db = mysqli_connect($db_host, $db_username, $db_password,$db_name)
 or die('could not connect to database');
}
?>
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
        <a href="#"><img src="images/V.png" height="50px" width="50px" class="logo" alt="Logo"></a>
        <div class="search-box">
            <form method="get" action="verif-form.php" id="search-box">


                <input type="search" name="terme" class="search-input" placeholder="Recherche...">
                <button type="submit" class="search-button"><i class="fa fa-search"></i></button>
        
            </form>
        </div>       
            
        
        <div>
            <ul id="navbar">
                <li><a class="active" href="Site Web.php">Home</a> </li>
                <li><a href="shop.php">Shop</a> </li>
                <li><a href="review.php">Review</a></li>
                <li><a href="blog.php">Blog</a> </li>
                <li><a href="about.php">About</a> </li>
                <li><a href="contact.php">Contact</a> </li>
                <li><a href="seconnecter.php">Authentification</a> </li>
                <li><a href="index.php"><i class="far fa-shopping-bag" id="cart-icon"></i>
                
            </a></li>

                
            </ul>
        </div>
    </section>

    <!--Page 1-->

    <section id="page1">
        <h4>Fashion 2023 for you!</h4>
        <h2>Sale up to <b>50% </b><i>off</i></h2>
        <h1>On all products</h1>
        <p>Virtual Fashion</p>
        <button>Shop Now</button>
    </section>

    
    <section id="feature" class="section-p1">
        <div class="fe-box">
            <img src="images/f1.png" alt="">
            <h6>Free Shipping</h6>
        </div>
        <div class="fe-box">
            <img src="images/f2.png" alt="">
            <h6>Online order</h6>
        </div>
        <div class="fe-box">
            <img src="images/f3.png" alt="">
            <h6>Save Money</h6>
        </div>
        <div class="fe-box">
            <img src="images/f4.png" alt="">
            <h6>Promotions</h6>
        </div>
        <div class="fe-box">
            <img src="images/f5.png" alt="">
            <h6>Happy Sell</h6>
        </div>
        <div class="fe-box">
            <img src="images/f6.png" alt="">
            <h6>Support</h6>
        </div>
    </section>



    <section id="product1" class="section-p1">
        <h2>Mid Season Sale!!</h2>
        <p>(re)Découvrez vos bests-seller à Petits prix</p>
        <div class="pro-container">
            <div class="pro">

                <img src="images/B.jpg" alt="" width="200px">
                <div class="des">
                    <span>razana</span>
                    <h5>Manteau Beige</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>300 DHS</h4>
                </div>
                <a href="#" ><i class="fal fa-shopping-cart cart"></i></a>
            </div>


            <div class="pro">

                <img src="images/images3.jpg" alt="">
                <div class="des">
                    <span>razana</span>
                    <h5>Manteau  Peignoir Marron</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>300 DHS</h4>
                </div>
                <a href="#"><i class="fal fa-shopping-cart cart"></i></a>
            </div>

            <div class="pro">

                <img src="images/img7.jpg" alt="">
                <div class="des">
                    <span>razana</span>
                    <h5>Manteau Blanc</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>250 DHS</h4>
                </div>
                <a href="#"><i class="fal fa-shopping-cart cart"></i></a>
            </div>


            <div class="pro">

                <img src="images/img6.jpg" alt="">
                <div class="des">
                    <span>Manora</span>
                    <h5>Manteau Long à Carreaux</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>350 DHS</h4>
                </div>
                <a href="#"><i class="fal fa-shopping-cart cart"></i></a>
            </div>


            <div class="pro">

                <img src="images/image4.jpg" alt="">
                <div class="des">
                    <span>razana</span>
                    <h5>Manteau Noir</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>600 DHS</h4>
                </div>
                <a href="#"><i class="fal fa-shopping-cart cart"></i></a>
            </div>

            <div class="pro">

                <img src="images/images2.jpg" alt="">
                <div class="des">
                    <span>razana</span>
                    <h5>Manteau Gris</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>250 DHS</h4>
                </div>
                <a href="#"><i class="fal fa-shopping-cart cart"></i></a>
            </div>

            <div class="pro">

                <img src="images/img9.jpg" alt="">
                <div class="des">
                    <span>razana</span>
                    <h5>Manteau Long Boutonné</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>400 DHS</h4>
                </div>
                <a href="#"><i class="fal fa-shopping-cart cart"></i></a>
            </div>


            <div class="pro">

                <img src="images/img8.jpg" alt="">
                <div class="des">
                    <span>razana</span>
                    <h5>Manteau Veste Bouclette Beige</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>200 DHS</h4>
                </div>
                <a href="#"><i class="fal fa-shopping-cart cart"></i></a>
            </div>
        </div>
    </section>

    <section id="banner" class="section-m1">
        <h4>Repair Services</h4>
        <h2>Up to <span>70% off</span> on All Jacket & Accessoires</h2>
        <button class="normal">Explore More</button>
    </section>


    <section id="product1" class="section-p1">
        <h2>New Arrivals!!</h2>
        <p>Discover More</p>
        <div class="pro-container">
            <div class="pro">

                <img src="images/tele1.jpg" alt="">
                <div class="des">
                    <span>razana</span>
                    <h5>Jeans Boyfriend</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>300 DHS</h4>
                </div>
                <a href="#"><i class="fal fa-shopping-cart cart"></i></a>
            </div>


            <div class="pro">

                <img src="images/tele2.jpg" alt="">
                <div class="des">
                    <span>razana</span>
                    <h5>Pantalon Armee Large</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>300 DHS</h4>
                </div>
                <a href="#"><i class="fal fa-shopping-cart cart"></i></a>
            </div>

            <div class="pro">

                <img src="images/tele3.jpg" alt="">
                <div class="des">
                    <span>razana</span>
                    <h5>Manteau Blanc</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>250 DHS</h4>
                </div>
                <a href="#"><i class="fal fa-shopping-cart cart"></i></a>
            </div>


            <div class="pro">

                <img src="images/tele4.jpg" alt="">
                <div class="des">
                    <span>Manora</span>
                    <h5>Pantalon Skinny en Denim</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>350 DHS</h4>
                </div>
                <a href="#"><i class="fal fa-shopping-cart cart"></i></a>
            </div>


            <div class="pro">

                <img src="images/tele5.jpg" alt="">
                <div class="des">
                    <span>Arwa</span>
                    <h5>Manteau Noir</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>600 DHS</h4>
                </div>
                <a href="#"><i class="fal fa-shopping-cart cart"></i></a>
            </div>

            <div class="pro">

                <img src="images/tele6.jpg" alt="">
                <div class="des">
                    <span>razana</span>
                    <h5>Salopette en Jeans</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>350 DHS</h4>
                </div>
                <a href="#"><i class="fal fa-shopping-cart cart"></i></a>
            </div>

            <div class="pro">

                <img src="images/tele7.jpg" alt="">
                <div class="des">
                    <span>razana</span>
                    <h5>Pantalon Cargo Large</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>200 DHS</h4>
                </div>
                <a href="#"><i class="fal fa-shopping-cart cart"></i></a>
            </div>


            <div class="pro">

                <img src="images/tele8.jpg" alt="" height="225px">
                <div class="des">
                    <span>Arwa</span>
                    <h5>Pantalon Large</h5>
                    <div class="star">
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                        <i class="fas fa-star"></i>
                    </div>
                    <h4>150 DHS</h4>
                </div>
                <a href="#"><i class="fal fa-shopping-cart cart"></i></a>
            </div>
        </div>
    </section>

<section id="sm-banner" class="section-p1">
    <div class="banner-box">
        <h4>Crazy Deals</h4>
        <h2>buy 2 get 1 free</h2>
        <span>The best clothes is on sale at virtual fashion</span>
        <button class="white">Learn More</button>
    </div>

    <div class=" banner-box banner-box2">
        <h4>Spring/Summer</h4>
        <h2>Upcoming Season</h2>
        <span>The best casual dress is on sale at virtual fashion</span>
        <button class="white">Collections</button>
    </div>
</section>

<section id="banner3">
    <div class=" banner-box">
        <h2>Season SALE</h2>
        <h3>Winter Collection -50% OFF</h3>
    </div>
    <div class=" banner-box banner-box2">
        <h2>ONLINE SALE</h2>
        <h3>Winter 2023/2024</h3>
    </div>
    <div class=" banner-box banner-box3">
        <h2>HIM AND HER</h2>
        <h3>New Collections</h3>
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