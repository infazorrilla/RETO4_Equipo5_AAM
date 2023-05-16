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

		lblGif.setBounds(600, 63, 597, 540);
		panel.add(lblGif);

		textField = new JTextField();
		textField.setBounds(145, 255, 284, 46);
		panel.add(textField);
		textField.setColumns(10);

		btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(153, 102, 0));
		btnLogin.setFont(new Font("Verdana", Font.BOLD, 15));
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
		btnLogin.setBounds(223, 419, 125, 46);
		panel.add(btnLogin);

		lblHeader = new JLabel("Log In");
		lblHeader.setForeground(new Color(0, 0, 0));
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		lblHeader.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblHeader.setBounds(208, 148, 146, 46);
		panel.add(lblHeader);

		JPanel panelheader = new JPanel();
		panelheader.setBackground(new Color(255, 204, 51));
		panelheader.setForeground(new Color(255, 128, 0));
		panelheader.setBounds(0, 0, 1197, 63);
		panel.add(panelheader);
		panelheader.setLayout(null);

		btnASignup = new JButton("SIGNUP");
		btnASignup.setForeground(new Color(255, 255, 255));
		btnASignup.setBackground(new Color(153, 102, 0));
		btnASignup.setFont(new Font("Verdana", Font.BOLD, 16));
		btnASignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changesForSignUp();

			}
		});
		btnASignup.setBounds(1021, 0, 130, 52);
		panelheader.add(btnASignup);

		btnBack = new JButton("");
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.setIcon(new ImageIcon(LoginSignupWindow.class.getResource("/es/images/flecha (1).jpg")));
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
		btnBack.setBounds(23, 0, 91, 63);
		panelheader.add(btnBack);

		JPanel panelFooter = new JPanel();
		panelFooter.setBackground(new Color(255, 204, 51));
		panelFooter.setBounds(0, 598, 1207, 63);
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
	/**
	 * Checks the login credentials provided by the user and performs appropriate actions based on the result.
	 *
	 * @param email The email entered by the user.
	 * @param pass The password entered by the user.
	 * @param order The Order object associated with the login.
	 * @throws SQLException if a database access error occurs.
	 * @throws AccessToDataBaseException if there is an issue with accessing the database.
	 * @throws NotFoundException if the requested data is not found.
	 * @throws Exception if an error occurs during the process.
	 */
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

	/**
	 * Checks if a customer with the given email and password exists in the
	 * database.
	 *
	 * @param email The email of the customer.
	 * @param pass  The password of the customer.
	 * @return The Customer object representing the customer if found, or null if
	 *         not found.
	 * @throws SQLException              if a database access error occurs.
	 * @throws AccessToDataBaseException if there is an issue with accessing the
	 *                                   database.
	 * @throws NotFoundException         if the requested data is not found.
	 * @throws Exception                 if an error occurs during the process.
	 */
	private Customer isCustomerExist(String email, String pass)
			throws SQLException, AccessToDataBaseException, NotFoundException, Exception {

		Customer customer = new Customer();
		ManagerCustomers managerCustomer = new ManagerCustomers();
		customer.setPassword(pass);
		customer.setEmail(email);

		Customer ret = managerCustomer.select(customer);
		return ret;

	}

	/**
	 * Checks if a customer with the given email and password exists in the database
	 * and performs login-related actions.
	 *
	 * @param email The email of the customer.
	 * @param pass  The password of the customer.
	 * @param order The Order object associated with the customer.
	 * @return An ArrayList containing the Customer object representing the customer
	 *         if found, or null if not found, and a boolean value indicating
	 *         whether the customer is already logged in , blocked or dosn't exist.
	 * @throws SQLException              if a database access error occurs.
	 * @throws AccessToDataBaseException if there is an issue with accessing the
	 *                                   database.
	 * @throws NotFoundException         if the requested data is not found.
	 * @throws Exception                 if an error occurs during the process.
	 */
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

	/**
	 * Checks if an employee with the given email and password exists in the
	 * database.
	 *
	 * @param email The email of the employee.
	 * @param pass  The password of the employee.
	 * @return The EmployeeManagedOrders object representing the employee if found,
	 *         or null if not found.
	 * @throws SQLException              if a database access error occurs.
	 * @throws AccessToDataBaseException if there is an issue with accessing the
	 *                                   database.
	 * @throws NotFoundException         if the requested data is not found.
	 * @throws Exception                 if an error occurs during the process.
	 */
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

	/**
	 * Checks the login credentials for an employee and returns an ArrayList
	 * containing the employee object and a flag indicating the login status.
	 *
	 * @param email The email of the employee.
	 * @param pass  The password of the employee.
	 * @param order The Order object associated with the login.
	 * @return An ArrayList containing the employee object and a flag indicating the
	 *         login status (loggedin ,blocked or dosnt exist ).
	 * @throws SQLException              if a database access error occurs.
	 * @throws AccessToDataBaseException if there is an issue with accessing the
	 *                                   database.
	 * @throws NotFoundException         if the requested data is not found.
	 * @throws Exception                 if an error occurs during the process.
	 */
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

	/**
	 * Sets the warnings for date, email, and password based on the provided
	 * validation object and values.
	 *
	 * @param validate The LoginSignupValidation object used for validation.
	 * @param date     The date to be validated.
	 * @param email    The email to be validated.
	 * @param pass     The password to be validated.
	 */
	private void setWarningsDateEmailPass(LoginSignupValidation validate, String date, String email, String pass) {
		makeDateWrningVisible(validate, date);
		makeEmailWarningVisible(validate, email);
		makePassWarningVisible(validate, pass);

	}

	/**
	 * Makes the date warning label visible if the provided date is invalid.
	 *
	 * @param validate The LoginSignupValidation object used for date validation.
	 * @param date     The date to be validated.
	 */
	private void makeDateWrningVisible(LoginSignupValidation validate, String date) {
		if (!validate.isValidDate(date)) {
			lblDateWarning.setVisible(true);
		}
	}

	/**
	 * Makes the email warning label visible if the provided email is invalid.
	 *
	 * @param validate The LoginSignupValidation object used for email validation.
	 * @param email    The email to be validated.
	 */
	private void makeEmailWarningVisible(LoginSignupValidation validate, String email) {
		if (!validate.isValidEmail(email)) {
			lblEmailWarning.setVisible(true);
		}
	}

	/**
	 * Makes the password warning labels visible if the provided password is
	 * invalid.
	 *
	 * @param validate The LoginSignupValidation object used for password
	 *                 validation.
	 * @param pass     The password to be validated.
	 */
	private void makePassWarningVisible(LoginSignupValidation validate, String pass) {
		if (!validate.isValidPassword(pass)) {
			lblPassPartOneWarn.setVisible(true);
			lblPassPartTwoWrn.setVisible(true);
		}
	}

	/**
	 * Checks the sign-up information provided (email, date, password) and performs
	 * the necessary actions based on the validation and user existence checks.
	 *
	 * @param email The email provided during sign-up.
	 * @param date  The birth date provided during sign-up.
	 * @param pass  The password provided during sign-up.
	 * @throws SQLException              if there is an error in the SQL operation.
	 * @throws AccessToDataBaseException if there is an error accessing the
	 *                                   database.
	 * @throws NotFoundException         if the user is not found.
	 * @throws ParseException            if there is an error parsing the date
	 *                                   string.
	 * @throws Exception                 for any other generic exception.
	 */
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

	/**
	 * Checks if a user with the provided email and password exists in the database,
	 * first checks if is a customer , the result is null checks if is an employee
	 *
	 * @param email The email of the user to check.
	 * @param pass  The password of the user to check.
	 * @return true if the user exists, false otherwise.
	 * @throws SQLException              if there is an error in the SQL operation.
	 * @throws AccessToDataBaseException if there is an error accessing the
	 *                                   database.
	 * @throws NotFoundException         if the user is not found.
	 * @throws Exception                 for any other generic exception.
	 */
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

	/**
	 * Checks if all the provided information (date, email, password) is correct
	 *
	 * 
	 * @param validate The LoginSignupValidation object used for validation.
	 * @param date     The date string to be checked.
	 * @param email    The email string to be checked.
	 * @param pass     The password string to be checked.
	 * @return true if all the information is correct, false otherwise.
	 */
	private boolean areAllInfoCorrect(LoginSignupValidation validate, String date, String email, String pass) {
		boolean ret = false;
		if (validate.isValidDate(date) && validate.isValidPassword(pass) && validate.isValidEmail(email)) {
			ret = true;
		}
		return ret;

	}

	/**
	 * Inserts a new customer into the database with the provided email, birth date,
	 * and password.
	 *
	 * @param email The email address of the customer.
	 * @param date  The birth date of the customer in the format "dd/MM/yyyy".
	 * @param pass  The password of the customer.
	 * @throws ParseException            if the birth date string cannot be parsed
	 *                                   into a valid date.
	 * @throws SQLException              if there is an error in the SQL operation.
	 * @throws AccessToDataBaseException if there is an error accessing the
	 *                                   database.
	 * @throws NotFoundException         if the required data is not found.
	 * @throws Exception                 for any other generic exception.
	 */
	private void insertCustomer(String email, String date, String pass)
			throws ParseException, SQLException, AccessToDataBaseException, NotFoundException, Exception {
		ManagerCustomers managerCustomer = new ManagerCustomers();
		Customer customer = new Customer();
		customer.setPassword(pass);
		customer.setEmail(email);
		customer.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(date));
		managerCustomer.insert(customer);

	}

	/**
	 * Clears the text fields by setting their text values to an empty string.
	 */
	private void refreshJtextFields() {
		textField.setText("");
		textFieldBirthDate.setText("");
		passwordField.setText("");
	}

}
