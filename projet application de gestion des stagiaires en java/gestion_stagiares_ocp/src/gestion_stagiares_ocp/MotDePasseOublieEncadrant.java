package gestion_stagiares_ocp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.UIManager;

public class MotDePasseOublieEncadrant {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MotDePasseOublieEncadrant window = new MotDePasseOublieEncadrant();
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
	public MotDePasseOublieEncadrant() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Mot de passe oublié ");
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\\\\\\\Users\\\\\\\\hp\\\\\\\\eclipse-workspace\\\\\\\\gestion_stagiares_ocp\\\\\\\\images\\\\\\\\1.png");  
		frame.setIconImage(icon);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(253, 245, 230));
		panel.setBounds(0, 0, 436, 263);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel Login = new JLabel("Login :");
		Login.setFont(new Font("Tahoma", Font.BOLD, 13));
		Login.setBounds(28, 37, 142, 29);
		panel.add(Login);
		
		JLabel lblQuestionSecret = new JLabel("Question secréte :");
		lblQuestionSecret.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuestionSecret.setBounds(28, 93, 142, 29);
		panel.add(lblQuestionSecret);
		
		JLabel lblRponse = new JLabel("Réponse :");
		lblRponse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRponse.setBounds(28, 149, 142, 29);
		panel.add(lblRponse);
		
		textField = new JTextField();
		textField.setBackground(UIManager.getColor("Button.highlight"));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(211, 33, 215, 29);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(UIManager.getColor("Button.highlight"));
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(211, 149, 215, 29);
		panel.add(textField_1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Quel est votre numéro de télèphone ?"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(211, 93, 215, 29);
		panel.add(comboBox);
		
		final JButton btnValider = new JButton("Valider");
		btnValider.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//codeeeeeeeeeeeeeeeeeeeeeeeeeeerrrrrrrrs
				//connexion à la base de données et vérification de login et mot de passe de l'utilisateur
				if(textField.getText().equals("")|| textField_1.getText().equals("")||comboBox.getSelectedItem().equals(""))
			        JOptionPane.showMessageDialog(null, "Veuillez  remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
				else {
					PreparedStatement ps;
					ResultSet rs;
					String login=textField.getText();
					String question=(String) comboBox.getSelectedItem();
					String reponse=textField_1.getText();
					

					String query = "SELECT motdepasse FROM gestionstagiareocp.administrateur WHERE login=? AND telephone=?;";
					try {
						ps= ConnexionDB.getConnection().prepareStatement(query);
						ps.setString(1, login);
						ps.setString(2, reponse);
						rs=ps.executeQuery();
						

						String motdepasse="";
						if(rs.next()) {
							 motdepasse=rs.getString("motdepasse");
							 }
						// Afficher le mot de passe de l'encadrant dans une boîte de dialogue JOptionPane
			            if (!motdepasse.isEmpty()) {
					        JOptionPane.showMessageDialog(null, "Votre mot de passe est "+motdepasse+ " .", "valide", JOptionPane.ERROR_MESSAGE);
					        PagePrincipale fenetre1 =new PagePrincipale();
							fenetre1.frame.setVisible(true);
							fenetre1.frame.setLocationRelativeTo(null);
							frame.dispose();
			            } else {
			                JOptionPane.showMessageDialog(null, "Aucun utilisateur trouvé avec ces identifiants !");
			            }
					}catch(Exception ex) {
						JOptionPane.showConfirmDialog(null, "Erreur lors de la connexion avec la base de données!!");
						ex.printStackTrace();
			}
		}
				//codeeeeeeeeeeeeeeeeeeeeeeeeeeerrrrrrrrs

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnValider.setBackground(Color.white);
				btnValider.setForeground(SystemColor.textHighlight);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnValider.setBackground(SystemColor.textHighlight);
				btnValider.setForeground(Color.WHITE);
			}
		});
		btnValider.setBackground(SystemColor.textHighlight);
		btnValider.setForeground(Color.WHITE);
		btnValider.setBounds(57, 200, 142, 37);
		panel.add(btnValider);
		
		final JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				PagePrincipale fenetre1 = new PagePrincipale();
				fenetre1.frame.setVisible(true);
				fenetre1.frame.setLocationRelativeTo(null);
				frame.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAnnuler.setBackground(Color.WHITE);
				btnAnnuler.setForeground(SystemColor.textHighlight);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAnnuler.setForeground(Color.WHITE);
				btnAnnuler.setBackground(SystemColor.textHighlight);
			}
		});
		btnAnnuler.setForeground(Color.WHITE);
		btnAnnuler.setBackground(SystemColor.textHighlight);
		btnAnnuler.setBounds(254, 200, 142, 37);
		panel.add(btnAnnuler);
	}
}
