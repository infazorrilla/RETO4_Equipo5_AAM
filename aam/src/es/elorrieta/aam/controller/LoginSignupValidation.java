package es.elorrieta.aam.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
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

	public boolean isValidDate(String dateToParse) {
		boolean ret = true;
		try {
			Date date = returnsDate(dateToParse);
			if (!isValidYear(date)) {
				ret = false;
			} else if (!isValidDayMonth(dateToParse)) {
				ret = false;
			}
		} catch (ParseException e) {
			ret = false;
		}
		return ret;

	}

	private boolean isValidYear(Date date) {
		boolean ret = true;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int year = calendar.get(Calendar.YEAR);
		int actual = Calendar.getInstance().get(Calendar.YEAR);

		if ((year < 1970) || (year > actual)) {
			ret = false;
		}
		return ret;
	}

	private boolean isValidDayMonth(String date) {
		boolean ret = true;
		String[] getMonthDayYear = date.split("/");
		int year = Integer.parseInt(getMonthDayYear[2]);
		int month = Integer.parseInt(getMonthDayYear[1]);
		int day = Integer.parseInt(getMonthDayYear[0]);
		try {
			LocalDate.of(year, month, day);
		} catch (Exception e) {
			ret = false;
		}
		return ret;
	}

	private Date returnsDate(String date) throws ParseException {

		return new SimpleDateFormat("dd/MM/yyyy").parse(date);
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
