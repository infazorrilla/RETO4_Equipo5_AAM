package es.elorrieta.aam.controller;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import es.elorrieta.aam.model.bbdd.pojo.Customer;

public class ReadWriteFromFile {
	public void writeToFile(List<Customer> customers) {
		/**
		 * Writes a list of customers to a file.
		 *
		 * @param customers the list of customers to be written to the file
		 */
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			File file = new File("LOG.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			fileOutputStream = new FileOutputStream(file);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(customers);
			objectOutputStream.reset();
		} catch (EOFException e) {
			System.out.println("");
		} catch (IOException ex) {
			System.out.println("IOException Error" + ex);
		} finally {
			if (objectOutputStream != null) {
				try {
					objectOutputStream.flush();
				} catch (IOException e) {
				}
			}
			if (objectOutputStream != null) {
				try {
					objectOutputStream.close();
				} catch (IOException e) {
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
				}

			}
		}

	}

	/**
	 * Reads a list of customers from a file and returns it.
	 *
	 * @return the list of customers read from the file, or {@code null} if an error
	 *         occurs
	 */
	public List<Customer> readFromFile() {
		List<Customer> ret = null;
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			File file = new File("LOG.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			fileInputStream = new FileInputStream(file);

			objectInputStream = new ObjectInputStream(fileInputStream);

			while (fileInputStream.available() != -1) {

				List<Customer> customers = ((List<Customer>) objectInputStream.readObject());
				ret = new ArrayList<Customer>(customers);
			}
		} catch (EOFException e) {
			System.out.println("");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException Error" + e);
		} catch (IOException e) {
			System.out.println("IOException Error" + e);
		} finally {
			if (objectInputStream != null) {
				try {
					objectInputStream.close();
				} catch (IOException e) {
				}
			}
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
				}
			}
		}
		return ret;

	}

}
