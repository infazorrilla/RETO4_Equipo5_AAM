package es.elorrieta.aam.view.windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import es.elorrieta.aam.model.bbdd.pojo.Order;

public class ResumeWindow extends JFrame {

	private static final long serialVersionUID = 5620497918243100838L;
	private JPanel contentPane;

	public ResumeWindow(Order order) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1207, 661);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 51));
		panel_1.setBounds(0, 0, 1207, 63);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton_1 = new JButton("Volver al inicio");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order.setShoppingCart(null);
				GenderWindow gender = new GenderWindow(order);
				dispose();
				gender.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(102, 204, 0));
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 14));
		btnNewButton_1.setBounds(10, 11, 171, 41);
		panel_1.add(btnNewButton_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 51));
		panel_2.setBounds(0, 598, 1207, 63);
		panel.add(panel_2);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ResumeWindow.class.getResource("/es/images/cool.jpg")));
		lblNewLabel.setBounds(667, 62, 540, 536);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ResumeWindow.class.getResource("/es/images/QRfORpRO (1).png")));
		lblNewLabel_1.setBounds(197, 199, 167, 163);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(ResumeWindow.class.getResource("/es/images/SCANME (1).png")));
		lblNewLabel_2.setBounds(187, 104, 167, 84);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Accede a tu factura ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel_3.setBounds(150, 373, 276, 26);
		panel.add(lblNewLabel_3);

		JButton btnNewButton = new JButton("");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon(ResumeWindow.class.getResource("/es/images/click (1).gif")));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(197, 410, 203, 177);
		panel.add(btnNewButton);

	}
}
