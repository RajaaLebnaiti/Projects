package com.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jakarta.servlet.http.Part;

import org.apache.tomcat.jakartaee.commons.io.IOUtils;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.jpaClass.modele.client;


@WebServlet(name = "InsertClientServlet", urlPatterns = { "/InsertClientServlet" })

@MultipartConfig(maxFileSize = 1024 * 1024 * 5)
public class InsertClientServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Récupérer les données du formulaire
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String adresse = request.getParameter("adresse");
        String telephone = request.getParameter("telephone");
        String nomUtilisateur = request.getParameter("nomUtilisateur");
        String motdepasse = request.getParameter("motdepasse");
        String cin = request.getParameter("cin");
        String dateNaissanceStr = request.getParameter("dateNaissance");

        // Convertir la chaîne de date en objet Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateNaissance = null;
        try {
            dateNaissance = new Date(sdf.parse(dateNaissanceStr).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Gérer le fichier image
        Part imagePart = (Part) request.getPart("image");
        InputStream imageInputStream = imagePart.getInputStream();
        byte[] imageBytes = IOUtils.toByteArray(imageInputStream);

        // Créer une instance de l'entité Client
        client client = new client();
        client.setNom_client(nom);
        client.setPrenom_client(prenom);
        client.setEmail_client(email);
        client.setAdresse_client(adresse);
        client.setTelephone_client(telephone);
        client.setNom_utilisateur(nomUtilisateur);
        client.setMotdepasse(motdepasse);
        client.setCIN(cin);
        client.setDateNaissance(dateNaissance);
        client.setimage(imageBytes);

        // Insérer le client dans la base de données
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(client);

            em.getTransaction().commit();

            // Rediriger vers une page de confirmation
            response.sendRedirect("/LocationVoituresApp/ListeClientsServlet");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Fermer l'EntityManager
            if (em != null) {
                em.close();
            }
        }
    }
}