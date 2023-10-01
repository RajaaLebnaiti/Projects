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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import com.toedter.calendar.JCalendar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class Encadrant {

	JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Encadrant window = new Encadrant();
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
	public Encadrant() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Encadrants");
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
		lblNewLabel.setBackground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 34));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 1063, 52);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\gestion_stagiares_ocp\\images\\left-arrow.png"));
		lblNewLabel_3.setBounds(10, 11, 36, 45);
		panel.add(lblNewLabel_3);
		
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
		btnEncadrant.setForeground(new Color(128, 0, 0));
		btnEncadrant.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEncadrant.setBackground(new Color(255, 255, 255));
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
		
		JLabel lblNewLabel_1 = new JLabel("Liste des encadrants disponibles : \r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(284, 78, 727, 81);
		frame.getContentPane().add(lblNewLabel_1);
		
		

		//Ajouuuuuuuuuuuuuuuuuuuuuuuuuuuuuut
		 // Informations de connexion à la base de données
        String jdbcUrl = "jdbc:mysql://localhost:3306/gestionstagiareocp";
        String username = "root";
        String password = "";

        // Créer le modèle de tableau
        String[] columnNames = {"Num","Nom", "Prénom", "Télèphone", "Domaine", "Sujet_Proposé", "Disponibilité", "login", "motdepasse"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        try {
            // Établir la connexion à la base de données
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Créer la requête SQL
            String sqlQuery = "SELECT * FROM  encadrant;";

            // Créer l'objet Statement pour exécuter la requête
            java.sql.Statement statement = connection.createStatement();

            // Exécuter la requête SQL
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            
         // Compteur pour le numéro de ligne
            int rowCount = 1;

            // Parcourir les résultats de la requête et ajouter les données au modèle de tableau
            while (resultSet.next()) {

                String nom = resultSet.getString("Nom");
                String prenom = resultSet.getString("Prénom");
                String telephone = resultSet.getString("Télèphone");
                String domaine = resultSet.getString("Domaine");
                String sujet_Proposé = resultSet.getString("Sujet_Proposé");
                String disponibilité = resultSet.getString("Disponibilité");
                String Login = resultSet.getString("login");
                String Motdepasse = resultSet.getString("motdepasse");

                Object[] rowData = {rowCount,nom, prenom, telephone, domaine, sujet_Proposé, disponibilité,Login, Motdepasse};
                tableModel.addRow(rowData);
                rowCount++;
            }

            // Fermer les ressources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Créer le tableau avec le modèle de données
        JTable table = new JTable(tableModel);
        table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 0, 0)));
        table.setBackground(new Color(192, 192, 192));

        // Créer le JScrollPane contenant le tableau
        JScrollPane scrollPane = new JScrollPane(table);

        // Ajouter le JScrollPane à la fenêtre
        frame.getContentPane().add(scrollPane);
        scrollPane.setBounds(219, 143, 837, 328);
		
			//Ajouuuuuuuuuuuuuuuuuuuuuuuuuuuuuut
		
		
	
		JLabel lblNewLabel_2 = new JLabel("Tous droits réservés © 2023");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(20, 535, 1063, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		

	}
}
