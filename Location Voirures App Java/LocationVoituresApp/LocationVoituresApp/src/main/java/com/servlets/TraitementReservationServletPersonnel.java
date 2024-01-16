package com.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.jpaClass.modele.client;
import com.jpaClass.modele.personnel;
import com.jpaClass.modele.reservation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "TraitementReservationServletPersonnel", urlPatterns = {"/TraitementReservationServletPersonnel"})
public class TraitementReservationServletPersonnel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public TraitementReservationServletPersonnel() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		      
		 // Récupérer les paramètres du formulaire
        String dateDebutStr = request.getParameter("date_debut");
        String dateFinStr = request.getParameter("date_fin");
        String lieuPrise = request.getParameter("lieuPrise");
        String lieuRetour = request.getParameter("lieuRetour");
        String modePaiement = request.getParameter("modePaiement");
        String statut = request.getParameter("statut");
        String cin = request.getParameter("cin");
        System.out.println("============"+cin);
        // Convertir les chaînes de date en objets Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDebut = null;
        Date dateFin = null;
        try {
            dateDebut = dateFormat.parse(dateDebutStr);
            dateFin = dateFormat.parse(dateFinStr);
        } catch (ParseException e) {
            e.printStackTrace();
            // Gérer l'erreur de conversion de date
        }

        // Obtenez l'ID du client à partir du CIN en utilisant une requête JPQL
        int idClient = getIdClientFromCin(cin);

        
     // Créer une instance de l'entité client et la remplir avec les données
        client client = new client();
        client.setId_client(idClient);

        // Créer une instance de l'entité personnel et la remplir avec les données
        personnel personnel = new personnel();
        
        //recuperer id du personnel à partir de la session
     // Récupérer l'ID du personnel à partir de la session
        HttpSession session = request.getSession();
        int idPersonnel = (int) session.getAttribute("idPersonnel");
        //int idPersonnelParDefaut =1;
		personnel.setId_personnel(idPersonnel);

        // Créer une instance de l'entité de réservation et la remplir avec les données
        reservation reservation = new reservation();
        reservation.setDate_debut(dateDebut);
        reservation.setDate_fin(dateFin);
        reservation.setLieuPrise(lieuPrise);
        reservation.setLieuRetour(lieuRetour);
        reservation.setModePaiment(modePaiement);
        reservation.setStatut(statut);

        // Associer le client et le personnel à la réservation
        reservation.setClient(client);
        reservation.setPersonnel(personnel);

        // Enregistrer la réservation dans la base de données en utilisant une requête JPQL
        saveReservation(reservation);

     // Rediriger avec un message de confirmation
        String message = "La réservation a été effectuée avec succès.";
        request.setAttribute("message", message);

        RequestDispatcher dispatcher = request.getRequestDispatcher("confirmationReservationPersonnel.jsp");
        dispatcher.forward(request, response);
    }

    private int getIdClientFromCin(String cin) {
        // Effectuer une recherche dans la base de données pour obtenir l'ID du client à partir du CIN
        // Utilisez une requête JPQL pour trouver l'ID du client par son CIN
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        TypedQuery<client> query = em.createQuery("SELECT c FROM client c WHERE c.CIN = :cin", client.class);
        query.setParameter("cin", cin);

        List<client> resultList = query.getResultList();
        em.close();
        emf.close();

        if (!resultList.isEmpty()) {
            // Retourne l'ID du premier client trouvé
            return resultList.get(0).getId_client();
        } else {
            // Si aucun client n'est trouvé, vous pouvez gérer cela selon vos besoins
            return 0;
        }
    }

    private void saveReservation(reservation reservation) {
        // Enregistrer la réservation dans la base de données
        // Utilisez une requête JPQL pour insérer la réservation dans la base de données
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(reservation);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
  
