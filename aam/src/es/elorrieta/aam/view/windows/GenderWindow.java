package es.elorrieta.aam.view.windows;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.elorrieta.aam.model.bbdd.pojo.Order;
import es.elorrieta.aam.controller.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * represents a JFrame window that allows the user to select gender. Male or
 * female. The window also includes a navigation bar at the top with buttons to
 * Access to profile and users management if the user is an administrator.
 * 
 * @author Admin
 *
 */
public class GenderWindow extends JFrame {

	private static final long serialVersionUID = 6919893765005151313L;
	private JPanel contentPane;
	private JButton btnUser;
	private JButton btnCustomers;

	public GenderWindow(Order order) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel jPanelCines = new JPanel();
		jPanelCines.setBackground(new Color(255, 255, 255));
		jPanelCines.setBounds(0, 71, 1207, 519);
		contentPane.add(jPanelCines);
		jPanelCines.setLayout(null);

		JButton btnMale = new JButton("");
		btnMale.setBackground(new Color(255, 255, 255));
		btnMale.setIcon(new ImageIcon(GenderWindow.class.getResource("/es/images/try (3).gif")));
		btnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				UserChoice userChoice = new UserChoice();
				userChoice.setFemale(false);
				dispose();
				MenuWindow menu = new MenuWindow(order, userChoice);
				menu.setVisible(true);
			}
		});
		btnMale.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMale.setBounds(690, 73, 248, 384);
		jPanelCines.add(btnMale);

		JButton btnFemale = new JButton("");
		btnFemale.setBackground(new Color(255, 255, 255));
		btnFemale.setIcon(new ImageIcon(GenderWindow.class.getResource("/es/images/girl (1).gif")));
		btnFemale.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MenuWindow menu = new MenuWindow(order, new UserChoice());
				menu.setVisible(true);
			}
		});
		btnFemale.setBounds(293, 73, 248, 384);
		jPanelCines.add(btnFemale);

		JLabel lblNewLabel = new JLabel("Mujer");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel.setBounds(357, 468, 123, 29);
		jPanelCines.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Hombre");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 18));
		lblNewLabel_1.setBounds(766, 468, 112, 29);
		jPanelCines.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 128, 0));
		panel.setBackground(new Color(255, 204, 51));
		panel.setBounds(0, 590, 1207, 71);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel jPanelBarraSuperior = new JPanel();
		jPanelBarraSuperior.setBounds(0, 0, 1207, 71);
		contentPane.add(jPanelBarraSuperior);
		jPanelBarraSuperior.setBackground(new Color(248, 212, 64));
		jPanelBarraSuperior.setLayout(null);

		JButton btnInicio = new JButton("");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				WelcomeWindow welcomeWin = new WelcomeWindow();
				dispose();
				welcomeWin.frame.setVisible(true);
			}
		});
		btnInicio.setIcon(new ImageIcon(GenderWindow.class.getResource("/es/images/flecha (1).jpg")));

		btnInicio.setForeground(new Color(255, 255, 255));
		btnInicio.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnInicio.setBackground(new Color(255, 255, 255));
		btnInicio.setBounds(36, 11, 90, 50);
		jPanelBarraSuperior.add(btnInicio);

		btnUser = new JButton("");
		btnUser.setIcon(new ImageIcon(GenderWindow.class.getResource("/es/images/10418806.png")));
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (null != order.getCustomer()) {
					if (order.getCustomer().getProfile().isOn()) {
						dispose();
						Profile profile = new Profile(order);
						profile.setVisible(true);
					}
				} else {
					LoginSignupWindow LoginSignUpWindow = new LoginSignupWindow(order);
					dispose();
					LoginSignUpWindow.setVisible(true);
				}

			}
		});
		btnUser.setForeground(new Color(255, 255, 255));
		btnUser.setBackground(new Color(255, 255, 255));
		btnUser.setBounds(1104, 11, 64, 50);
		jPanelBarraSuperior.add(btnUser);

		btnCustomers = new JButton("Gestionar Usuarios ");
		btnCustomers.setForeground(new Color(255, 255, 255));
		btnCustomers.setBackground(new Color(153, 102, 0));
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				UsersManagerWindow usersManager = new UsersManagerWindow(order);
				usersManager.setVisible(true);
			}
		});
		btnCustomers.setVisible(false);
		btnCustomers.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCustomers.setBounds(830, 11, 216, 50);
		jPanelBarraSuperior.add(btnCustomers);
		doMakeBtnsVisible(order);
	}

	/**
	 * takes an Order object as a parameter and checks if the associated customer's
	 * profile is turned on and has a user type of 1 (administrator). if the user is
	 * an administartor makes button gestionar usuarios visible
	 * 
	 * @param order
	 */
	private void doMakeBtnsVisible(Order order) {
		if (null != order.getCustomer()) {
			if (order.getCustomer().getProfile().isOn() && order.getCustomer().getProfile().getUserType() == 1) {
				makeBtnsVisible(true);
			} else {
				makeBtnsVisible(false);
			}
		}
	}

	/**
	 * takes a boolean parameter value. It sets the visibility of a button
	 * (btnCustomers) based on the value of the boolean parameter.
	 * 
	 * @param value
	 */
	private void makeBtnsVisible(boolean value) {
		btnCustomers.setVisible(value);

	}
}
