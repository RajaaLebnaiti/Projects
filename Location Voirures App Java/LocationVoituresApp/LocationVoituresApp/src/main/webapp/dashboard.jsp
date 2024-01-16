<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tableau de Bord</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>
    body {
        font-family: 'Arial', sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f5f5f5;
    }

    header {
        background-color: #376380;
        color: #fff;
        padding: 30px;
        text-align: center;
    }

    .graphiques {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
    }

    .graphique-container {
        display: flex;
        justify-content: space-between;
        margin-bottom: 20px; /* Ajustez selon votre mise en page */
    }

    .graphique {
        flex: 1;
        margin-right: 100px; /* Ajustez selon l'espace souhaité entre les graphiques */
        box-shadow: 0 0 100px rgba(0, 0, 0, 0.1);
        margin-left: 150px;
        margin-top: 40px;
        border: 1px solid #ccc;
        border-radius: 8px;
        overflow: hidden;
    }

    .graphique h2 {
        text-align: center;
        color: #BA0F30;
    }

    .return-button {
        display: block;
        text-align: center;
        margin-top: 20px;
        margin-bottom: 20px;
    }

    .return-button button {
        padding: 10px 20px;
        font-size: 26px;
        background-color: #376380;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s ease; /* Ajout de la transition */
    }

    .return-button button:hover {
        background-color: #2b4b5b; /* Changement de couleur au survol */
    }
</style>

    
</head>
<body>
    <header><h1>Tableau de Bord</h1></header>

     <section class="graphiques">
        <div class="graphique-container">
  <div class="graphique" style="max-width: 500px;">
    <h2>Graphique</h2>
    <canvas id="graphiqueReservations" width="600" height="400"></canvas>
    <script>
        var reservationsParMois = <%= request.getAttribute("reservationsParMois") %>;
        var ctx = document.getElementById('graphiqueReservations').getContext('2d');

        new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ['Jan', 'Fév', 'Mar', 'Avr', 'Mai', 'Juin', 'Juill', 'Aout', 'Sept', 'Oct', 'Nov', 'Déc'],
                datasets: [{
                    label: 'Réservations/mois',
                    data: reservationsParMois,
                    backgroundColor: '#0461B1',
                    borderColor: '#0461B1',
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: { beginAtZero: true }
                }
            }
        });
    </script>
</div>

<!-- afficher le nombre de clients -->

 <div class="graphique" style="max-width: 500px;">
        <h2>Évolution du Nombre de Clients</h2>
        <canvas id="graphiqueEvolutionClients" width="600" height="400"></canvas>
        <script>
            // Récupérez les données depuis la servlet
            var evolutionNombreClients = <%= request.getAttribute("evolutionNombreClients") %>;

            // Créez le graphique avec Chart.js
            var ctxEvolution = document.getElementById('graphiqueEvolutionClients').getContext('2d');
            var graphiqueEvolutionClients = new Chart(ctxEvolution, {
                type: 'line',
                data: {
                    labels: ['Jan', 'Fév', 'Mar', 'Avr', 'Mai', 'Juin', 'Juill', 'Aout', 'Sept', 'Oct', 'Nov', 'Déc'],
                    datasets: [{
                        label: 'Évolution du Nombre de Clients',
                        data: evolutionNombreClients,
                        backgroundColor: '#3B0918',
                        borderColor: '#3B0918',
                        borderWidth: 2
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        </script>
    </div>
</div>
<!-- Graphique pour le nombre de voitures disponibles et non disponibles -->
    <div class="graphique-container">

<div class="graphique" style="max-width: 500px;">
    <h2>Répartition des voitures</h2>
    <canvas id="graphiqueVoituresRepartition" width="600" height="400"></canvas>
    <script>
        var nombreVoituresDisponibles = <%= request.getAttribute("nombreVoituresDisponibles") %>;
        var nombreVoituresNonDisponibles = <%= request.getAttribute("nombreVoituresNonDisponibles") %>;

        var ctx = document.getElementById('graphiqueVoituresRepartition').getContext('2d');
        var graphiqueVoituresRepartition = new Chart(ctx, {
            type: 'doughnut', // Utilisez le type 'doughnut' pour un graphique à secteurs
            data: {
                labels: ['Voitures Disponibles', 'Voitures Non Disponibles'],
                datasets: [{
                    data: [nombreVoituresDisponibles, nombreVoituresNonDisponibles],
                    backgroundColor: ['#603840', '#BD8990'],
                    borderColor: ['#603840', '#BD8990'],
                    borderWidth: 1
                }]
            }
        });
    </script>
</div>


<!--  reclamation par mois  -->

 <div class="graphique" style="max-width: 500px;">
        <h2>Graphique des Réclamations</h2>
        <canvas id="graphiqueReclamations" width="600" height="600"></canvas>
        <script>
            // Récupérez les données depuis la servlet
            var reclamationsParMois = <%= request.getAttribute("reclamationsParMois") %>;

            // Créez le graphique avec Chart.js
            var ctxReclamations = document.getElementById('graphiqueReclamations').getContext('2d');
            var graphiqueReclamations = new Chart(ctxReclamations, {
                type: 'line',
                data: {
                    labels: ['Jan', 'Fév', 'Mar', 'Avr', 'Mai', 'Juin', 'Juill', 'Aout', 'Sept', 'Oct', 'Nov', 'Déc'],
                    datasets: [{
                        label: 'Nombre de réclamations par mois',
                        data: reclamationsParMois,
                        fill: false,
                        borderColor: '#211522',
                        borderWidth: 2
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        </script>
    </div>
    </div>
</section>

  <a href="/LocationVoituresApp/TableauServlet" class="return-button">
    <button>Retour</button>
</a> 

</body>
</html>