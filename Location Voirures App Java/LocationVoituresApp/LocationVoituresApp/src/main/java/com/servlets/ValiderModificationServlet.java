package com.servlets;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.jpaClass.modele.voiture;


@WebServlet(name = "ValiderModificationServlet", urlPatterns = { "/ValiderModificationServlet" })
public class ValiderModificationServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     // Récupérer les paramètres de la requête
     String idParameter = request.getParameter("id");
     int id = (idParameter != null && !idParameter.isEmpty()) ? Integer.parseInt(idParameter) : 0;
     String marque = request.getParameter("marque");
     String modele = request.getParameter("modele");
     String annee = request.getParameter("annee");
     String couleur = request.getParameter("couleur");
     boolean disponible = Boolean.parseBoolean(request.getParameter("disponible"));
     String matricule = request.getParameter("matricule");
     String kilometragePrevuParam = request.getParameter("Kilométrage_prevu");
     int kilometragePrevu = (kilometragePrevuParam != null && !kilometragePrevuParam.isEmpty()) ? Integer.parseInt(kilometragePrevuParam) : 0;
     String place=request.getParameter("nbPlaces");
     int nbPlaces = Integer.parseInt(place);

     // Récupérer l'EntityManager à partir du contexte
     EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
     EntityManager em = emf.createEntityManager();
     try {
         // Commencer une transaction
         em.getTransaction().begin();

         // Trouver la voiture à modifier par son ID
         voiture voitureAModifier = em.find(voiture.class, id);

         // Mettre à jour les informations de la voiture
         voitureAModifier.setMarque(marque);
         voitureAModifier.setModele(modele);
         // Convertir la chaîne en Date (à adapter selon le format de votre date)
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         Date dateAnnee = new Date(dateFormat.parse(annee).getTime());
         voitureAModifier.setAnnee(dateAnnee);
         
         voitureAModifier.setCouleur(couleur);
         voitureAModifier.setDisponible(disponible);
         voitureAModifier.setMatricule(matricule);
         voitureAModifier.setKilometragePrevu(kilometragePrevu);
         voitureAModifier.setNbPlaces(nbPlaces);

         // Valider la transaction
         em.getTransaction().commit();

         // Rediriger vers la page de détails de la voiture
         response.sendRedirect("/LocationVoituresApp/DetailsVoitureServlet?id="+id);
         
     } catch (Exception e) {
         e.printStackTrace();
         // Annuler la transaction en cas d'erreur
         if (em.getTransaction().isActive()) {
             em.getTransaction().rollback();
         }
     } finally {
         // Vérifier si l'EntityManager n'est pas null avant de le fermer
         if (em != null) {
             em.close();
         }
     }
 }
}