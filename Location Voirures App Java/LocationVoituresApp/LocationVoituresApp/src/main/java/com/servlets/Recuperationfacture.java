package com.servlets;

import java.io.IOException;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.jpaClass.modele.facturation;
@WebServlet(name = "Recuperationfacture", urlPatterns = { "/Recuperationfacture" })
@MultipartConfig(maxFileSize = 1024 * 1024 * 5) // 5MB max file size

public class Recuperationfacture extends HttpServlet {
	
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String ID=request.getParameter("id");
    	int id_facture=Integer.parseInt(ID);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Récupérer les réservations avec les détails du client
            //String jpql = "SELECT * FROM facturation f JOIN reservation r WHERE f.id_reservation=r.id_reservation";
            String jpql = "SELECT r FROM facturation r JOIN FETCH r.reservation WHERE r.id_facture = :id_facture";
            Query query = em.createQuery(jpql);
            query.setParameter("id_facture", id_facture);
            facturation facturations = (facturation) query.getSingleResult();


            em.getTransaction().commit();
            
            request.setAttribute("facturations", facturations);
            request.getRequestDispatcher("/ModificationFacture.jsp").forward(request, response);

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}