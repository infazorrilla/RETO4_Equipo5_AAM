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
	/**
	 * Checks if the given email address is valid based on a regular expression
	 * pattern.
	 *
	 * @param mail the email address to be validated
	 * @return true if the email address is valid, false otherwise
	 */
	public boolean isValidEmail(String mail) {
		return Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$").matcher(mail)
				.matches();
	}

	/**
	 * Checks if the given password is valid based on a regular expression pattern.
	 *
	 * @param pass the password to be validated
	 * @return true if the password is valid, false otherwise
	 */
	public boolean isValidPassword(String pass) {
		return Pattern.compile("^(?=.*[0-9])(?=.*[a-z-A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$").matcher(pass)
				.matches();
	}

	/**
	 * Checks if the given date string is a valid date.
	 *
	 * @param dateToParse the date string to be validated
	 * @return true if the date string is a valid date, false otherwise
	 */
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

	/**
	 * Checks if the year of the given date is within a valid range.
	 *
	 * @param date the date to check the year for
	 * @return true if the year is within a valid range, false otherwise
	 */
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

	/**
	 * Checks if the day and month of the given date string are valid.
	 *
	 * @param date the date string to check the day and month for
	 * @return true if the day and month are valid, false otherwise
	 */
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

	/**
	 * Parses the given date string and returns a corresponding Date object.
	 *
	 * @param date the date string to be parsed
	 * @return the Date object representing the parsed date
	 * @throws ParseException if the parsing of the date string fails
	 */
	private Date returnsDate(String date) throws ParseException {
		return new SimpleDateFormat("dd/MM/yyyy").parse(date);
	}

	/**
	 * Reads an image file and returns it as a BufferedImage object.
	 *
	 * @param file the image file to be read
	 * @return the BufferedImage object representing the image file
	 */
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
