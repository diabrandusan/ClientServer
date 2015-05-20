package client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import client.UserDataAccess;
import database.User;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel labelt;
	private JButton loginButton;
	private JTextField usernameText;
	private JPasswordField passwordText;
	private JMenuBar menuBar;
	private JMenu menu;
	public static UserDataAccess loggedUser = null;

	public MainWindow() {
		this.setSize(500, 400);

		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.initComponenteMain();

	}

	public void initComponenteMain() {

		labelt = new JLabel("Va rugam sa introduceti username-ul si parola:");
		labelt.setBounds(20, 35, 1000, 50);
		labelt.setForeground(Color.white);
		labelt.setFont(new Font("Times New Roman", Font.BOLD, 18));

		usernameLabel = new JLabel("Username: ");
		usernameLabel.setBounds(50, 100, 150, 20);
		usernameLabel.setForeground(Color.white);
		usernameLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(50, 120, 150, 20);
		passwordLabel.setForeground(Color.white);
		passwordLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));

		usernameText = new JTextField();
		usernameText.setBounds(150, 100, 100, 20);
		passwordText = new JPasswordField();
		passwordText.setBounds(150, 120, 100, 20);

		usernameLabel.setVisible(true);
		passwordLabel.setVisible(true);
		usernameText.setVisible(true);
		passwordText.setVisible(true);
		labelt.setVisible(true);

		loginButton = new JButton("Login");
		loginButton.setBounds(100, 190, 100, 30);
		// loginButton.addActionListener(this);

		menu = new JMenu("Login");
		menu.setForeground(Color.white);
		menu.setBackground(Color.BLACK);
		menuBar = new JMenuBar();
		menuBar.add(menu);

		menuBar.setBackground(Color.BLACK);
		menuBar.setBorder(BorderFactory.createRaisedBevelBorder());
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 500, 400);
		panel.setBackground(Color.black);
		panel.add(labelt);
		panel.add(usernameLabel);
		panel.add(passwordLabel);
		panel.add(usernameText);
		panel.add(passwordText);
		panel.add(loginButton);
		// panel.setVisible(true);
		this.setJMenuBar(menuBar);
		this.add(panel);
		this.repaint();

		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameText.getText();
				String password = new String(passwordText.getPassword());
				UserDataAccess uda = new UserDataAccess();

				try {

					User user = uda.login(username, password);
					loggedUser = uda;

					System.out.println("aaa");
					if ((user.getType()).equals("admin")) {
						MainWindow.this.dispose();
						AdminWindow ruw = new AdminWindow();
						ruw.setVisible(true);

					} else if ((user.getType()).equals("doctor")) {
						MainWindow.this.dispose();
						DoctorWindow ruw = new DoctorWindow(user.getUsername());
						ruw.setVisible(true);
					} else if ((user.getType()).equals("secretary")) {
						MainWindow.this.dispose();
						SecretaryWindow ruw = new SecretaryWindow();
						ruw.setVisible(true);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					return;
				}

			}

		});
	}
}