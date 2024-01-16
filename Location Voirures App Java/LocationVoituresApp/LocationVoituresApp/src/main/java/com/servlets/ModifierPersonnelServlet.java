package com.servlets;

import java.io.IOException;
import java.io.InputStream;

import java.util.Base64;
import java.util.Date;
import java.util.Date.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import com.jpaClass.modele.personnel;


@WebServlet(name = "ModifierPersonnelServlet", urlPatterns = { "/ModifierPersonnelServlet" })
@MultipartConfig(maxFileSize = 1024 * 1024 * 5) // 5MB max file size
public class ModifierPersonnelServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	
    	// Mise à jour de l'objet client dans la base de données avec JPA
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();
        
        
        // Récupération des paramètres du formulaire
        String idStr = request.getParameter("idPersonnel");
        String nomClient = request.getParameter("nomPersonnel");
        String prenomClient = request.getParameter("prenomPersonnel");
        String dateNaissanceStr = request.getParameter("dateNaissance");
        String postePersonnel = request.getParameter("postePersonnel");
        
        String nomUtilisateur = request.getParameter("nom_utilisateur");
        String motDePasse = request.getParameter("motDePasse");
        String cin = request.getParameter("cin");
        String emailClient = request.getParameter("emailPersonnel");

        // Conversion des paramètres
        int id = Integer.parseInt(idStr);
       Date dateNaissance = java.sql.Date.valueOf(dateNaissanceStr);
        

        

        // Création de l'objet client avec les nouvelles valeurs
        personnel  clientModifie = em.find(personnel.class, idStr);
        clientModifie.setId_personnel(id);
        clientModifie.setNom_personnel(nomClient);
        clientModifie.setPrenom_personnel(prenomClient);
        clientModifie.setDateNaissance(dateNaissance);
        clientModifie.setPoste_personnel(postePersonnel);
        
        clientModifie.setNom_utilisateur(nomUtilisateur);
        clientModifie.setMotdepasse(motDePasse);
        clientModifie.setCIN(cin);
        clientModifie.setEmail_personnel(emailClient);
        
        
     // Traitement de l'image
        Part filePart = request.getPart("image");
        if (filePart != null && filePart.getSize() > 0) {
        InputStream imageInputStream = filePart.getInputStream();
        byte[] imageBytes = imageInputStream.readAllBytes();
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        clientModifie.setImage(imageBytes);
        
        }
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            em.merge(clientModifie);

            transaction.commit();
        } finally {
            em.close();
            emf.close();
        }

        // Redirection vers la liste des clients après la modification
        response.sendRedirect("/LocationVoituresApp/AffichagePersonnel");
    }
}