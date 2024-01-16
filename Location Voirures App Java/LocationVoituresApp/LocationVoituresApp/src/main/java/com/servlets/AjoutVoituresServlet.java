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


import com.jpaClass.modele.voiture;


@WebServlet(name = "AjoutVoituresServlet", urlPatterns = {"/AjoutVoituresServlet"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 5) // 5MB max file size
public class AjoutVoituresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AjoutVoituresServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // Récupération des données saisies par le client
        String marque = request.getParameter("marque");
        String modele = request.getParameter("modele");
        String anneeStr = request.getParameter("annee");
        String couleur = request.getParameter("couleur");
        boolean disponible = request.getParameter("disponible") != null;
        String matricule = request.getParameter("matricule");
        int kilometragePrevu = Integer.parseInt(request.getParameter("kilometragePrevu"));
        int nbPlaces = Integer.parseInt(request.getParameter("nbPlaces"));

        // Récupération du fichier image
        Part filePart = request.getPart("image");
        InputStream inputStream = filePart.getInputStream();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ClientUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Enregistrement des données de la voiture dans la base de données via JPA
        voiture newVoiture = new voiture();
        newVoiture.setMarque(marque);
        newVoiture.setModele(modele);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date annee = null;
        try {
            annee = dateFormat.parse(anneeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        newVoiture.setAnnee(annee);

        newVoiture.setCouleur(couleur);
        newVoiture.setDisponible(disponible);
        newVoiture.setMatricule(matricule);
        newVoiture.setKilometragePrevu(kilometragePrevu);
        newVoiture.setNbPlaces(nbPlaces);

        // Ajout du fichier image
        byte[] imageBytes = new byte[inputStream.available()];
        inputStream.read(imageBytes);
        newVoiture.setPhoto(imageBytes);

        em.persist(newVoiture);

        em.getTransaction().commit();

        em.close();
        emf.close();
        // Redirection vers la page de confirmation
        response.sendRedirect("/LocationVoituresApp/VoitureServlet");
	}

}
