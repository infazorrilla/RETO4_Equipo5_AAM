package es.elorrieta.aam.view.windows.panelFactory;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import es.elorrieta.aam.controller.LoginSignupValidation;
import es.elorrieta.aam.controller.UserChoice;
import es.elorrieta.aam.model.bbdd.pojo.Order;
import es.elorrieta.aam.model.bbdd.pojo.ShoppingCartItem;
import es.elorrieta.aam.view.windows.MenuWindow;
import es.elorrieta.aam.view.windows.ShoppingCartWindow;

public class PanelsForShoppingCartWindow extends JPanel {

	private static final long serialVersionUID = -7690496946878281325L;

	public JPanel panelI(Order order, ShoppingCartItem shoppingCartItem, UserChoice userChoice, ShoppingCartWindow frame,
			MenuWindow frameMenu) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(0, 0, 353, 118);
		panel.setLayout(null);
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(shoppingCartItem.getProductItem().getProduct().getImages().get(0))
						.getScaledInstance(77, 97, WIDTH)));
		lblImage.setBackground(new Color(255, 255, 255));
		lblImage.setBounds(28, 11, 77, 97);
		panel.add(lblImage);

		JLabel lblName = new JLabel("");
		lblName.setText(shoppingCartItem.getProductItem().getProduct().getName());
		lblName.setFont(new Font("Verdana", Font.BOLD, 11));
		lblName.setBounds(133, 11, 210, 14);
		panel.add(lblName);

		JLabel lblSize = new JLabel("");
		lblSize.setText(shoppingCartItem.getProductItem().getSize());
		lblSize.setFont(new Font("Verdana", Font.BOLD, 11));
		lblSize.setBounds(133, 36, 46, 14);
		panel.add(lblSize);

		JLabel lblQuantity = new JLabel("");
		lblQuantity.setText("x" + shoppingCartItem.getQuantity());
		lblQuantity.setFont(new Font("Verdana", Font.BOLD, 11));
		lblQuantity.setBounds(133, 61, 46, 14);
		panel.add(lblQuantity);

		JLabel lblPrice = new JLabel("");
		lblPrice.setText(shoppingCartItem.getProductItem().getProduct().getPrice() + "" + "€");
		lblPrice.setFont(new Font("Verdana", Font.BOLD, 11));
		lblPrice.setBounds(133, 93, 46, 14);
		panel.add(lblPrice);

		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ShoppingCartItem> shopCartItems = order.getShoppingCart().getShoppingCartItems();
				shopCartItems.remove(shoppingCartItem);
				order.getShoppingCart().setShoppingCartItems(shopCartItems);
				frame.dispose();
				new ShoppingCartWindow(frameMenu, order, userChoice).setVisible(true);

			}
		});
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setIcon(new ImageIcon(ShoppingCartWindow.class.getResource("/es/images/cancelIcon.png")));
		btnDelete.setBounds(285, 43, 32, 32);
		panel.add(btnDelete);
		return panel;
	}

	public JPanel panelII(Order order, ShoppingCartItem shoppingCartItem, UserChoice userChoice, ShoppingCartWindow frame,
			MenuWindow frameMenu) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(0, 129, 353, 118);
		panel.setLayout(null);
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(shoppingCartItem.getProductItem().getProduct().getImages().get(0))
						.getScaledInstance(77, 97, WIDTH)));
		lblImage.setBackground(new Color(255, 255, 255));
		lblImage.setBounds(28, 11, 77, 97);
		panel.add(lblImage);

		JLabel lblName = new JLabel("");
		lblName.setText(shoppingCartItem.getProductItem().getProduct().getName());
		lblName.setFont(new Font("Verdana", Font.BOLD, 11));
		lblName.setBounds(133, 11, 210, 14);
		panel.add(lblName);

		JLabel lblSize = new JLabel("");
		lblSize.setText(shoppingCartItem.getProductItem().getSize());
		lblSize.setFont(new Font("Verdana", Font.BOLD, 11));
		lblSize.setBounds(133, 36, 46, 14);
		panel.add(lblSize);

		JLabel lblQuantity = new JLabel("");
		lblQuantity.setText("x" + shoppingCartItem.getQuantity());
		lblQuantity.setFont(new Font("Verdana", Font.BOLD, 11));
		lblQuantity.setBounds(133, 61, 46, 14);
		panel.add(lblQuantity);

		JLabel lblPrice = new JLabel("");
		lblPrice.setText(shoppingCartItem.getProductItem().getProduct().getPrice() + "" + "€");
		lblPrice.setFont(new Font("Verdana", Font.BOLD, 11));
		lblPrice.setBounds(133, 93, 46, 14);
		panel.add(lblPrice);

		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ShoppingCartItem> shopCartItems = order.getShoppingCart().getShoppingCartItems();
				shopCartItems.remove(shoppingCartItem);
				order.getShoppingCart().setShoppingCartItems(shopCartItems);
				frame.dispose();
				new ShoppingCartWindow(frameMenu, order, userChoice).setVisible(true);

			}
		});
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setIcon(new ImageIcon(ShoppingCartWindow.class.getResource("/es/images/cancelIcon.png")));
		btnDelete.setBounds(285, 43, 32, 32);
		panel.add(btnDelete);
		return panel;
	}

	public JPanel panelIII(Order order, ShoppingCartItem shoppingCartItem, UserChoice userChoice, ShoppingCartWindow frame,
			MenuWindow frameMenu) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(0, 258, 353, 118);
		panel.setLayout(null);
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(shoppingCartItem.getProductItem().getProduct().getImages().get(0))
						.getScaledInstance(77, 97, WIDTH)));
		lblImage.setBackground(new Color(255, 255, 255));
		lblImage.setBounds(28, 11, 77, 97);
		panel.add(lblImage);

		JLabel lblName = new JLabel("");
		lblName.setText(shoppingCartItem.getProductItem().getProduct().getName());
		lblName.setFont(new Font("Verdana", Font.BOLD, 11));
		lblName.setBounds(133, 11, 210, 14);
		panel.add(lblName);

		JLabel lblSize = new JLabel("");
		lblSize.setText(shoppingCartItem.getProductItem().getSize());
		lblSize.setFont(new Font("Verdana", Font.BOLD, 11));
		lblSize.setBounds(133, 36, 46, 14);
		panel.add(lblSize);

		JLabel lblQuantity = new JLabel("");
		lblQuantity.setText("x" + shoppingCartItem.getQuantity());
		lblQuantity.setFont(new Font("Verdana", Font.BOLD, 11));
		lblQuantity.setBounds(133, 61, 46, 14);
		panel.add(lblQuantity);

		JLabel lblPrice = new JLabel("");
		lblPrice.setText(shoppingCartItem.getProductItem().getProduct().getPrice() + "" + "€");
		lblPrice.setFont(new Font("Verdana", Font.BOLD, 11));
		lblPrice.setBounds(133, 93, 46, 14);
		panel.add(lblPrice);

		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ShoppingCartItem> shopCartItems = order.getShoppingCart().getShoppingCartItems();
				shopCartItems.remove(shoppingCartItem);
				order.getShoppingCart().setShoppingCartItems(shopCartItems);
				frame.dispose();
				new ShoppingCartWindow(frameMenu, order, userChoice).setVisible(true);

			}
		});
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setIcon(new ImageIcon(ShoppingCartWindow.class.getResource("/es/images/cancelIcon.png")));
		btnDelete.setBounds(285, 43, 32, 32);
		panel.add(btnDelete);
		return panel;
	}

	public JPanel panelIV(Order order, ShoppingCartItem shoppingCartItem, UserChoice userChoice, ShoppingCartWindow frame,
			MenuWindow frameMenu) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(0, 387, 353, 118);
		panel.setLayout(null);
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(shoppingCartItem.getProductItem().getProduct().getImages().get(0))
						.getScaledInstance(77, 97, WIDTH)));
		lblImage.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(shoppingCartItem.getProductItem().getProduct().getImages().get(0))
						.getScaledInstance(77, 97, WIDTH)));
		lblImage.setBackground(new Color(255, 255, 255));
		lblImage.setBounds(28, 11, 77, 97);
		panel.add(lblImage);

		JLabel lblName = new JLabel("");
		lblName.setText(shoppingCartItem.getProductItem().getProduct().getName());
		lblName.setFont(new Font("Verdana", Font.BOLD, 11));
		lblName.setBounds(133, 11, 210, 14);
		panel.add(lblName);

		JLabel lblSize = new JLabel("");
		lblSize.setText(shoppingCartItem.getProductItem().getSize());
		lblSize.setFont(new Font("Verdana", Font.BOLD, 11));
		lblSize.setBounds(133, 36, 46, 14);
		panel.add(lblSize);

		JLabel lblQuantity = new JLabel("");
		lblQuantity.setText("x" + shoppingCartItem.getQuantity());
		lblQuantity.setFont(new Font("Verdana", Font.BOLD, 11));
		lblQuantity.setBounds(133, 61, 46, 14);
		panel.add(lblQuantity);

		JLabel lblPrice = new JLabel("");
		lblPrice.setText(shoppingCartItem.getProductItem().getProduct().getPrice() + "" + "€");
		lblPrice.setFont(new Font("Verdana", Font.BOLD, 11));
		lblPrice.setBounds(133, 93, 46, 14);
		panel.add(lblPrice);

		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ShoppingCartItem> shopCartItems = order.getShoppingCart().getShoppingCartItems();
				shopCartItems.remove(shoppingCartItem);
				order.getShoppingCart().setShoppingCartItems(shopCartItems);
				frame.dispose();
				new ShoppingCartWindow(frameMenu, order, userChoice).setVisible(true);

			}
		});
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setIcon(new ImageIcon(ShoppingCartWindow.class.getResource("/es/images/cancelIcon.png")));
		btnDelete.setBounds(285, 43, 32, 32);
		panel.add(btnDelete);
		return panel;
	}

	public JPanel panelV(Order order, ShoppingCartItem shoppingCartItem, UserChoice userChoice, ShoppingCartWindow frame,
			MenuWindow frameMenu) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setBounds(0, 516, 353, 118);
		panel.setLayout(null);
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(shoppingCartItem.getProductItem().getProduct().getImages().get(0))
						.getScaledInstance(77, 97, WIDTH)));
		lblImage.setBackground(new Color(255, 255, 255));
		lblImage.setBounds(28, 11, 77, 97);
		panel.add(lblImage);

		JLabel lblName = new JLabel("");
		lblName.setText(shoppingCartItem.getProductItem().getProduct().getName());
		lblName.setFont(new Font("Verdana", Font.BOLD, 11));
		lblName.setBounds(133, 11, 210, 14);
		panel.add(lblName);

		JLabel lblSize = new JLabel("");
		lblSize.setText(shoppingCartItem.getProductItem().getSize());
		lblSize.setFont(new Font("Verdana", Font.BOLD, 11));
		lblSize.setBounds(133, 36, 46, 14);
		panel.add(lblSize);

		JLabel lblQuantity = new JLabel("");
		lblQuantity.setText("x" + shoppingCartItem.getQuantity());
		lblQuantity.setFont(new Font("Verdana", Font.BOLD, 11));
		lblQuantity.setBounds(133, 61, 46, 14);
		panel.add(lblQuantity);

		JLabel lblPrice = new JLabel("");
		lblPrice.setText(shoppingCartItem.getProductItem().getProduct().getPrice() + "" + "€");
		lblPrice.setFont(new Font("Verdana", Font.BOLD, 11));
		lblPrice.setBounds(133, 93, 46, 14);
		panel.add(lblPrice);

		JButton btnDelete = new JButton("");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<ShoppingCartItem> shopCartItems = order.getShoppingCart().getShoppingCartItems();
				shopCartItems.remove(shoppingCartItem);
				order.getShoppingCart().setShoppingCartItems(shopCartItems);
				frame.dispose();
				new ShoppingCartWindow(frameMenu, order, userChoice).setVisible(true);

			}
		});
		btnDelete.setBackground(new Color(255, 255, 255));
		btnDelete.setIcon(new ImageIcon(ShoppingCartWindow.class.getResource("/es/images/cancelIcon.png")));
		btnDelete.setBounds(285, 43, 32, 32);
		panel.add(btnDelete);
		return panel;
	}
}
