package com.servlets;


import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import com.jpaClass.modele.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




import jakarta.persistence.TypedQuery;
import com.jpaClass.modele.personnel;


import jakarta.servlet.http.HttpSession;
@WebServlet(name = "StatistiquesServlet", urlPatterns = {"/StatistiquesServlet"})
public class StatistiquesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        super.init();
        emf = Persistence.createEntityManagerFactory("ClientUnit");
    }

    @Override
    public void destroy() {
        super.destroy();
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	// Récupérez les données de réservation depuis la base de données
        List<Long> reservationsParMois = obtenirReservationsParMois();
        request.setAttribute("reservationsParMois", reservationsParMois);

        // Récupérez le nombre de clients existants
        Long nombreClients = obtenirNombreClients();
        request.setAttribute("nombreClients", nombreClients);

     // Obtenir l'évolution du nombre de clients
        List<Long> evolutionNombreClients = obtenirEvolutionNombreClients();
        request.setAttribute("evolutionNombreClients", evolutionNombreClients);
        
     // Récupérez le nombre de voitures non disponibles
        Long nombreVoituresNonDisponibles = obtenirNombreVoituresNonDisponibles();
        request.setAttribute("nombreVoituresNonDisponibles", nombreVoituresNonDisponibles);
        // Récupérez le nombre de voitures disponibles
        Long nombreVoituresDisponibles = obtenirNombreVoituresDisponibles();
        request.setAttribute("nombreVoituresDisponibles", nombreVoituresDisponibles);
        
      
        List<Long> reclamationsParMois = obtenirReclamationsParMois();
        request.setAttribute("reclamationsParMois", reclamationsParMois);
        
        // Transmettez les données à la page JSP
        RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard.jsp");
        dispatcher.forward(request, response);
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
        
        
    }
    //methode pour avoir le nombre de reservations dans chaque mois
    public List<Long> obtenirReservationsParMois() {
        EntityManager entityManager = getEntityManager();


        
        String jpql = "SELECT MONTH(r.date_debut), COUNT(r) FROM reservation r GROUP BY MONTH(r.date_debut)";

        // Exécuter la requête
        Query query = entityManager.createQuery(jpql);

        // Récupérer les résultats
        List<Object[]> resultats = query.getResultList();

        // Créer une liste pour stocker les résultats finaux
        List<Long> reservationsParMois = new ArrayList<>();

        // Initialiser un tableau pour stocker le nombre de réservations pour chaque mois
        Long[] reservationsParMoisArray = new Long[12];
        Arrays.fill(reservationsParMoisArray, 0L);

        // Remplir le tableau avec les résultats de la requête
        for (Object[] result : resultats) {
            Integer mois = (Integer) result[0];
            Long count = (Long) result[1];
            reservationsParMoisArray[mois - 1] = count;
        }

        // Ajouter les résultats à la liste finale
        reservationsParMois.addAll(Arrays.asList(reservationsParMoisArray));

        // Fermer l'EntityManager
        entityManager.close();

        return reservationsParMois;
    }

//methode pour avoir le nombre totales des clients 
    public Long obtenirNombreClients() {
        EntityManager entityManager = getEntityManager();

        // Utiliser JPA pour exécuter une requête pour obtenir le nombre total de clients
        String jpql = "SELECT COUNT(c) FROM client c";
        Query query = entityManager.createQuery(jpql);

        // Récupérer le résultat
        Long nombreClients = (Long) query.getSingleResult();

        // Fermer l'EntityManager
        entityManager.close();

        return nombreClients;
    }
  //methode pour obtenir l'évolution du nombre de clients
    public List<Long> obtenirEvolutionNombreClients() {
        EntityManager entityManager = getEntityManager();

        // Utiliser JPA pour exécuter une requête pour obtenir l'évolution du nombre de clients
        String jpql = "SELECT COUNT(c) FROM client c WHERE FUNCTION('MONTH', c.DateNaissance) = :month GROUP BY FUNCTION('MONTH', c.DateNaissance) ORDER BY FUNCTION('MONTH', c.DateNaissance)";
        
        List<Long> evolutionNombreClients = new ArrayList<>();

        for (int mois = 1; mois <= 12; mois++) {
            Query query = entityManager.createQuery(jpql);
            query.setParameter("month", mois);
            
            try {
                Long count = (Long) query.getSingleResult();
                evolutionNombreClients.add(count);
            } catch (NoResultException e) {
                // Si aucune valeur n'est trouvée pour un mois, ajouter 0
                evolutionNombreClients.add(0L);
            }
        }

        // Fermer l'EntityManager
        entityManager.close();

        return evolutionNombreClients;
    }

    
 // Méthode pour obtenir le nombre de voitures disponibles
    public Long obtenirNombreVoituresDisponibles() {
        EntityManager entityManager = getEntityManager();

        // Utiliser JPA pour exécuter une requête pour obtenir le nombre total de voitures disponibles
        String jpql = "SELECT COUNT(v) FROM voiture v WHERE v.disponible = true";
        Query query = entityManager.createQuery(jpql);

        // Récupérer le résultat
        Long nombreVoituresDisponibles = (Long) query.getSingleResult();

        // Fermer l'EntityManager
        entityManager.close();

        return nombreVoituresDisponibles;
    }

    // Méthode pour obtenir le nombre de voitures non disponibles
    public Long obtenirNombreVoituresNonDisponibles() {
        EntityManager entityManager = getEntityManager();

        // Utiliser JPA pour exécuter une requête pour obtenir le nombre total de voitures non disponibles
        String jpql = "SELECT COUNT(v) FROM voiture v WHERE v.disponible = false";
        Query query = entityManager.createQuery(jpql);

        // Récupérer le résultat
        Long nombreVoituresNonDisponibles = (Long) query.getSingleResult();

        // Fermer l'EntityManager
        entityManager.close();

        return nombreVoituresNonDisponibles;
    }
 // methode pour obtenir le nombre de reclamations
    public List<Long> obtenirReclamationsParMois() {
        EntityManager entityManager = getEntityManager();

        // Utilisez JPA pour exécuter une requête pour obtenir le nombre de réclamations par mois
        String jpql = "SELECT MONTH(r.dateSoumission), COUNT(r) FROM reclamation r GROUP BY MONTH(r.dateSoumission)";

        // Exécuter la requête
        Query query = entityManager.createQuery(jpql);

        // Récupérer les résultats
        List<Object[]> resultats = query.getResultList();

        // Créer une liste pour stocker les résultats finaux
        List<Long> reclamationsParMois = new ArrayList<>();

        // Initialiser un tableau pour stocker le nombre de réclamations pour chaque mois
        Long[] reclamationsParMoisArray = new Long[12];
        Arrays.fill(reclamationsParMoisArray, 0L);

        // Remplir le tableau avec les résultats de la requête
        for (Object[] result : resultats) {
            Integer mois = (Integer) result[0];
            Long count = (Long) result[1];
            reclamationsParMoisArray[mois - 1] = count;
        }

        // Ajouter les résultats à la liste finale
        reclamationsParMois.addAll(Arrays.asList(reclamationsParMoisArray));

        // Fermer l'EntityManager
        entityManager.close();

        return reclamationsParMois;
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
