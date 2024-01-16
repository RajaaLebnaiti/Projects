package com.servlets;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.jpaClass.modele.client;
import com.jpaClass.modele.personnel;
import com.jpaClass.modele.reservation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "processPayment", urlPatterns = {"/processPayment"})
public class processPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public processPayment() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Récupérez les champs du formulaire
        String cardHolderName = request.getParameter("cardHolderName");
        String cardName = request.getParameter("cardName");
        String cardNumber = request.getParameter("cardNumber");
   

      // int carteBancaire = Integer.parseInteger(cardNumber);
        String expirationDateStr = request.getParameter("expirationDate");

        // Convertissez la date d'expiration en objet Date
        Date expirationDate = parseDate(expirationDateStr);
        System.out.println("daaaaaaaaaaaaaaaaate"+expirationDate);
        System.out.println(cardNumber);
        System.out.println(cardName);
        System.out.println(cardHolderName);
        // Récupérez les autres informations de la session
        HttpSession session = request.getSession();
        // Vérifiez la longueur du numéro de carte bancaire
        if (cardNumber.length() < 14) {
            // Numéro de carte bancaire invalide, redirigez avec un message d'erreur
            session.setAttribute("errorMessage", "Numéro de carte bancaire invalide (doit avoir au moins 14 chiffres)");
            response.sendRedirect("PaimentEnLigne.jsp");
            return; // Arrêtez le traitement ici
        }
        // Vérifiez si la date d'expiration est antérieure à la date d'aujourd'hui
        if (expirationDate.before(new Date())) {
            // Date d'expiration invalide, redirigez avec un message d'erreur
            session.setAttribute("errorMessage", "La date d'expiration de la carte est invalide");
            response.sendRedirect("PaimentEnLigne.jsp");
            return; // Arrêtez le traitement ici
        }
        Date dateDebut = (Date) session.getAttribute("dateDebut");
        Date dateFin = (Date) session.getAttribute("dateFin");
        String lieuPrise = (String) session.getAttribute("lieuPrise");
        String lieuRetour = (String) session.getAttribute("lieuRetour");
        String modePaiement = (String) session.getAttribute("modePaiement");
        String statut = (String) session.getAttribute("statut");

       
        client clientObj = (client) session.getAttribute("utilisateur");

        if (clientObj != null) {
        	 int id ;
             id = clientObj.getId_client();
             System.out.println("++++++++++++++++"+id);
             System.out.println(cardNumber);
            clientObj.setCarteBancaire(cardNumber);
            // Obtenez l'objet personnel avec l'ID par défaut (1)
            // Assurez-vous que l'ID 1 existe dans votre base de données
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
            EntityManager em = emf.createEntityManager();
            
            personnel personnelObj = em.find(personnel.class, 1);
           
            // Créez une nouvelle réservation
            reservation nouvelleReservation = new reservation();
            nouvelleReservation.setDate_debut(dateDebut);
            nouvelleReservation.setDate_fin(dateFin);
            nouvelleReservation.setLieuPrise(lieuPrise);
            nouvelleReservation.setLieuRetour(lieuRetour);
            nouvelleReservation.setModePaiment(modePaiement);
            nouvelleReservation.setClient(clientObj);
            nouvelleReservation.setStatut(statut);
            nouvelleReservation.setPersonnel(personnelObj);

         // Persistez les modifications de clientObj
            em.getTransaction().begin();
            clientObj = em.merge(clientObj);
            em.getTransaction().commit();
            // Persistez la nouvelle réservation
            em.getTransaction().begin();
            em.persist(nouvelleReservation);
            em.getTransaction().commit();

            // Redirigez l'utilisateur vers une page de confirmation ou une autre page appropriée
            session.setAttribute("successMessage", "Réservation établie avec succès");
            response.sendRedirect("PaimentEnLigne.jsp");

            // Fermez EntityManager et EntityManagerFactory ici
            em.close();
            emf.close();
        } else {
            session.setAttribute("successMessage", "Une erreur s'est produite. Réessayez.");
            response.sendRedirect("PaimentEnLigne.jsp");
        }
    }
	 private Date parseDate(String dateStr) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = null;
	        try {
	            date = dateFormat.parse(dateStr);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        return date;
	    }
}