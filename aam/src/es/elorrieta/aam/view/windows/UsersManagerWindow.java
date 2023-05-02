package es.elorrieta.aam.view.windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import es.elorrieta.aam.model.bbdd.pojo.Order;
import es.elorrieta.aam.view.windows.UserManagerWindowComponents.CustomersTab;
import es.elorrieta.aam.view.windows.UserManagerWindowComponents.EmployeesTab;

public class UsersManagerWindow extends JFrame {

	private static final long serialVersionUID = 377100524628466154L;
	private JPanel contentPane;

	public UsersManagerWindow(Order order) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		tabbedPane.setBounds(0, 49, 1300, 566);
		contentPane.add(tabbedPane);
		JPanel tempPanel = new JPanel();
		contentPane.add(tempPanel);
		tabbedPane.addTab("Clientes", null, new CustomersTab().panelCustomers(), null);

		tabbedPane.addTab("Empleados", null, tempPanel, null);

		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(255, 204, 51));
		panelHeader.setBounds(0, 1, 1207, 47);
		contentPane.add(panelHeader);
		panelHeader.setLayout(null);

		JButton btnBack = new JButton("Atras");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GenderWindow GenderWindow = new GenderWindow(order);
				GenderWindow.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(10, 11, 89, 25);
		panelHeader.add(btnBack);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 51));
		panel.setBounds(0, 614, 1207, 47);
		contentPane.add(panel);
		panel.setLayout(null);

		tabbedPane.addChangeListener(new ChangeListener() {

			public void stateChanged(ChangeEvent evt) {
				JTabbedPane pane = (JTabbedPane) evt.getSource();
				int index = pane.getSelectedIndex();
				switch (index) {
				case 0:
					new CustomersTab().panelCustomers();
					break;
				case 1:
					contentPane.remove(tempPanel);
					new EmployeesTab().panelEmployees();
					
					break;
				}
			}

		});
	}

}
