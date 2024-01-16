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
import com.jpaClass.modele.facturation;

@WebServlet(name = "supprimerFacture", urlPatterns = { "/supprimerFacture" })
public class supprimerFacture extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer l'ID de la voiture à supprimer depuis les paramètres de requête
        String FactureId = request.getParameter("id");

        // Vérifier si l'ID de la voiture est présent
        if (FactureId != null && !FactureId .isEmpty()) {
           
            int id = Integer.parseInt(FactureId );

            // Appeler la méthode de suppression de la voiture
            int choix = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer cette facturation ?", "Confirmation", JOptionPane.YES_NO_OPTION);
            if (choix == JOptionPane.YES_OPTION) {
            	// Appeler la méthode de suppression de la voiture
            supprimerFacture(id);
            }else {
            	
            	response.sendRedirect("/LocationVoituresApp/FacturationServlet");
            }
            // Rediriger vers la page de la liste des voitures après la suppression
            response.sendRedirect("/LocationVoituresApp/FacturationServlet");
        } else {
            // Si l'ID n'est pas présent, rediriger vers une page d'erreur ou la liste des voitures
            response.sendRedirect("/LocationVoituresApp/FacturationServlet");
        }
    }

    private void supprimerFacture(int id) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        try {
            
            em.getTransaction().begin();

            facturation factureASupprimer = em.find(facturation.class, id);

          
            if (factureASupprimer != null) {
                // Supprimer la voiture
                em.remove(factureASupprimer);

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