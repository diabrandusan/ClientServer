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
import client.PatientDataAccess;
import database.Consultation;
import database.Patient;

public class SecretaryWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private JMenu menuPatient;
	private JMenu menuConsultation;
	private JMenu menuBackS;

	private JMenuBar menuBar;

	private JMenuItem itemAddPatient;
	private JMenuItem itemUpdatePatient;
	private JMenuItem itemCreateConsultation;
	private JMenuItem itemViewConsultation;
	private JMenuItem itemUpdateConsultation;
	private JMenuItem itemDeleteConsultation;
	private JMenuItem itemBackS;

	private JPanel addPanel;
	private JPanel updatePatientPanel;
	private JPanel createPanel;
	private JPanel viewPanel;
	private JPanel updatePanel;
	private JPanel deletePanel;

	private JLabel cnp;
	private JLabel name;
	private JLabel cardnumber;
	private JLabel datebirth;
	private JLabel address;
	private JLabel cnpU;
	private JLabel nameU;
	private JLabel cardnumberU;
	private JLabel datebirthU;
	private JLabel addressU;
	private JLabel idCreate;
	private JLabel cnpCreate;
	private JLabel nameCreate;
	private JLabel dateCreate;
	private JLabel descriptionCreate;
	private JLabel idUpdate;
	private JLabel cnpUpdate;
	private JLabel nameUpdate;
	private JLabel dateUpdate;
	private JLabel descriptionUpdate;
	private JLabel idDelete;

	private JTextField cnpText;
	private JTextField nameText;
	private JTextField cardnumberText;
	private JTextField datebirthText;
	private JTextField addressText;
	private JTextField cnpTextU;
	private JTextField nameTextU;
	private JTextField cardnumberTextU;
	private JTextField datebirthTextU;
	private JTextField addressTextU;
	private JTextField idCreateText;
	private JTextField cnpCreateText;
	private JTextField nameCreateText;
	private JTextField dateCreateText;
	private JTextField descriptionCreateText;
	private JTextField idUpdateText;
	private JTextField cnpUpdateText;
	private JTextField nameUpdateText;
	private JTextField dateUpdateText;
	private JTextField descriptionUpdateText;
	private JTextField idDeleteText;

	private JButton addButton;
	private JButton updatePatientButton;
	private JButton createButton;
	private JButton updateButton;
	private JButton deleteButton;

	private JTable tableConsultation;
	private JScrollPane listInfoScroll;

	public SecretaryWindow() {

		this.setSize(700, 600);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.initComponenteMain();
	}

	private void initComponenteMain() {

		itemAddPatient = new JMenuItem("Add", KeyEvent.VK_1);
		itemAddPatient.setBackground(Color.BLACK);
		itemAddPatient.setForeground(Color.white);

		itemUpdatePatient = new JMenuItem("Update", KeyEvent.VK_2);
		itemUpdatePatient.setBackground(Color.BLACK);
		itemUpdatePatient.setForeground(Color.white);

		menuPatient = new JMenu("Add/Update Patients");
		menuPatient.setMnemonic(KeyEvent.VK_M);
		menuPatient.setForeground(Color.white);
		menuPatient.setBackground(Color.BLACK);
		menuPatient.add(itemAddPatient);
		menuPatient.add(itemUpdatePatient);

		itemCreateConsultation = new JMenuItem("Create", KeyEvent.VK_3);
		itemCreateConsultation.setBackground(Color.BLACK);
		itemCreateConsultation.setForeground(Color.white);

		itemViewConsultation = new JMenuItem("View", KeyEvent.VK_4);
		itemViewConsultation.setBackground(Color.BLACK);
		itemViewConsultation.setForeground(Color.white);

		itemUpdateConsultation = new JMenuItem("Update", KeyEvent.VK_5);
		itemUpdateConsultation.setBackground(Color.BLACK);
		itemUpdateConsultation.setForeground(Color.white);

		itemDeleteConsultation = new JMenuItem("Delete", KeyEvent.VK_6);
		itemDeleteConsultation.setBackground(Color.BLACK);
		itemDeleteConsultation.setForeground(Color.white);

		menuConsultation = new JMenu("CRUD on patient's consultation");
		menuConsultation.setMnemonic(KeyEvent.VK_M);
		menuConsultation.setForeground(Color.white);
		menuConsultation.setBackground(Color.BLACK);
		menuConsultation.add(itemCreateConsultation);
		menuConsultation.add(itemViewConsultation);
		menuConsultation.add(itemUpdateConsultation);
		menuConsultation.add(itemDeleteConsultation);

		itemBackS = new JMenuItem("Back", KeyEvent.VK_5);
		itemBackS.setBackground(Color.BLACK);
		itemBackS.setForeground(Color.white);

		menuBackS = new JMenu("Back");
		menuBackS.setMnemonic(KeyEvent.VK_M);
		menuBackS.setForeground(Color.white);
		menuBackS.setBackground(Color.BLACK);
		menuBackS.add(itemBackS);

		menuBar = new JMenuBar();
		menuBar.add(menuPatient);
		menuBar.add(menuConsultation);
		menuBar.add(menuBackS);

		menuBar.setBackground(Color.BLACK);
		menuBar.setBorder(BorderFactory.createRaisedBevelBorder());

		// add a patient

		cnp = new JLabel("Enter the cnp: ");
		cnp.setBounds(50, 50, 150, 200);
		cnp.setForeground(Color.white);
		cnp.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 15));

		cnpText = new JTextField();
		cnpText.setBounds(200, 135, 150, 20);

		name = new JLabel("Enter the name: ");
		name.setBounds(50, 100, 200, 200);
		name.setForeground(Color.white);
		name.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 15));

		nameText = new JTextField();
		nameText.setBounds(200, 190, 150, 20);

		cardnumber = new JLabel("Enter the card number: ");
		cardnumber.setBounds(50, 150, 150, 200);
		cardnumber.setForeground(Color.white);
		cardnumber.setFont(new Font("Times New Roman",
				Font.LAYOUT_LEFT_TO_RIGHT, 15));

		cardnumberText = new JTextField();
		cardnumberText.setBounds(200, 240, 150, 20);

		datebirth = new JLabel("Enter the date of birth: ");
		datebirth.setBounds(50, 200, 150, 200);
		datebirth.setForeground(Color.white);
		datebirth.setFont(new Font("Times New Roman",
				Font.LAYOUT_LEFT_TO_RIGHT, 15));

		datebirthText = new JTextField();
		datebirthText.setBounds(200, 290, 150, 20);

		address = new JLabel("Enter the address: ");
		address.setBounds(50, 250, 150, 200);
		address.setForeground(Color.white);
		address.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT,
				15));

		addressText = new JTextField();
		addressText.setBounds(200, 340, 150, 20);

		addButton = new JButton("Add");
		addButton.setBounds(150, 390, 100, 30);

		addPanel = new JPanel();
		addPanel.setLayout(null);
		addPanel.setBounds(0, 0, 700, 600);
		addPanel.add(cnp);
		addPanel.add(cnpText);
		addPanel.add(name);
		addPanel.add(nameText);
		addPanel.add(cardnumber);
		addPanel.add(cardnumberText);
		addPanel.add(datebirth);
		addPanel.add(datebirthText);
		addPanel.add(address);
		addPanel.add(addressText);
		addPanel.add(addButton);
		addPanel.setBackground(Color.DARK_GRAY);
		this.setJMenuBar(menuBar);
		this.add(addPanel);
		addPanel.setVisible(false);

		// update a patient

		cnpU = new JLabel("Enter the cnp: ");
		cnpU.setBounds(50, 50, 150, 200);
		cnpU.setForeground(Color.white);
		cnpU.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 15));

		cnpTextU = new JTextField();
		cnpTextU.setBounds(200, 135, 150, 20);

		nameU = new JLabel("Enter the name: ");
		nameU.setBounds(50, 100, 200, 200);
		nameU.setForeground(Color.white);
		nameU.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 15));

		nameTextU = new JTextField();
		nameTextU.setBounds(200, 190, 150, 20);

		cardnumberU = new JLabel("Enter the card number: ");
		cardnumberU.setBounds(50, 150, 150, 200);
		cardnumberU.setForeground(Color.white);
		cardnumberU.setFont(new Font("Times New Roman",
				Font.LAYOUT_LEFT_TO_RIGHT, 15));

		cardnumberTextU = new JTextField();
		cardnumberTextU.setBounds(200, 240, 150, 20);

		datebirthU = new JLabel("Enter the date of birth: ");
		datebirthU.setBounds(50, 200, 150, 200);
		datebirthU.setForeground(Color.white);
		datebirthU.setFont(new Font("Times New Roman",
				Font.LAYOUT_LEFT_TO_RIGHT, 15));

		datebirthTextU = new JTextField();
		datebirthTextU.setBounds(200, 290, 150, 20);

		addressU = new JLabel("Enter the address: ");
		addressU.setBounds(50, 250, 150, 200);
		addressU.setForeground(Color.white);
		addressU.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT,
				15));

		addressTextU = new JTextField();
		addressTextU.setBounds(200, 340, 150, 20);

		updatePatientButton = new JButton("Update");
		updatePatientButton.setBounds(150, 390, 100, 30);

		updatePatientPanel = new JPanel();
		updatePatientPanel.setLayout(null);
		updatePatientPanel.setBounds(0, 0, 700, 600);
		updatePatientPanel.add(cnpU);
		updatePatientPanel.add(cnpTextU);
		updatePatientPanel.add(nameU);
		updatePatientPanel.add(nameTextU);
		updatePatientPanel.add(cardnumberU);
		updatePatientPanel.add(cardnumberTextU);
		updatePatientPanel.add(datebirthU);
		updatePatientPanel.add(datebirthTextU);
		updatePatientPanel.add(addressU);
		updatePatientPanel.add(addressTextU);
		updatePatientPanel.add(updatePatientButton);
		updatePatientPanel.setBackground(Color.DARK_GRAY);
		this.setJMenuBar(menuBar);
		this.add(updatePatientPanel);
		updatePatientPanel.setVisible(false);

		// create a patient's consultation

		idCreate = new JLabel("Enter the id Consultation: ");
		idCreate.setBounds(50, 50, 150, 200);
		idCreate.setForeground(Color.white);
		idCreate.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT,
				15));

		idCreateText = new JTextField();
		idCreateText.setBounds(200, 135, 150, 20);

		cnpCreate = new JLabel("Enter the cnp: ");
		cnpCreate.setBounds(50, 100, 200, 200);
		cnpCreate.setForeground(Color.white);
		cnpCreate.setFont(new Font("Times New Roman",
				Font.LAYOUT_LEFT_TO_RIGHT, 15));

		cnpCreateText = new JTextField();
		cnpCreateText.setBounds(200, 190, 150, 20);

		nameCreate = new JLabel("Enter the name doctor: ");
		nameCreate.setBounds(50, 150, 150, 200);
		nameCreate.setForeground(Color.white);
		nameCreate.setFont(new Font("Times New Roman",
				Font.LAYOUT_LEFT_TO_RIGHT, 15));

		nameCreateText = new JTextField();
		nameCreateText.setBounds(200, 240, 150, 20);

		dateCreate = new JLabel("Enter the date:");
		dateCreate.setBounds(50, 200, 150, 200);
		dateCreate.setForeground(Color.white);
		dateCreate.setFont(new Font("Times New Roman",
				Font.LAYOUT_LEFT_TO_RIGHT, 15));

		dateCreateText = new JTextField();
		dateCreateText.setBounds(200, 290, 150, 20);

		descriptionCreate = new JLabel("Enter the description:");
		descriptionCreate.setBounds(50, 250, 150, 200);
		descriptionCreate.setForeground(Color.white);
		descriptionCreate.setFont(new Font("Times New Roman",
				Font.LAYOUT_LEFT_TO_RIGHT, 15));

		descriptionCreateText = new JTextField();
		descriptionCreateText.setBounds(200, 330, 150, 20);

		createButton = new JButton("Create");
		createButton.setBounds(150, 410, 100, 30);

		createPanel = new JPanel();
		createPanel.setLayout(null);
		createPanel.setBounds(0, 0, 700, 600);
		createPanel.add(idCreate);
		createPanel.add(idCreateText);
		createPanel.add(cnpCreate);
		createPanel.add(cnpCreateText);
		createPanel.add(nameCreate);
		createPanel.add(nameCreateText);
		createPanel.add(dateCreate);
		createPanel.add(dateCreateText);
		createPanel.add(descriptionCreate);
		createPanel.add(descriptionCreateText);
		createPanel.add(createButton);
		createPanel.setBackground(Color.DARK_GRAY);
		this.setJMenuBar(menuBar);
		this.add(createPanel);
		createPanel.setVisible(false);

		// view info regular user

		DefaultTableModel model1;
		String[] columnNames1 = { "idConsultation", "cnp", "nameDoctor",
				"date", "description" };
		Object[][] data1 = new Object[25][5];
		model1 = new DefaultTableModel(data1, columnNames1);
		this.tableConsultation = new JTable(model1) {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}

		};
		TableColumn column1 = null;
		for (int i = 0; i < 5; i++) {
			column1 = tableConsultation.getColumnModel().getColumn(i);

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
		tableConsultation.setAutoCreateColumnsFromModel(false);

		listInfoScroll = new JScrollPane(tableConsultation);
		listInfoScroll.setBackground(Color.WHITE);
		listInfoScroll
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		listInfoScroll.setBorder(BorderFactory.createEtchedBorder(
				Color.DARK_GRAY, Color.white));

		listInfoScroll.setBounds(50, 100, 500, 300);
		viewPanel = new JPanel();
		viewPanel.setLayout(null);
		viewPanel.setBounds(0, 0, 700, 600);
		viewPanel.setBackground(Color.DARK_GRAY);
		viewPanel.add(listInfoScroll);
		viewPanel.setVisible(false);

		this.setJMenuBar(menuBar);
		this.add(viewPanel);
		viewPanel.setVisible(false);

		// update regular user's info

		idUpdate = new JLabel("Enter the id Consultation: ");
		idUpdate.setBounds(50, 50, 150, 200);
		idUpdate.setForeground(Color.white);
		idUpdate.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT,
				15));

		idUpdateText = new JTextField();
		idUpdateText.setBounds(200, 135, 150, 20);

		cnpUpdate = new JLabel("Enter the cnp: ");
		cnpUpdate.setBounds(50, 100, 200, 200);
		cnpUpdate.setForeground(Color.white);
		cnpUpdate.setFont(new Font("Times New Roman",
				Font.LAYOUT_LEFT_TO_RIGHT, 15));

		cnpUpdateText = new JTextField();
		cnpUpdateText.setBounds(200, 190, 150, 20);

		nameUpdate = new JLabel("Enter the name doctor: ");
		nameUpdate.setBounds(50, 150, 150, 200);
		nameUpdate.setForeground(Color.white);
		nameUpdate.setFont(new Font("Times New Roman",
				Font.LAYOUT_LEFT_TO_RIGHT, 15));

		nameUpdateText = new JTextField();
		nameUpdateText.setBounds(200, 240, 150, 20);

		dateUpdate = new JLabel("Enter the date:");
		dateUpdate.setBounds(50, 200, 150, 200);
		dateUpdate.setForeground(Color.white);
		dateUpdate.setFont(new Font("Times New Roman",
				Font.LAYOUT_LEFT_TO_RIGHT, 15));

		dateUpdateText = new JTextField();
		dateUpdateText.setBounds(200, 290, 150, 20);

		descriptionUpdate = new JLabel("Enter the description:");
		descriptionUpdate.setBounds(50, 250, 150, 200);
		descriptionUpdate.setForeground(Color.white);
		descriptionUpdate.setFont(new Font("Times New Roman",
				Font.LAYOUT_LEFT_TO_RIGHT, 15));

		descriptionUpdateText = new JTextField();
		descriptionUpdateText.setBounds(200, 330, 150, 20);

		updateButton = new JButton("Update");
		updateButton.setBounds(150, 410, 100, 30);

		updatePanel = new JPanel();
		updatePanel.setLayout(null);
		updatePanel.setBounds(0, 0, 700, 600);
		updatePanel.add(idUpdate);
		updatePanel.add(idUpdateText);
		updatePanel.add(cnpUpdate);
		updatePanel.add(cnpUpdateText);
		updatePanel.add(nameUpdate);
		updatePanel.add(nameUpdateText);
		updatePanel.add(dateUpdate);
		updatePanel.add(dateUpdateText);
		updatePanel.add(descriptionUpdate);
		updatePanel.add(descriptionUpdateText);
		updatePanel.add(updateButton);
		updatePanel.setBackground(Color.DARK_GRAY);
		this.setJMenuBar(menuBar);
		this.add(updatePanel);
		updatePanel.setVisible(false);

		// delete a regular user's information

		idDelete = new JLabel("Enter the id: ");
		idDelete.setBounds(50, 50, 150, 200);
		idDelete.setForeground(Color.white);
		idDelete.setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT,
				15));

		idDeleteText = new JTextField();
		idDeleteText.setBounds(200, 137, 150, 20);

		deleteButton = new JButton("Delete");
		deleteButton.setBounds(150, 330, 100, 30);

		deletePanel = new JPanel();
		deletePanel.setLayout(null);
		deletePanel.setBounds(0, 0, 700, 600);
		deletePanel.add(idDelete);
		deletePanel.add(idDeleteText);
		deletePanel.add(deleteButton);
		deletePanel.setBackground(Color.DARK_GRAY);
		this.setJMenuBar(menuBar);
		this.add(deletePanel);
		deletePanel.setVisible(false);

		itemAddPatient.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				SecretaryWindow.this.setVisible(true);
				addPanel.setVisible(true);
				updatePatientPanel.setVisible(false);
				createPanel.setVisible(false);
				viewPanel.setVisible(false);
				updatePanel.setVisible(false);
				deletePanel.setVisible(false);

			}

		});

		itemUpdatePatient.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SecretaryWindow.this.setVisible(true);
				updatePatientPanel.setVisible(true);
				addPanel.setVisible(false);
				createPanel.setVisible(false);
				viewPanel.setVisible(false);
				updatePanel.setVisible(false);
				deletePanel.setVisible(false);
			}

		});

		itemCreateConsultation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SecretaryWindow.this.setVisible(true);
				createPanel.setVisible(true);
				addPanel.setVisible(false);
				updatePatientPanel.setVisible(false);
				viewPanel.setVisible(false);
				updatePanel.setVisible(false);
				deletePanel.setVisible(false);

			}

		});

		itemViewConsultation.addActionListener(new ActionListener() {

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

						tableConsultation.setValueAt(
								consData.getIdConsultation(), i, 0);
						tableConsultation.setValueAt(consData.getCnp(), i, 1);
						tableConsultation.setValueAt(consData.getNameDoctor(),
								i, 2);
						tableConsultation.setValueAt(consData.getDate(), i, 3);
						tableConsultation.setValueAt(consData.getDescription(),
								i, 4);
					}
				}

				SecretaryWindow.this.setVisible(true);
				viewPanel.setVisible(true);
				addPanel.setVisible(false);
				updatePatientPanel.setVisible(false);
				createPanel.setVisible(false);
				updatePanel.setVisible(false);
				deletePanel.setVisible(false);

				tableConsultation.revalidate();
				tableConsultation.repaint();
			}

		});

		itemUpdateConsultation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SecretaryWindow.this.setVisible(true);
				updatePanel.setVisible(true);
				addPanel.setVisible(false);
				updatePatientPanel.setVisible(false);
				createPanel.setVisible(false);
				viewPanel.setVisible(false);
				deletePanel.setVisible(false);

			}

		});

		itemDeleteConsultation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SecretaryWindow.this.setVisible(true);
				deletePanel.setVisible(true);
				addPanel.setVisible(false);
				updatePatientPanel.setVisible(false);
				createPanel.setVisible(false);
				viewPanel.setVisible(false);
				updatePanel.setVisible(false);

			}

		});

		itemBackS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SecretaryWindow.this.setVisible(false);
				SecretaryWindow sw = new SecretaryWindow();
				sw.setVisible(true);

			}

		});

		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String cnp = cnpText.getText();
				String name = nameText.getText();
				String cardNumber = cardnumberText.getText();
				int cardNumberInt = 0;
				String dateBirth = datebirthText.getText();
				Date dateBirthData = null;
				String address = addressText.getText();

				try {
					SimpleDateFormat formatter = new SimpleDateFormat(
							"dd/MM/yyyy");
					dateBirthData = formatter.parse(dateBirth);
					cardNumberInt = Integer.parseInt(cardNumber);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Invalid data!");
					return;
				}
				Patient patient = new Patient(cnp, name, cardNumberInt,
						dateBirthData, address);
				try {
					new PatientDataAccess().addPatient(patient);

					JOptionPane.showMessageDialog(null,
							"Patient has been added!");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					return;
				}

			}

		});

		updatePatientButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String cnp = cnpTextU.getText();
				String name = nameTextU.getText();
				String cardNumber = cardnumberTextU.getText();
				int cardNumberInt = 0;
				String dateBirth = datebirthTextU.getText();
				Date dateBirthData = null;
				String address = addressTextU.getText();

				try {
					SimpleDateFormat formatter = new SimpleDateFormat(
							"dd/MM/yyyy");
					dateBirthData = formatter.parse(dateBirth);
					cardNumberInt = Integer.parseInt(cardNumber);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Invalid data!");
					return;
				}
				Patient patient = new Patient(cnp, name, cardNumberInt,
						dateBirthData, address);
				try {
					new PatientDataAccess().updatePatient(patient);

					JOptionPane.showMessageDialog(null,
							"Patient has been updated!");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					return;
				}

			}

		});

		createButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String idConsultation = idCreateText.getText();
				int idConsultationInt = 0;
				String cnp = cnpCreateText.getText();
				String nameDoctor = nameCreateText.getText();
				String date = dateCreateText.getText();
				Date dateData = null;
				String description = descriptionCreateText.getText();

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

		updateButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String idConsultation = idUpdateText.getText();
				int idConsultationInt = 0;
				String cnp = cnpUpdateText.getText();
				String nameDoctor = nameUpdateText.getText();
				String date = dateUpdateText.getText();
				Date dateData = null;
				String description = descriptionUpdateText.getText();

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
					new ConsultationDataAccess()
							.updateConsultation(consultation);

					JOptionPane.showMessageDialog(null,
							"Consultation has been updated!");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					return;
				}

			}

		});
		deleteButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int valueId = Integer.valueOf(idDeleteText.getText());
				try {
					new ConsultationDataAccess().deleteConsultation(valueId);
					JOptionPane.showMessageDialog(null,
							"The consultation has been deleted!");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
					return;
				}
			}

		});

	}
}
