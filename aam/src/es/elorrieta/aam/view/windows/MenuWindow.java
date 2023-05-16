package es.elorrieta.aam.view.windows;

import java.awt.Color;
import java.awt.Dimension;
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
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import es.elorrieta.aam.controller.UserChoice;
import es.elorrieta.aam.model.bbdd.exception.AccessToDataBaseException;
import es.elorrieta.aam.model.bbdd.exception.NotFoundException;
import es.elorrieta.aam.model.bbdd.manager.ManagerProducts;
import es.elorrieta.aam.model.bbdd.pojo.Order;
import es.elorrieta.aam.model.bbdd.pojo.Product;
import es.elorrieta.aam.view.windows.panelFactory.Panels;

public class MenuWindow extends JFrame {

	private static final long serialVersionUID = -8261199952324498953L;
	private JPanel contentPane;
	private JPanel panelItems;
	private JLabel lblGigleft;
	private JLabel lblGiF;
	private JLabel lblGifMan;
	private JButton btnHM;
	private JButton btnPullAndBear;
	private JButton btnBershka;
	private JButton btnZara;
	private JButton btnDresses;
	private ArrayList<JPanel> jpanels;

	public MenuWindow(Order order, UserChoice userChoice) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.repaint();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panelFooter = new JPanel();
		panelFooter.setForeground(new Color(255, 204, 51));
		panelFooter.setBackground(new Color(255, 204, 51));
		panelFooter.setBounds(0, 612, 1207, 49);
		contentPane.add(panelFooter);
		JPanel panelheader = new JPanel();
		panelheader.setBackground(new Color(255, 204, 51));
		panelheader.setForeground(new Color(255, 204, 51));
		panelheader.setBounds(0, 0, 1207, 63);
		contentPane.add(panelheader);
		panelheader.setLayout(null);

		JButton btnGoBack = new JButton("");
		btnGoBack.setIcon(new ImageIcon(MenuWindow.class.getResource("/es/images/flecha (1).jpg")));
		btnGoBack.setBackground(new Color(255, 255, 255));
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				GenderWindow genderWindow = new GenderWindow(order);
				genderWindow.setVisible(true);
			}
		});
		btnGoBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGoBack.setBounds(44, 0, 93, 63);
		panelheader.add(btnGoBack);

		JButton btnShopCart = new JButton("");
		btnShopCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShoppingCartWindow shopCart = new ShoppingCartWindow(MenuWindow.this, order, userChoice);
				shopCart.setVisible(true);

			}
		});
		btnShopCart.setBackground(new Color(255, 255, 255));
		btnShopCart.setIcon(new ImageIcon(MenuWindow.class.getResource("/es/images/2331970.png")));
		btnShopCart.setBounds(1111, 7, 53, 56);
		panelheader.add(btnShopCart);

		JButton btnProfile = new JButton("");
		btnProfile.addActionListener(new ActionListener() {
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
		btnProfile.setBackground(new Color(255, 255, 255));
		btnProfile.setIcon(new ImageIcon(MenuWindow.class.getResource("/es/images/10418806.png")));
		btnProfile.setBounds(1021, 7, 53, 56);
		panelheader.add(btnProfile);

		JPanel panelContainer = new JPanel();
		panelContainer.setBackground(new Color(255, 255, 255));
		panelContainer.setForeground(new Color(255, 255, 255));
		panelContainer.setBounds(0, 0, 1207, 661);
		contentPane.add(panelContainer);
		panelContainer.setLayout(null);

		panelItems = new JPanel();
		panelItems.setBackground(Color.WHITE);
		JScrollPane scrollPanel = new JScrollPane(panelItems, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPanel.setBounds(259, 110, 948, 503);
		panelItems.setBounds(0, 0, 1920, 1080);
		panelItems.setPreferredSize(new Dimension(500, 3000));
		panelItems.setLayout(null);

		lblGigleft = new JLabel("New label");
		lblGigleft.setIcon(new ImageIcon(MenuWindow.class.getResource("/es/images/gifLeft.gif")));
		lblGigleft.setBounds(0, 0, 504, 501);
		panelItems.add(lblGigleft);

		lblGiF = new JLabel("");

		lblGiF.setBounds(443, 0, 486, 501);
		panelItems.add(lblGiF);
		panelContainer.add(scrollPanel);

		lblGiF.setIcon(new ImageIcon(MenuWindow.class.getResource("/es/images/aa.gif")));
		lblGifMan = new JLabel("");
		lblGifMan.setVisible(false);
		lblGifMan.setIcon(new ImageIcon(MenuWindow.class.getResource("/es/images/gifMan.gif")));
		lblGifMan.setBounds(0, 0, 929, 501);
		panelItems.add(lblGifMan);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 204));
		panel.setForeground(new Color(255, 255, 204));
		panel.setBounds(0, 110, 262, 503);
		panelContainer.add(panel);
		panel.setLayout(null);

		btnDresses = new JButton("Vestidos");
		btnDresses.setForeground(new Color(255, 255, 255));
		btnDresses.setBackground(new Color(153, 102, 0));
		btnDresses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makeChanges();
				userChoice.setDress(true);
				userChoice.setJeans(false);
				userChoice.setShoes(false);
				userChoice.setTshirt(false);

			}
		});
		btnDresses.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDresses.setBounds(21, 84, 215, 48);
		panel.add(btnDresses);

		JButton btnTshirts = new JButton("Camisitas");
		btnTshirts.setForeground(new Color(255, 255, 255));
		btnTshirts.setBackground(new Color(153, 102, 0));
		btnTshirts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makeChanges();
				userChoice.setDress(false);
				userChoice.setJeans(false);
				userChoice.setShoes(false);
				userChoice.setTshirt(true);
			}
		});
		btnTshirts.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTshirts.setBounds(21, 166, 215, 48);
		panel.add(btnTshirts);

		JButton btnJeans = new JButton("Pantalones");
		btnJeans.setForeground(new Color(255, 255, 255));
		btnJeans.setBackground(new Color(153, 102, 0));
		btnJeans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makeChanges();
				userChoice.setDress(false);
				userChoice.setJeans(true);
				userChoice.setShoes(false);
				userChoice.setTshirt(false);
			}
		});
		btnJeans.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnJeans.setBounds(21, 252, 215, 48);
		panel.add(btnJeans);

		JButton btnShoes = new JButton("Zapatillas");
		btnShoes.setForeground(new Color(255, 255, 255));
		btnShoes.setBackground(new Color(153, 102, 0));
		btnShoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				makeChangesForShoes();
				userChoice.setDress(false);
				userChoice.setJeans(false);
				userChoice.setShoes(true);
				userChoice.setTshirt(false);
			}
		});
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
		btnFemale.setForeground(new Color(255, 255, 255));
		btnFemale.setBackground(new Color(153, 102, 0));
		btnFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removePanelsFromPanelItems();
				userChoice.setFemale(true);
				makeGifsForFemaleVisible(true);
				makeGifsForManVisible(false);
				makeBrandsButtonVisible(false);
				userChoice.setDress(false);
				userChoice.setJeans(false);
				userChoice.setShoes(false);
				userChoice.setTshirt(false);
				btnDresses.setText("Vestidos");
			}
		});
		btnFemale.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnFemale.setBounds(415, 6, 110, 39);
		panelGender.add(btnFemale);

		JButton btnMale = new JButton("Hombre");
		btnMale.setForeground(new Color(255, 255, 255));
		btnMale.setBackground(new Color(153, 102, 0));
		btnMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userChoice.setFemale(false);
				makeGifsForFemaleVisible(false);
				makeGifsForManVisible(true);
				makeBrandsButtonVisible(false);
				userChoice.setDress(false);
				userChoice.setJeans(false);
				userChoice.setShoes(false);
				userChoice.setTshirt(false);
				btnDresses.setText("Trajes");
				removePanelsFromPanelItems();

			}
		});
		btnMale.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnMale.setBounds(695, 6, 104, 39);
		panelGender.add(btnMale);

		btnZara = new JButton("");
		btnZara.setVisible(false);
		btnZara.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userChoice.setZara(true);
				userChoice.setHM(false);
				userChoice.setBershka(false);
				userChoice.setPullAndBear(false);
				clearPanelItems(userChoice);
				doGetAllProductOfSelectedBrand(MenuWindow.this, order, userChoice);

			}

		});
		btnZara.setBounds(111, 185, 244, 96);

		panelItems.add(btnZara);

		btnHM = new JButton("");
		btnHM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userChoice.setHM(true);
				userChoice.setZara(false);
				userChoice.setBershka(false);
				userChoice.setPullAndBear(false);
				clearPanelItems(userChoice);
				doGetAllProductOfSelectedBrand(MenuWindow.this, order, userChoice);
			}
		});
		btnHM.setVisible(false);
		btnHM.setBounds(513, 185, 244, 105);

		panelItems.add(btnHM);
		panelItems.add(btnHM);

		btnPullAndBear = new JButton("");
		btnPullAndBear.setVisible(false);
		btnPullAndBear.setBounds(513, 337, 244, 96);

		panelItems.add(btnPullAndBear);

		btnBershka = new JButton("");
		btnBershka.setVisible(false);
		btnBershka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBershka.setBounds(111, 337, 244, 96);

		panelItems.add(btnBershka);
		setBackground(userChoice);
	}

	private void clearPanelItems(UserChoice userChoice) {
		makeGifsForFemaleVisible(false);
		makeGifsForManVisible(false);
		makeBrandsButtonVisible(false);

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

	private void makeChanges() {
		setImages(true);
		makeBrandsButtonVisible(true);
		makeGifsForFemaleVisible(false);
		makeGifsForManVisible(false);
	}

	private void makeGifsForFemaleVisible(boolean value) {
		lblGigleft.setVisible(value);
		lblGiF.setVisible(value);
	}

	private void makeGifsForManVisible(boolean value) {
		lblGifMan.setVisible(value);
	}

	/**
	 * sets the visibility of all four buttons
	 * 
	 * @param value true or false
	 */
	private void makeBrandsButtonVisible(boolean value) {
		btnZara.setVisible(value);
		btnHM.setVisible(value);
		btnPullAndBear.setVisible(value);
		btnBershka.setVisible(value);
	}

	private void setBackground(UserChoice userChoice) {
		if (userChoice.isFemale()) {
			makeGifsForFemaleVisible(true);
			makeGifsForManVisible(false);
			makeBrandsButtonVisible(false);
			btnDresses.setText("Vestidos");
		} else {
			makeGifsForFemaleVisible(false);
			makeGifsForManVisible(true);
			makeBrandsButtonVisible(false);
			btnDresses.setText("Trajes");
		}
	}

	private void makeChangesForShoes() {
		makeBrandsButtonVisible(true);
		changeButtonsName();
		setImages(false);
		makeGifsForFemaleVisible(false);
		makeGifsForManVisible(false);
	}

	/**
	 * This method is used to change the action command (name) of four buttons:
	 * btnBershka, btnPullAndBear, btnHM, and btnZara.
	 */
	private void changeButtonsName() {

		btnBershka.setActionCommand("nike");

		btnPullAndBear.setActionCommand("adidas");

		btnHM.setActionCommand("levis");

		btnZara.setActionCommand("newBalance");
	}

	/**
	 * takes a boolean parameter value. Based on the value of value, the method sets
	 * different images to four buttons (btnZara, btnHM, btnPullAndBear, and
	 * btnBershka).
	 * 
	 * @param value true or false
	 */
	private void setImages(boolean value) {
		if (value) {
			ImageIcon imageIcon = new ImageIcon(fitimage(getimage(MenuWindow.class.getResource("/es/images/ZARA.jpg")),
					btnZara.getWidth(), btnZara.getHeight()));
			btnZara.setIcon(imageIcon);
			ImageIcon imageIcon1 = new ImageIcon(fitimage(getimage(MenuWindow.class.getResource("/es/images/HM.jpg")),
					btnHM.getWidth(), btnHM.getHeight()));
			btnHM.setIcon(imageIcon1);
			ImageIcon imageIcon3 = new ImageIcon(fitimage(getimage(MenuWindow.class.getResource("/es/images/PULL.jpg")),
					btnPullAndBear.getWidth(), btnPullAndBear.getHeight()));
			btnPullAndBear.setIcon(imageIcon3);
			ImageIcon imageIcon2 = new ImageIcon(
					fitimage(getimage(MenuWindow.class.getResource("/es/images/BERSHKA.jpg")), btnBershka.getWidth(),
							btnBershka.getHeight()));
			btnBershka.setIcon(imageIcon2);
		} else {
			ImageIcon imageIcon = new ImageIcon(
					fitimage(getimage(MenuWindow.class.getResource("/es/images/newBalence.jpg")), btnZara.getWidth(),
							btnZara.getHeight()));
			btnZara.setIcon(imageIcon);
			ImageIcon imageIcon1 = new ImageIcon(
					fitimage(getimage(MenuWindow.class.getResource("/es/images/levis.jpg")), btnHM.getWidth(),
							btnHM.getHeight()));
			btnHM.setIcon(imageIcon1);
			ImageIcon imageIcon3 = new ImageIcon(
					fitimage(getimage(MenuWindow.class.getResource("/es/images/adidas.jpg")), btnPullAndBear.getWidth(),
							btnPullAndBear.getHeight()));
			btnPullAndBear.setIcon(imageIcon3);
			ImageIcon imageIcon2 = new ImageIcon(fitimage(getimage(MenuWindow.class.getResource("/es/images/nike.jpg")),
					btnBershka.getWidth(), btnBershka.getHeight()));
			btnBershka.setIcon(imageIcon2);
		}
	}

	private void doGetAllProductOfSelectedBrand(MenuWindow frame, Order order, UserChoice userChoice) {
		try {
			List<Product> products = getAllProductOfSelectedBrand(userChoice);
			addProductsToPanel(frame, order, products, userChoice);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(contentPane, "Data Base Error. Contents cannot be displayed", "ERROR!!",
					JOptionPane.ERROR_MESSAGE);

		} catch (AccessToDataBaseException e) {
			JOptionPane.showMessageDialog(contentPane, "Data Base Access. Coundn't connect to data base  ", "ERROR!!",
					JOptionPane.ERROR_MESSAGE);
		} catch (NotFoundException e) {
			JOptionPane.showMessageDialog(contentPane, "Data Base is empty", "ERROR!!", JOptionPane.ERROR_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "Generic error...", "ERROR!!", JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * 
	 *
	 * This method takes in a UserChoice object (userChoice) and retrieves all
	 * products that belong to the selected brand. It calls the
	 * doSelectAllByGenderSubCategoryBrand() method from the ManagerProducts class,
	 * passing in the selected gender, brand, and subcategory from the userChoice
	 * object. The method returns a List of Product objects representing all the
	 * products of the selected brand.
	 *
	 * @param userChoice the UserChoice object containing the selected gender,
	 *                   brand, and subcategory
	 * @return a List of Product objects representing all products of the selected
	 *         brand
	 * @throws SQLException              if an error occurs while accessing the
	 *                                   database
	 * @throws NotFoundException         if the requested data is not found
	 * @throws AccessToDataBaseException if there is an issue with accessing the
	 *                                   database
	 * @throws Exception                 for any other unexpected exception
	 */
	private List<Product> getAllProductOfSelectedBrand(UserChoice userChoice)
			throws SQLException, NotFoundException, AccessToDataBaseException, Exception {

		return new ManagerProducts().doSelectAllByGenderSubCategoryBrand(userChoice.getSelectedGender(),
				userChoice.getSelectedBrand(), userChoice.getSelectedSubCategory());

	}

	/**
	 * Adds products to the panelItems .
	 * 
	 * This method takes in a MenuWindow object (frame), an Order object (order), a
	 * List of Product objects (products), and a UserChoice object (userChoice). It
	 * iterates over the products list, assigns a number (num) to each product, and
	 * calls the returnsJpanelNumberX() method to obtain a JPanel based on the
	 * number and other parameters. If the returned JPanel is not null, it adds the
	 * panel to both the panelItems list and the jpanels list.
	 *
	 * @param frame      the MenuWindow object to be passed to the
	 *                   returnsJpanelNumberX() method
	 * @param order      the Order object to be passed to the returnsJpanelNumberX()
	 *                   method
	 * @param products   the List of Product objects to be iterated over
	 * @param userChoice the UserChoice object to be passed to the
	 *                   returnsJpanelNumberX() method
	 */

	private void addProductsToPanel(MenuWindow frame, Order order, List<Product> products, UserChoice userChoice) {
		int num = 0;
		jpanels = new ArrayList<JPanel>();
		for (Product product : products) {
			num++;
			JPanel panel = returnsJpanelNumberX(num, order, product, frame, userChoice);
			if (panel != null) {
				panelItems.add(panel);
				jpanels.add(panel);
			}
		}
	}

	/**
	 * Returns a specific JPanel based on the given number.
	 * 
	 * This method takes in a number (num), an Order object (order), a Product
	 * object (product), a MenuWindow object (frame), and a UserChoice object
	 * (userChoice), and returns a JPanel corresponding to the given number. The
	 * returned JPanel is obtained by calling the appropriate method from the Panels
	 * class based on the number. If the number is invalid or out of range (not
	 * between 1 and 12), the method returns null.
	 *
	 * @param num        the number representing the desired JPanel
	 * @param order      the Order object to be passed to the Panels methods
	 * @param product    the Product object to be passed to the Panels methods
	 * @param frame      the MenuWindow object to be passed to the Panels methods
	 * @param userChoice the UserChoice object to be passed to the Panels methods
	 * @return the JPanel corresponding to the given number, or null if the number
	 *         is invalid
	 */
	private JPanel returnsJpanelNumberX(int num, Order order, Product product, MenuWindow frame,
			UserChoice userChoice) {
		JPanel ret = null;
		switch (num) {
		case 1:
			ret = new Panels().getJpanelOne(order, product, frame, userChoice);
			break;
		case 2:
			ret = new Panels().getJpanelTwo(order, product, frame, userChoice);
			break;
		case 3:
			ret = new Panels().getJpanelThree(order, product, frame, userChoice);
			break;
		case 4:
			ret = new Panels().getJpanelFour(order, product, frame, userChoice);
			break;
		case 5:
			ret = new Panels().getJpanelFive(order, product, frame, userChoice);
			break;
		case 6:
			ret = new Panels().getJpanelSix(order, product, frame, userChoice);
			break;
		case 7:
			ret = new Panels().getJpanelSeven(order, product, frame, userChoice);
			break;
		case 8:
			ret = new Panels().getJpanelEight(order, product, frame, userChoice);
			break;
		case 9:
			ret = new Panels().getJpanelNine(order, product, frame, userChoice);
			break;
		case 10:
			ret = new Panels().getJpanelTen(order, product, frame, userChoice);
			break;
		case 11:
			ret = new Panels().getJpanelEleven(order, product, frame, userChoice);
			break;
		case 12:
			ret = new Panels().getJpanelTwelve(order, product, frame, userChoice);
			break;
		}

		return ret;
	}

	/**
	 * Removes panels from the panelItems list.
	 * 
	 * This method iterates over the jpanels list and removes each panel from the
	 * panelItems list. If the jpanels list is null, no panels are removed.
	 */
	private void removePanelsFromPanelItems() {
		if (jpanels != null) {
			for (JPanel panel : jpanels) {
				panelItems.remove(panel);
			}
		}
	}
}
