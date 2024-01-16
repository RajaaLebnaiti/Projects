package com.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.jpaClass.modele.client;


@WebServlet(name = "ModifierClientServlet", urlPatterns = { "/ModifierClientServlet" })
@MultipartConfig // 5MB max file size
public class ModifierClientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	// Récupérer les paramètres du formulaire
        int idClient = Integer.parseInt(request.getParameter("id"));
        String nomClient = request.getParameter("nom_client");
        String prenomClient = request.getParameter("prenom_client");
        String dateNaissanceStr = request.getParameter("DateNaissance");
        String adresseClient = request.getParameter("adresse_client");
        String telephoneClient = request.getParameter("telephone_client");
        String nomUtilisateur = request.getParameter("nom_utilisateur");
        String motDePasse = request.getParameter("motdepasse");
        String cin = request.getParameter("CIN");
        String emailClient = request.getParameter("email_client");
System.out.println("==========="+nomClient);
        // Convertir la date de naissance en objet Date
        Date dateNaissance = null;
        try {
            dateNaissance = new SimpleDateFormat("yyyy-MM-dd").parse(dateNaissanceStr);
        } catch (ParseException e) {
            e.printStackTrace(); // Gérer l'exception selon votre besoin
        }

        // Récupérer la partie du fichier (image)
        Part filePart = request.getPart("image");

        // Initialisez l'EntityManagerFactory (à adapter selon votre configuration)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        try {
            // Commencez la transaction
            em.getTransaction().begin();

            // Récupérer le client à partir de la base de données
            client clientAModifier = em.find(client.class, idClient);

            // Mettre à jour les valeurs modifiées
            clientAModifier.setNom_client(nomClient);
            clientAModifier.setPrenom_client(prenomClient);
            clientAModifier.setDateNaissance(dateNaissance);
            clientAModifier.setAdresse_client(adresseClient);
            clientAModifier.setTelephone_client(telephoneClient);
            clientAModifier.setNom_utilisateur(nomUtilisateur);
            clientAModifier.setMotdepasse(motDePasse);
            clientAModifier.setCIN(cin);
            clientAModifier.setEmail_client(emailClient);

            // Mettre à jour l'image si un nouveau fichier a été chargé
            if (filePart != null && filePart.getSize() > 0) {
                byte[] imageBytes = new byte[(int) filePart.getSize()];
                filePart.getInputStream().read(imageBytes);
                clientAModifier.setimage(imageBytes);
            }

            // Validez la transaction
            em.getTransaction().commit();
        } finally {
            // Fermez l'EntityManager
            em.close();

            // Fermez l'EntityManagerFactory (à faire une seule fois à l'arrêt de l'application)
            emf.close();
        }

        // Redirection vers la liste des clients après la modification
        response.sendRedirect("/LocationVoituresApp/ListeClientsServlet");
    }
}