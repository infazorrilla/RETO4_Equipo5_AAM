package es.elorrieta.aam.view.windows.panelFactory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import es.elorrieta.aam.controller.LoginSignupValidation;
import es.elorrieta.aam.model.bbdd.pojo.Order;
import es.elorrieta.aam.model.bbdd.pojo.Product;
import es.elorrieta.aam.view.AddToShopCartWindow;
import es.elorrieta.aam.view.windows.MenuWindow;

public class Panels extends JPanel {

	private static final long serialVersionUID = 9116332867354927132L;

	public JPanel getJpanelOne(Order order, Product product, MenuWindow frame) {
		JPanel panelOne = new JPanel();
		panelOne.setBounds(87, 29, 191, 370);
		panelOne.setBackground(new Color(255, 255, 255));
		panelOne.setLayout(null);
		JButton btnPanelOne = new JButton("");
		btnPanelOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AddToShopCartWindow GG = new AddToShopCartWindow(order, product);
				GG.setVisible(true);
			}
		});

		btnPanelOne.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(product.getImage()).getScaledInstance(191, 290, WIDTH)));
		btnPanelOne.setBounds(0, 0, 191, 290);
		panelOne.add(btnPanelOne);

		JLabel lblProductName = new JLabel("");
		lblProductName.setText(product.getName());
		lblProductName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProductName.setBounds(10, 301, 181, 25);
		panelOne.add(lblProductName);

		JLabel lblPrice = new JLabel("");
		lblPrice.setText(product.getPrice() + "" + "€");
		lblPrice.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPrice.setBounds(10, 332, 116, 14);
		panelOne.add(lblPrice);
		return panelOne;
	}

	public JPanel getJpanelTwo(Order order, Product product, MenuWindow frame) {
		JPanel panelTwo = new JPanel();
		panelTwo.setBounds(386, 29, 191, 370);
		panelTwo.setBackground(new Color(255, 255, 255));
		panelTwo.setLayout(null);
		JButton btnPanelTwo = new JButton("");
		btnPanelTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "2");
			}
		});
		btnPanelTwo.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(product.getImage()).getScaledInstance(191, 290, WIDTH)));
		btnPanelTwo.setBounds(0, 0, 191, 290);
		panelTwo.add(btnPanelTwo);

		JLabel lblProductName = new JLabel("");
		lblProductName.setText(product.getName());
		lblProductName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProductName.setBounds(10, 301, 181, 25);
		panelTwo.add(lblProductName);

		JLabel lblPrice = new JLabel("");
		lblPrice.setText(product.getPrice() + "" + "€");
		lblPrice.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPrice.setBounds(10, 332, 116, 14);
		panelTwo.add(lblPrice);
		return panelTwo;
	}

	public JPanel getJpanelThree(Order order, Product product, MenuWindow frame) {
		JPanel panelThree = new JPanel();
		panelThree.setBounds(671, 29, 191, 370);
		panelThree.setBackground(new Color(255, 255, 255));
		panelThree.setLayout(null);
		JButton btnPanelThree = new JButton("");
		btnPanelThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "3");
			}
		});
		btnPanelThree.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(product.getImage()).getScaledInstance(191, 290, WIDTH)));
		btnPanelThree.setBounds(0, 0, 191, 290);
		panelThree.add(btnPanelThree);

		JLabel lblProductName = new JLabel("");
		lblProductName.setText(product.getName());
		lblProductName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProductName.setBounds(10, 301, 181, 25);
		panelThree.add(lblProductName);

		JLabel lblPrice = new JLabel("");
		lblPrice.setText(product.getPrice() + "" + "€");
		lblPrice.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPrice.setBounds(10, 332, 116, 14);
		panelThree.add(lblPrice);
		return panelThree;
	}

	public JPanel getJpanelFour(Order order, Product product, MenuWindow frame) {
		JPanel panelFour = new JPanel();
		panelFour.setBounds(84, 439, 191, 370);
		panelFour.setBackground(new Color(255, 255, 255));
		panelFour.setLayout(null);
		JButton btnPanelFour = new JButton("");
		btnPanelFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "4");
			}
		});
		btnPanelFour.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(product.getImage()).getScaledInstance(191, 290, WIDTH)));
		btnPanelFour.setBounds(0, 0, 191, 290);
		panelFour.add(btnPanelFour);

		JLabel lblProductName = new JLabel("");
		lblProductName.setText(product.getName());
		lblProductName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProductName.setBounds(10, 301, 181, 25);
		panelFour.add(lblProductName);

		JLabel lblPrice = new JLabel("");
		lblPrice.setText(product.getPrice() + "" + "€");
		lblPrice.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPrice.setBounds(10, 332, 116, 14);
		panelFour.add(lblPrice);
		return panelFour;
	}

	public JPanel getJpanelFive(Order order, Product product, MenuWindow frame) {
		JPanel panelFive = new JPanel();
		panelFive.setBounds(386, 438, 191, 370);
		panelFive.setBackground(new Color(255, 255, 255));
		panelFive.setLayout(null);
		JButton btnPanelFive = new JButton("");
		btnPanelFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "5");
			}
		});
		btnPanelFive.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(product.getImage()).getScaledInstance(191, 290, WIDTH)));
		btnPanelFive.setBounds(0, 0, 191, 290);
		panelFive.add(btnPanelFive);

		JLabel lblProductName = new JLabel("");
		lblProductName.setText(product.getName());
		lblProductName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProductName.setBounds(10, 301, 181, 25);
		panelFive.add(lblProductName);

		JLabel lblPrice = new JLabel("");
		lblPrice.setText(product.getPrice() + "" + "€");
		lblPrice.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPrice.setBounds(10, 332, 116, 14);
		panelFive.add(lblPrice);
		return panelFive;
	}

	public JPanel getJpanelSix(Order order, Product product, MenuWindow frame) {
		JPanel panelSix = new JPanel();
		panelSix.setBounds(672, 439, 191, 370);
		panelSix.setBackground(new Color(255, 255, 255));
		panelSix.setLayout(null);
		JButton btnPanelSix = new JButton("");
		btnPanelSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "6");
			}
		});
		btnPanelSix.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(product.getImage()).getScaledInstance(191, 290, WIDTH)));
		btnPanelSix.setBounds(0, 0, 191, 290);
		panelSix.add(btnPanelSix);

		JLabel lblProductName = new JLabel("");
		lblProductName.setText(product.getName());
		lblProductName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProductName.setBounds(10, 301, 181, 25);
		panelSix.add(lblProductName);

		JLabel lblPrice = new JLabel("");
		lblPrice.setText(product.getPrice() + "" + "€");
		lblPrice.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPrice.setBounds(10, 332, 116, 14);
		panelSix.add(lblPrice);
		return panelSix;
	}

	public JPanel getJpanelSeven(Order order, Product product, MenuWindow frame) {
		JPanel panelSeven = new JPanel();
		panelSeven.setBounds(80, 850, 191, 370);
		panelSeven.setBackground(new Color(255, 255, 255));
		panelSeven.setLayout(null);
		JButton btnPanelSeven = new JButton("");
		btnPanelSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "7");
			}
		});
		btnPanelSeven.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(product.getImage()).getScaledInstance(191, 290, WIDTH)));
		btnPanelSeven.setBounds(0, 0, 191, 290);
		panelSeven.add(btnPanelSeven);

		JLabel lblProductName = new JLabel("");
		lblProductName.setText(product.getName());
		lblProductName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProductName.setBounds(10, 301, 181, 25);
		panelSeven.add(lblProductName);

		JLabel lblPrice = new JLabel("");
		lblPrice.setText(product.getPrice() + "" + "€");
		lblPrice.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPrice.setBounds(10, 332, 116, 14);
		panelSeven.add(lblPrice);
		return panelSeven;
	}

	public JPanel getJpanelEight(Order order, Product product, MenuWindow frame) {
		JPanel panelEight = new JPanel();
		panelEight.setBounds(386, 850, 191, 370);
		panelEight.setBackground(new Color(255, 255, 255));
		panelEight.setLayout(null);
		JButton btnPanelEight = new JButton("");
		btnPanelEight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "8");
			}
		});
		btnPanelEight.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(product.getImage()).getScaledInstance(191, 290, WIDTH)));
		btnPanelEight.setBounds(0, 0, 191, 290);
		panelEight.add(btnPanelEight);

		JLabel lblProductName = new JLabel("");
		lblProductName.setText(product.getName());
		lblProductName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProductName.setBounds(10, 301, 181, 25);
		panelEight.add(lblProductName);

		JLabel lblPrice = new JLabel("");
		lblPrice.setText(product.getPrice() + "" + "€");
		lblPrice.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPrice.setBounds(10, 332, 116, 14);
		panelEight.add(lblPrice);
		return panelEight;
	}

	public JPanel getJpanelNine(Order order, Product product, MenuWindow frame) {
		JPanel panelNine = new JPanel();
		panelNine.setBounds(671, 850, 191, 370);
		panelNine.setBackground(new Color(255, 255, 255));
		panelNine.setLayout(null);
		JButton btnPanelNine = new JButton("");
		btnPanelNine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "9");
			}
		});
		btnPanelNine.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(product.getImage()).getScaledInstance(191, 290, WIDTH)));
		btnPanelNine.setBounds(0, 0, 191, 290);
		panelNine.add(btnPanelNine);

		JLabel lblProductName = new JLabel("");
		lblProductName.setText(product.getName());
		lblProductName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProductName.setBounds(10, 301, 181, 25);
		panelNine.add(lblProductName);

		JLabel lblPrice = new JLabel("");
		lblPrice.setText(product.getPrice() + "" + "€");
		lblPrice.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPrice.setBounds(10, 332, 116, 14);
		panelNine.add(lblPrice);
		return panelNine;
	}

	public JPanel getJpanelTen(Order order, Product product, MenuWindow frame) {
		JPanel panelTen = new JPanel();
		panelTen.setBounds(87, 1289, 184, 370);
		panelTen.setBackground(new Color(255, 255, 255));
		panelTen.setLayout(null);
		JButton btnPanelTen = new JButton("");
		btnPanelTen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "10");
			}
		});
		btnPanelTen.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(product.getImage()).getScaledInstance(191, 290, WIDTH)));
		btnPanelTen.setBounds(0, 0, 191, 290);
		panelTen.add(btnPanelTen);

		JLabel lblProductName = new JLabel("");
		lblProductName.setText(product.getName());
		lblProductName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProductName.setBounds(10, 301, 181, 25);
		panelTen.add(lblProductName);

		JLabel lblPrice = new JLabel("");
		lblPrice.setText(product.getPrice() + "" + "€");
		lblPrice.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPrice.setBounds(10, 332, 116, 14);
		panelTen.add(lblPrice);
		return panelTen;
	}

	public JPanel getJpanelEleven(Order order, Product product, MenuWindow frame) {
		JPanel panelEleven = new JPanel();
		panelEleven.setBounds(386, 1289, 191, 370);
		panelEleven.setBackground(new Color(255, 255, 255));
		panelEleven.setLayout(null);
		JButton btnPanelEleven = new JButton("");
		btnPanelEleven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AddToShopCartWindow GG = new AddToShopCartWindow(order, product);
				GG.setVisible(true);
			}
		});
		btnPanelEleven.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(product.getImage()).getScaledInstance(191, 290, WIDTH)));
		btnPanelEleven.setBounds(0, 0, 191, 290);
		panelEleven.add(btnPanelEleven);

		JLabel lblProductName = new JLabel("");
		lblProductName.setText(product.getName());
		lblProductName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProductName.setBounds(10, 301, 181, 25);
		panelEleven.add(lblProductName);

		JLabel lblPrice = new JLabel("");
		lblPrice.setText(product.getPrice() + "" + "€");
		lblPrice.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPrice.setBounds(10, 332, 116, 14);
		panelEleven.add(lblPrice);
		return panelEleven;
	}

	public JPanel getJpanelTwelve(Order order, Product product, MenuWindow frame) {
		JPanel panelTwelve = new JPanel();
		panelTwelve.setBounds(671, 1289, 191, 370);
		panelTwelve.setBackground(new Color(255, 255, 255));
		panelTwelve.setLayout(null);
		JButton btnPanelTwelve = new JButton("");
		btnPanelTwelve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "12");
			}
		});
		btnPanelTwelve.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(product.getImage()).getScaledInstance(191, 290, WIDTH)));
		btnPanelTwelve.setBounds(0, 0, 191, 290);
		panelTwelve.add(btnPanelTwelve);

		JLabel lblProductName = new JLabel("");
		lblProductName.setText(product.getName());
		lblProductName.setFont(new Font("Arial", Font.PLAIN, 15));
		lblProductName.setBounds(10, 301, 181, 25);
		panelTwelve.add(lblProductName);

		JLabel lblPrice = new JLabel("");
		lblPrice.setText(product.getPrice() + "" + "€");
		lblPrice.setFont(new Font("Arial", Font.PLAIN, 13));
		lblPrice.setBounds(10, 332, 116, 14);
		panelTwelve.add(lblPrice);
		return panelTwelve;
	}
}
