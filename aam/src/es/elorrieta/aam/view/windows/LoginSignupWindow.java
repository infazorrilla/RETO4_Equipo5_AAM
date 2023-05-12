package es.elorrieta.aam.view.windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import java.util.ArrayList;
import es.elorrieta.aam.controller.LoginSignupValidation;
import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
import es.elorrieta.aam.model.bbdd.manager.ManagerCustomers;
import es.elorrieta.aam.model.bbdd.manager.ManagerEmployee;
import es.elorrieta.aam.model.bbdd.pojo.Customer;
import es.elorrieta.aam.model.bbdd.pojo.EmployeeManagedOrders;
import es.elorrieta.aam.model.bbdd.pojo.Order;
import es.elorrieta.aam.model.bbdd.pojo.Profile;

public class LoginSignupWindow extends JFrame {

	private static final long serialVersionUID = 5963032894092933466L;

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JLabel lblGif;
	private JButton btnLogin;
	private JTextField textFieldBirthDate;
	private JPanel panel;
	private JLabel lblHeader;
	private JButton btnASignup;
	private JButton btnBack;
	private JLabel lblMailIcon;
	private JLabel lblPass;
	private JLabel lblIconCalendar;
	private JLabel lblDateWarning;
	private JLabel lblEmailWarning;
	private JLabel lblPassPartOneWarn;
	private JLabel lblPassPartTwoWrn;

	public LoginSignupWindow(Order order) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1217, 661);
		contentPane.add(panel);
		panel.setLayout(null);

		lblGif = new JLabel("");
		lblGif.setIcon(new ImageIcon(LoginSignupWindow.class.getResource("/es/images/2020-fashion-trends.gif")));

		lblGif.setBounds(600, 52, 597, 561);
		panel.add(lblGif);

		textField = new JTextField();
		textField.setBounds(145, 255, 284, 46);
		panel.add(textField);
		textField.setColumns(10);

		btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = textField.getText();
				String pass = new String(passwordField.getPassword());

				if (e.getActionCommand().equalsIgnoreCase("login")) {
					try {
						checkLogin(email, pass, order);

					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(contentPane, "Data Base Error. Contents cannot be displayed",
								"ERROR!!", JOptionPane.ERROR_MESSAGE);

					} catch (AccessToDataBaseException e1) {
						JOptionPane.showMessageDialog(contentPane, "Data Base Access. Coundn't connect to data base  ",
								"ERROR!!", JOptionPane.ERROR_MESSAGE);
					} catch (NotFoundException e1) {
						JOptionPane.showMessageDialog(contentPane, "Data Base is empty", "ERROR!!",
								JOptionPane.ERROR_MESSAGE);

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(contentPane, "Generic error...", "ERROR!!",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {
					String date = textFieldBirthDate.getText();

					makeAllWarningsInvisible();
					try {
						checkSigUp(email, date, pass);
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(contentPane, "Data Base Error. Contents cannot be displayed",
								"ERROR!!", JOptionPane.ERROR_MESSAGE);

					} catch (AccessToDataBaseException e1) {
						JOptionPane.showMessageDialog(contentPane, "Data Base Access. Coundn't connect to data base  ",
								"ERROR!!", JOptionPane.ERROR_MESSAGE);
					} catch (NotFoundException e1) {
						JOptionPane.showMessageDialog(contentPane, "Data Base is empty", "ERROR!!",
								JOptionPane.ERROR_MESSAGE);

					} catch (ParseException e1) {
						System.out.println("parsing error");
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(contentPane, "Generic error...", "ERROR!!",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});
		btnLogin.setBounds(228, 417, 104, 38);
		panel.add(btnLogin);

		lblHeader = new JLabel("Log In");
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblHeader.setBounds(208, 148, 146, 46);
		panel.add(lblHeader);

		JPanel panelheader = new JPanel();
		panelheader.setBackground(new Color(255, 128, 0));
		panelheader.setForeground(new Color(255, 128, 0));
		panelheader.setBounds(0, 0, 1197, 52);
		panel.add(panelheader);
		panelheader.setLayout(null);

		btnASignup = new JButton("SIGNUP");
		btnASignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changesForSignUp();

			}
		});
		btnASignup.setBounds(1045, 11, 130, 30);
		panelheader.add(btnASignup);

		btnBack = new JButton("ATRAS");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (btnLogin.getActionCommand().equalsIgnoreCase("login")) {
					dispose();
					GenderWindow genderWindow = new GenderWindow(order);
					genderWindow.setVisible(true);

				} else {
					changesCancel();
					refreshJtextFields();
					makeAllWarningsInvisible();
				}
			}
		});
		btnBack.setBounds(25, 11, 118, 30);
		panelheader.add(btnBack);

		JPanel panelFooter = new JPanel();
		panelFooter.setBackground(new Color(255, 128, 0));
		panelFooter.setBounds(0, 612, 1207, 49);
		panel.add(panelFooter);

		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 201, 147));
		passwordField.setBounds(145, 344, 284, 46);
		panel.add(passwordField);

		lblMailIcon = new JLabel("");
		lblMailIcon.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/es/images/mail.png"))
				.getImage().getScaledInstance(54, 45, Image.SCALE_SMOOTH)));

		lblMailIcon.setBounds(91, 256, 54, 45);
		panel.add(lblMailIcon);

		lblPass = new JLabel("");
		lblPass.setIcon(new ImageIcon(LoginSignupWindow.class.getResource("/es/images/pass.png")));
		lblPass.setBounds(91, 344, 54, 46);
		panel.add(lblPass);
	}

	private void changesForSignUp() {
		lblGif.setBounds(0, 53, 553, 559);
		textField.setBounds(674, 285, 284, 46);
		textField.setText("");
		MaskFormatter fmt = null;
		try {
			fmt = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, e);
		}

		textFieldBirthDate = new JFormattedTextField(fmt);
		textFieldBirthDate.setBounds(674, 199, 284, 46);
		panel.add(textFieldBirthDate);
		textFieldBirthDate.setColumns(10);
		lblHeader.setBounds(615, 116, 396, 46);
		lblHeader.setText("Sign Up");
		passwordField.setBounds(674, 365, 284, 46);
		passwordField.setText("");
		btnLogin.setBounds(754, 468, 104, 38);
		btnLogin.setText("Signup");
		btnLogin.setActionCommand("Signup");
		btnASignup.setVisible(false);
		lblPass.setBounds(615, 369, 59, 42);
		lblMailIcon.setBounds(615, 285, 59, 46);
		lblIconCalendar = new JLabel("");
		lblIconCalendar.setIcon(new ImageIcon(LoginSignupWindow.class.getResource("/es/images/calendar.png")));
		lblIconCalendar.setBounds(618, 199, 56, 46);

		panel.add(lblIconCalendar);
		lblDateWarning = new JLabel("    Fecha invalida !!");
		lblDateWarning.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 15));
		lblDateWarning.setForeground(new Color(255, 0, 0));
		lblDateWarning.setBackground(new Color(255, 0, 0));
		lblDateWarning.setBounds(961, 199, 236, 46);

		panel.add(lblDateWarning);

		lblEmailWarning = new JLabel(" Email invalido !!");
		lblEmailWarning.setForeground(new Color(255, 0, 0));
		lblEmailWarning.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 15));
		lblEmailWarning.setBounds(982, 285, 189, 46);

		panel.add(lblEmailWarning);

		lblPassPartOneWarn = new JLabel(" Contraseña invalida !! ");
		lblPassPartOneWarn.setForeground(new Color(255, 0, 0));
		lblPassPartOneWarn.setFont(new Font("Lucida Handwriting", Font.BOLD | Font.ITALIC, 14));
		lblPassPartOneWarn.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassPartOneWarn.setBounds(968, 365, 229, 31);

		panel.add(lblPassPartOneWarn);

		lblPassPartTwoWrn = new JLabel(
				"Debe tener Mayusculas , Minisculas  Numeros , Caracter especial Min: 8 Carac Max:20     ");
		lblPassPartTwoWrn.setFont(new Font("Source Serif Pro Light", Font.BOLD, 11));
		lblPassPartTwoWrn.setForeground(new Color(0, 255, 0));
		lblPassPartTwoWrn.setBounds(672, 422, 525, 38);

		panel.add(lblPassPartTwoWrn);
		makeAllWarningsInvisible();
	}

	private void makeAllWarningsInvisible() {
		lblDateWarning.setVisible(false);
		lblEmailWarning.setVisible(false);
		lblPassPartOneWarn.setVisible(false);
		lblPassPartTwoWrn.setVisible(false);
	}

	private void changesCancel() {
		lblGif.setBounds(600, 52, 597, 561);
		textField.setBounds(145, 255, 284, 46);
		panel.remove(textFieldBirthDate);
		lblHeader.setBounds(208, 148, 146, 46);
		lblHeader.setText("Sign Up");
		passwordField.setBounds(145, 344, 284, 46);
		btnLogin.setBounds(228, 417, 104, 38);
		btnLogin.setText("Log In");
		btnLogin.setActionCommand("login");
		btnASignup.setVisible(true);
		panel.remove(lblIconCalendar);
		lblPass.setBounds(91, 344, 54, 46);
		lblMailIcon.setBounds(91, 256, 54, 45);

	}

	private void checkLogin(String email, String pass, Order order)
			throws SQLException, AccessToDataBaseException, NotFoundException, Exception {

		ArrayList<Object> isCustomer = checkCustomerLogin(email, pass, order);

		if (isCustomer.get(0) == null) {
			ArrayList<Object> isEmployee = checkEmployeeLogin(email, pass, order);
			if (isEmployee.get(0) == null) {
				JOptionPane.showMessageDialog(null, "Usuario o contraseña incorreacta");
			} else if ((boolean) isEmployee.get(1)) {
				JOptionPane.showMessageDialog(null, "No puedes iniciar sesion , esta cuenta esta bloqueada");
			} else {
				textField.setText("");
				passwordField.setText("");
				JOptionPane.showMessageDialog(null, "Bienvenido");
				dispose();
				GenderWindow genderWindow = new GenderWindow(order);
				genderWindow.setVisible(true);
			}

		} else if ((boolean) isCustomer.get(1)) {
			JOptionPane.showMessageDialog(null, "No puedes iniciar sesion , esta cuenta esta bloqueada");
		} else {
			textField.setText("");
			passwordField.setText("");
			JOptionPane.showMessageDialog(null, "Bienvenido");
			dispose();
			GenderWindow genderWindow = new GenderWindow(order);
			genderWindow.setVisible(true);
		}

	}

	private Customer isCustomerExist(String email, String pass)
			throws SQLException, AccessToDataBaseException, NotFoundException, Exception {

		Customer customer = new Customer();
		ManagerCustomers managerCustomer = new ManagerCustomers();
		customer.setPassword(pass);
		customer.setEmail(email);

		Customer ret = managerCustomer.select(customer);
		return ret;

	}

	private ArrayList<Object> checkCustomerLogin(String email, String pass, Order order)
			throws SQLException, AccessToDataBaseException, NotFoundException, Exception {
		ArrayList<Object> ret = new ArrayList<Object>();
		Customer customer = isCustomerExist(email, pass);
		ret.add(customer);
		ret.add(false);
		if (customer != null) {
			if (!customer.isStatus()) {
				order.setCustomer(customer);
				Profile profile = new Profile();
				profile.setUser(customer);
				order.getCustomer().setProfile(profile);

				order.getCustomer().getProfile().setOn(true);
				order.getCustomer().getProfile().setUserType(3);
				ret.set(0, customer);
			} else {
				ret.set(1, true);
			}
		}

		return ret;
	}

	private EmployeeManagedOrders isEmployeeExist(String email, String pass)
			throws SQLException, AccessToDataBaseException, NotFoundException, Exception {

		EmployeeManagedOrders employee = new EmployeeManagedOrders();
		ManagerEmployee managerEmployee = new ManagerEmployee();
		employee.setPassword(pass);
		employee.setEmail(email);

		EmployeeManagedOrders ret = new EmployeeManagedOrders();
		ret = managerEmployee.select(employee);
		return ret;

	}

	private ArrayList<Object> checkEmployeeLogin(String email, String pass, Order order)
			throws SQLException, AccessToDataBaseException, NotFoundException, Exception {
		ArrayList<Object> ret = new ArrayList<Object>();
		EmployeeManagedOrders employee = isEmployeeExist(email, pass);
		ret.add(employee);
		ret.add(false);

		if (employee != null) {
			if (!employee.isStatus()) {
				Profile profile = new Profile();
				profile.setUser(employee);
				profile.setOn(true);
				profile.setUserType(employee.getEmployeeType());
				order.setCustomer(new Customer());
				order.getCustomer().setProfile(profile);
				ret.set(0, employee);
			} else {

				ret.set(1, true);
			}
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
			lblDateWarning.setVisible(true);
		}
	}

	private void makeEmailWarningVisible(LoginSignupValidation validate, String email) {
		if (!validate.isValidEmail(email)) {
			lblEmailWarning.setVisible(true);
		}
	}

	private void makePassWarningVisible(LoginSignupValidation validate, String pass) {
		if (!validate.isValidPassword(pass)) {
			lblPassPartOneWarn.setVisible(true);
			lblPassPartTwoWrn.setVisible(true);
		}
	}

	private void checkSigUp(String email, String date, String pass)
			throws SQLException, AccessToDataBaseException, NotFoundException, ParseException, Exception {
		LoginSignupValidation validate = new LoginSignupValidation();
		if (!isUserExsit(email, pass)) {
			if (!areAllInfoCorrect(validate, date, email, pass)) {
				setWarningsDateEmailPass(validate, date, email, pass);

			} else {
				insertCustomer(email, date, pass);
				JOptionPane.showMessageDialog(null,
						"Bienvenido!! inicia tu sesion y descubre nuestra coleccion de verano ");
				changesCancel();
				refreshJtextFields();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Usuario existe !!");
		}

	}

	private boolean isUserExsit(String email, String pass)
			throws SQLException, AccessToDataBaseException, NotFoundException, Exception {
		boolean ret = false;
		Customer customer = isCustomerExist(email, pass);
		EmployeeManagedOrders employee = isEmployeeExist(email, pass);
		if (customer != null || employee != null) {
			ret = true;
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

	private void insertCustomer(String email, String date, String pass)
			throws ParseException, SQLException, AccessToDataBaseException, NotFoundException, Exception {
		ManagerCustomers managerCustomer = new ManagerCustomers();
		Customer customer = new Customer();
		customer.setPassword(pass);
		customer.setEmail(email);
		customer.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(date));
		managerCustomer.insert(customer);

	}

	private void refreshJtextFields() {
		textField.setText("");
		textFieldBirthDate.setText("");
		passwordField.setText("");
	}

}
