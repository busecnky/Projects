package com.busecnky.controller;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.commons.lang3.StringUtils;

import com.busecnky.entity.Contact;
import com.busecnky.entity.Student;
import com.busecnky.service.ContactsService;
import com.busecnky.service.StudentService;

import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class StudentInfoGui {

	private JFrame frame;
	private JTextField tf_Id;
	private JTextField tf_email;
	private JTextField tf_firstname;
	private JTextField tf_lastname;
	private JTable table;
	private JTextField textField_phone1;
	private JTextField textField_phone2;
	private JLabel lblDateTime;
	private JLabel lblEmail;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblGender;
	private JComboBox<String> comboBox_Gender;
	private JLabel lblNewLabel_Language;
	private JLabel lblPhone;
	private JButton btn_searchEmail;
	private JButton btn_searchFname;
	private JButton btnGetAll;
	private JButton btnSave;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel lblNewLabel_2;
	private JComboBox<String> comboBox_Language;
	private JButton btn_searchSname;
	private JLabel lblContactInfo1;
	private JLabel lblContactInfo2;
	private JLabel lblAddress;
	private JEditorPane editorPane_adres1;
	private JEditorPane editorPane_adres2;
	private ImageIcon icon;
	private ImageIcon icon1;
	private ImageIcon icon2;
	private ImageIcon icon3;
	private ImageIcon icon4;
	private ImageIcon icon5;
	private ImageIcon icon6;
	private ImageIcon icon7;
	private ImageIcon icon8;
	private ImageIcon icon9;
	private ImageIcon icon10;

	private StudentService studentService = new StudentService();
	private ContactsService contactsService = new ContactsService();
	private JLabel piclabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfoGui window = new StudentInfoGui();
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
	public StudentInfoGui() {
		initialize();

		Locale.setDefault(new Locale("en", "EN"));
		i18n();
	}

	private void i18n() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("com/busecnky/config/resource_bundle");
		lblEmail.setText(resourceBundle.getString("word1"));
		lblFirstName.setText(resourceBundle.getString("word2"));
		lblLastName.setText(resourceBundle.getString("word3"));
		lblGender.setText(resourceBundle.getString("word4"));

		btn_searchEmail.setText(resourceBundle.getString("word7"));
		btn_searchFname.setText(resourceBundle.getString("word8"));
		btn_searchSname.setText(resourceBundle.getString("word9"));
		lblPhone.setText(resourceBundle.getString("word10"));
		lblAddress.setText(resourceBundle.getString("word11"));
		lblContactInfo1.setText(resourceBundle.getString("word12"));
		lblContactInfo2.setText(resourceBundle.getString("word13"));
		btnSave.setText(resourceBundle.getString("word14"));
		btnGetAll.setText(resourceBundle.getString("word15"));
		btnUpdate.setText(resourceBundle.getString("word16"));
		btnDelete.setText(resourceBundle.getString("word17"));
		lblNewLabel_Language.setText(resourceBundle.getString("word18"));
		comboBox_Gender.removeAllItems();
		comboBox_Gender.addItem(resourceBundle.getString("word5"));
		comboBox_Gender.addItem(resourceBundle.getString("word6"));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { resourceBundle.getString("word19"), resourceBundle.getString("word20"),
						resourceBundle.getString("word21"), resourceBundle.getString("word22") }));

		Date now = new Date();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.getDefault());
		System.out.println(df.format(now));
		lblDateTime.setText(df.format(now));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Student Information System");
		frame.setTitle("Student Information System");
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				emptyFields();
				piclabel.setIcon(icon);
				
			}
		});
		frame.setBounds(100, 100, 1187, 581);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		piclabel = new JLabel("New label");
		piclabel.setBounds(973, 72, 140, 140);
		frame.getContentPane().add(piclabel);

		String[] imagenames = {"default.png", "afrakaya.png","alikaya.png","alyaatici.png", "cagataykaran.png","cagriokan.png", "emrahtaran.png", "emreeren.png","farukcetin.png","gulsahdelen.png","mustafaterzi.png"};
		icon = new ImageIcon(getClass().getResource("/com/busecnky/images/"+imagenames[0]));
		icon.getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT);
		piclabel.setIcon(icon);
		icon1 = new ImageIcon(getClass().getResource("/com/busecnky/images/"+imagenames[1]));
		icon1.getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT);
		icon2 = new ImageIcon(getClass().getResource("/com/busecnky/images/"+imagenames[2]));
		icon2.getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT);
		icon3 = new ImageIcon(getClass().getResource("/com/busecnky/images/"+imagenames[3]));
		icon3.getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT);
		icon4 = new ImageIcon(getClass().getResource("/com/busecnky/images/"+imagenames[4]));
		icon4.getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT);
		icon5 = new ImageIcon(getClass().getResource("/com/busecnky/images/"+imagenames[5]));
		icon5.getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT);
		icon6 = new ImageIcon(getClass().getResource("/com/busecnky/images/"+imagenames[6]));
		icon6.getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT);
		icon7 = new ImageIcon(getClass().getResource("/com/busecnky/images/"+imagenames[7]));
		icon7.getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT);
		icon8 = new ImageIcon(getClass().getResource("/com/busecnky/images/"+imagenames[8]));
		icon8.getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT);
		icon9 = new ImageIcon(getClass().getResource("/com/busecnky/images/"+imagenames[9]));
		icon9.getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT);
		icon10 = new ImageIcon(getClass().getResource("/com/busecnky/images/"+imagenames[10]));
		icon10.getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT);
		
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(63, 72, 61, 16);
		frame.getContentPane().add(lblNewLabel);

		lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(63, 160, 82, 16);
		frame.getContentPane().add(lblEmail);

		lblFirstName = new JLabel("Name");
		lblFirstName.setBounds(63, 104, 82, 16);
		frame.getContentPane().add(lblFirstName);

		lblLastName = new JLabel("Surname");
		lblLastName.setBounds(63, 132, 82, 16);
		frame.getContentPane().add(lblLastName);

		lblGender = new JLabel("Gender");
		lblGender.setBounds(63, 188, 82, 16);
		frame.getContentPane().add(lblGender);

		tf_Id = new JTextField();
		tf_Id.setEnabled(false);
		tf_Id.setEditable(false);
		tf_Id.setBounds(164, 72, 130, 26);
		frame.getContentPane().add(tf_Id);
		tf_Id.setColumns(10);

		tf_email = new JTextField();
		tf_email.setBounds(164, 155, 130, 26);
		frame.getContentPane().add(tf_email);
		tf_email.setColumns(10);

		tf_firstname = new JTextField();
		tf_firstname.setColumns(10);
		tf_firstname.setBounds(164, 100, 130, 26);
		frame.getContentPane().add(tf_firstname);

		tf_lastname = new JTextField();
		tf_lastname.setColumns(10);
		tf_lastname.setBounds(164, 128, 130, 26);
		frame.getContentPane().add(tf_lastname);

		comboBox_Gender = new JComboBox();
		comboBox_Gender.setModel(new DefaultComboBoxModel(new String[] { "MAN", "WOMAN" }));
		comboBox_Gender.setBounds(164, 189, 130, 27);
		frame.getContentPane().add(comboBox_Gender);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(308, 252, 806, 242);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();

				TableModel model = table.getModel();
				tf_Id.setText(model.getValueAt(row, 0).toString());
				tf_firstname.setText(model.getValueAt(row, 1).toString());
				tf_lastname.setText(model.getValueAt(row, 2).toString());
				tf_email.setText(model.getValueAt(row, 3).toString());

				Student student = studentService.findByID(Long.parseLong(tf_Id.getText()));
				textField_phone1.setText(student.getContacts().getPhone1());
				textField_phone2.setText(student.getContacts().getPhone2());
				editorPane_adres1.setText(student.getContacts().getAddress1());
				editorPane_adres2.setText(student.getContacts().getAddress2());

				if (student.getGender().equalsIgnoreCase("MAN")) {
					comboBox_Gender.setSelectedItem("MAN");
				} else if (student.getGender().equalsIgnoreCase("WOMAN")) {
					comboBox_Gender.setSelectedItem("WOMAN");
				}
				
				String nameSurname = student.getName() + " " + student.getSurname();
				
				if ((nameSurname).equalsIgnoreCase("Afra Kaya")) {
					piclabel.setIcon(icon1);
					
				}else if ((nameSurname).equalsIgnoreCase("Ali Kaya")) {
					piclabel.setIcon(icon2);
					
				}else if ((nameSurname).equalsIgnoreCase("Alya Atıcı")) {
					piclabel.setIcon(icon3);
					
				}else if ((nameSurname).equalsIgnoreCase("Çağatay Karan")) {
					piclabel.setIcon(icon4);
					
				}else if ((nameSurname).equalsIgnoreCase("Çağrı Okan")) {
					piclabel.setIcon(icon5);
					
				}else if ((nameSurname).equalsIgnoreCase("Emrah Taran")) {
					piclabel.setIcon(icon6);
					
				}else if ((nameSurname).equalsIgnoreCase("Emre Eren")) {
					piclabel.setIcon(icon7);
					
				}else if ((nameSurname).equalsIgnoreCase("Faruk Çetin")) {
					piclabel.setIcon(icon8);
					
				}else if ((nameSurname).equalsIgnoreCase("Gülşah Delen")) {
					piclabel.setIcon(icon9);
					
				}else if ((nameSurname).equalsIgnoreCase("Mustafa Terzi")) {
					piclabel.setIcon(icon10);
					
				}else {
					//comboBox.getSelectedItem().toString().equalsIgnoreCase("Default");
					ImageIcon icon = new ImageIcon(getClass().getResource("/com/busecnky/images/"+imagenames[0]));
					icon.getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT);
					piclabel.setIcon(icon);
					//comboBox/.setSelectedIndex(0);
					}
			}
		});

		table.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "ID", "First Name", "Last Name", "Email" }));
		scrollPane.setViewportView(table);

		lblPhone = new JLabel("Phone");
		lblPhone.setBounds(550, 104, 93, 16);
		frame.getContentPane().add(lblPhone);

		btn_searchEmail = new JButton("Search By E-mail");
		btn_searchEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!(tf_email.getText().isEmpty())) {
					List<Student> list = studentService.getByEmail(tf_email.getText());

					if (list.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Email cannot be found.");
					} else {
						fillTheTable(list);
					}
				}
			}
		});
		btn_searchEmail.setBounds(308, 155, 230, 29);
		frame.getContentPane().add(btn_searchEmail);

		btn_searchFname = new JButton("Search By Name");
		btn_searchFname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(tf_firstname.getText().isEmpty())) {
					List<Student> list = studentService.getByName(tf_firstname.getText());
					if (list.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Student cannot be found.");
					} else {
						fillTheTable(list);
					}
				}
			}
		});
		btn_searchFname.setBounds(306, 97, 232, 29);
		frame.getContentPane().add(btn_searchFname);

		lblNewLabel_Language = new JLabel("Language");
		lblNewLabel_Language.setBounds(64, 439, 154, 16);
		frame.getContentPane().add(lblNewLabel_Language);

		JComboBox comboBox_Language = new JComboBox();
		comboBox_Language.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_Language.getSelectedItem().toString().equalsIgnoreCase("English")) {
					Locale.setDefault(new Locale("en", "EN"));
					i18n();
					comboBox_Language.setSelectedIndex(0);
				} else if (comboBox_Language.getSelectedItem().toString().equalsIgnoreCase("Türkçe")) {
					Locale.setDefault(new Locale("tr", "TR"));
					i18n();
					comboBox_Language.setSelectedIndex(1);
				} else if (comboBox_Language.getSelectedItem().toString().equalsIgnoreCase("Deutsch")) {
					Locale.setDefault(new Locale("de", "DE"));
					i18n();
					comboBox_Language.setSelectedIndex(2);
				} else if (comboBox_Language.getSelectedItem().toString().equalsIgnoreCase("Français")) {
					Locale.setDefault(new Locale("fr", "FR"));
					i18n();
					comboBox_Language.setSelectedIndex(3);
				}
			}
		});
		comboBox_Language
				.setModel(new DefaultComboBoxModel(new String[] { "English", "Türkçe", "Deutsch", "Français" }));
		comboBox_Language.setBounds(59, 468, 137, 27);
		frame.getContentPane().add(comboBox_Language);

		btn_searchSname = new JButton("Search By Surname");
		btn_searchSname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!(tf_lastname.getText().isEmpty())) {
					List<Student> list = studentService.getBySurname(tf_lastname.getText());
					if (list.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Student cannot be found.");
					} else {
						fillTheTable(list);
					}
				}
			}
		});
		btn_searchSname.setBounds(306, 125, 232, 29);
		frame.getContentPane().add(btn_searchSname);

		lblContactInfo1 = new JLabel("Contact Info 1");
		lblContactInfo1.setBounds(644, 72, 154, 16);
		frame.getContentPane().add(lblContactInfo1);

		lblContactInfo2 = new JLabel("Contact Info 2");
		lblContactInfo2.setBounds(810, 72, 183, 16);
		frame.getContentPane().add(lblContactInfo2);

		textField_phone1 = new JTextField();
		textField_phone1.setColumns(10);
		textField_phone1.setBounds(644, 99, 130, 26);
		frame.getContentPane().add(textField_phone1);

		textField_phone2 = new JTextField();
		textField_phone2.setColumns(10);
		textField_phone2.setBounds(804, 99, 130, 26);
		frame.getContentPane().add(textField_phone2);

		lblAddress = new JLabel("Address");
		lblAddress.setBounds(550, 132, 93, 16);
		frame.getContentPane().add(lblAddress);

		lblDateTime = new JLabel("New label");
		lblDateTime.setBounds(859, 27, 255, 16);
		frame.getContentPane().add(lblDateTime);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(644, 132, 119, 44);
		frame.getContentPane().add(scrollPane_1);

		editorPane_adres1 = new JEditorPane();
		scrollPane_1.setViewportView(editorPane_adres1);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(805, 132, 119, 44);
		frame.getContentPane().add(scrollPane_2);

		editorPane_adres2 = new JEditorPane();
		scrollPane_2.setViewportView(editorPane_adres2);

		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf_firstname.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Name area cannot be empty.");
				} else if (tf_lastname.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Last name area cannot be empty.");
				} else if (tf_email.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Email area cannot be empty.");
				} else if (textField_phone1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Phone 1 area cannot be empty.");
				} else if (editorPane_adres1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Address 1 area cannot be empty.");
				} else {
					Contact con = new Contact(textField_phone1.getText(), textField_phone2.getText(),
							editorPane_adres1.getText(), editorPane_adres2.getText());

					if (StringUtils.isNumeric(con.getPhone1())) {
						if (StringUtils.isNumeric(con.getPhone2()) || (con.getPhone2().isEmpty())) {
							Student student = new Student(tf_firstname.getText(), tf_lastname.getText(),
									tf_email.getText(), String.valueOf(comboBox_Gender.getSelectedItem()), con);
							if (!(student == null)) {
								if (!(con == null)) {
									contactsService.save(con);
									studentService.save(student);
									emptyFields();
								}
							}
						}

					} else {
						JOptionPane.showMessageDialog(null, "You should enter number for phone areas.");
					}

				}

				fillTable();
			}
		});
		btnSave.setBounds(59, 248, 174, 29);
		frame.getContentPane().add(btnSave);

		btnGetAll = new JButton("Get All");
		btnGetAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillTable();

			}
		});
		btnGetAll.setBounds(59, 289, 174, 29);
		frame.getContentPane().add(btnGetAll);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tf_firstname.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Name area cannot be empty.");
				} else if (tf_lastname.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Last name area cannot be empty.");
				} else if (tf_email.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Email area cannot be empty.");
				} else if (textField_phone1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Phone 1 area cannot be empty.");
				} else if (editorPane_adres1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Address 1 area cannot be empty.");
				} else {
					if (StringUtils.isNumeric(textField_phone1.getText())) {
						if (StringUtils.isNumeric(textField_phone2.getText()) || (textField_phone2.getText().isEmpty())) {
							if(tf_email.getText().contains("@")) {
								if(!(tf_email.getText().startsWith("@"))){
									Contact contact = contactsService.update(Long.parseLong(tf_Id.getText()),
											textField_phone1.getText(), textField_phone2.getText(), editorPane_adres1.getText(),
											editorPane_adres2.getText());

									studentService.update(Long.parseLong(tf_Id.getText()), tf_firstname.getText(),
											tf_lastname.getText(), tf_email.getText(),
											String.valueOf(comboBox_Gender.getSelectedItem()), contact);
									
									JOptionPane.showMessageDialog(null, "Student updated successfully.");
									emptyFields();
									
								}else {
									JOptionPane.showMessageDialog(null, "Email can't start with @ sign.");
								}
							}else {
								JOptionPane.showMessageDialog(null, "Email should have @ sign.");
							}
							
						}
					}else {
						JOptionPane.showMessageDialog(null, "You should enter number for phone areas.");
					}

				}
				fillTable();
			}
		});
		btnUpdate.setBounds(59, 330, 174, 29);
		frame.getContentPane().add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!(tf_Id.getText().isEmpty())) {
					Student student = studentService.findByID(Long.parseLong(tf_Id.getText()));
					int result = JOptionPane.showConfirmDialog(frame, "Sure? You want to delete?", "Delete Student",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {

						contactsService.delete((student.getContacts().getId()));
						studentService.delete(Long.parseLong(tf_Id.getText()));

						JOptionPane.showMessageDialog(null, "You deleted successfully");
					} else if (result == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "Your deletion has been canceled");
					} else {
						JOptionPane.showMessageDialog(null, "None selected");
					}

				} else {
					JOptionPane.showMessageDialog(null, "You must click on the student you want to delete");
				}

				fillTable();
				emptyFields();
			}
		});
		btnDelete.setBounds(59, 371, 174, 29);
		frame.getContentPane().add(btnDelete);
		

		
	}

	private void fillTable() {
		List<Student> list = studentService.getAll();
		fillTheTable(list);
	}

	private void emptyFields() {
		tf_firstname.setText("");
		tf_lastname.setText("");
		tf_email.setText("");
		tf_Id.setText("");
		textField_phone1.setText("");
		textField_phone2.setText("");
		editorPane_adres1.setText("");
		editorPane_adres2.setText("");
	}

	public void fillTheTable(List<Student> list) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		model.setRowCount(0);

		Object[] columns = new Object[4];
		for (int i = 0; i < list.size(); i++) {
			columns[0] = list.get(i).getId();
			columns[1] = list.get(i).getName();
			columns[2] = list.get(i).getSurname();
			columns[3] = list.get(i).getEmail();

			model.addRow(columns);
		}
	}
}