package es.elorrieta.aam.view.windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MaskFormatter;

import es.elorrieta.aam.controller.LoginSignupValidation;
import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
import es.elorrieta.aam.model.bbdd.manager.ManagerCustomers;
import es.elorrieta.aam.model.bbdd.manager.ManagerEmployee;
import es.elorrieta.aam.model.bbdd.pojo.Address;
import es.elorrieta.aam.model.bbdd.pojo.Customer;
import es.elorrieta.aam.model.bbdd.pojo.EmployeeManagedOrders;
import es.elorrieta.aam.model.bbdd.pojo.Order;

public class Profile extends JFrame {

	private static final long serialVersionUID = 8686585852859562151L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldLastName;
	private JTextField textFieldEmail;
	private JFormattedTextField textFieldBirthDate;
	private JTextField textFieldAddress;
	private JTextField textFieldzip;
	private JTextField textFieldCity;
	private JTextField textFieldCountry;
	private JPasswordField passwordField;
	private JLabel lblFoto;
	private JTextField textFieldProvince;
	private JLabel lblEmailWarning;
	private JLabel lblPassWarning;
	private JLabel lblBirthDateWarning;

	public Profile(Order order) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 0, 1217, 661);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnDeleteAccount = new JButton("Borrar Mi Cuenta");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (askUser("Estas seguro??", "Borrar Cuenta") != 0) {
					if (order.getCustomer().getProfile().getUser() instanceof Customer) {
						ManagerCustomers managerCustomer = new ManagerCustomers();

						try {
							managerCustomer.delete((Customer) order.getCustomer().getProfile().getUser());
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(contentPane, "Data Base Error. Contents cannot be displayed",
									"ERROR!!", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						} catch (AccessToDataBaseException e1) {
							JOptionPane.showMessageDialog(contentPane,
									"Data Base Access. Coundn't connect to data base  ", "ERROR!!",
									JOptionPane.ERROR_MESSAGE);
						} catch (NotFoundException e1) {
							JOptionPane.showMessageDialog(contentPane, "Data Base is empty", "ERROR!!",
									JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(contentPane, "Generic error...", "ERROR!!",
									JOptionPane.ERROR_MESSAGE);
						}
						JOptionPane.showMessageDialog(null, "Se ha borrado la cuenta correctamente");
						order.getCustomer().getProfile().setOn(false);
						order.setCustomer(null);

						dispose();
						new GenderWindow(order).setVisible(true);

					} else {
						ManagerEmployee managerEmployee = new ManagerEmployee();
						try {
							managerEmployee.delete((EmployeeManagedOrders) order.getCustomer().getProfile().getUser());
							JOptionPane.showMessageDialog(null, "Se ha borrado la cuenta correctamente");
							order.getCustomer().getProfile().setOn(false);
							order.setCustomer(null);
							dispose();
							new GenderWindow(order).setVisible(true);
						} catch (SQLException e1) {
							JOptionPane.showMessageDialog(contentPane, "Data Base Error. Contents cannot be displayed",
									"ERROR!!", JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						} catch (AccessToDataBaseException e1) {
							JOptionPane.showMessageDialog(contentPane,
									"Data Base Access. Coundn't connect to data base  ", "ERROR!!",
									JOptionPane.ERROR_MESSAGE);
						} catch (NotFoundException e1) {
							JOptionPane.showMessageDialog(contentPane, "Data Base is empty", "ERROR!!",
									JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(contentPane, "Generic error...", "ERROR!!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		btnDeleteAccount.setBackground(new Color(255, 255, 255));
		btnDeleteAccount.setForeground(new Color(128, 64, 0));
		btnDeleteAccount.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
		btnDeleteAccount.setBounds(36, 458, 183, 39);
		panel.add(btnDeleteAccount);

		JButton btnNewButton_1 = new JButton("Modificar Mis Datos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makeAllWarningsInvisible();
				LoginSignupValidation validate = new LoginSignupValidation();
				String date = textFieldBirthDate.getText();
				String pass = new String(passwordField.getPassword());
				String email = textFieldEmail.getText();

				if (!areAllInfoCorrect(validate, date, email, pass)) {
					setWarningsDateEmailPass(validate, date, email, pass);
				} else {

					try {
						if (getUserInfo(order) instanceof Customer) {
							ManagerCustomers managerCustomer = new ManagerCustomers();
							order.getCustomer().getProfile().setUser((Customer) getUserInfo(order));

							try {
								managerCustomer.update((Customer) getUserInfo(order));
							} catch (SQLException e1) {
								JOptionPane.showMessageDialog(contentPane,
										"Data Base Error. Contents cannot be displayed", "ERROR!!",
										JOptionPane.ERROR_MESSAGE);
								e1.printStackTrace();
							} catch (AccessToDataBaseException e1) {
								JOptionPane.showMessageDialog(contentPane,
										"Data Base Access. Coundn't connect to data base  ", "ERROR!!",
										JOptionPane.ERROR_MESSAGE);
							} catch (NotFoundException e1) {
								JOptionPane.showMessageDialog(contentPane, "Data Base is empty", "ERROR!!",
										JOptionPane.ERROR_MESSAGE);
								e1.printStackTrace();
							} catch (Exception e1) {
								System.out.println(e1);
								JOptionPane.showMessageDialog(contentPane, "Generic error...", "ERROR!!",
										JOptionPane.ERROR_MESSAGE);
							}

							JOptionPane.showMessageDialog(null, "Se han realizado correctamente las modificaiones ");
							new Profile(order);

//updateCustomer
						} else {
							ManagerEmployee managerEmployee = new ManagerEmployee();
							try {
								managerEmployee.update((EmployeeManagedOrders) getUserInfo(order));
								JOptionPane.showMessageDialog(null,
										"Se han reakizado correctamente las modificaiones ");
								new Profile(order);
							} catch (SQLException e1) {
								JOptionPane.showMessageDialog(contentPane,
										"Data Base Error. Contents cannot be displayed", "ERROR!!",
										JOptionPane.ERROR_MESSAGE);
								e1.printStackTrace();
							} catch (AccessToDataBaseException e1) {
								JOptionPane.showMessageDialog(contentPane,
										"Data Base Access. Coundn't connect to data base  ", "ERROR!!",
										JOptionPane.ERROR_MESSAGE);
							} catch (NotFoundException e1) {
								JOptionPane.showMessageDialog(contentPane, "Data Base is empty", "ERROR!!",
										JOptionPane.ERROR_MESSAGE);
								e1.printStackTrace();
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(contentPane, "Generic error...", "ERROR!!",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					} catch (ParseException e1) {
						System.out.println("Parsing error");
					}

				}
			}
		});
		btnNewButton_1.setBackground(new Color(238, 130, 238));
		btnNewButton_1.setForeground(new Color(128, 64, 0));
		btnNewButton_1.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
		btnNewButton_1.setBounds(38, 392, 181, 31);
		panel.add(btnNewButton_1);

		JButton btnEditFoto = new JButton("");
		btnEditFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				File file = getImageFromUser(e);
				if (null != getImageFromUser(e)) {
					order.getCustomer().getProfile().getUser().setImage(file);
					setUserFoto(order);

				}
			}
		});
		btnEditFoto.setBackground(new Color(255, 255, 255));
		btnEditFoto.setIcon(new ImageIcon(Profile.class.getResource("/images/3838756.png")));
		btnEditFoto.setBounds(182, 283, 54, 49);
		panel.add(btnEditFoto);

		JPanel panelheader = new JPanel();
		panelheader.setBackground(new Color(255, 128, 0));
		panelheader.setForeground(new Color(255, 128, 0));
		panelheader.setBounds(0, 0, 1197, 52);
		panel.add(panelheader);
		panelheader.setLayout(null);

		JButton btnExit = new JButton("Cerrar Sesion");
		btnExit.setFont(new Font("Source Sans Pro", Font.BOLD, 13));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (askUser("Estas seguro??", "Cerrar Sesion") != 0) {
					order.getCustomer().getProfile().setOn(false);
					order.setCustomer(null);

					dispose();
					new GenderWindow(order).setVisible(true);
				}

			}
		});
		btnExit.setBounds(1045, 11, 130, 30);
		panelheader.add(btnExit);

		JButton btnGoBack = new JButton("Atras");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenderWindow genderWin = new GenderWindow(order);
				dispose();
				genderWin.setVisible(true);
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGoBack.setBounds(22, 16, 89, 23);
		panelheader.add(btnGoBack);

		JPanel panelFooter = new JPanel();
		panelFooter.setBackground(new Color(254, 167, 5));
		panelFooter.setBounds(0, 612, 1207, 49);
		panel.add(panelFooter);

		lblFoto = new JLabel("");
		lblFoto.setBounds(36, 123, 183, 183);
		panel.add(lblFoto);
		lblFoto.setIcon(new ImageIcon(Profile.class.getResource("/images/istockphoto-1298261537-612x612.jpg")));
		lblFoto.setBackground(new Color(0, 0, 0));
		lblFoto.setForeground(new Color(0, 0, 0));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel
				.setIcon(new ImageIcon(Profile.class.getResource("/images/mona-eendra-vC8wj_Kphak-unsplash (1).jpg")));
		lblNewLabel.setBounds(0, 51, 278, 560);
		panel.add(lblNewLabel);

		textFieldName = new JTextField();
		textFieldName.setBackground(new Color(255, 255, 255));
		textFieldName.setBounds(416, 123, 145, 39);
		panel.add(textFieldName);
		textFieldName.setColumns(10);

		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(616, 123, 268, 39);
		panel.add(textFieldLastName);
		textFieldLastName.setColumns(10);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(416, 225, 268, 39);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JLabel lblname = new JLabel("Nombre : ");
		lblname.setForeground(new Color(128, 64, 0));
		lblname.setFont(new Font("Source Sans Pro Light", Font.BOLD, 14));
		lblname.setBounds(416, 91, 142, 21);
		panel.add(lblname);

		JLabel lblNewLabel_1 = new JLabel("Apellidos :");
		lblNewLabel_1.setFont(new Font("Source Sans Pro Light", Font.BOLD, 14));
		lblNewLabel_1.setBounds(616, 91, 263, 21);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Email: ");
		lblNewLabel_2.setFont(new Font("Source Serif Pro Light", Font.BOLD, 14));
		lblNewLabel_2.setBounds(416, 193, 168, 21);
		panel.add(lblNewLabel_2);

		MaskFormatter fmt = null;
		try {
			fmt = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, e);
		}

		textFieldBirthDate = new JFormattedTextField(fmt);

		textFieldBirthDate.setBounds(931, 123, 205, 39);
		panel.add(textFieldBirthDate);
		textFieldBirthDate.setColumns(10);

		JLabel lblBirthDate = new JLabel("Fecha de nacimiento :");
		lblBirthDate.setFont(new Font("Source Serif Pro Light", Font.BOLD, 14));
		lblBirthDate.setBounds(931, 94, 205, 14);
		panel.add(lblBirthDate);

		JLabel lblPass = new JLabel("Contraseña :");
		lblPass.setFont(new Font("Source Serif Pro Light", Font.BOLD, 14));
		lblPass.setBounds(823, 193, 332, 21);
		panel.add(lblPass);

		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(416, 368, 240, 39);
		panel.add(textFieldAddress);
		textFieldAddress.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Calle:");
		lblNewLabel_3.setFont(new Font("Source Serif Pro Light", Font.BOLD, 14));
		lblNewLabel_3.setBounds(416, 336, 240, 21);
		panel.add(lblNewLabel_3);

		textFieldzip = new JTextField();
		textFieldzip.setBounds(931, 368, 205, 39);
		panel.add(textFieldzip);
		textFieldzip.setColumns(10);

		JLabel lblCodPostal = new JLabel("Codigo postal:");
		lblCodPostal.setFont(new Font("Source Serif Pro Light", Font.BOLD, 14));
		lblCodPostal.setBounds(991, 330, 145, 33);
		panel.add(lblCodPostal);

		textFieldCity = new JTextField();
		textFieldCity.setBounds(416, 473, 268, 39);
		panel.add(textFieldCity);
		textFieldCity.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Ciudad :");
		lblNewLabel_4.setFont(new Font("Source Serif Pro Light", Font.BOLD, 14));
		lblNewLabel_4.setBounds(416, 429, 174, 33);
		panel.add(lblNewLabel_4);

		textFieldCountry = new JTextField();
		textFieldCountry.setBounds(946, 473, 190, 39);
		panel.add(textFieldCountry);
		textFieldCountry.setColumns(10);

		JLabel lblPais = new JLabel("Pais:");
		lblPais.setFont(new Font("Source Serif Pro Light", Font.BOLD, 14));
		lblPais.setForeground(new Color(0, 0, 0));
		lblPais.setBounds(946, 435, 190, 25);
		panel.add(lblPais);

		passwordField = new JPasswordField();
		passwordField.setBounds(823, 225, 313, 39);
		panel.add(passwordField);

		textFieldProvince = new JTextField();
		textFieldProvince.setBounds(733, 474, 168, 36);
		panel.add(textFieldProvince);
		textFieldProvince.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Provencia");
		lblNewLabel_5.setFont(new Font("Source Sans Pro Light", Font.BOLD, 14));
		lblNewLabel_5.setBounds(733, 440, 168, 14);
		panel.add(lblNewLabel_5);

		lblEmailWarning = new JLabel("Email invalido!!!");
		lblEmailWarning.setVisible(false);
		lblEmailWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailWarning.setForeground(new Color(255, 0, 0));
		lblEmailWarning.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 14));
		lblEmailWarning.setBounds(416, 275, 268, 31);
		panel.add(lblEmailWarning);

		lblPassWarning = new JLabel("Contraseña invalida!!!");
		lblPassWarning.setVisible(false);
		lblPassWarning.setForeground(new Color(255, 0, 0));
		lblPassWarning.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 14));
		lblPassWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassWarning.setBounds(823, 275, 313, 31);
		panel.add(lblPassWarning);

		lblBirthDateWarning = new JLabel("Fecha invalida!!!");
		lblBirthDateWarning.setVisible(false);
		lblBirthDateWarning.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirthDateWarning.setForeground(new Color(255, 0, 0));
		lblBirthDateWarning.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 14));
		lblBirthDateWarning.setBounds(931, 173, 205, 21);
		panel.add(lblBirthDateWarning);
		setInfoUser(order);
	}

	private void setInfoUser(Order order) {

		textFieldName.setText(order.getCustomer().getProfile().getUser().getName() == null ? ""
				: order.getCustomer().getProfile().getUser().getName());
		textFieldLastName.setText(order.getCustomer().getProfile().getUser().getLastName() == null ? ""
				: order.getCustomer().getProfile().getUser().getLastName());
		textFieldEmail.setText(order.getCustomer().getProfile().getUser().getEmail() == null ? ""
				: order.getCustomer().getProfile().getUser().getEmail());
		textFieldBirthDate.setText(order.getCustomer().getProfile().getUser().getBirthDate() == null ? ""
				: new SimpleDateFormat("dd/MM/yyyy").format(order.getCustomer().getProfile().getUser().getBirthDate()));
		passwordField.setText(order.getCustomer().getProfile().getUser().getPassword() == null ? ""
				: order.getCustomer().getProfile().getUser().getPassword());
		if (order.getCustomer().getProfile().getUser().getAddress() != null) {
			textFieldAddress.setText(order.getCustomer().getProfile().getUser().getAddress().getStreet() == null ? ""
					: order.getCustomer().getProfile().getUser().getAddress().getStreet());
			textFieldzip.setText(order.getCustomer().getProfile().getUser().getAddress().getCodPostal() == null ? ""
					: order.getCustomer().getProfile().getUser().getAddress().getCodPostal());
			textFieldCity.setText(order.getCustomer().getProfile().getUser().getAddress().getCity() == null ? ""
					: order.getCustomer().getProfile().getUser().getAddress().getCity());
			textFieldCountry.setText(order.getCustomer().getProfile().getUser().getAddress().getCountry() == null ? ""
					: order.getCustomer().getProfile().getUser().getAddress().getCountry());
			textFieldProvince.setText(order.getCustomer().getProfile().getUser().getAddress().getProvince() == null ? ""
					: order.getCustomer().getProfile().getUser().getAddress().getProvince());

		}
		setUserFoto(order);
	}

	private void setUserFoto(Order order) {
		if (order.getCustomer().getProfile().getUser().getImage() != null)

			lblFoto.setIcon(new javax.swing.ImageIcon(
					new LoginSignupValidation().getImage(order.getCustomer().getProfile().getUser().getImage())
							.getScaledInstance(183, 183, WIDTH)));
	}

	private <T> T getUserInfo(Order order) throws ParseException {
		T ret = null;
		if (3 != order.getCustomer().getProfile().getUserType()) {
			EmployeeManagedOrders employee = getEmployeeInfo(order);
			ret = (T) employee;
		} else {
			Customer customer = getCustomerInfo(order);
			ret = ((T) customer);
		}
		return (T) ret;
	}

	private EmployeeManagedOrders getEmployeeInfo(Order order) throws ParseException {
		EmployeeManagedOrders ret = new EmployeeManagedOrders();
		ret.setId(order.getCustomer().getProfile().getUser().getId());
		ret.setName(textFieldName.getText());
		ret.setLastName(textFieldLastName.getText());
		ret.setEmail(textFieldEmail.getText());
		ret.setPassword(new String(passwordField.getPassword()));
		ret.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(textFieldBirthDate.getText()));

		if (areAllAddressFieldsCompleted()) {
			Address address = new Address();
			if (order.getCustomer().getProfile().getUser().getAddress() != null) {
				address.setId(order.getCustomer().getProfile().getUser().getAddress().getId());
				address.setCreatedAt(order.getCustomer().getProfile().getUser().getAddress().getCreatedAt());
			} else {
				address.setCreatedAt(new Date());
			}
			address.setStreet(textFieldAddress.getText());
			address.setCodPostal(textFieldzip.getText());
			address.setCity(textFieldCity.getText());
			address.setCountry(textFieldCountry.getText());
			address.setProvince(textFieldProvince.getText());
			ret.setAddress(address);
		}
		ret.setImage(order.getCustomer().getProfile().getUser().getImage());
		ret.setEmployeeType(order.getCustomer().getProfile().getUserType());

		return ret;
	}

	private Customer getCustomerInfo(Order order) throws ParseException {
		Customer ret = new Customer();
		ret.setId(order.getCustomer().getProfile().getUser().getId());
		ret.setName(textFieldName.getText());
		ret.setLastName(textFieldLastName.getText());
		ret.setEmail(textFieldEmail.getText());
		ret.setEmail(textFieldEmail.getText());
		ret.setPassword(new String(passwordField.getPassword()));
		ret.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(textFieldBirthDate.getText()));

		if (areAllAddressFieldsCompleted()) {
			Address address = new Address();
			if (order.getCustomer().getProfile().getUser().getAddress() != null) {
				address.setId(order.getCustomer().getProfile().getUser().getAddress().getId());
				address.setCreatedAt(order.getCustomer().getProfile().getUser().getAddress().getCreatedAt());
			} else {
				address.setCreatedAt(new Date());
			}

			address.setStreet(textFieldAddress.getText());
			address.setCodPostal(textFieldzip.getText());
			address.setCity(textFieldCity.getText());
			address.setCountry(textFieldCountry.getText());
			address.setProvince(textFieldProvince.getText());
			ret.setAddress(address);
		}
		ret.setImage(order.getCustomer().getProfile().getUser().getImage());

		return ret;
	}

	private boolean areAllAddressFieldsCompleted() {
		boolean ret = false;
		if (!textFieldAddress.getText().isEmpty() && !textFieldzip.getText().isEmpty()
				&& !textFieldCity.getText().isEmpty() && !textFieldCountry.getText().isEmpty()) {
			ret = true;
		}
		return ret;

	}

	public File getImageFromUser(ActionEvent event) {
		File ret = null;
		JFileChooser fileChooser = new JFileChooser();

		FileNameExtensionFilter filter = new FileNameExtensionFilter("images", "jpg", "png");
		fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showOpenDialog(null);
		File file = fileChooser.getSelectedFile();
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			if (file.getName().endsWith(".jpg") || file.getName().endsWith(".png")) {
				ret = file;
			} else
				JOptionPane.showMessageDialog(null, "select .jpg , png");
		}
		return ret;
	}

	private int askUser(String message, String title) {
		int ret = 0;
		int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
		if (reply == JOptionPane.YES_OPTION) {
			ret = 1;
		}
		return ret;
	}

	private boolean areAllInfoCorrect(LoginSignupValidation validate, String date, String email, String pass) {
		boolean ret = false;
		if (validate.isValidDate(date) && validate.isValidPassword(pass) && validate.isValidEmail(email)) {
			ret = true;
		}
		return ret;

	}

	private boolean setWarningsDateEmailPass(LoginSignupValidation validate, String date, String email, String pass) {
		makeDateWrningVisible(validate, date);
		makeEmailWarningVisible(validate, email);
		makePassWarningVisible(validate, pass);
		return false;

	}

	private void makeDateWrningVisible(LoginSignupValidation validate, String date) {
		if (!validate.isValidDate(date)) {
			lblBirthDateWarning.setVisible(true);
		}
	}

	private void makeEmailWarningVisible(LoginSignupValidation validate, String email) {
		if (!validate.isValidEmail(email)) {
			lblEmailWarning.setVisible(true);
		}
	}

	private void makePassWarningVisible(LoginSignupValidation validate, String pass) {
		if (!validate.isValidPassword(pass)) {
			lblPassWarning.setVisible(true);

		}
	}

	private void makeAllWarningsInvisible() {
		lblBirthDateWarning.setVisible(false);
		lblEmailWarning.setVisible(false);
		lblPassWarning.setVisible(false);

	}
}
