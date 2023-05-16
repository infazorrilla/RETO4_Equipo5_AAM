package es.elorrieta.aam.view.windows;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import es.elorrieta.aam.controller.ContollerShoppingCart;
import es.elorrieta.aam.controller.LoginSignupValidation;
import es.elorrieta.aam.controller.UserChoice;
import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
import es.elorrieta.aam.model.bbdd.manager.ManagerProductItems;
import es.elorrieta.aam.model.bbdd.pojo.Order;
import es.elorrieta.aam.model.bbdd.pojo.Product;
import es.elorrieta.aam.model.bbdd.pojo.ProductItem;
import es.elorrieta.aam.model.bbdd.pojo.ShoppingCart;
import es.elorrieta.aam.model.bbdd.pojo.ShoppingCartItem;

public class AddToShopCartWindow extends JFrame {

	private static final long serialVersionUID = 5333455454443017256L;
	private JPanel contentPane;
	private JButton btnSizeII;
	private JButton btnSizeI;
	private JButton btnSizeIII;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JButton btnSizeVI;
	private JButton btnSizeVII;
	private JButton btnSizeV;
	private JLabel lblQuantity;
	private JButton btnSizeIV;
	private JButton btnSizeVIII;
	private JLabel lblSelectedSize;
	private JLabel lblProductName;
	private JLabel lblProductPrice;

	public AddToShopCartWindow(Order order, Product product, UserChoice userChoice) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 63, 1207, 552);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblImgLeft = new JLabel("");

		lblImgLeft.setForeground(new Color(204, 153, 0));
		lblImgLeft.setBackground(new Color(204, 153, 0));

		lblImgLeft.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(product.getImages().get(0)).getScaledInstance(300, 499, WIDTH)));
		lblImgLeft.setBounds(79, 42, 300, 499);
		panel.add(lblImgLeft);

		JLabel lblImgRight = new JLabel("");

		lblImgRight.setBackground(new Color(102, 0, 153));

		lblImgRight.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(product.getImages().get(1)).getScaledInstance(300, 499, WIDTH)));
		lblImgRight.setBounds(461, 42, 300, 499);
		panel.add(lblImgRight);

		btnSizeII = new JButton("");
		btnSizeII.setForeground(new Color(255, 255, 255));
		btnSizeII.setBackground(new Color(153, 102, 0));
		btnSizeII.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelectedSize.setText(btnSizeII.getText());
			}
		});
		btnSizeII.setVisible(false);
		btnSizeII.setBounds(910, 233, 61, 41);
		panel.add(btnSizeII);

		btnSizeI = new JButton("");
		btnSizeI.setForeground(new Color(255, 255, 255));
		btnSizeI.setBackground(new Color(153, 102, 0));
		btnSizeI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelectedSize.setText(btnSizeI.getText());
			}
		});
		btnSizeI.setVisible(false);
		btnSizeI.setBounds(816, 233, 61, 41);
		panel.add(btnSizeI);

		btnSizeIII = new JButton("");
		btnSizeIII.setForeground(new Color(255, 255, 255));
		btnSizeIII.setBackground(new Color(153, 102, 0));
		btnSizeIII.setVisible(false);
		btnSizeIII.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelectedSize.setText(btnSizeIII.getText());
			}
		});
		btnSizeIII.setBounds(1001, 233, 61, 41);
		panel.add(btnSizeIII);

		JLabel lblNewLabel = new JLabel("Talla : ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel.setBounds(874, 184, 97, 28);
		panel.add(lblNewLabel);

		btnNewButton_3 = new JButton("-");
		btnNewButton_3.setForeground(new Color(255, 204, 51));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 99));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt(lblQuantity.getText().toString()) == 1) {

				} else {
					int cantidad = Integer.parseInt(lblQuantity.getText().toString());
					lblQuantity.setText(new ContollerShoppingCart().quantityNowMinus(cantidad) + "");
				}
			}
		});
		btnNewButton_3.setBounds(978, 394, 97, 76);
		panel.add(btnNewButton_3);

		btnNewButton_4 = new JButton("+");
		btnNewButton_4.setForeground(new Color(255, 204, 51));
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 45));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantidad = Integer.parseInt(lblQuantity.getText().toString());
				lblQuantity.setText(new ContollerShoppingCart().quantityNowPlus(cantidad) + "");
			}
		});
		btnNewButton_4.setBounds(803, 394, 97, 76);
		panel.add(btnNewButton_4);

		JLabel lblNewLabel_1 = new JLabel("Cantidad :");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(816, 344, 233, 28);
		panel.add(lblNewLabel_1);

		btnNewButton_5 = new JButton("Añadir Al carrito");
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(153, 102, 0));
		btnNewButton_5.setFont(new Font("Verdana", Font.BOLD, 18));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addToShoppingCart(order, product);
			}
		});
		btnNewButton_5.setBounds(842, 485, 207, 41);
		panel.add(btnNewButton_5);

		lblQuantity = new JLabel("1");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setBounds(910, 383, 46, 24);
		panel.add(lblQuantity);

		btnSizeVI = new JButton("");
		btnSizeVI.setForeground(new Color(255, 255, 255));
		btnSizeVI.setBackground(new Color(153, 102, 0));
		btnSizeVI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelectedSize.setText(btnSizeVI.getText());

			}
		});
		btnSizeVI.setVisible(false);
		btnSizeVI.setBounds(910, 285, 61, 41);
		panel.add(btnSizeVI);

		btnSizeVII = new JButton("");
		btnSizeVII.setForeground(new Color(255, 255, 255));
		btnSizeVII.setBackground(new Color(153, 102, 0));
		btnSizeVII.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelectedSize.setText(btnSizeVII.getText());
			}
		});
		btnSizeVII.setVisible(false);
		btnSizeVII.setBounds(1001, 285, 61, 41);
		panel.add(btnSizeVII);

		btnSizeV = new JButton("");
		btnSizeV.setForeground(new Color(255, 255, 255));
		btnSizeV.setBackground(new Color(153, 102, 0));
		btnSizeV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelectedSize.setText(btnSizeV.getText());
			}
		});
		btnSizeV.setVisible(false);
		btnSizeV.setBounds(816, 285, 61, 41);
		panel.add(btnSizeV);

		btnSizeIV = new JButton("");
		btnSizeIV.setForeground(new Color(255, 255, 255));
		btnSizeIV.setBackground(new Color(153, 102, 0));
		btnSizeIV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelectedSize.setText(btnSizeIV.getText());

			}
		});
		btnSizeIV.setVisible(false);
		btnSizeIV.setBounds(1088, 233, 61, 41);
		panel.add(btnSizeIV);

		btnSizeVIII = new JButton("");
		btnSizeVIII.setForeground(new Color(255, 255, 255));
		btnSizeVIII.setBackground(new Color(153, 102, 0));
		btnSizeVIII.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelectedSize.setText(btnSizeVIII.getText());
			}
		});
		btnSizeVIII.setVisible(false);
		btnSizeVIII.setBounds(1089, 285, 60, 41);
		panel.add(btnSizeVIII);

		lblSelectedSize = new JLabel("");
		lblSelectedSize.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelectedSize.setForeground(new Color(153, 102, 0));
		lblSelectedSize.setBounds(975, 184, 53, 28);
		panel.add(lblSelectedSize);

		lblProductName = new JLabel("");
		lblProductName.setText(product.getName());
		lblProductName.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductName.setFont(new Font("Source Sans Pro", Font.BOLD, 16));
		lblProductName.setBounds(786, 42, 323, 28);
		panel.add(lblProductName);

		lblProductPrice = new JLabel("66.99");
		lblProductPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductPrice.setText(product.getPrice() + "" + "€");
		lblProductPrice.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 18));
		lblProductPrice.setBounds(910, 71, 96, 24);
		panel.add(lblProductPrice);
		JPanel panelFooter = new JPanel();
		panelFooter.setForeground(new Color(255, 204, 51));
		panelFooter.setBackground(new Color(255, 255, 204));
		panelFooter.setBounds(0, 611, 1207, 50);
		contentPane.add(panelFooter);
		JPanel panelheader = new JPanel();
		panelheader.setBackground(new Color(255, 204, 102));
		panelheader.setForeground(new Color(255, 204, 51));
		panelheader.setBounds(0, 0, 1207, 63);
		contentPane.add(panelheader);
		panelheader.setLayout(null);

		JButton btnGoBack = new JButton("");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MenuWindow menu = new MenuWindow(order, userChoice);
				dispose();
				menu.setVisible(true);
			}
		});
		btnGoBack.setBackground(new Color(255, 255, 255));
		btnGoBack.setIcon(new ImageIcon(AddToShopCartWindow.class.getResource("/es/images/flecha (1).jpg")));
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGoBack.setBounds(35, 0, 93, 63);
		panelheader.add(btnGoBack);
		doGetAvaliableSizes(product);
	}

	private void doGetAvaliableSizes(Product product) {
		getAvaliableSizes(product.getId());
	}
	/**
	 * Retrieves the available sizes for a productItem with the given ID and makes the corresponding buttons visible.
	 * 
	 * @param id the ID of the productItem
	 */
	private void getAvaliableSizes(int id) {

		try {
			List<String> ret = new ManagerProductItems().getAvaliableSizes(id);
			doMakeButtonVisble(ret);
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
	 * Sets the visibility and text of buttons based on a list of sizes.
	 *
	 * @param sizes The list of sizes to be displayed on buttons.
	 */
	private void doMakeButtonVisble(List<String> sizes) {
		int num = 0;
		for (String size : sizes) {
			num++;
			makeButtonVisibleAndSetText(num, size);
		}
	}
	/**
	 * Makes a button visible and sets its size.
	 *
	 * This method sets the value of the size  of the button corresponding to the given number and makes it visible.
	 *
	 * @param num  The number indicating the button to be modified.
	 * @param text The size value to be set for the button.
	 */
	private void makeButtonVisibleAndSetText(int num, String text) {
		switch (num) {
		case 1:
			btnSizeI.setText(text);
			btnSizeI.setVisible(true);
			break;
		case 2:
			btnSizeII.setText(text);
			btnSizeII.setVisible(true);
			break;
		case 3:
			btnSizeIII.setText(text);
			btnSizeIII.setVisible(true);
			break;
		case 4:
			btnSizeIV.setText(text);
			btnSizeIV.setVisible(true);
			break;
		case 5:
			btnSizeV.setText(text);
			btnSizeV.setVisible(true);
			break;
		case 6:
			btnSizeVI.setText(text);
			btnSizeVI.setVisible(true);
			break;
		case 7:
			btnSizeVII.setText(text);
			btnSizeVII.setVisible(true);
			break;
		case 8:
			btnSizeVIII.setText(text);
			btnSizeVIII.setVisible(true);
			break;
		}
	}
	/**
	 * Adds a productItem to the shopping cart.
	 *
	 * This method adds the specified product to the shopping cart in the given order if a size is selected.
	 * If no size is selected, it displays a message prompting the user to select a size.
	 * After adding the product to the shopping cart, it shows a success message and navigates to the menu window.
	 *
	 * @param order   The order to which the product will be added to the shopping cart.
	 * @param product The product to be added to the shoppingcartitem and shoppingcartitem to the shoppingCart.
	 */
	private void addToShoppingCart(Order order, Product product) {
		if (sizeIsSelected()) {
			doAddToShoppingCart(order, product);
			JOptionPane.showMessageDialog(null, "Tu compra se añadido correctamente al carrito");
			dispose();
			MenuWindow menuWindow = new MenuWindow(order, new UserChoice());
			menuWindow.setVisible(true);
		} else
			JOptionPane.showMessageDialog(null, "Selecciona tu talla!!!");
	}
	/**
	 * Checks if a size is selected.
	 *
	 * This method checks if the label representing the selected size is empty or not. If the label is empty,
	 * it means that no size is currently selected, and the method returns false. Otherwise, it returns true
	 * indicating that a size is selected.
	 *
	 * @return true if a size is selected, false otherwise.
	 */
	private boolean sizeIsSelected() {
		boolean ret = true;
		if (lblSelectedSize.getText().isEmpty()) {

			ret = false;
		}
		return ret;
	}
	/**
	 * Adds a product to the shopping cart in the provided order.
	 *
	 * If the order's shopping cart is null, a new shopping cart is created and added to the order
	 * using the returnsShoppingCart method. Otherwise, a new shopping cart item is created for the
	 * product using the returnsShoppingCartItem method, and added to the existing shopping cart in
	 * the order.
	 *
	 * @param order The order to which the product should be added to the shopping cart.
	 * @param product The product to be added to the shoppingcartitem and shoppingcartitem to the shoppingCart
	 */
	private void doAddToShoppingCart(Order order, Product product) {
		if (order.getShoppingCart() == null) {
			order.setShoppingCart(returnsShoppingCart(product));
		} else {
			order.getShoppingCart().getShoppingCartItems().add(returnsShoppingCartItem(product));
		}

	}
	/**
	 * Creates a new ShoppingCart object and adds a ShoppingCartItem for the provided product.
	 *
	 * @param product The product to be added to the shoppingcartItem .
	 * @return The ShoppingCart object with the added ShoppingCartItem.
	 */
	private ShoppingCart returnsShoppingCart(Product product) {
		ShoppingCart ret = new ShoppingCart();
		ShoppingCartItem shopCartItem = new ShoppingCartItem();
		List<ShoppingCartItem> shopCartItems = new ArrayList<ShoppingCartItem>();
		shopCartItem.setPrice((new ContollerShoppingCart().calculateTotalPrice(product.getPrice(),
				Integer.parseInt(lblQuantity.getText().trim()))));
		shopCartItem.setQuantity(Integer.parseInt(lblQuantity.getText().trim()));
		shopCartItem.setProductItem(
				returnsProductItemSelectedSize(lblSelectedSize.getText(), product.getProductItems(), product));
		shopCartItems.add(shopCartItem);
		ret.setShoppingCartItems(shopCartItems);
		return ret;
	}

	/**
	 * Creates a new ShoppingCartItem object based on the provided product and
	 * selected size.
	 *
	 * @param product The product for which the ShoppingCartItem is being created.
	 * @return The ShoppingCartItem object representing the product in the shopping
	 *         cart.
	 */
	private ShoppingCartItem returnsShoppingCartItem(Product product) {
		ShoppingCartItem shopCartItem = new ShoppingCartItem();

		shopCartItem.setPrice((new ContollerShoppingCart().calculateTotalPrice(product.getPrice(),
				Integer.parseInt(lblQuantity.getText().trim()))));
		shopCartItem.setQuantity(Integer.parseInt(lblQuantity.getText().trim()));
		shopCartItem.setProductItem(
				returnsProductItemSelectedSize(lblSelectedSize.getText(), product.getProductItems(), product));
		return shopCartItem;
	}

	/**
	 * Returns the selected ProductItem from the given list of ProductItems based on
	 * the specified size.
	 *
	 * @param size         The size of the product item to search for.
	 * @param productItems The list of product items to search within.
	 * @param product      The associated product object to set for the selected
	 *                     product item.
	 * @return The selected ProductItem matching the specified size, or null if not
	 *         found.
	 */
	private ProductItem returnsProductItemSelectedSize(String size, List<ProductItem> productItems, Product product) {
		ProductItem ret = null;
		for (ProductItem productItem : productItems) {
			if (productItem.getSize().equalsIgnoreCase(size)) {
				productItem.setProduct(product);
				ret = productItem;
				break;
			}
		}
		return ret;
	}
}
