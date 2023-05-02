package es.elorrieta.aam.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;


public class LoginSignupValidation {

	public boolean isValidEmail(String mail) {
		return Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$").matcher(mail)
				.matches();
	}

	public boolean isValidPassword(String pass) {
		return Pattern.compile("^(?=.*[0-9])(?=.*[a-z-A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$").matcher(pass)
				.matches();
	}

	public boolean isValidDate(String date) {
		boolean ret = true;
		try {
			new SimpleDateFormat("dd/MM/yyyy").parse(date);
		} catch (Exception e) {
			ret = false;
		}
		return ret;
	}

	
	public BufferedImage getImage(File file) {

		BufferedImage img = null;
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}
