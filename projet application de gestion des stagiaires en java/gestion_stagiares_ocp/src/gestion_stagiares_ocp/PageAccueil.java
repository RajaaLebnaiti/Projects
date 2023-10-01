package gestion_stagiares_ocp;

import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PageAccueil {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageAccueil window = new PageAccueil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PageAccueil() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Page d'acceuil");
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\\\\\\\Users\\\\\\\\hp\\\\\\\\eclipse-workspace\\\\\\\\gestion_stagiares_ocp\\\\\\\\images\\\\\\\\1.png");  
		frame.setIconImage(icon);


		 // Obtient la taille de l'écran
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice graphicsDevice = graphicsEnvironment.getDefaultScreenDevice();
        Rectangle screenSize = graphicsDevice.getDefaultConfiguration().getBounds();

        frame.setSize(screenSize.width, screenSize.height);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 0));
		panel.setBounds(0, 0, 1083, 67);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion Des Stagiares");
		
		lblNewLabel.setBackground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1063, 52);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(0, 65, 196, 339);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Liste des stagiares");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ListeStagiares fenetre1 = new ListeStagiares();
				fenetre1.frame.setVisible(true);
				fenetre1.frame.setLocationRelativeTo(null);
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(new Color(128, 0, 0));
		btnNewButton.setBounds(10, 11, 176, 34);
		panel_1.add(btnNewButton);
		
		JButton btnAjouterStagiare = new JButton("Ajouter Stagiare");
		btnAjouterStagiare.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AjouterStagiare fenetre1 = new AjouterStagiare();
				fenetre1.frame.setVisible(true);
				fenetre1.frame.setLocationRelativeTo(null);
				frame.dispose();
			}
		});
		btnAjouterStagiare.setForeground(SystemColor.text);
		btnAjouterStagiare.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAjouterStagiare.setBackground(new Color(128, 0, 0));
		btnAjouterStagiare.setBounds(10, 56, 176, 34);
		panel_1.add(btnAjouterStagiare);
		
		JButton btnStage = new JButton("Stage");
		btnStage.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Stage fenetre1 = new Stage();
				fenetre1.frame.setVisible(true);
				fenetre1.frame.setLocationRelativeTo(null);
				frame.dispose();
				
			}
		});
		btnStage.setForeground(SystemColor.text);
		btnStage.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnStage.setBackground(new Color(128, 0, 0));
		btnStage.setBounds(10, 101, 176, 34);
		panel_1.add(btnStage);
		
		JButton btnEncadrant = new JButton("Encadrant");
		btnEncadrant.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Encadrant fenetre1 = new Encadrant();
				fenetre1.frame.setVisible(true);
				fenetre1.frame.setLocationRelativeTo(null);
				frame.dispose();
			}
		});
		btnEncadrant.setForeground(SystemColor.text);
		btnEncadrant.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEncadrant.setBackground(new Color(128, 0, 0));
		btnEncadrant.setBounds(10, 146, 176, 34);
		panel_1.add(btnEncadrant);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Rechercher fenetre1 = new Rechercher();
				fenetre1.frame.setVisible(true);
				fenetre1.frame.setLocationRelativeTo(null);
				frame.dispose();
			}
		});
		btnRechercher.setForeground(SystemColor.text);
		btnRechercher.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRechercher.setBackground(new Color(128, 0, 0));
		btnRechercher.setBounds(10, 192, 176, 34);
		panel_1.add(btnRechercher);
		
		JButton btnGestionDesComptes = new JButton("Gestion des comptes");
		btnGestionDesComptes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				GestionComptes fenetre1 = new GestionComptes();
				fenetre1.frame.setVisible(true);
				fenetre1.frame.setLocationRelativeTo(null);
				frame.dispose();
			
			}
		});
		btnGestionDesComptes.setForeground(SystemColor.text);
		btnGestionDesComptes.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGestionDesComptes.setBackground(new Color(128, 0, 0));
		btnGestionDesComptes.setBounds(10, 237, 176, 34);
		panel_1.add(btnGestionDesComptes);
		
		JButton btnEnvoyerEmail = new JButton("Supprimer stagiare");
		btnEnvoyerEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				SupprimerStagiare fenetre1 = new SupprimerStagiare();
				fenetre1.frame.setVisible(true);
				fenetre1.frame.setLocationRelativeTo(null);
				frame.dispose();
			}
		});
		btnEnvoyerEmail.setForeground(SystemColor.text);
		btnEnvoyerEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEnvoyerEmail.setBackground(new Color(128, 0, 0));
		btnEnvoyerEmail.setBounds(10, 282, 176, 34);
		panel_1.add(btnEnvoyerEmail);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.setBounds(0, 405, 196, 151);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setWeekdayForeground(new Color(255, 255, 255));
		calendar.setSundayForeground(new Color(255, 0, 0));
		calendar.setForeground(new Color(0, 0, 0));
		calendar.setDecorationBackgroundColor(new Color(128, 0, 0));
		calendar.setBackground(new Color(128, 0, 0));
		calendar.setBounds(0, 0, 196, 153);
		panel_2.add(calendar);
		
		JLabel lblNewLabel_1 = new JLabel("Bienvenu dans notre application de gestion des stagiares !\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(286, 156, 727, 81);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnDconnexion = new JButton("Déconnexion");
		btnDconnexion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				PagePrincipale fenetre1 = new PagePrincipale();
				fenetre1.frame.setVisible(true);
				fenetre1.frame.setLocationRelativeTo(null);
				frame.dispose();
				
			}
		});
		btnDconnexion.setForeground(new Color(128, 0, 0));
		btnDconnexion.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDconnexion.setBackground(Color.WHITE);
		btnDconnexion.setBounds(858, 440, 176, 34);
		frame.getContentPane().add(btnDconnexion);
		
		JLabel lblNewLabel_2 = new JLabel("Tous droits réservés © 2023");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(20, 535, 1063, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("<html>\r\nNotre application est conçue pour simplifier et rationaliser le processus de gestion des stagiaires au sein de votre organisation. <br>Que vous soyez une entreprise, une institution d'enseignement ou toute autre entité proposant des stages, notre application vous offre les outils nécessaires pour gérer efficacement toutes les informations liées aux stagiaires.\r\n</html>");
		lblNewLabel_3.setBackground(new Color(72, 61, 139));
		lblNewLabel_3.setForeground(new Color(128, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(442, 248, 452, 156);
		frame.getContentPane().add(lblNewLabel_3);

	}
}
