package com.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

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
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import com.jpaClass.modele.client;

@WebServlet(name = "ModifierProfilServlet", urlPatterns = { "/ModifierProfilServlet" })
@MultipartConfig
public class ModifierProfilServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 HttpSession session = request.getSession();
         client client = (client) session.getAttribute("client");

         // Retrieve form parameters
         String nomClient = request.getParameter("nom_client");
         String prenomClient = request.getParameter("prenom_client");
         String emailClient = request.getParameter("email_client");
         String adresseClient = request.getParameter("adresse_client");
         String telephoneClient = request.getParameter("telephone_client");
         String nomUtilisateur = request.getParameter("nom_utilisateur");
         String motDePasse = request.getParameter("motdepasse");
         String cin = request.getParameter("CIN");
         String dateNaissanceString = request.getParameter("DateNaissance");
         

         // Convert date string to Date object
         Date dateNaissance = null;
         try {
             dateNaissance = new SimpleDateFormat("yyyy-MM-dd").parse(dateNaissanceString);
         } catch (ParseException e) {
             e.printStackTrace(); 
         }

         // Update client object
         client.setNom_client(nomClient);
         client.setPrenom_client(prenomClient);
         client.setEmail_client(emailClient);
         client.setAdresse_client(adresseClient);
         client.setTelephone_client(telephoneClient);
         client.setNom_utilisateur(nomUtilisateur);
         client.setMotdepasse(motDePasse);
         client.setCIN(cin);
         client.setDateNaissance(dateNaissance);

         // Handle file upload
         Part filePart = request.getPart("image");
         if (filePart != null && filePart.getSize() > 0) {
             // Only update the image if a new file is uploaded
             InputStream fileContent = filePart.getInputStream();
             byte[] imageBytes = fileContent.readAllBytes();
             client.setimage(imageBytes);
         }

         // Database update using JPA
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
         EntityManager em = emf.createEntityManager();

         try {
             EntityTransaction tx = em.getTransaction();
             tx.begin();

             // Merge the updated client object
             em.merge(client);

             tx.commit();
         } catch (Exception e) {
             e.printStackTrace(); // Handle the exception properly in a production environment
         } finally {
             em.close();
             emf.close();
         }

         response.sendRedirect("ProfilClient.jsp");
     }
 }