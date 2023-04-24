package es.elorrieta.aam.model.bbdd.pojo;

import java.util.Objects;

public class Address {
	
	//PK
	private int id= 0;
	
	//Attributes
	
	private String street = null;
	private String codPostal = null;
	private String city = null;
	private String province = null;
	private Country country = null;
	
	
	
	public enum Country{
		GERMANY , FRANCE , ITALY , SPAIN
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, codPostal, country, id, province, street);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(codPostal, other.codPostal)
				&& country == other.country && id == other.id && Objects.equals(province, other.province)
				&& Objects.equals(street, other.street);
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", codPostal=" + codPostal + ", city=" + city
				+ ", province=" + province + ", country=" + country + "]";
	}
	
	
}
