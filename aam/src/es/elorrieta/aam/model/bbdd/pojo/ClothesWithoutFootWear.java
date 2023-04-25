package es.elorrieta.aam.model.bbdd.pojo;

import java.util.List;
import java.util.Objects;

public abstract class ClothesWithoutFootWear extends ProductItem {

	private ClothesSize size = null;

	public enum ClothesSize {
		S, M, L
	}

	

	@Override
	public abstract List<String> getSizes();

	public ClothesSize getSize() {
		return size;
	}

	public void setSize(ClothesSize size) {
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
		ClothesWithoutFootWear other = (ClothesWithoutFootWear) obj;
		return size == other.size;
	}

	@Override
	public String toString() {
		return "ClothesWithoutFootWear [size=" + size + "]";
	}

}
