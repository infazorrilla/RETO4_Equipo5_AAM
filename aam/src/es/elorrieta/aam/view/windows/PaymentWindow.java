package es.elorrieta.aam.view.windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import es.elorrieta.aam.controller.ValidatePayment;
import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
import es.elorrieta.aam.model.bbdd.manager.ManagerOrders;
import es.elorrieta.aam.model.bbdd.pojo.Address;
import es.elorrieta.aam.model.bbdd.pojo.Order;
import es.elorrieta.aam.model.bbdd.pojo.Payment;

public class PaymentWindow extends JFrame {

	private static final long serialVersionUID = -6180317732194723997L;
	private JPanel contentPane;
	private JTextField textFieldNumCreditCard;
	private JTextField textFieldCvv;
	private JTextField textFieldAdress;
	private JTextField textFieldCity;
	private JTextField textFieldProvince;
	private JTextField textFieldCountry;
	private JTextField textFieldZip;
	private JLabel lblNumCrCardWarning;
	private JLabel lblExperitionDateWarning;
	private JLabel lblCvvWarning;
	private JFormattedTextField fieldExpirationDate;
	JPanel panel;

	public PaymentWindow(Order order) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1207, 672);
		contentPane.add(panel);
		panel.setLayout(null);

		textFieldNumCreditCard = new JTextField();
		textFieldNumCreditCard.setBounds(85, 121, 348, 39);
		panel.add(textFieldNumCreditCard);
		textFieldNumCreditCard.setColumns(10);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PaymentWindow.class.getResource("/es/images/9519605.png")));
		lblNewLabel.setBounds(29, 121, 46, 39);
		panel.add(lblNewLabel);

		textFieldCvv = new JTextField();
		textFieldCvv.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				if (textFieldCvv.getText().length() >= 4
						&& !(evt.getKeyChar() == KeyEvent.VK_DELETE || evt.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		textFieldCvv.setBounds(314, 225, 119, 38);
		panel.add(textFieldCvv);
		textFieldCvv.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PaymentWindow.class.getResource("/es/images/10705659.png")));
		lblNewLabel_1.setBounds(29, 217, 46, 46);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(PaymentWindow.class.getResource("/es/images/807241 (1).png")));
		lblNewLabel_2.setBounds(269, 224, 46, 39);
		panel.add(lblNewLabel_2);

		textFieldAdress = new JTextField();
		textFieldAdress.setBounds(85, 324, 322, 39);
		panel.add(textFieldAdress);
		textFieldAdress.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(PaymentWindow.class.getResource("/es/images/727606.png")));
		lblNewLabel_3.setBounds(35, 317, 40, 46);
		panel.add(lblNewLabel_3);

		textFieldCity = new JTextField();
		textFieldCity.setBounds(85, 405, 136, 39);
		panel.add(textFieldCity);
		textFieldCity.setColumns(10);

		textFieldProvince = new JTextField();
		textFieldProvince.setBounds(259, 405, 148, 39);
		panel.add(textFieldProvince);
		textFieldProvince.setColumns(10);

		textFieldCountry = new JTextField();
		textFieldCountry.setBounds(259, 499, 148, 39);
		panel.add(textFieldCountry);
		textFieldCountry.setColumns(10);

		textFieldZip = new JTextField();
		textFieldZip.setBounds(86, 499, 135, 39);
		panel.add(textFieldZip);
		textFieldZip.setColumns(10);

		JLabel lblAddress = new JLabel("Direccion :");
		lblAddress.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblAddress.setBounds(85, 288, 89, 23);
		panel.add(lblAddress);

		JLabel lblCity = new JLabel("Ciudad : ");
		lblCity.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblCity.setBounds(85, 374, 119, 20);
		panel.add(lblCity);

		JLabel lblProvince = new JLabel("Provincia :");
		lblProvince.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblProvince.setBounds(264, 374, 99, 20);
		panel.add(lblProvince);

		JLabel lblZip = new JLabel("Codigo Postal :");
		lblZip.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblZip.setBounds(85, 455, 136, 26);
		panel.add(lblZip);

		JLabel lblCountry = new JLabel("Pais : ");
		lblCountry.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblCountry.setBounds(259, 455, 148, 26);
		panel.add(lblCountry);

		JLabel lblCvv = new JLabel("CVV :");
		lblCvv.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblCvv.setBounds(314, 191, 119, 23);
		panel.add(lblCvv);

		JLabel lblExpirationDate = new JLabel("Fecha de caducidad :");
		lblExpirationDate.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblExpirationDate.setBounds(85, 188, 170, 29);
		panel.add(lblExpirationDate);

		JLabel lblNumCreditCard = new JLabel("Numero de tarjeta : ");
		lblNumCreditCard.setFont(new Font("Verdana", Font.PLAIN, 15));
		lblNumCreditCard.setBounds(85, 87, 348, 23);
		panel.add(lblNumCreditCard);

		JLabel lbl = new JLabel("Coste de Envío :");
		lbl.setFont(new Font("Verdana", Font.BOLD, 14));
		lbl.setBounds(727, 382, 148, 26);
		panel.add(lbl);

		JLabel lblNewLabel_13 = new JLabel("2,99€");
		lblNewLabel_13.setForeground(new Color(255, 0, 0));
		lblNewLabel_13.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_13.setBounds(975, 385, 89, 20);
		panel.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("Precio base : ");
		lblNewLabel_14.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_14.setBounds(727, 433, 125, 17);
		panel.add(lblNewLabel_14);

		JLabel lblOrderPrice = new JLabel("");

		lblOrderPrice.setText(order.getTotalPrice() + "" + "€");
		lblOrderPrice.setFont(new Font("Verdana", Font.BOLD, 14));
		lblOrderPrice.setBounds(975, 425, 84, 32);
		panel.add(lblOrderPrice);

		JLabel lblNewLabel_16 = new JLabel("Total a pagar : ");
		lblNewLabel_16.setFont(new Font("Verdana", Font.BOLD, 14));
		lblNewLabel_16.setBounds(727, 505, 125, 23);
		panel.add(lblNewLabel_16);

		JLabel lblTotalToPay = new JLabel("");
		lblTotalToPay.setText(new ValidatePayment().calculateTotalPricrToPay(order.getTotalPrice()) + "" + "€");
		lblTotalToPay.setFont(new Font("Verdana", Font.BOLD, 14));
		lblTotalToPay.setBounds(975, 505, 84, 23);
		panel.add(lblTotalToPay);

		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setIcon(new ImageIcon(PaymentWindow.class.getResource("/es/images/crCard.gif")));
		lblNewLabel_19.setBounds(541, 73, 618, 282);
		panel.add(lblNewLabel_19);

		JButton btnNewButton = new JButton("Pagar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makeLabelsWarning(false);
				checkPayment(order);

			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(51, 204, 51));
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 15));
		btnNewButton.setBounds(799, 554, 179, 46);
		panel.add(btnNewButton);

		JPanel panelFooter = new JPanel();
		panelFooter.setBackground(new Color(255, 204, 51));
		panelFooter.setBounds(0, 611, 1207, 50);
		panel.add(panelFooter);
		panelFooter.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 51));
		panel_1.setBounds(0, -12, 1207, 62);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenderWindow genderMenu = new GenderWindow(order);
				dispose();
				genderMenu.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(153, 102, 51));
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 18));
		btnNewButton_1.setBounds(42, 11, 147, 51);
		panel_1.add(btnNewButton_1);

		JLabel lblNewLabel_20 = new JLabel("-------------------------------------\r\n");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_20.setBounds(727, 467, 432, 14);
		panel.add(lblNewLabel_20);
		MaskFormatter fmt = null;
		try {
			fmt = new MaskFormatter("##/####");
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		fieldExpirationDate = new JFormattedTextField(fmt);
		fieldExpirationDate.setBounds(85, 225, 158, 38);
		panel.add(fieldExpirationDate);

		lblNumCrCardWarning = new JLabel("Numero de tarjeta invalido !!");
		lblNumCrCardWarning.setVisible(false);
		lblNumCrCardWarning.setForeground(new Color(255, 0, 0));
		lblNumCrCardWarning.setBackground(new Color(255, 0, 0));
		lblNumCrCardWarning.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblNumCrCardWarning.setBounds(85, 163, 230, 14);
		panel.add(lblNumCrCardWarning);

		lblExperitionDateWarning = new JLabel("Fecha invalida !!");
		lblExperitionDateWarning.setVisible(false);
		lblExperitionDateWarning.setForeground(new Color(255, 0, 0));
		lblExperitionDateWarning.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblExperitionDateWarning.setBounds(85, 263, 158, 14);
		panel.add(lblExperitionDateWarning);

		lblCvvWarning = new JLabel("CVV invalido !!!");
		lblCvvWarning.setVisible(false);
		lblCvvWarning.setForeground(new Color(255, 0, 0));
		lblCvvWarning.setFont(new Font("Verdana", Font.PLAIN, 13));
		lblCvvWarning.setBounds(317, 265, 116, 14);
		panel.add(lblCvvWarning);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane.setLayout(null);

		setAddressText(order);
	}

	/**
	 * Sets the text fields with the address information from the Order object, if
	 * available.
	 *
	 * @param order The Order object containing the customer's address information.
	 */

	private void setAddressText(Order order) {
		if (null != order.getCustomer().getProfile().getUser().getAddress()) {
			doSetAddressText(order.getCustomer().getProfile().getUser().getAddress());
		} else {
			// nothing
		}
	}

	/**
	 * Sets the text fields with the values from the given Address object.
	 *
	 * @param address The Address object containing the address information.
	 */
	private void doSetAddressText(Address address) {
		textFieldAdress.setText(address.getStreet());
		textFieldCity.setText(address.getCity());
		textFieldCountry.setText(address.getCountry());
		textFieldZip.setText(address.getCodPostal());
		textFieldProvince.setText(address.getProvince());
	}

	/**
	 * Checks the validity of the payment and address information before inserting
	 * the order into the database. If the payment and address information is valid,
	 * the order is inserted into the database, a success message is displayed, and
	 * the user is redirected to the order summary window.
	 *
	 * @param order The Order object to be inserted into the database.
	 */
	private void checkPayment(Order order) {
		if (doCheckPayment() && checkAddress()) {

			insertOrderIntoDB(order);
			JOptionPane.showMessageDialog(null, "Tu compra se ha realizado con exito");
			ResumeWindow resumeWindow = new ResumeWindow(order);
			dispose();
			resumeWindow.setVisible(true);
		} else {
			// nothing
		}
	}

	/**
	 * Checks the validity of the payment information and displays relevant warnings
	 * if any field is invalid.
	 *
	 * @return true if the payment information is valid, false otherwise.
	 */
	private boolean doCheckPayment() {
		boolean ret = true;
		if (!new ValidatePayment().checkPayment(textFieldNumCreditCard.getText(),
				new String(fieldExpirationDate.getText()), textFieldCvv.getText())) {
			checkCrCardNum(textFieldNumCreditCard.getText());
			checkExpirationDate(new String(fieldExpirationDate.getText()));
			checkCvv(textFieldCvv.getText());
			ret = false;
		}

		return ret;
	}

	/**
	 * Checks the validity of the credit card number and displays a warning if it is
	 * invalid.
	 *
	 * @param crCardNum The credit card number to be checked.
	 */
	private void checkCrCardNum(String crCardNum) {
		if (!new ValidatePayment().validitychk(crCardNum)) {
			lblNumCrCardWarning.setVisible(true);
		}
	}

	/**
	 * Checks the validity of the expiration date and displays a warning if it is
	 * invalid.
	 *
	 * @param date The expiration date to be checked.
	 */
	private void checkExpirationDate(String date) {
		if (!new ValidatePayment().checkParsingDate(date)) {
			lblExperitionDateWarning.setVisible(true);
		}
	}

	/**
	 * Checks the validity of the CVV (Card Verification Value) and displays a
	 * warning if it is invalid.
	 *
	 * @param cvv The CVV value to be checked.
	 */
	private void checkCvv(String cvv) {
		if (!new ValidatePayment().checkCvv(cvv)) {
			lblCvvWarning.setVisible(true);
		}
	}

	/**
	 * Checks if the address fields are filled and displays an error message if any
	 * field is empty.
	 *
	 * @return true if all address fields are filled, false otherwise.
	 */
	private boolean checkAddress() {
		boolean ret = true;
		if (!doCheckAddress()) {
			JOptionPane.showMessageDialog(null, "Campo vacio !!");
			ret = false;
		}

		return ret;
	}

	/**
	 * Checks if the address fields have been filled.
	 *
	 * @return true if all address fields are filled, false otherwise.
	 */
	private boolean doCheckAddress() {
		boolean ret = true;

		if (textFieldAdress.getText().isEmpty() || textFieldCity.getText().isEmpty()
				|| textFieldCountry.getText().isEmpty() || textFieldZip.getText().isEmpty()
				|| textFieldProvince.getText().isEmpty()) {
			ret = false;
		}
		return ret;
	}

	/**
	 * makes labelsWarning true or false
	 * 
	 * @param value boolean true or false
	 */
	private void makeLabelsWarning(boolean value) {
		lblNumCrCardWarning.setVisible(value);
		lblExperitionDateWarning.setVisible(value);
		lblCvvWarning.setVisible(value);

	}

	/**
	 * Inserts an order into the database and handles potential exceptions.
	 *
	 * @param order The Order object to be inserted.
	 */

	private void insertOrderIntoDB(Order order) {
		try {
			doInsertOrderIntoDB(order);
		} catch (SQLException e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(contentPane, "Data Base Error. Contents cannot be displayed", "ERROR!!",
					JOptionPane.ERROR_MESSAGE);

		} catch (AccessToDataBaseException e) {
			JOptionPane.showMessageDialog(contentPane, "Data Base Access. Coundn't connect to data base  ", "ERROR!!",
					JOptionPane.ERROR_MESSAGE);
		} catch (NotFoundException e) {
			JOptionPane.showMessageDialog(contentPane, "Data Base is empty", "ERROR!!", JOptionPane.ERROR_MESSAGE);

		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(contentPane, "Generic error...", "ERROR!!", JOptionPane.ERROR_MESSAGE);

		}

	}

	/**
	 * Inserts an order into the database.
	 *
	 * @param order The Order object to be inserted.
	 * @throws SQLException              If a database access error occurs.
	 * @throws NotFoundException         If the required data is not found.
	 * @throws AccessToDataBaseException If there is an issue with accessing the
	 *                                   database.
	 * @throws Exception                 If any other exception occurs.
	 */

	private void doInsertOrderIntoDB(Order order)
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {
		if (order.getCustomer().getProfile().getUser().getAddress() == null) {
			order.getCustomer().getProfile().getUser().setAddress(getAddress());
			Payment payment = getPayment();
			order.setPayment(payment);
			order.getShoppingCart().setCreatedAt(new Date());
			order.setStatus("awaiting_shipment");
			new ManagerOrders().insert(order);

		} else {
			int id = order.getCustomer().getProfile().getUser().getAddress().getId();
			Address addr = getAddress();
			addr.setId(id);
			Payment payment = getPayment();
			order.setPayment(payment);
			order.getCustomer().getProfile().getUser().setAddress(addr);
			order.getShoppingCart().setCreatedAt(new Date());
			order.setStatus("awaiting_shipment");
			new ManagerOrders().insertOrder(order);
		}
	}

	/**
	 * Retrieves the text from JTextFields related to address information and
	 * returns a Address object.
	 * 
	 * @return The Address object with the retrieved Address information.
	 */

	private Address getAddress() {
		Address ret = new Address();
		ret.setStreet(textFieldAdress.getText());
		ret.setCity(textFieldCity.getText());
		ret.setCountry(textFieldCountry.getText());
		ret.setCodPostal(textFieldZip.getText());
		ret.setProvince(textFieldProvince.getText());
		return ret;
	}

	/**
	 * Retrieves the text from JTextFields related to payment information and
	 * returns a Payment object.
	 * 
	 * @return The Payment object with the retrieved payment information.
	 */

	private Payment getPayment() {
		Payment ret = new Payment();
		ret.setIban(textFieldNumCreditCard.getText());
		Date date = null;
		try {
			date = new ValidatePayment().getExpirationDate(new String(fieldExpirationDate.getText()));
		} catch (ParseException e) {
			// never will happen
		}
		ret.setExpirationDate(date);
		ret.setCvv(textFieldCvv.getText());
		ret.setCreatedAt(new Date());
		return ret;
	}

}
