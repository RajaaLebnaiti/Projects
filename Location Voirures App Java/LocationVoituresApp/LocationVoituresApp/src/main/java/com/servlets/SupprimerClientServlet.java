package com.servlets;

import java.io.IOException;

import javax.swing.JOptionPane;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.jpaClass.modele.client;


@WebServlet(name = "SupprimerClientServlet", urlPatterns = { "/SupprimerClientServlet" })
public class SupprimerClientServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer l'ID de la voiture à supprimer depuis les paramètres de requête
        String ClientId = request.getParameter("id");

        // Vérifier si l'ID de la voiture est présent
        if (ClientId  != null && !ClientId .isEmpty()) {
            // Convertir l'ID en entier
            int id = Integer.parseInt(ClientId );

            // Appeler la méthode de suppression de la voiture
            int choix = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer ce client ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (choix == JOptionPane.YES_OPTION) {
            	// Appeler la méthode de suppression de la voiture
            supprimerClient(id);
         // Rediriger vers la page de la liste des voitures après la suppression
            response.sendRedirect("/LocationVoituresApp/ListeClientsServlet");
            }else {
            	response.sendRedirect("/LocationVoituresApp/ListeClientsServlet");
            }
            
        } else {
            // Si l'ID n'est pas présent, rediriger vers une page d'erreur ou la liste des voitures
            response.sendRedirect("/LocationVoituresApp/ListeClientsServlet");
        }
    }

    private void supprimerClient(int id) {
        // Créer une instance de l'EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");

        // Créer une instance de l'EntityManager
        EntityManager em = emf.createEntityManager();

        try {
            // Commencer une transaction
            em.getTransaction().begin();

            // Trouver la voiture à supprimer par son ID
            client ClientASupprimer = em.find(client.class, id);

            // Vérifier si la voiture existe avant de la supprimer
            if (ClientASupprimer != null) {
                // Supprimer la voiture
                em.remove(ClientASupprimer);

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