package client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import client.UserDataAccess;
import database.User;

public class AdminWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private JMenu menuAdmin;
	private JMenu menuBackA;

	private JMenuBar menuBar;

	private JMenuItem itemCreateUser;
	private JMenuItem itemViewUser;
	private JMenuItem itemUpdateUser;
	private JMenuItem itemDeleteUser;
	private JMenuItem itemABack;

	private JPanel createUserPanel;
	private JPanel viewUserPanel;
	private JPanel updateUserPanel;
	private JPanel deleteUserPanel;

	private JLabel username;
	private JLabel password;
	private JLabel type;
	private JLabel usernameU;
	private JLabel passwordU;
	private JLabel typeU;
	private JLabel usernameD;

	private JTextField usernameText;
	private JTextField passwordText;
	private JTextField typeText;
	private JTextField usernameTextU;
	private JTextField passwordTextU;
	private JTextField typeTextU;
	private JTextField usernameTextD;

	private JButton createUserButton;
	private JButton updateUserButton;
	private JButton deleteUserButton;

	private JTable tableUser;
	private JScrollPane listUserScroll;

	public AdminWindow() {

		this.setSize(700, 600);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.initComponenteMain();

	}

	private void initComponenteMain() {

		itemCreateUser = new JMenuItem("Create", KeyEvent.VK_1);
		itemCreateUser.setBackground(Color.BLACK);
		itemCreateUser.setForeground(Color.white);

		itemViewUser = new JMenuItem("View", KeyEvent.VK_2);
		itemViewUser.setBackground(Color.BLACK);
		itemViewUser.setForeground(Color.white);

		itemUpdateUser = new JMenuItem("Update", KeyEvent.VK_3);
		itemUpdateUser.setBackground(Color.BLACK);
		itemUpdateUser.setForeground(Color.white);

		itemDeleteUser = new JMenuItem("Delete", KeyEvent.VK_4);
		itemDeleteUser.setBackground(Color.BLACK);
		itemDeleteUser.setForeground(Color.white);

		menuAdmin = new JMenu("CRUD on user's account");
		menuAdmin.setMnemonic(KeyEvent.VK_M);
		menuAdmin.setForeground(Color.white);
		menuAdmin.setBackground(Color.BLACK);
		menuAdmin.add(itemCreateUser);
		menuAdmin.add(itemViewUser);
		menuAdmin.add(itemUpdateUser);
		menuAdmin.add(itemDeleteUser);

		itemABack = new JMenuItem("Back", KeyEvent.VK_5);
		itemABack.setBackground(Color.BLACK);
		itemABack.setForeground(Color.white);

		menuBackA = new JMenu("Back");
		menuBackA.setMnemonic(KeyEvent.VK_M);
		menuBackA.setForeground(Color.white);
		menuBackA.setBackground(Color.BLACK);
		menuBackA.add(itemABack);

		menuBar = new JMenuBar();
		menuBar.add(menuAdmin);
		menuBar.add(menuBackA);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBorder(BorderFactory.createRaisedBevelBorder());

		// create a user's account

		username = new JLabel("Enter username: ");
		username.setBounds(50, 50, 150, 200);
		username.setForeground(Color.white);
		username.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT,
				15));

		usernameText = new JTextField();
		usernameText.setBounds(200, 135, 150, 20);

		password = new JLabel("Enter the password: ");
		password.setBounds(50, 100, 200, 200);
		password.setForeground(Color.white);
		password.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT,
				15));

		passwordText = new JTextField();
		passwordText.setBounds(200, 190, 150, 20);

		type = new JLabel("Enter the type: ");
		type.setBounds(50, 150, 150, 200);
		type.setForeground(Color.white);
		type.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 15));

		typeText = new JTextField();
		typeText.setBounds(200, 240, 150, 20);

		createUserButton = new JButton("Create");
		createUserButton.setBounds(150, 410, 100, 30);

		createUserPanel = new JPanel();
		createUserPanel.setLayout(null);
		createUserPanel.setBounds(0, 0, 700, 600);
		createUserPanel.add(username);
		createUserPanel.add(usernameText);
		createUserPanel.add(password);
		createUserPanel.add(passwordText);
		createUserPanel.add(type);
		createUserPanel.add(typeText);
		createUserPanel.add(createUserButton);
		createUserPanel.setBackground(Color.DARK_GRAY);
		this.setJMenuBar(menuBar);
		this.add(createUserPanel);
		createUserPanel.setVisible(false);

		// view info regular user

		DefaultTableModel model1;
		String[] columnNames1 = { "username", "password", "type" };
		Object[][] data1 = new Object[25][3];
		model1 = new DefaultTableModel(data1, columnNames1);
		this.tableUser = new JTable(model1) {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}

		};
		TableColumn column1 = null;
		for (int i = 0; i < 3; i++) {
			column1 = tableUser.getColumnModel().getColumn(i);

			if (i == 0) {
				column1.setPreferredWidth(70);
			}
			if (i == 1) {
				column1.setPreferredWidth(70);
			}
			if (i == 2) {
				column1.setPreferredWidth(70);
			}

		}
		tableUser.setAutoCreateColumnsFromModel(false);

		listUserScroll = new JScrollPane(tableUser);
		listUserScroll.setBackground(Color.WHITE);
		listUserScroll
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		listUserScroll.setBorder(BorderFactory.createEtchedBorder(
				Color.DARK_GRAY, Color.white));

		listUserScroll.setBounds(50, 100, 500, 300);
		viewUserPanel = new JPanel();
		viewUserPanel.setLayout(null);
		viewUserPanel.setBounds(0, 0, 700, 600);
		viewUserPanel.setBackground(Color.DARK_GRAY);
		viewUserPanel.add(listUserScroll);
		viewUserPanel.setVisible(false);

		this.setJMenuBar(menuBar);
		this.add(viewUserPanel);
		viewUserPanel.setVisible(false);

		// update regular user's info

		usernameU = new JLabel("Enter username: ");
		usernameU.setBounds(50, 50, 150, 200);
		usernameU.setForeground(Color.white);
		usernameU.setFont(new Font("Times New Roman",
				Font.LAYOUT_LEFT_TO_RIGHT, 15));

		usernameTextU = new JTextField();
		usernameTextU.setBounds(200, 135, 150, 20);

		passwordU = new JLabel("Enter the password: ");
		passwordU.setBounds(50, 100, 200, 200);
		passwordU.setForeground(Color.white);
		passwordU.setFont(new Font("Times New Roman",
				Font.LAYOUT_LEFT_TO_RIGHT, 15));

		passwordTextU = new JTextField();
		passwordTextU.setBounds(200, 190, 150, 20);

		typeU = new JLabel("Enter the type: ");
		typeU.setBounds(50, 150, 150, 200);
		typeU.setForeground(Color.white);
		typeU.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 15));

		typeTextU = new JTextField();
		typeTextU.setBounds(200, 240, 150, 20);

		updateUserButton = new JButton("Update");
		updateUserButton.setBounds(150, 410, 100, 30);

		updateUserPanel = new JPanel();
		updateUserPanel.setLayout(null);
		updateUserPanel.setBounds(0, 0, 700, 600);
		updateUserPanel.add(usernameU);
		updateUserPanel.add(usernameTextU);
		updateUserPanel.add(passwordU);
		updateUserPanel.add(passwordTextU);
		updateUserPanel.add(typeU);
		updateUserPanel.add(typeTextU);
		updateUserPanel.add(updateUserButton);
		updateUserPanel.setBackground(Color.DARK_GRAY);
		this.setJMenuBar(menuBar);
		this.add(updateUserPanel);
		updateUserPanel.setVisible(false);

		// delete a regular user's information

		usernameD = new JLabel("Enter the username: ");
		usernameD.setBounds(50, 50, 150, 200);
		usernameD.setForeground(Color.white);
		usernameD.setFont(new Font("Times New Roman",
				Font.LAYOUT_LEFT_TO_RIGHT, 15));

		usernameTextD = new JTextField();
		usernameTextD.setBounds(200, 137, 150, 20);

		deleteUserButton = new JButton("Delete");
		deleteUserButton.setBounds(150, 330, 100, 30);

		deleteUserPanel = new JPanel();
		deleteUserPanel.setLayout(null);
		deleteUserPanel.setBounds(0, 0, 700, 600);
		deleteUserPanel.add(usernameD);
		deleteUserPanel.add(usernameTextD);
		deleteUserPanel.add(deleteUserButton);
		deleteUserPanel.setBackground(Color.DARK_GRAY);
		this.setJMenuBar(menuBar);
		this.add(deleteUserPanel);
		deleteUserPanel.setVisible(false);

		itemCreateUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminWindow.this.setVisible(true);
				createUserPanel.setVisible(true);
				viewUserPanel.setVisible(false);
				updateUserPanel.setVisible(false);
				deleteUserPanel.setVisible(false);

			}

		});

		itemViewUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				UserDataAccess cons = new UserDataAccess();

				List<User> list = new ArrayList<User>();
				try {
					list = cons.getAllUser();
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error!");
					return;
				}

				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						User userData = list.get(i);

						tableUser.setValueAt(userData.getUsername(), i, 0);
						tableUser.setValueAt(userData.getPassword(), i, 1);
						tableUser.setValueAt(userData.getType(), i, 2);
					}
				}

				AdminWindow.this.setVisible(true);
				createUserPanel.setVisible(false);
				viewUserPanel.setVisible(true);
				updateUserPanel.setVisible(false);
				deleteUserPanel.setVisible(false);

				tableUser.revalidate();
				tableUser.repaint();

				try {
					list = cons.getAllUser();
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error!");
					return;
				}

				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						User userData = list.get(i);

						tableUser.setValueAt(userData.getUsername(), i, 0);
						tableUser.setValueAt(userData.getPassword(), i, 1);
						tableUser.setValueAt(userData.getType(), i, 2);
					}
				}

			}

		});

		itemUpdateUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminWindow.this.setVisible(true);
				createUserPanel.setVisible(false);
				viewUserPanel.setVisible(false);
				updateUserPanel.setVisible(true);
				deleteUserPanel.setVisible(false);

			}

		});

		itemDeleteUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminWindow.this.setVisible(true);
				createUserPanel.setVisible(false);
				viewUserPanel.setVisible(false);
				updateUserPanel.setVisible(false);
				deleteUserPanel.setVisible(true);

			}

		});

		itemABack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AdminWindow.this.setVisible(false);
				MainWindow mw = new MainWindow();
				mw.setVisible(true);

			}

		});

		createUserButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String username = usernameText.getText();
				String password = passwordText.getText();
				String type = typeText.getText();

				User user = new User(username, password, type);
				try {
					new UserDataAccess().addUser(user);

					JOptionPane.showMessageDialog(null, "User has been added!");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					return;
				}

			}

		});

		updateUserButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String username = usernameTextU.getText();
				String password = passwordTextU.getText();
				String type = typeTextU.getText();
				User user = new User(username, password, type);
				try {
					new UserDataAccess().updateUser(user);

					JOptionPane.showMessageDialog(null,
							"User has been updated!");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					return;
				}

			}

		});
		deleteUserButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = usernameTextD.getText();
				try {
					new UserDataAccess().deleteUser(username);
					JOptionPane.showMessageDialog(null,
							"The user has been deleted!");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					return;
				}
			}

		});

	}
}
