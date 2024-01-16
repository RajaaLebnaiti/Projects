package com.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jpaClass.modele.voiture;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet(name = "RechercheVoituresServletPersonnel", urlPatterns = {"/RechercheVoituresServletPersonnel"})
public class RechercheVoituresServletPersonnel extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RechercheVoituresServletPersonnel() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        String anneeStr = request.getParameter("annee");
        Date annee = parseDate(anneeStr); // Méthode pour convertir la chaîne en Date

        String marque = request.getParameter("marque");

        List<voiture> Voitures = getVoituresFromDatabase(em, annee, marque);
        
        em.close();
        emf.close();

        request.setAttribute("Voitures", Voitures);
        request.getRequestDispatcher("ReservationPersonnel.jsp").forward(request, response);
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

    private List<voiture> getVoituresFromDatabase(EntityManager em, Date annee, String marque) {
        String jpql = "SELECT v FROM voiture v WHERE v.annee = :annee AND v.marque = :marque";
        TypedQuery<voiture> query = em.createQuery(jpql, voiture.class);
        query.setParameter("annee", annee);
        query.setParameter("marque", marque);
        return query.getResultList();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}