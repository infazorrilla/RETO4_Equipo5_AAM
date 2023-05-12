package es.elorrieta.aam.view.windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import es.elorrieta.aam.controller.UserChoice;
import es.elorrieta.aam.model.bbdd.pojo.Order;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;

public class toTry extends JFrame {

	private static final long serialVersionUID = -8261199952324498953L;
	private JPanel contentPane;

	public toTry(Order order, UserChoice userChoice) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panelFooter = new JPanel();
		panelFooter.setForeground(new Color(255, 204, 51));
		panelFooter.setBackground(new Color(255, 204, 51));
		panelFooter.setBounds(0, 612, 1207, 49);
		contentPane.add(panelFooter);
		JPanel panelheader = new JPanel();
		panelheader.setBackground(new Color(255, 204, 102));
		panelheader.setForeground(new Color(255, 204, 51));
		panelheader.setBounds(0, 0, 1207, 63);
		contentPane.add(panelheader);
		panelheader.setLayout(null);

		JButton btnGoBack = new JButton("Atras");
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGoBack.setBounds(29, 11, 95, 30);
		panelheader.add(btnGoBack);

		JButton btnProfile = new JButton("");
		btnProfile.setBounds(1127, 8, 54, 41);
		panelheader.add(btnProfile);

		JButton btnShopCart = new JButton("");
		btnShopCart.setBounds(1042, 9, 54, 40);
		panelheader.add(btnShopCart);

		JPanel panelContainer = new JPanel();
		panelContainer.setBackground(new Color(255, 255, 255));
		panelContainer.setForeground(new Color(255, 255, 255));
		panelContainer.setBounds(0, 0, 1207, 661);
		contentPane.add(panelContainer);
		panelContainer.setLayout(null);

		JPanel panelItems = new JPanel();
		panelItems.setBackground(Color.WHITE);
		JScrollPane scrollPanel = new JScrollPane(panelItems, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPanel.setBounds(259, 110, 948, 503);
		panelItems.setBounds(0, 0, 1920, 1080);
		panelItems.setPreferredSize(new Dimension(500, 3000));
		panelItems.setLayout(null);
		
		JPanel panelOne = new JPanel();
		panelOne.setBounds(87, 29, 191, 370);
		panelOne.setBackground(new Color(255, 255, 255));
		panelItems.add(panelOne);
		panelOne.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\in1dw3\\Downloads\\PARADB\\zara\\dress1.jpg"));
		btnNewButton.setBounds(0, 0, 191, 290);
		panelOne.add(btnNewButton);
		
		JLabel lbl = new JLabel("vestido blanco negro");
		lbl.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl.setBounds(10, 301, 181, 25);
		panelOne.add(lbl);
		
		JLabel lblNewLabel_1 = new JLabel("99,9 ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 332, 116, 14);
		panelOne.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(386, 29, 191, 370);
		panelItems.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(0, 0, 191, 290);
		panel_2.add(btnNewButton_1);
		
		JLabel lblName = new JLabel("fffff");
		lblName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblName.setBounds(10, 301, 181, 24);
		panel_2.add(lblName);
		
		JLabel lblNewLabel = new JLabel("55");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 332, 116, 14);
		panel_2.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(671, 29, 191, 370);
		panelItems.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(0, 0, 191, 290);
		panel_1.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 301, 181, 25);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("33");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 336, 116, 14);
		panel_1.add(lblNewLabel_3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(84, 439, 191, 370);
		panelItems.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(0, 0, 191, 290);
		panel_3.add(btnNewButton_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 301, 181, 25);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(10, 332, 116, 14);
		panel_3.add(lblNewLabel_5);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(386, 438, 191, 370);
		panelItems.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setBounds(0, 0, 191, 290);
		panel_4.add(btnNewButton_4);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(10, 301, 181, 25);
		panel_4.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(10, 332, 116, 14);
		panel_4.add(lblNewLabel_7);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_5.setBounds(672, 439, 191, 370);
		panelItems.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setBounds(0, 0, 192, 290);
		panel_5.add(btnNewButton_5);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(10, 301, 181, 14);
		panel_5.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_9.setBackground(new Color(255, 255, 255));
		lblNewLabel_9.setBounds(10, 332, 116, 14);
		panel_5.add(lblNewLabel_9);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_7.setBounds(80, 850, 191, 370);
		panelItems.add(panel_7);
		panel_7.setLayout(null);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setBounds(0, 0, 191, 292);
		panel_7.add(btnNewButton_6);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(10, 301, 181, 25);
		panel_7.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_11.setBounds(10, 332, 116, 14);
		panel_7.add(lblNewLabel_11);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		panel_8.setBounds(386, 850, 191, 370);
		panelItems.add(panel_8);
		panel_8.setLayout(null);
		
		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.setBounds(0, 0, 191, 290);
		panel_8.add(btnNewButton_7);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(10, 301, 181, 25);
		panel_8.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_13.setBounds(10, 332, 116, 14);
		panel_8.add(lblNewLabel_13);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBounds(671, 850, 191, 370);
		panelItems.add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnNewButton_8 = new JButton("New button");
		btnNewButton_8.setBounds(0, 0, 191, 290);
		panel_6.add(btnNewButton_8);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_14.setBounds(10, 301, 181, 25);
		panel_6.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_15.setBounds(10, 332, 116, 14);
		panel_6.add(lblNewLabel_15);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		panel_9.setBounds(671, 1289, 191, 370);
		panelItems.add(panel_9);
		panel_9.setLayout(null);
		
		JButton btnNewButton_9 = new JButton("New button");
		btnNewButton_9.setBounds(0, 0, 191, 290);
		panel_9.add(btnNewButton_9);
		
		JLabel lblNewLabel_16 = new JLabel("New label");
		lblNewLabel_16.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_16.setBounds(10, 301, 181, 25);
		panel_9.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("New label");
		lblNewLabel_17.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_17.setBounds(10, 332, 181, 14);
		panel_9.add(lblNewLabel_17);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 255));
		panel_10.setBounds(386, 1289, 191, 370);
		panelItems.add(panel_10);
		panel_10.setLayout(null);
		
		JButton btnNewButton_10 = new JButton("New button");
		btnNewButton_10.setBounds(0, 0, 191, 292);
		panel_10.add(btnNewButton_10);
		
		JLabel lblNewLabel_18 = new JLabel("New label");
		lblNewLabel_18.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_18.setBounds(10, 301, 181, 25);
		panel_10.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("New label");
		lblNewLabel_19.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_19.setBounds(10, 332, 116, 14);
		panel_10.add(lblNewLabel_19);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 255, 255));
		panel_11.setBounds(87, 1289, 184, 370);
		panelItems.add(panel_11);
		panel_11.setLayout(null);
		
		JButton btnNewButton_11 = new JButton("New button");
		btnNewButton_11.setBounds(0, 0, 191, 292);
		panel_11.add(btnNewButton_11);
		
		JLabel lblNewLabel_20 = new JLabel("New label");
		lblNewLabel_20.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_20.setBounds(10, 301, 181, 25);
		panel_11.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("New label");
		lblNewLabel_21.setFont(new Font("Arial", Font.PLAIN, 13));
		lblNewLabel_21.setBounds(10, 332, 116, 14);
		panel_11.add(lblNewLabel_21);
		panelContainer.add(scrollPanel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 102));
		panel.setForeground(new Color(255, 255, 204));
		panel.setBounds(0, 110, 262, 503);
		panelContainer.add(panel);
		panel.setLayout(null);

		JButton btnDresses = new JButton("Vestidos");
		btnDresses.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDresses.setBounds(21, 84, 215, 48);
		panel.add(btnDresses);

		JButton btnTshirts = new JButton("Camisitas");
		btnTshirts.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTshirts.setBounds(21, 166, 215, 48);
		panel.add(btnTshirts);

		JButton btnJeans = new JButton("Pantalones");
		btnJeans.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnJeans.setBounds(21, 252, 215, 48);
		panel.add(btnJeans);

		JButton btnShoes = new JButton("Zapatillas");
		btnShoes.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnShoes.setBounds(21, 330, 215, 48);
		panel.add(btnShoes);

		JPanel panelGender = new JPanel();
		panelGender.setBackground(new Color(255, 255, 255));
		panelGender.setForeground(new Color(255, 255, 204));
		panelGender.setBounds(0, 62, 1207, 48);
		panelContainer.add(panelGender);
		panelGender.setLayout(null);

		JButton btnFemale = new JButton("Mujer");
		btnFemale.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnFemale.setBounds(370, 14, 110, 23);
		panelGender.add(btnFemale);

		JButton btnMale = new JButton("Hombre");
		btnMale.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnMale.setBounds(697, 14, 104, 23);
		panelGender.add(btnMale);
	}


}
