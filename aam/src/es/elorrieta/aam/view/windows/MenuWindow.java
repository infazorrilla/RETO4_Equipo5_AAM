package es.elorrieta.aam.view.windows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuWindow extends JFrame {

	private static final long serialVersionUID = -8261199952324498953L;
	private JPanel contentPane;


	public MenuWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1223, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelContainer = new JPanel();
		panelContainer.setBounds(0, 0, 1207, 661);
		contentPane.add(panelContainer);
		panelContainer.setLayout(null);
	}
}
