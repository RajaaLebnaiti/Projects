package gestion_stagiares_ocp;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;
import com.toedter.calendar.JCalendar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.border.MatteBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class ListeStagiares {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListeStagiares window = new ListeStagiares();
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
	public ListeStagiares() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Liste des stagiares");
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
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\gestion_stagiares_ocp\\images\\left-arrow.png"));
		lblNewLabel_3.setBounds(10, 11, 30, 34);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 65, 196, 328);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Liste des stagiares");
		panel_1.add(btnNewButton);
		
		
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
		btnNewButton.setForeground(new Color(128, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
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
		
		
		JLabel lblNewLabel_1 = new JLabel("Liste des stagiaires\r\n");
		
		
		//Ajouuuuuuuuuuuuuuuuuuuuuuuuuuuuuut
		 // Informations de connexion à la base de données
        String jdbcUrl = "jdbc:mysql://localhost:3306/gestionstagiareocp";
        String username = "root";
        String password = "";

        // Créer le modèle de tableau
        String[] columnNames = {"Num","Nom", "Prénom", "Filière", "École", "Année", "Email", "Adresse", "Nom encadrant", "Absence"};
        final DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        try {
            // Établir la connexion à la base de données
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Créer la requête SQL
            String sqlQuery = "SELECT stagiare.*, encadrant.Nom AS 'Nom encadrant', absence FROM stagiare, encadrant, absence WHERE stagiare.id_encadrant=encadrant.id_encadrant AND absence.id_stagiare=stagiare.id_stagiare;";

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
                String filiere = resultSet.getString("Filiére");
                String ecole = resultSet.getString("Ecole");
                String annee = resultSet.getString("Année");
                String email = resultSet.getString("Email");
                String adresse = resultSet.getString("Adresse");
                String encadrant = resultSet.getString("Nom encadrant");
                String absence = resultSet.getString("absence");

                Object[] rowData = {rowCount,nom, prenom, filiere, ecole, annee, email, adresse, encadrant, absence};
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
        final JTable table = new JTable(tableModel);
        table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 0, 0)));
        table.setBackground(new Color(192, 192, 192));

        // Créer le JScrollPane contenant le tableau
        JScrollPane scrollPane = new JScrollPane(table);

        // Ajouter le JScrollPane à la fenêtre
        frame.getContentPane().add(scrollPane);
        scrollPane.setBounds(219, 229, 837, 242);
		
        
    
			//Ajouuuuuuuuuuuuuuuuuuuuuuuuuuuuuut
        table.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE && e.getColumn() == tableModel.findColumn("Absence")) {
                    int row = e.getFirstRow();
                    String absence = (String) tableModel.getValueAt(row, tableModel.findColumn("Absence"));
                    // Appel à une méthode pour mettre à jour la base de données avec la nouvelle valeur d'absence
                    updateAbsenceValue(row, absence);
                }
            }

			private void updateAbsenceValue(int row, String absence) {
				  try {
				        // Établir la connexion à la base de données
					   String jdbcUrl = "jdbc:mysql://localhost:3306/gestionstagiareocp";
				        String username = "root";
				        String password = "";
				        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

				        // Récupérer l'identifiant du stagiaire correspondant à la ligne modifiée
				        int stagiareId = (int) tableModel.getValueAt(row, tableModel.findColumn("Num"));

				        // Créer la requête SQL pour mettre à jour la valeur d'absence
				        String sqlQuery = "UPDATE absence SET absence = ? WHERE id_stagiare = ?";

				        // Préparer la requête avec les paramètres nécessaires
				        PreparedStatement statement = connection.prepareStatement(sqlQuery);
				        statement.setString(1, absence);
				        statement.setInt(2, stagiareId);

				        // Exécuter la requête de mise à jour
				        statement.executeUpdate();

				        // Fermer les ressources
				        statement.close();
				        connection.close();
				        // Appliquer le rendu personnalisé à la colonne "Absence"
				        TableColumn absenceColumn = table.getColumnModel().getColumn(tableModel.findColumn("Absence"));
				        absenceColumn.setCellRenderer(new CustomTableCellRenderer(tableModel));
				    } catch (SQLException ex) {
				        ex.printStackTrace();
				    }				
			}
        });
        
        
     	
  

        //ajouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuut
		
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(275, 93, 727, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.setBounds(0, 404, 196, 152);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(0, 0, 186, 153);
		panel_2.add(calendar);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Tous droits réservés © 2023");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(20, 535, 1063, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Veuillez clicker sur le colonne Absence pour la modifier ");
		lblNewLabel_4.setBounds(410, 163, 536, 20);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		//ajouuuuutttt
		
		
		//ajouuuuuut
		

}	
}
