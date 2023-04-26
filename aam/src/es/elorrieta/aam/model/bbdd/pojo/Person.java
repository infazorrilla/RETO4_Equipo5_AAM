package es.elorrieta.aam.model.bbdd.pojo;

import java.io.File;
import java.util.Objects;



public abstract class Person  {
	private int id = 0;
	private String name = null;
	private String lastName = null;
	private String numberPhone = null;
	private String email = null;
	private Address address = null;
	private String password = null;
	private Profile profile = null;
	private boolean status = true;
	private File image = null;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, email, id, image, lastName, name, numberPhone, password, profile, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(image, other.image) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(name, other.name) && Objects.equals(numberPhone, other.numberPhone)
				&& Objects.equals(password, other.password) && Objects.equals(profile, other.profile)
				&& status == other.status;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", lastName=" + lastName + ", numberPhone=" + numberPhone
				+ ", email=" + email + ", address=" + address + ", password=" + password + ", profile=" + profile
				+ ", status=" + status + ", image=" + image + "]";
	}

}
