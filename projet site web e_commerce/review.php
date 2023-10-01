<html>
    <head>
        <title>Review</title>
        <link rel="stylesheet" href="style2.css">
        

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
                <li><a  href="Site Web.php">Home</a> </li>
                <li><a href="shop.php">Shop</a> </li>
                <li><a class="active" href="review.php">Review</a></li>

                <li><a href="blog.php">Blog</a> </li>
                <li><a href="about.php">About</a> </li>
                <li><a href="contact.php">Contact</a> </li>
                <li><a href="seconnecter.php">Authentification</a> </li>
                <li><a href="index.php"><i class="far fa-shopping-bag" id="cart-icon"></i>
                
            </a></li>

                
            </ul>
        </div>
    </section>


        <div class="hero">
            <h1>
                Our Clients Review
            </h1>
            <div class="container">
                <div class="indicator">
                    <span class="btn active"></span>
                    <span class="btn"></span>
                    <span class="btn"></span>
                    <span class="btn"></span>
                </div>
                <div class="testimonial">
            <div class="slide-row" id="slide">

                <div class="slide-col">
                    <div class="user-text">
                        <p>Alaoui Maryam is an american entrepreneur and medie productor.
                        She is the ceo of the multi-national company Rozana.</p>
                    <h3>Maryam</h3>
                    <p>Rozana Inc.</p>
                </div>
                    <div class="user-img">
                <img src="images/pers3.jpg"alt="" height="300" width="350"></div>
                </div>

                <div class="slide-col">
                    <div class="user-text">
                        <p>Alami Zineb is an american entrepreneur and medie productor.
                        She is the ceo of the multi-national company Rozana.</p>
                    <h3>Zineb</h3>
                    <p>Rozana Inc.</p>
                </div>
                    <div class="user-img">
                <img src="images/pers4.jpg"alt="" height="300" width="350"></div>
                </div>

                <div class="slide-col">
                    <div class="user-text">
                        <p>Malki Yassir is an american entrepreneur and medie productor.
                        He is the ceo of the multi-national company .</p>
                    <h3>Yassir</h3>
                    <p>Siliea Inc.</p>
                </div>
                    <div class="user-img">
                <img src="images/pers2.jpg"alt="" height="300" width="350"></div>
                </div>

                <div class="slide-col">
                    <div class="user-text">
                        <p>Bennani Ahmed m is a moroccan entrepreneur and investor.
                        He is the ceo of  multi-national companies.</p>
                    <h3>Ahmed</h3>
                    <p>GlobalTech Inc.</p>
                </div>
                    <div class="user-img">
                <img src="images/pers1.jpg"alt="" height="300" width="350" >
                </div>
                </div>


            </div>
        </div>
        </div>
        </div>
    <script>
        var btn=document.getElementsByClassName("btn");
        var slide=document.getElementById("slide");
        btn[0].onclick=function(){
            slide.style.transform="translateX(0px)";
        for(i=0;i<4;i++){
            btn[i].classList.remove("active");
        }
        this.classList.add("active");
        }

        btn[1].onclick=function(){
            slide.style.transform="translateX(-800px)";
            for(i=0;i<4;i++){
            btn[i].classList.remove("active");
        }
        this.classList.add("active");
        }
        btn[2].onclick=function(){
            slide.style.transform="translateX(-1600px)";
            for(i=0;i<4;i++){
            btn[i].classList.remove("active");
        }
        this.classList.add("active");
        }
        btn[3].onclick=function(){
            slide.style.transform="translateX(-2400px)";
            for(i=0;i<4;i++){
            btn[i].classList.remove("active");
        }
        this.classList.add("active");
        }
    </script>

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
    </body>
</html>