package gestion_stagiares_ocp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.mysql.cj.xdevapi.Statement;
import com.toedter.calendar.JCalendar;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class AjouterStagiare {

	JFrame frame;
	private JTextField NomField;
	private JTextField PrenomField;
	private JTextField FiliereField;
	private JTextField EcoleField;
	private JTextField AnneeField;
	private JTextField EmailField;
	private JTextField AdresseField;
	private JTextField id_encadrantField;
	private JTextField nombreAbsenceField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterStagiare window = new AjouterStagiare();
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
	public AjouterStagiare() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Ajouter stagiare");
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
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				PageAccueil fenetre1 = new PageAccueil();
				fenetre1.frame.setVisible(true);
				fenetre1.frame.setLocationRelativeTo(null);
				frame.dispose();
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1063, 52);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\gestion_stagiares_ocp\\images\\left-arrow.png"));
		lblNewLabel_4.setBounds(10, 11, 33, 34);
		panel.add(lblNewLabel_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 65, 196, 328);
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
		
		final JButton btnAjouterStagiare = new JButton("Ajouter Stagiare");
		btnAjouterStagiare.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AjouterStagiare fenetre1 = new AjouterStagiare();
				fenetre1.frame.setVisible(true);
				fenetre1.frame.setLocationRelativeTo(null);
				frame.dispose();
			}
		});
		
		btnAjouterStagiare.setForeground(new Color(128, 0, 0));
		btnAjouterStagiare.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAjouterStagiare.setBackground(new Color(255, 255, 255));
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
		
		JButton btnEnvoyerEmail = new JButton("Supprimer Stagiare");
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
		panel_2.setBounds(0, 404, 196, 152);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setWeekdayForeground(new Color(255, 255, 255));
		calendar.setSundayForeground(new Color(128, 0, 0));
		calendar.setDecorationBackgroundColor(new Color(128, 0, 0));
		calendar.setBackground(new Color(255, 255, 255));
		calendar.setBounds(0, 0, 186, 153);
		panel_2.add(calendar);
		
		JLabel lblNewLabel_1 = new JLabel("Veuillez remplir les champs ci-dessous\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(261, 78, 727, 44);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Tous droits réservés © 2023");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(20, 535, 1063, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(228, 150, 816, 314);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Nom :");
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel_3.setForeground(new Color(128, 0, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3.setBounds(20, 33, 91, 27);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Prénom :");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_3_1.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(20, 84, 91, 27);
		panel_3.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Filiére :");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_3_1_1.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel_3_1_1.setBounds(20, 138, 91, 27);
		panel_3.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Ecole :");
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_3_1_1_1.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel_3_1_1_1.setBounds(20, 197, 91, 27);
		panel_3.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("Année :");
		lblNewLabel_3_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_3_1_1_2.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel_3_1_1_2.setBounds(20, 255, 91, 27);
		panel_3.add(lblNewLabel_3_1_1_2);
		
		JLabel lblNewLabel_3_1_1_3 = new JLabel("Email :");
		lblNewLabel_3_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1_3.setForeground(new Color(128, 0, 0));
		lblNewLabel_3_1_1_3.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel_3_1_1_3.setBounds(471, 50, 91, 27);
		panel_3.add(lblNewLabel_3_1_1_3);
		
		JLabel lblNewLabel_3_1_1_4 = new JLabel("Adresse :");
		lblNewLabel_3_1_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1_4.setForeground(new Color(128, 0, 0));
		lblNewLabel_3_1_1_4.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel_3_1_1_4.setBounds(471, 115, 91, 27);
		panel_3.add(lblNewLabel_3_1_1_4);
		
		JLabel lblNewLabel_3_1_1_5 = new JLabel("Encadrant :");
		lblNewLabel_3_1_1_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1_5.setForeground(new Color(128, 0, 0));
		lblNewLabel_3_1_1_5.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel_3_1_1_5.setBounds(471, 174, 91, 27);
		panel_3.add(lblNewLabel_3_1_1_5);
		
		JLabel lblNewLabel_3_1_1_6 = new JLabel("Absence :");
		lblNewLabel_3_1_1_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_3_1_1_6.setForeground(new Color(128, 0, 0));
		lblNewLabel_3_1_1_6.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel_3_1_1_6.setBounds(471, 236, 91, 27);
		panel_3.add(lblNewLabel_3_1_1_6);
		
		NomField = new JTextField();
		NomField.setBounds(119, 34, 151, 27);
		panel_3.add(NomField);
		NomField.setColumns(10);
		
		PrenomField = new JTextField();
		PrenomField.setColumns(10);
		PrenomField.setBounds(119, 85, 151, 27);
		panel_3.add(PrenomField);
		
		FiliereField = new JTextField();
		FiliereField.setColumns(10);
		FiliereField.setBounds(119, 139, 151, 27);
		panel_3.add(FiliereField);
		
		EcoleField = new JTextField();
		EcoleField.setColumns(10);
		EcoleField.setBounds(119, 198, 151, 27);
		panel_3.add(EcoleField);
		
		AnneeField = new JTextField();
		AnneeField.setColumns(10);
		AnneeField.setBounds(119, 256, 151, 27);
		panel_3.add(AnneeField);
		
		EmailField = new JTextField();
		EmailField.setColumns(10);
		EmailField.setBounds(593, 51, 151, 27);
		panel_3.add(EmailField);
		
		AdresseField = new JTextField();
		AdresseField.setColumns(10);
		AdresseField.setBounds(593, 116, 151, 27);
		panel_3.add(AdresseField);
		
		id_encadrantField = new JTextField();
		id_encadrantField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				id_encadrantField.setToolTipText("veuillez saisir id de l'encadrant");
			}
		});
		id_encadrantField.setColumns(10);
		id_encadrantField.setBounds(593, 175, 151, 27);
		panel_3.add(id_encadrantField);
		
		nombreAbsenceField = new JTextField();
		nombreAbsenceField.setColumns(10);
		nombreAbsenceField.setBounds(593, 237, 151, 27);
		panel_3.add(nombreAbsenceField);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				//Ajouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuut
				
				// Récupérer les valeurs des champs textuels
				String nom = NomField.getText();
				String prenom = PrenomField.getText();
				String filiere = FiliereField.getText();
				String ecole = EcoleField.getText();
				String annee = AnneeField.getText();
				String email = EmailField.getText();
				String adresse = AdresseField.getText();
				
				String idEncadrantText = id_encadrantField.getText();
				String absenceText = nombreAbsenceField.getText();

				// Vérifier si les champs sont vides
				if (nom.isEmpty() || prenom.isEmpty() || filiere.isEmpty() || ecole.isEmpty() ||
				    annee.isEmpty() || email.isEmpty() || adresse.isEmpty() || idEncadrantText.isEmpty() ||
				    absenceText.isEmpty()) {
				    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
				} else {
				    // Vérifier si les champs numériques sont valides
				    int idEncadrant;
				    int absence;
				    try {
				        idEncadrant = Integer.parseInt(idEncadrantText);
				        absence = Integer.parseInt(absenceText);
				    } catch (NumberFormatException ex) {
				        JOptionPane.showMessageDialog(null, "Veuillez entrer des valeurs numériques valides pour les champs d'entier.", "Erreur", JOptionPane.ERROR_MESSAGE);
				        return;
				    }
				
				// Informations de connexion à la base de données
				String jdbcUrl = "jdbc:mysql://localhost:3306/gestionstagiareocp";
				String username = "root";
				String password = "";

				try {
				    // Établir la connexion à la base de données
				    Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
				    
				    // Préparer la première requête SQL pour insérer les données dans la table 'stagiare'
				    String sqlQueryStagiare = "INSERT INTO stagiare (Nom, Prénom, Filiére, Ecole, Année, Email, Adresse, id_encadrant) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				    PreparedStatement statementStagiare = connection.prepareStatement(sqlQueryStagiare, PreparedStatement.RETURN_GENERATED_KEYS);
				    statementStagiare.setString(1, nom);
				    statementStagiare.setString(2, prenom);
				    statementStagiare.setString(3, filiere);
				    statementStagiare.setString(4, ecole);
				    statementStagiare.setString(5, annee);
				    statementStagiare.setString(6, email);
				    statementStagiare.setString(7, adresse);
				    statementStagiare.setInt(8, idEncadrant);
				    
				    // Exécuter la première requête d'insertion
				    int rowsAffectedStagiare = statementStagiare.executeUpdate();
				    
				    // Récupérer l'identifiant du stagiaire inséré
				    ResultSet generatedKeys = statementStagiare.getGeneratedKeys();
				    int idStagiare = -1;
				    if (generatedKeys.next()) {
				        idStagiare = generatedKeys.getInt(1);
				    }
				    
				    // Fermer les ressources de la première requête
				    generatedKeys.close();
				    statementStagiare.close();
				    
				    // Préparer la deuxième requête SQL pour insérer les données dans la table 'absence'
				    String sqlQueryAbsence = "INSERT INTO absence (absence, id_stagiare) VALUES (?, ?)";
				    PreparedStatement statementAbsence = connection.prepareStatement(sqlQueryAbsence);
				    statementAbsence.setInt(1, absence);
				    statementAbsence.setInt(2, idStagiare);
				    
				    // Exécuter la deuxième requête d'insertion
				    int rowsAffectedAbsence = statementAbsence.executeUpdate();
				    
				    // Fermer les ressources de la deuxième requête
				    statementAbsence.close();
				    
				    if (rowsAffectedStagiare > 0 && rowsAffectedAbsence > 0) {
						JOptionPane.showConfirmDialog(null, "Les données ont été enregistrées avec succès dans la base de données.","saisi avec succés",JOptionPane.ERROR_MESSAGE);
						
				    } else {
						JOptionPane.showConfirmDialog(null, "Une erreur s'est produite lors de l'enregistrement des données dans la base de données.","opération échoué",JOptionPane.ERROR_MESSAGE);
				    }
				    
				    NomField.setText("");
					PrenomField.setText("");
					FiliereField.setText("");
					EcoleField.setText("");
					AnneeField.setText("");
					EmailField.setText("");
					AdresseField.setText("");
					id_encadrantField.setText("");
					nombreAbsenceField.setText("");
				    
				    // Fermer la connexion à la base de données
				    connection.close();
				} catch (SQLException ex) {
				    ex.printStackTrace();
				}


				}

				
				//Ajouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuut
			}
		});
		btnEnregistrer.setForeground(Color.WHITE);
		btnEnregistrer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEnregistrer.setBackground(new Color(0, 128, 128));
		btnEnregistrer.setBounds(849, 475, 176, 55);
		frame.getContentPane().add(btnEnregistrer);
	}
}
