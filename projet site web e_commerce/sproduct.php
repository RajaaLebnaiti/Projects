<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css">
    <title>Sproduct</title>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"/>
    <!-- Inclure les fichiers CSS et JavaScript de Bootstrap -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    

</head>
<body>
    
    <!--Barre menu-->
    <section id="header">
        <a href="#"><img src="images/V.png" height="50px" width="60px" class="logo" alt="Logo"> </a>
        <div>
            <ul id="navbar">
                <li><a  href="Site Web.php">Home</a> </li>
                <li><a class="active" href="shop.php">Shop</a> </li>
                <li><a href="blog.php">Blog</a> </li>
                <li><a href="about.php">About</a> </li>
                <li><a href="contact.php">Contact</a> </li>
                <li><a href="seconnecter.php">Authentification</a> </li>

                <li><a href="panier.php"><i class="far fa-shopping-bag"></i> </a></li>
            </ul>
        </div>
    </section>

    <section id="prodetails" class="section-p1">
        <div class="single-pro-image">
            <img src="images/B.jpg" alt="" width="460px" id="Main">
            <div class="small-image-group">
                <div class="small-img-col">
                    <img src="images/A.jpg" alt="" width="100px" class="small-img">
                </div>
                <div class="small-img-col">
                    <img src="images/C.jpg" alt="" width="100px" class="small-img">
                </div>
                <div class="small-img-col">
                    <img src="images/E.jpg" alt="" width="100px" class="small-img">
                </div>
                <div class="small-img-col">
                    <img src="images/D.jpg" alt="" width="100px" class="small-img">
                </div>
            </div>
        </div>
        <div class="single-pro-details" data-id="1">
            <h6>Femme / Manteau</h6>
            <h4>Lady-s Fashion Manteau</h4>
            <h2>300 DHS</h2>
            
            <select>
                <option>Select Size</option>
                <option>XL</option>
                <option>XXL</option>
                <option>Small</option>
                <option>Large</option>
                <option>X Large</option>

            </select>
            <input type="number" value="1" id="quantity">
            <button class="normal" onclick="addToCart()">Add To Cart</button>
            <h4>Product details</h4>
            <span>Straight coat with rhinestones beige ladies ,and available in a range of colors,it offers it all in the ultimate head-turning package</span>
        </div>
    </section>

    
    <section id="product1" class="section-p1">
        <h2>Featured Products!!</h2>
        <p>New Collection</p>
        <div class="pro-container">
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

                <img src="images/tele8.jpg" alt="">
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

<!--Image slider-->
<script>
var MainImg=document.getElementById('Main');
var smallimg=document.getElementsByClassName("small-img");
smallimg[0].onclick=function(){
    MainImg.src=smallimg[0].src;
}
smallimg[1].onclick=function(){
    MainImg.src=smallimg[1].src;
}
smallimg[2].onclick=function(){
    MainImg.src=smallimg[2].src;
}
smallimg[3].onclick=function(){
    MainImg.src=smallimg[3].src;
}
</script>


<script>
function addToCart() {
  var productId = 1; // ID du produit
  var quantity = document.getElementById('quantity').value; // Quantité du produit

  // Envoi de la requête AJAX
  var xhr = new XMLHttpRequest();
  xhr.open('POST', 'panier.php');
  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
  xhr.onreadystatechange = function() {
    if (xhr.readyState === XMLHttpRequest.DONE) {
      // Traitement de la réponse du serveur
      if (xhr.status === 200) {
        alert('Produit ajouté au panier');
      } else {
        alert('Erreur lors de l\'ajout du produit au panier. Veuillez réssayer ulterieurement');
      }
    }
  };
  xhr.send('id=' + productId + '&quantity=' + quantity);
  
  // Afficher un message de confirmation avec un lien vers la page de consultation du panier
  var message = 'Le produit a été ajouté au panier !!! <a href="panier.php">Voir mon panier</a>';
  var modal = document.createElement('div');
  modal.innerHTML = message;
  modal.style.position = 'fixed';
  modal.style.top = '50%';
  modal.style.left = '50%';
  modal.style.transform = 'translate(-50%, -50%)';
  modal.style.backgroundColor = 'white';
  modal.style.padding = '20px';
  modal.style.boxShadow = '0 0 10px rgba(0, 0, 0, 0.5)';
  modal.style.zIndex = 9999;
  document.body.appendChild(modal);
}
</script>
    <script src="script.js"></script>
</body>
</html>