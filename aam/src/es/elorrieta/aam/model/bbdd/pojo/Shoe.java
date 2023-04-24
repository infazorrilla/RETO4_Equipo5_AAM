package es.elorrieta.aam.model.bbdd.pojo;

import java.util.List;
import java.util.Objects;

public class Shoe extends ProductItem {
	private ShoesSize size = null;

	public enum ShoesSize {
		A("34"), B("35"), C("36"), D("37"), E("38"), F("39"), G("40"), H("41"), I("42"), J("43"), K("44");

		private String sizeStr;

		ShoesSize(String sizeStr) {
			this.sizeStr = sizeStr;
		}

		public String getSize() {
			return sizeStr;
		}

	}

	@Override
	public void insert(ProductItem t) {

	}

	@Override
	public ProductItem select(ProductItem t) {

		return null;
	}

	@Override
	public void update(ProductItem t) {

	}

	@Override
	public void delete(ProductItem t) {

	}

	@Override
	public List<String> getSizes() {

		return null;
	}

	public ShoesSize getSize() {
		return size;
	}

	public void setSize(ShoesSize size) {
		this.size = size;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(size);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shoe other = (Shoe) obj;
		return size == other.size;
	}

	@Override
	public String toString() {
		return "Shoe [size=" + size + ", getId()=" + getId() + ", getPrice()=" + getPrice() + ", getStock()="
				+ getStock() + ", getImages()=" + getImages() + ", getProduct()=" + getProduct() + "]";
	}

}
