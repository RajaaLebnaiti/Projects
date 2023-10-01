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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

public class SupprimerStagiare {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupprimerStagiare window = new SupprimerStagiare();
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
	public SupprimerStagiare() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Rechercher");
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 0, 0));
		btnNewButton.setBounds(10, 11, 176, 34);
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
		btnRechercher.setForeground(new Color(255, 255, 255));
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
		btnEnvoyerEmail.setForeground(new Color(128, 0, 0));
		btnEnvoyerEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEnvoyerEmail.setBackground(new Color(255, 255, 255));
		btnEnvoyerEmail.setBounds(10, 282, 176, 34);
		panel_1.add(btnEnvoyerEmail);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.setBounds(0, 404, 196, 152);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(0, 0, 186, 153);
		panel_2.add(calendar);
		
		JLabel lblNewLabel_1 = new JLabel("Rechercher : \r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(206, 89, 218, 46);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Tous droits réservés © 2023");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 555, 1063, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Veuillez saisir le nom du stagiare à supprimer: ");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(206, 146, 304, 32);
		frame.getContentPane().add(lblNewLabel_4);
		
		final JTextField textField = new JTextField();
		textField.setBounds(520, 141, 176, 37);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnRechercher_1 = new JButton("Rechercher");
		btnRechercher_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				

				//Ajouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuut
				
				// Récupérer les valeurs des champs textuels
				String nom = textField.getText();

				// Vérifier si les champs sont vides
				if (nom.isEmpty()) {
				    JOptionPane.showMessageDialog(null, "Veuillez saisir le nom recherché.", "Erreur", JOptionPane.ERROR_MESSAGE);
				} else {
				    // Informations de connexion à la base de données
				    final String jdbcUrl = "jdbc:mysql://localhost:3306/gestionstagiareocp";
				    final String username = "root";
				    final String password = "";

				    try {
				        // Établir la connexion à la base de données
				        Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

				        // Préparer la requête SQL pour sélectionner les informations du stagiaire
				        String sqlQuery = "SELECT Nom,Prénom,Filiére,Ecole,Année,Email,Adresse FROM stagiare WHERE Nom = ?";

				        PreparedStatement statement = connection.prepareStatement(sqlQuery);
				        statement.setString(1, nom);

				        // Exécuter la requête SQL
				        ResultSet resultSet = statement.executeQuery();

				        // Créer un modèle de tableau pour les données
				        DefaultTableModel tableModel = new DefaultTableModel();
				        tableModel.addColumn("Nom");
				        tableModel.addColumn("Prénom");
				        tableModel.addColumn("Filière");
				        tableModel.addColumn("École");
				        tableModel.addColumn("Année");
				        tableModel.addColumn("Email");
				        tableModel.addColumn("Adresse");
				        ;

				        // Remplir le modèle de tableau avec les données
				        while (resultSet.next()) {
				            String Nom= resultSet.getString("Nom");
				            String Prénom = resultSet.getString("Prénom");
				            String filiere = resultSet.getString("Filiére");
				            String ecole = resultSet.getString("Ecole");
				            String annee = resultSet.getString("Année");
				            String email = resultSet.getString("Email");
				            String adresse = resultSet.getString("Adresse");
				           

				            Object[] rowData = {Nom, Prénom, filiere, ecole, annee, email, adresse};
				            tableModel.addRow(rowData);
				        }

				        // Créer la table et l'afficher dans votre fenêtre
				        final JTable table = new JTable(tableModel);
				        JScrollPane scrollPane = new JScrollPane(table);

				        frame.getContentPane().add(scrollPane);
				        scrollPane.setBounds(219, 213, 837, 128);
				        
				     // Create the delete button
				        JButton btnSupprimer = new JButton("Supprimer");
				       
				        btnSupprimer.addActionListener(new ActionListener() {
				            @Override
				            public void actionPerformed(ActionEvent e) {
				                int selectedRow = table.getSelectedRow();
				                if (selectedRow != -1) { // Check if a row is selected
				                    String nomToDelete = table.getValueAt(selectedRow, 0).toString(); // Assuming the student's name is in the first column

				                    int confirmResult = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer " + nomToDelete + " ?", "Confirmation", JOptionPane.YES_NO_OPTION);
				                    if (confirmResult == JOptionPane.YES_OPTION) {
				                        try {
				                            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

				                            String deleteAbsenceQuery = "DELETE FROM absence WHERE id_stagiare IN (SELECT id_stagiare FROM stagiare WHERE Nom = ?)";
				                            PreparedStatement deleteAbsenceStatement = connection.prepareStatement(deleteAbsenceQuery);
				                            deleteAbsenceStatement.setString(1, nomToDelete);
				                            deleteAbsenceStatement.executeUpdate();
				                            deleteAbsenceStatement.close();

				                          
				                            // Supprimer le stagiaire
				                            String deleteStagiaireQuery = "DELETE FROM stagiare WHERE Nom = ?";
				                            PreparedStatement deleteStagiaireStatement = connection.prepareStatement(deleteStagiaireQuery);
				                            deleteStagiaireStatement.setString(1, nomToDelete);
				                            int deletedRows = deleteStagiaireStatement.executeUpdate();
				                            deleteStagiaireStatement.close();

				                            if (deletedRows > 0) {
				                                // Remove the selected row from the table model
				                                ((DefaultTableModel) table.getModel()).removeRow(selectedRow);

				                                JOptionPane.showMessageDialog(null, "Le stagiaire a été supprimé avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
				                            } else {
				                                JOptionPane.showMessageDialog(null, "Échec de la suppression du stagiaire.", "Erreur", JOptionPane.ERROR_MESSAGE);
				                            }

				                            // Close the connection
				                            connection.close();
				                        } catch (SQLException ex) {
				                            ex.printStackTrace();
				                        }
				                    }
				                } else {
				                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un stagiaire à supprimer.", "Erreur", JOptionPane.ERROR_MESSAGE);
				                }
				            }
				        });


				        // Add the delete button to the frame
				        btnSupprimer.setForeground(new Color(128, 0, 0));
				        btnSupprimer.setFont(new Font("Tahoma", Font.BOLD, 15));
				        btnSupprimer.setBackground(new Color(255, 255, 255));
				        btnSupprimer.setBounds(578, 425, 163, 32);
				        frame.getContentPane().add(btnSupprimer);


				        // Fermer la connexion à la base de données
				        connection.close();
				    } catch (SQLException ex) {
				        ex.printStackTrace();
				    }
				}

				
				//Ajouuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuut
			}
		});
		
		
		
		btnRechercher_1.setIcon(null);
		btnRechercher_1.setForeground(new Color(128, 0, 0));
		btnRechercher_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRechercher_1.setBackground(new Color(255, 255, 255));
		btnRechercher_1.setBounds(793, 144, 163, 32);
		frame.getContentPane().add(btnRechercher_1);
		
		

	}
}
