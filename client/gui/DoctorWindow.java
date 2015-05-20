package client.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import client.ConsultationDataAccess;
import client.NotificationDataAccess;
import database.Consultation;
import database.Notification;

public class DoctorWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private JMenu menuDoctor;
	private JMenu menuBackD;
	private JMenu menuNotif;
	private String username;

	private JMenuBar menuBar;

	private JMenuItem itemAddCons;
	private JMenuItem itemViewCons;
	private JMenuItem itemBackD;
	private JMenuItem itemNotif;

	private JPanel addConsPanel;
	private JPanel viewConsPanel;
	private JPanel viewNotifPanel;

	private JLabel idCons;
	private JLabel cnpCons;
	private JLabel nameCons;
	private JLabel dateCons;
	private JLabel descriptionCons;

	private JTextField idConsText;
	private JTextField cnpConsText;
	private JTextField nameConsText;
	private JTextField dateConsText;
	private JTextField descriptionConsText;

	private JButton addConsButton;

	private JTable tableCons;
	private JTable tableNotif;
	private JScrollPane listScroll;
	private JScrollPane listNotifScroll;

	public DoctorWindow(String username) {
		this();
		this.username = username;
	}

	private DoctorWindow() {

		this.setSize(700, 600);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.initComponenteMain();

	}

	private void initComponenteMain() {

		itemAddCons = new JMenuItem("Add", KeyEvent.VK_1);
		itemAddCons.setBackground(Color.BLACK);
		itemAddCons.setForeground(Color.white);

		itemViewCons = new JMenuItem("View", KeyEvent.VK_2);
		itemViewCons.setBackground(Color.BLACK);
		itemViewCons.setForeground(Color.white);

		menuDoctor = new JMenu("Add/View patient's consultation");
		menuDoctor.setMnemonic(KeyEvent.VK_M);
		menuDoctor.setForeground(Color.white);
		menuDoctor.setBackground(Color.BLACK);
		menuDoctor.add(itemAddCons);
		menuDoctor.add(itemViewCons);

		itemNotif = new JMenuItem("Notification", KeyEvent.VK_5);
		itemNotif.setBackground(Color.BLACK);
		itemNotif.setForeground(Color.white);

		menuNotif = new JMenu("Notify");
		menuNotif.setMnemonic(KeyEvent.VK_M);
		menuNotif.setForeground(Color.white);
		menuNotif.setBackground(Color.BLACK);
		menuNotif.add(itemNotif);

		itemBackD = new JMenuItem("Back", KeyEvent.VK_5);
		itemBackD.setBackground(Color.BLACK);
		itemBackD.setForeground(Color.white);

		menuBackD = new JMenu("Back");
		menuBackD.setMnemonic(KeyEvent.VK_M);
		menuBackD.setForeground(Color.white);
		menuBackD.setBackground(Color.BLACK);
		menuBackD.add(itemBackD);

		menuBar = new JMenuBar();
		menuBar.add(menuDoctor);
		menuBar.add(menuBackD);
		menuBar.add(menuNotif);
		menuBar.add(menuNotif);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBorder(BorderFactory.createRaisedBevelBorder());

		// add a patient's consultation

		idCons = new JLabel("Enter the id Consultation: ");
		idCons.setBounds(50, 50, 150, 200);
		idCons.setForeground(Color.white);
		idCons.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT,
				15));

		idConsText = new JTextField();
		idConsText.setBounds(200, 135, 150, 20);

		cnpCons = new JLabel("Enter the cnp: ");
		cnpCons.setBounds(50, 100, 200, 200);
		cnpCons.setForeground(Color.white);
		cnpCons.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT,
				15));

		cnpConsText = new JTextField();
		cnpConsText.setBounds(200, 190, 150, 20);

		nameCons = new JLabel("Enter the name doctor: ");
		nameCons.setBounds(50, 150, 150, 200);
		nameCons.setForeground(Color.white);
		nameCons.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT,
				15));

		nameConsText = new JTextField();
		nameConsText.setBounds(200, 240, 150, 20);

		dateCons = new JLabel("Enter the date:");
		dateCons.setBounds(50, 200, 150, 200);
		dateCons.setForeground(Color.white);
		dateCons.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT,
				15));

		dateConsText = new JTextField();
		dateConsText.setBounds(200, 290, 150, 20);

		descriptionCons = new JLabel("Enter the description:");
		descriptionCons.setBounds(50, 250, 150, 200);
		descriptionCons.setForeground(Color.white);
		descriptionCons.setFont(new Font("Times New Roman",
				Font.LAYOUT_LEFT_TO_RIGHT, 15));

		descriptionConsText = new JTextField();
		descriptionConsText.setBounds(200, 330, 150, 20);

		addConsButton = new JButton("Create");
		addConsButton.setBounds(150, 410, 100, 30);

		addConsPanel = new JPanel();
		addConsPanel.setLayout(null);
		addConsPanel.setBounds(0, 0, 700, 600);
		addConsPanel.add(idCons);
		addConsPanel.add(idConsText);
		addConsPanel.add(cnpCons);
		addConsPanel.add(cnpConsText);
		addConsPanel.add(nameCons);
		addConsPanel.add(nameConsText);
		addConsPanel.add(dateCons);
		addConsPanel.add(dateConsText);
		addConsPanel.add(descriptionCons);
		addConsPanel.add(descriptionConsText);
		addConsPanel.add(addConsButton);
		addConsPanel.setBackground(Color.DARK_GRAY);
		this.setJMenuBar(menuBar);
		this.add(addConsPanel);
		addConsPanel.setVisible(false);

		// view info regular user

		DefaultTableModel model1;
		String[] columnNames1 = { "idConsultation", "cnp", "nameDoctor",
				"date", "description" };
		Object[][] data1 = new Object[25][5];
		model1 = new DefaultTableModel(data1, columnNames1);
		this.tableCons = new JTable(model1) {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}

		};
		TableColumn column1 = null;
		for (int i = 0; i < 5; i++) {
			column1 = tableCons.getColumnModel().getColumn(i);

			if (i == 0) {
				column1.setPreferredWidth(50);
			}
			if (i == 1) {
				column1.setPreferredWidth(70);
			}
			if (i == 2) {
				column1.setPreferredWidth(70);
			}
			if (i == 3) {
				column1.setPreferredWidth(60);
			}
			if (i == 4) {
				column1.setPreferredWidth(70);
			}

		}
		tableCons.setAutoCreateColumnsFromModel(false);

		listScroll = new JScrollPane(tableCons);
		listScroll.setBackground(Color.WHITE);
		listScroll
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		listScroll.setBorder(BorderFactory.createEtchedBorder(Color.DARK_GRAY,
				Color.white));

		listScroll.setBounds(50, 100, 500, 300);
		viewConsPanel = new JPanel();
		viewConsPanel.setLayout(null);
		viewConsPanel.setBounds(0, 0, 700, 600);
		viewConsPanel.setBackground(Color.DARK_GRAY);
		viewConsPanel.add(listScroll);
		viewConsPanel.setVisible(false);

		this.setJMenuBar(menuBar);
		this.add(viewConsPanel);
		viewConsPanel.setVisible(false);

		// view notification

		DefaultTableModel model2;
		String[] columnNames2 = { "username", "message", "id" };
		Object[][] data2 = new Object[25][3];
		model2 = new DefaultTableModel(data2, columnNames2);
		this.tableNotif = new JTable(model2) {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}

		};
		TableColumn column2 = null;
		for (int i = 0; i < 2; i++) {
			column2 = tableNotif.getColumnModel().getColumn(i);

			if (i == 0) {
				column2.setPreferredWidth(70);
			}
			if (i == 1) {
				column2.setPreferredWidth(70);
			}
			if (i == 2) {
				column2.setPreferredWidth(40);
			}

		}
		tableNotif.setAutoCreateColumnsFromModel(false);

		listNotifScroll = new JScrollPane(tableNotif);
		listNotifScroll.setBackground(Color.WHITE);
		listNotifScroll
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		listNotifScroll.setBorder(BorderFactory.createEtchedBorder(
				Color.DARK_GRAY, Color.white));

		listNotifScroll.setBounds(50, 100, 500, 300);
		viewNotifPanel = new JPanel();
		viewNotifPanel.setLayout(null);
		viewNotifPanel.setBounds(0, 0, 700, 600);
		viewNotifPanel.setBackground(Color.DARK_GRAY);
		viewNotifPanel.add(listNotifScroll);
		viewNotifPanel.setVisible(false);

		this.setJMenuBar(menuBar);
		this.add(viewNotifPanel);
		viewNotifPanel.setVisible(false);

		itemAddCons.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DoctorWindow.this.setVisible(true);
				addConsPanel.setVisible(true);
				viewConsPanel.setVisible(false);
				viewNotifPanel.setVisible(false);
			}

		});

		itemViewCons.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ConsultationDataAccess cons = new ConsultationDataAccess();

				List<Consultation> list = new ArrayList<Consultation>();
				try {
					list = cons.getAllConsultation();
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error!");
					return;
				}

				if (list != null) {
					for (int i = 0; i < list.size(); i++) {
						Consultation consData = list.get(i);

						tableCons.setValueAt(consData.getIdConsultation(), i, 0);
						tableCons.setValueAt(consData.getCnp(), i, 1);
						tableCons.setValueAt(consData.getNameDoctor(), i, 2);
						tableCons.setValueAt(consData.getDate(), i, 3);
						tableCons.setValueAt(consData.getDescription(), i, 4);
					}
				}

				DoctorWindow.this.setVisible(true);
				addConsPanel.setVisible(false);
				viewConsPanel.setVisible(true);
				viewNotifPanel.setVisible(false);
				tableCons.revalidate();
				tableCons.repaint();

			}

		});

		itemNotif.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				NotificationDataAccess notif = new NotificationDataAccess();

				Notification[] list;

				try {
					list = notif.getNotifications(username);
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error!");
					return;
				}

				if (list != null) {
					for (int i = 0; i < list.length; i++) {
						Notification notifData = list[i];

						tableNotif.setValueAt(notifData.getUsername(), i, 0);
						tableNotif.setValueAt(notifData.getMessage(), i, 1);
						tableNotif.setValueAt(notifData.getId(), i, 2);

					}
				}

				DoctorWindow.this.setVisible(true);
				addConsPanel.setVisible(false);
				viewConsPanel.setVisible(false);
				viewNotifPanel.setVisible(true);
				tableCons.revalidate();
				tableCons.repaint();

			}

		});

		itemBackD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DoctorWindow.this.setVisible(false);
				MainWindow aw = new MainWindow();
				aw.setVisible(true);

			}

		});

		addConsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String idConsultation = idConsText.getText();
				int idConsultationInt = 0;
				String cnp = cnpConsText.getText();
				String nameDoctor = nameConsText.getText();
				String date = dateConsText.getText();
				Date dateData = null;
				String description = descriptionConsText.getText();

				try {
					SimpleDateFormat formatter = new SimpleDateFormat(
							"dd/MM/yyyy");
					dateData = formatter.parse(date);
					idConsultationInt = Integer.parseInt(idConsultation);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Invalid data!");
					return;
				}
				Consultation consultation = new Consultation(idConsultationInt,
						cnp, nameDoctor, dateData, description);
				try {
					new ConsultationDataAccess().addConsultation(consultation);

					JOptionPane.showMessageDialog(null,
							"Consultation has been added!");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					return;
				}

			}

		});

	}

}
