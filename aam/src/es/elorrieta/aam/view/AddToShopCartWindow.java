package es.elorrieta.aam.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import es.elorrieta.aam.controller.ContollerShoppingCart;
import es.elorrieta.aam.controller.*;
import es.elorrieta.aam.controller.LoginSignupValidation;
import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
import es.elorrieta.aam.model.bbdd.manager.ManagerProductItems;
import es.elorrieta.aam.model.bbdd.pojo.*;

import es.elorrieta.aam.model.bbdd.pojo.Product;
import es.elorrieta.aam.view.windows.MenuWindow;

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

	public AddToShopCartWindow(Order order, Product product) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 51, 1207, 564);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblImgLeft = new JLabel("");

		lblImgLeft.setForeground(new Color(204, 153, 0));
		lblImgLeft.setBackground(new Color(204, 153, 0));

		lblImgLeft.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(product.getImages().get(0)).getScaledInstance(300, 499, WIDTH)));
		lblImgLeft.setBounds(85, 42, 300, 499);
		panel.add(lblImgLeft);

		JLabel lblImgRight = new JLabel("");

		lblImgRight.setBackground(new Color(102, 0, 153));

		lblImgRight.setIcon(new javax.swing.ImageIcon(
				new LoginSignupValidation().getImage(product.getImages().get(1)).getScaledInstance(300, 499, WIDTH)));
		lblImgRight.setBounds(461, 42, 300, 499);
		panel.add(lblImgRight);

		btnSizeII = new JButton("");
		btnSizeII.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelectedSize.setText(btnSizeII.getText());
			}
		});
		btnSizeII.setVisible(false);
		btnSizeII.setBounds(910, 233, 61, 41);
		panel.add(btnSizeII);

		btnSizeI = new JButton("");
		btnSizeI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelectedSize.setText(btnSizeI.getText());
			}
		});
		btnSizeI.setVisible(false);
		btnSizeI.setBounds(816, 233, 61, 41);
		panel.add(btnSizeI);

		btnSizeIII = new JButton("");
		btnSizeIII.setVisible(false);
		btnSizeIII.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelectedSize.setText(btnSizeIII.getText());
			}
		});
		btnSizeIII.setBounds(1001, 233, 61, 41);
		panel.add(btnSizeIII);

		JLabel lblNewLabel = new JLabel("Talla : ");
		lblNewLabel.setBounds(889, 184, 45, 14);
		panel.add(lblNewLabel);

		btnNewButton_3 = new JButton("-");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt(lblQuantity.getText().toString()) == 1) {
//nothing to do
				} else {
					int cantidad = Integer.parseInt(lblQuantity.getText().toString());
					lblQuantity.setText(new ContollerShoppingCart().quantityNowMinus(cantidad) + "");
				}
			}
		});
		btnNewButton_3.setBounds(1011, 417, 61, 34);
		panel.add(btnNewButton_3);

		btnNewButton_4 = new JButton("+");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cantidad = Integer.parseInt(lblQuantity.getText().toString());
				lblQuantity.setText(new ContollerShoppingCart().quantityNowPlus(cantidad) + "");
			}
		});
		btnNewButton_4.setBounds(816, 417, 61, 34);
		panel.add(btnNewButton_4);

		JLabel lblNewLabel_1 = new JLabel("Selecciona ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(829, 358, 233, 14);
		panel.add(lblNewLabel_1);

		btnNewButton_5 = new JButton("Añadir Al carrito");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addToShoppingCart(order, product);
			}
		});
		btnNewButton_5.setBounds(889, 477, 140, 34);
		panel.add(btnNewButton_5);

		lblQuantity = new JLabel("1");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setBounds(910, 383, 46, 14);
		panel.add(lblQuantity);

		btnSizeVI = new JButton("");
		btnSizeVI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelectedSize.setText(btnSizeVI.getText());

			}
		});
		btnSizeVI.setVisible(false);
		btnSizeVI.setBounds(910, 285, 61, 41);
		panel.add(btnSizeVI);

		btnSizeVII = new JButton("");
		btnSizeVII.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelectedSize.setText(btnSizeVII.getText());
			}
		});
		btnSizeVII.setVisible(false);
		btnSizeVII.setBounds(1001, 285, 61, 41);
		panel.add(btnSizeVII);

		btnSizeV = new JButton("");
		btnSizeV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelectedSize.setText(btnSizeV.getText());
			}
		});
		btnSizeV.setVisible(false);
		btnSizeV.setBounds(816, 285, 61, 41);
		panel.add(btnSizeV);

		btnSizeIV = new JButton("");
		btnSizeIV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelectedSize.setText(btnSizeIV.getText());

			}
		});
		btnSizeIV.setVisible(false);
		btnSizeIV.setBounds(1088, 233, 61, 41);
		panel.add(btnSizeIV);

		btnSizeVIII = new JButton("");
		btnSizeVIII.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSelectedSize.setText(btnSizeVIII.getText());
			}
		});
		btnSizeVIII.setVisible(false);
		btnSizeVIII.setBounds(1089, 285, 60, 41);
		panel.add(btnSizeVIII);

		lblSelectedSize = new JLabel("");
		lblSelectedSize.setBounds(933, 184, 53, 14);
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
		doGetAvaliableSizes(product);
	}

	private BufferedImage getimage(URL image) {

		BufferedImage img = null;
		try {
			img = ImageIO.read(image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}

	private Image fitimage(Image img, int w, int h) {
		BufferedImage resizedimage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = resizedimage.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(img, 0, 0, w, h, null);
		g2.dispose();
		return resizedimage;
	}

	private void doGetAvaliableSizes(Product product) {
		getAvaliableSizes(product.getId());
	}

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

	private void doMakeButtonVisble(List<String> sizes) {
		int num = 0;
		for (String size : sizes) {
			num++;
			makeButtonVisibleAndSetText(num, size);
		}
	}

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

	private boolean sizeIsSelected() {
		boolean ret = true;
		if (lblSelectedSize.getText().isEmpty()) {

			ret = false;
		}
		return ret;
	}

	private void doAddToShoppingCart(Order order, Product product) {
		if (order.getShoppingCart() == null) {
			order.setShoppingCart(returnsShoppingCart(product));
		} else {
			order.getShoppingCart().getShoppingCartItems().add(returnsShoppingCartItem(product));
		}

	}

	private ShoppingCart returnsShoppingCart(Product product) {
		ShoppingCart ret = new ShoppingCart();
		ShoppingCartItem shopCartItem = new ShoppingCartItem();
		List<ShoppingCartItem> shopCartItems = new ArrayList<ShoppingCartItem>();
		shopCartItem
				.setPrice((calculateTotalPrice(product.getPrice(), Integer.parseInt(lblQuantity.getText().trim()))));
		shopCartItem.setQuantity(Integer.parseInt(lblQuantity.getText().trim()));
		shopCartItem
				.setProductItem(returnsProductItemSelectedSize(lblSelectedSize.getText(), product.getProductItems()));
		shopCartItems.add(shopCartItem);
		ret.setShoppingCartItems(shopCartItems);
		return ret;
	}

	private ShoppingCartItem returnsShoppingCartItem(Product product) {
		ShoppingCartItem shopCartItem = new ShoppingCartItem();

		shopCartItem
				.setPrice((calculateTotalPrice(product.getPrice(), Integer.parseInt(lblQuantity.getText().trim()))));
		shopCartItem.setQuantity(Integer.parseInt(lblQuantity.getText().trim()));
		shopCartItem
				.setProductItem(returnsProductItemSelectedSize(lblSelectedSize.getText(), product.getProductItems()));
		return shopCartItem;
	}

	private double calculateTotalPrice(double price, int quantiy) {
		return price * quantiy;
	}

	private ProductItem returnsProductItemSelectedSize(String size, List<ProductItem> productItems) {
		ProductItem ret = null;
		for (ProductItem product : productItems) {
			if (product.getSize().equalsIgnoreCase(size)) {
				ret = product;
				break;
			}
		}
		return ret;
	}
}
