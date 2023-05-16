package es.elorrieta.aam.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

public class ValidatePayment {
	/**
	 * Checks the validity of a credit card number using regex pattern matching.
	 *
	 * @param crCardNumber the credit card number to be validated
	 * @return true if the credit card number is valid, false otherwise
	 */
	public boolean validitychk(String crCardNumber) {
		String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" + "(?<mastercard>5[1-5][0-9]{14})|"
				+ "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" + "(?<amex>3[47][0-9]{13})|"
				+ "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" + "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";

		return Pattern.compile(regex).matcher(crCardNumber).matches();
	}

	/**
	 * Checks if a given date is valid and not expired.
	 *
	 * @param date the date to be checked, in the format "MM/yyyy"
	 * @return true if the date is valid and not expired, false otherwise
	 */
	public boolean checkParsingDate(String date) {
		boolean ret = true;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yyyy");
		simpleDateFormat.setLenient(false);
		Date expiry = null;
		try {
			expiry = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			ret = false;
		}
		if (ret) {
			if (expiry.before(new Date())) {
				ret = false;
			}
		}
		return ret;
	}

	/**
	 * Checks if a given CVV (Card Verification Value) is valid.
	 *
	 * @param cvv the CVV to be checked
	 * @return true if the CVV is valid, false otherwise
	 */
	public boolean checkCvv(String cvv) {
		return Pattern.compile("^[0-9]{3,4}$").matcher(cvv).matches();
	}

	/**
	 * Checks if a payment is valid based on the credit card number, expiration
	 * date, and CVV.
	 *
	 * @param numCrCard the credit card number to be checked
	 * @param date      the expiration date of the credit card in the format
	 *                  "MM/yyyy"
	 * @param cvv       the CVV (Card Verification Value) of the credit card
	 * @return true if the payment is valid, false otherwise
	 */
	public boolean checkPayment(String numCrCard, String date, String cvv) {
		boolean ret = false;

		if (validitychk(numCrCard) && checkParsingDate(date) && checkCvv(cvv)) {
			ret = true;
		}
		return ret;
	}

	/**
	 * Gets the expiration date as a Date object based on the input date string.
	 *
	 * @param date the date string representing the expiration date in the format
	 *             "MM/yyyy"
	 * @return the expiration date as a Date object
	 * @throws ParseException if the input date string is not in the expected format
	 */
	public Date getExpirationDate(String date) throws ParseException {
		return getDate(convertFormatMMyyyyToDate(date));
	}

	/**
	 * Converts a date string in the format "MM/yyyy" to a Date object.
	 *
	 * @param date the date string to be converted in the format "MM/yyyy"
	 * @return the converted date as a Date object
	 * @throws ParseException if the input date string is not in the expected format
	 */
	private Date convertFormatMMyyyyToDate(String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("MM/yyyy");
		return format.parse(date);
	}

	/**
	 * Gets the date with the day adjusted to the last day of the month based on the
	 * input date.
	 *
	 * @param date the input date
	 * @return the adjusted date with the day set to the last day of the month
	 * @throws ParseException if the input date is not in the expected format
	 */
	private Date getDate(Date date) throws ParseException {
		int month = convertToLocalDateViaInstant(date).getMonthValue();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int day = getLastDayOfAmonth(date);
		int year = c.get(Calendar.YEAR);

		Date convertedDate = convertToDateViaInstant(LocalDate.of(year, month, day));
		return convertedDate;

	}

	/**
	 * Converts a LocalDate object to a Date object .
	 *
	 * @param dateToConvert the LocalDate object to convert
	 * @return the converted Date object
	 */
	public Date convertToDateViaInstant(LocalDate dateToConvert) {
		return java.util.Date.from(dateToConvert.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * Gets the last day of the month for a given date.
	 *
	 * @param date the date to retrieve the last day of the month from
	 * @return the last day of the month as an integer
	 * @throws ParseException if there is an error parsing the date
	 */
	private int getLastDayOfAmonth(Date date) throws ParseException {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getActualMaximum(Calendar.DATE);
	}

	/**
	 * Converts a Date object to a LocalDate object.
	 *
	 * @param dateToConvert the Date object to convert
	 * @return the converted LocalDate object
	 */
	public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	/**
	 * Calculates the total price to pay by adding a shipping fee to the given price.
	 *
	 * @param price The base price to which the shipping fee will be added.
	 * @return The total price to pay including the shipping fee.
	 */
	public double calculateTotalPricrToPay(double price) {
		return price + 2.99;

	}
}
