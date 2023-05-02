package es.elorrieta.aam.view.windows;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.elorrieta.aam.model.bbdd.pojo.Order;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

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
		jPanelCines.setBackground(new Color(255, 255, 204));
		jPanelCines.setBounds(0, 63, 1207, 538);
		contentPane.add(jPanelCines);
		jPanelCines.setLayout(null);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(691, 102, 228, 328);
		jPanelCines.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(294, 102, 248, 328);
		jPanelCines.add(btnNewButton_1);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 128, 0));
		panel.setBackground(new Color(255, 204, 51));
		panel.setBounds(0, 599, 1207, 62);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel jPanelBarraSuperior = new JPanel();
		jPanelBarraSuperior.setBounds(0, 0, 1207, 62);
		contentPane.add(jPanelBarraSuperior);
		jPanelBarraSuperior.setBackground(new Color(248, 212, 64));
		jPanelBarraSuperior.setLayout(null);

		JButton btnInicio = new JButton("");

		btnInicio.setForeground(new Color(255, 255, 255));
		btnInicio.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnInicio.setBackground(new Color(0, 0, 0));
		btnInicio.setBounds(10, 0, 90, 50);
		jPanelBarraSuperior.add(btnInicio);

		btnUser = new JButton("");
		btnUser.setIcon(new ImageIcon(GenderWindow.class.getResource("/images/10418806.png")));
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
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
				UsersManagerWindow usersManager = new UsersManagerWindow(order);
				usersManager.setVisible(true);
			}
		});
		btnCustomers.setVisible(false);
		btnCustomers.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCustomers.setBounds(830, 11, 216, 39);
		jPanelBarraSuperior.add(btnCustomers);
		doMakeBtnsVisible(order);
	}

	private void doMakeBtnsVisible(Order order) {
		if (null != order.getCustomer()) {
			if (order.getCustomer().getProfile().isOn() && order.getCustomer().getProfile().getUserType() == 1) {
				makeBtnsVisible(true);
			} else {
				makeBtnsVisible(false);
			}
		}
	}

	private void makeBtnsVisible(boolean value) {
		btnCustomers.setVisible(value);

	}
}
