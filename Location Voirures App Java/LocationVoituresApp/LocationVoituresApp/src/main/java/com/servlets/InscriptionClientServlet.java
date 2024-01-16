package com.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.util.Date;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


import com.jpaClass.modele.client;


@WebServlet(name = "InscriptionClientServlet", urlPatterns = {"/InscriptionClientServlet"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5) // 5MB max file size
public class InscriptionClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public InscriptionClientServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperation des données saisit pas le client
		String nom_client = request.getParameter("nom_client");
	    String prenom_client = request.getParameter("prenom_client");
	    String email_client = request.getParameter("email_client");
	    String adresse_client = request.getParameter("adresse_client");
	    String telephone_client = request.getParameter("telephone_client");
	    String nom_utilisateur = request.getParameter("nom_utilisateur");
	    String motdepasse = request.getParameter("motdepasse");
	    String CIN = request.getParameter("CIN");
	    String DateNaissanceStr = request.getParameter("DateNaissance");
	    // Récupération du fichier image
        Part filePart = request.getPart("image");
        InputStream inputStream = filePart.getInputStream(); 
	    
	    
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
	    EntityManager em = emf.createEntityManager();

	    em.getTransaction().begin();
	    
	    //enregistrement des données du client dans la base se données via jpa
	    client newClient = new client();
	    newClient.setNom_client(nom_client);
	    newClient.setPrenom_client(prenom_client);
	    newClient.setEmail_client(email_client);
	    newClient.setAdresse_client(adresse_client);
	    newClient.setTelephone_client(telephone_client);
	    newClient.setNom_utilisateur(nom_utilisateur);
	    newClient.setMotdepasse(motdepasse);
	    newClient.setCIN(CIN);
	    // Ajout du fichier image
        byte[] imageBytes = new byte[inputStream.available()];
        inputStream.read(imageBytes);
        newClient.setimage(imageBytes);
	    
	    
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date dateNaissance = null;
	    try {
	        dateNaissance = dateFormat.parse(DateNaissanceStr);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    newClient.setDateNaissance(dateNaissance);

	    em.persist(newClient);

	    em.getTransaction().commit();

	    em.close();
	    emf.close();

	    // Redirection du client vers la page confirmation.jsp
	    response.sendRedirect("loginClient.jsp");
	}
	}