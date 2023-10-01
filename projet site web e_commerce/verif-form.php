<?php
if(isset($_GET['search_query'])) {
    $search_query = $_GET['search_query'];
    // Requête de recherche et traitement des résultats ici
    echo "Voici les résultats de votre recherche pour '$search_query'";
} else {
    header('location: jum.php');
}
?>
