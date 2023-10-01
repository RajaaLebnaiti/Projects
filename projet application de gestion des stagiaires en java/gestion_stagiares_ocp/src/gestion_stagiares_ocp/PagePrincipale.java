package gestion_stagiares_ocp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;


import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PagePrincipale {

	JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	
	@SuppressWarnings("deprecation")
	//ajjouuut
	//methode qui verifie que les zones de texte sont non vide
		boolean checkEmptyFields(){
			return(textField.getText().equals("")||passwordField.getText().equals(""));
				
		}
	//ajouuuut

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PagePrincipale window = new PagePrincipale();
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
	public PagePrincipale() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Authentification");
		frame.setResizable(false);
		Image icon = Toolkit.getDefaultToolkit().getImage("C:\\\\\\\\Users\\\\\\\\hp\\\\\\\\eclipse-workspace\\\\\\\\gestion_stagiares_ocp\\\\\\\\images\\\\\\\\1.png");  
		frame.setIconImage(icon);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(250, 240, 230)));
		panel.setBackground(new Color(253, 245, 230));
		panel.setBounds(0, 0, 436, 307);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(204, 153, 153)));
		panel_1.setBounds(102, 36, 250, 216);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				textField.setToolTipText("veuillez saisir votre nom d'utilisateur");
			}
		});
		textField.setBounds(63, 66, 147, 31);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Connexion");
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 230, 44);
		panel_1.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				passwordField.setToolTipText("veuillez saisir votre mot de passe");

			}
		});
		passwordField.setBounds(63, 108, 147, 31);
		panel_1.add(passwordField);
		
		JButton btnNewButton = new JButton("Se Connecter");
		
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				//connexion à la base de données et vérification de login et mot de passe de l'utilisateur
				if(checkEmptyFields())
			        JOptionPane.showMessageDialog(null, "Veuillez  remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
				else {
					PreparedStatement ps;
					ResultSet rs;
					String login=textField.getText();
					@SuppressWarnings("deprecation")
					String motdepasse=passwordField.getText();
					

					String query = "SELECT * FROM gestionstagiareocp.administrateur WHERE login=? AND motdepasse=?;  ";
					try {
						ps= ConnexionDB.getConnection().prepareStatement(query);
						ps.setString(1, login);
						ps.setString(2, motdepasse);
						rs=ps.executeQuery();
						if(rs.next()) {
							
							PageAccueil fenetre1 =new PageAccueil();
							fenetre1.frame.setVisible(true);
							fenetre1.frame.setLocationRelativeTo(null);
							frame.dispose();
						}
						else {
					        JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe non valides.", "Erreur", JOptionPane.ERROR_MESSAGE);
						}
					}catch(Exception ex) {
						JOptionPane.showConfirmDialog(null, "Erreur lors de la connexion avec la base de données!!");
						ex.printStackTrace();
			}
		}}});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(30, 144, 255));
		btnNewButton.setBounds(73, 149, 124, 31);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\gestion_stagiares_ocp\\images\\3741756-bussiness-ecommerce-marketplace-onlinestore-store-user_108907.png"));
		lblNewLabel_1.setBounds(20, 66, 36, 31);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\r\n");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\gestion_stagiares_ocp\\images\\password_security_icon_154431.png"));
		lblNewLabel_1_1.setBounds(17, 108, 36, 31);
		panel_1.add(lblNewLabel_1_1);
		
		final JLabel hide = new JLabel("");
	
		
		hide.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\gestion_stagiares_ocp\\images\\hide.png"));
		hide.setBounds(216, 108, 24, 31);
		panel_1.add(hide);
		
		final JLabel show = new JLabel("");
		//show password
		show.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				show.setVisible(false);
				hide.setVisible(true);
				passwordField .setEchoChar((char)0);
			}
		});
		
		//hide password
		hide.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				show.setVisible(true);
				hide.setVisible(false);
				passwordField .setEchoChar('*');

			}
		});
		
		
		show.setIcon(new ImageIcon("C:\\Users\\hp\\eclipse-workspace\\gestion_stagiares_ocp\\images\\view.png"));
		show.setBounds(216, 108, 24, 31);
		panel_1.add(show);
		//aeroport  publipostage  conception devellopement teste 
		
		JLabel mdpOublie = new JLabel("Mot de passe oublié ?");
		mdpOublie.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				MotDePasseOublieEncadrant fenetre1 = new MotDePasseOublieEncadrant();
				fenetre1.frame.setVisible(true);
				fenetre1.frame.setLocationRelativeTo(null);
				frame.dispose();
			}
		});
		mdpOublie.setFont(new Font("Arial", Font.PLAIN, 10));
		mdpOublie.setForeground(Color.RED);
		mdpOublie.setHorizontalAlignment(SwingConstants.CENTER);
		mdpOublie.setBounds(22, 191, 218, 14);
		panel_1.add(mdpOublie);
		
		hide.setVisible(false);
		frame.setLocationRelativeTo(null);
	}
}
