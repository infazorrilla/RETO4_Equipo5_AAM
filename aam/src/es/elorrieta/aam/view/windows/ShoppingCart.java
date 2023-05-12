package es.elorrieta.aam.view.windows;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import es.elorrieta.aam.controller.UserChoice;
import es.elorrieta.aam.model.bbdd.pojo.Order;

public class ShoppingCart extends JFrame {

	private static final long serialVersionUID = 4716225418795060797L;
	private JPanel contentPane;

	public ShoppingCart(Order odrer, UserChoice userChoice) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelContai = new JPanel();
		panelContai.setBounds(0, 0, 510, 661);
		contentPane.add(panelContai);
		panelContai.setLayout(null);

		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(255, 204, 51));
		panelHeader.setBounds(0, 0, 489, 44);
		panelContai.add(panelHeader);

		JPanel panelFooter = new JPanel();
		panelFooter.setBackground(new Color(255, 204, 51));
		panelFooter.setBounds(0, 617, 482, 44);
		panelContai.add(panelFooter);
		JScrollPane scrollPanel = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPanel.setBounds(60, 44, 372, 573);
		panelContai.add(scrollPanel);

		JPanel panelItems = new JPanel();
		scrollPanel.setViewportView(panelItems);
		panelItems.setBackground(Color.WHITE);
		panelItems.setPreferredSize(new Dimension(350, 3000));
		panelItems.setLayout(null);
	}
	
}
