package com.servlets;


import java.io.IOException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import javax.swing.JOptionPane;

import com.jpaClass.modele.voiture;


@WebServlet(name = "ServletVoitureSupprimer", urlPatterns = { "/ServletVoitureSupprimer" })
public class ServletVoitureSupprimer extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer l'ID de la voiture à supprimer depuis les paramètres de requête
        String voitureId = request.getParameter("id");

        // Vérifier si l'ID de la voiture est présent
        if (voitureId != null && !voitureId.isEmpty()) {
            // Convertir l'ID en entier
            int id = Integer.parseInt(voitureId);
            int choix = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer cette voiture ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (choix == JOptionPane.YES_OPTION) {
            	// Appeler la méthode de suppression de la voiture
                supprimerVoiture(id);
             // Rediriger vers la page de la liste des voitures après la suppression
                response.sendRedirect("/LocationVoituresApp/VoitureServlet");
                
            	} else {
            		response.sendRedirect("/LocationVoituresApp/VoitureServlet");
            	}
            

            
        } else {
            // Si l'ID n'est pas présent, rediriger vers la page des liste des voitures
            response.sendRedirect("/LocationVoituresApp/VoitureServlet");
        }
    }

    private void supprimerVoiture(int id) {
        // Créer une instance de l'EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");

        // Créer une instance de l'EntityManager
        EntityManager em = emf.createEntityManager();

        try {
            // Commencer une transaction
            em.getTransaction().begin();

            // Trouver la voiture à supprimer par son ID
            voiture voitureASupprimer = em.find(voiture.class, id);

            // Vérifier si la voiture existe avant de la supprimer
            if (voitureASupprimer != null) {
                // Supprimer la voiture
                em.remove(voitureASupprimer);

                // Valider la transaction
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Annuler la transaction en cas d'erreur
            em.getTransaction().rollback();
        } finally {
            // Fermer l'EntityManager
            em.close();

            // Fermer l'EntityManagerFactory
            emf.close();
        }
    }
}