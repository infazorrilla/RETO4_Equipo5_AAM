package es.elorrieta.aam.view.windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import es.elorrieta.aam.controller.ContollerShoppingCart;
import es.elorrieta.aam.controller.UserChoice;
import es.elorrieta.aam.model.bbdd.pojo.Order;
import es.elorrieta.aam.model.bbdd.pojo.ShoppingCartItem;
import es.elorrieta.aam.view.windows.panelFactory.PanelsForShoppingCartWindow;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShoppingCartWindow extends JFrame {

	private static final long serialVersionUID = 4716225418795060797L;
	private JPanel contentPane;
	private JPanel panelItems;

	public ShoppingCartWindow(MenuWindow menuWindow, Order order, UserChoice userChoice) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelContai = new JPanel();
		panelContai.setBackground(new Color(255, 255, 255));
		panelContai.setBounds(0, 0, 484, 661);
		contentPane.add(panelContai);
		panelContai.setLayout(null);

		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(255, 204, 51));
		panelHeader.setBounds(0, 0, 489, 75);
		panelContai.add(panelHeader);
		panelHeader.setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuWindow.dispose();
				dispose();
				MenuWindow menu = new MenuWindow(order, userChoice);
				menu.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(ShoppingCartWindow.class.getResource("/es/images/1828778.png")));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(384, 11, 50, 44);
		panelHeader.add(btnNewButton);

		JPanel panelFooter = new JPanel();
		panelFooter.setBackground(new Color(255, 204, 51));
		panelFooter.setBounds(0, 552, 482, 109);
		panelContai.add(panelFooter);
		panelFooter.setLayout(null);

		JLabel lblTotal = new JLabel("Total :");
		lblTotal.setFont(new Font("Verdana", Font.BOLD, 18));
		lblTotal.setBounds(112, 11, 82, 24);
		panelFooter.add(lblTotal);

		JLabel lblPrice = new JLabel("0€");
		lblPrice.setForeground(new Color(255, 0, 0));
		lblPrice.setText(order.getShoppingCart() == null ? "0€"
				: new ContollerShoppingCart().calculatPriceBase(order.getShoppingCart()) + "€");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Verdana", Font.BOLD, 18));
		lblPrice.setBounds(225, 12, 126, 23);
		panelFooter.add(lblPrice);

		JButton btnNewButton_1 = new JButton("Comprar");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (order.getCustomer() == null) {
					JOptionPane.showMessageDialog(null, "Para comprar, se necesita iniciar sesion o registrarse ");
				} else {

					order.setTotalPrice(Double.parseDouble(
							new ContollerShoppingCart().calculatPriceBase(order.getShoppingCart()).replace(",", ".")));
					PaymentWindow paymentWindow = new PaymentWindow(order);
					dispose();
					menuWindow.dispose();
					paymentWindow.setVisible(true);

				}
			}
		});
		btnNewButton_1.setBackground(new Color(153, 102, 0));
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 18));
		btnNewButton_1.setBounds(158, 59, 155, 39);
		panelFooter.add(btnNewButton_1);
		JScrollPane scrollPanel = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setBounds(60, 73, 372, 479);
		panelContai.add(scrollPanel);

		panelItems = new JPanel();
		scrollPanel.setViewportView(panelItems);
		panelItems.setBackground(Color.WHITE);
		panelItems.setPreferredSize(new Dimension(350, 3000));
		panelItems.setLayout(null);

		checkShoppingCart(menuWindow, order, userChoice, ShoppingCartWindow.this);
	}

	private void checkShoppingCart(MenuWindow menuWindow, Order order, UserChoice userChoice,
			ShoppingCartWindow frame) {
		if (order.getShoppingCart() != null) {
			addItemsToPanel(menuWindow, order, userChoice, ShoppingCartWindow.this);
		} else {

		}
	}

	private void addItemsToPanel(MenuWindow menuWindow, Order order, UserChoice userChoice, ShoppingCartWindow frame) {
		int num = 0;
		for (ShoppingCartItem shoppingCartItem : order.getShoppingCart().getShoppingCartItems()) {
			num++;
			panelItems.add(doAddItemsToPanel(num, shoppingCartItem, menuWindow, userChoice, order, frame));
		}
	}

	private JPanel doAddItemsToPanel(int num, ShoppingCartItem shoppingCartItem, MenuWindow menuWindow,
			UserChoice userChoice, Order odrer, ShoppingCartWindow frame) {
		JPanel ret = null;
		switch (num) {
		case 1:
			ret = new PanelsForShoppingCartWindow().panelI(odrer, shoppingCartItem, userChoice, frame, menuWindow);
			break;
		case 2:
			ret = new PanelsForShoppingCartWindow().panelII(odrer, shoppingCartItem, userChoice, frame, menuWindow);
			break;
		case 3:
			ret = new PanelsForShoppingCartWindow().panelIII(odrer, shoppingCartItem, userChoice, frame, menuWindow);
			break;
		case 4:
			ret = new PanelsForShoppingCartWindow().panelIV(odrer, shoppingCartItem, userChoice, frame, menuWindow);
			break;
		case 5:
			ret = new PanelsForShoppingCartWindow().panelV(odrer, shoppingCartItem, userChoice, frame, menuWindow);
			break;
		}
		return ret;

	}

}
