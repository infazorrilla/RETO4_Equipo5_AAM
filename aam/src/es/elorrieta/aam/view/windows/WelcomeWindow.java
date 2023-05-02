package es.elorrieta.aam.view.windows;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import es.elorrieta.aam.model.bbdd.pojo.Order;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeWindow {

	public JFrame frame;

	public WelcomeWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1223, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JPanel panelBienvenida = new JPanel();
		panelBienvenida.setBounds(0, 0, 1207, 661);
		frame.getContentPane().add(panelBienvenida);
		panelBienvenida.setLayout(null);

		JButton jButtonBienvenida = new JButton("");
		jButtonBienvenida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenderWindow genderWindow = new GenderWindow(new Order());
				frame.dispose();
				frame.setVisible(false);
				genderWindow.setVisible(true);

			}
		});

		jButtonBienvenida.setBounds(0, 0, 1207, 661);
		panelBienvenida.add(jButtonBienvenida);
	}
}
