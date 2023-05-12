package es.elorrieta.aam.controller;

public class UserChoice {
	private boolean isFemale = true;

	private boolean isDress = false;
	private boolean isTshirt = false;
	private boolean isJeans = false;
	private boolean isShoes = false;

	private boolean isZara = false;
	private boolean isHM = false;

	private boolean isPullAndBear = false;
	private boolean isBershka = false;
	private boolean isNewBalance = false;
	private boolean isLevis = false;
	private boolean isAdidas = false;
	private boolean isNike = false;

	public int getSelectedSubCategory() {
		int ret = 0;
		if (isDress) {
			ret = 5;
		} else if (isTshirt) {
			ret = 1;
		} else if (isJeans) {
			ret = 6;
		} else if (isShoes)
			ret = 7;
		return ret;
	}

	public int getSelectedBrand() {
		int ret = 0;
		if (isZara) {
			ret = 2;
		} else if (isHM) {
			ret = 5;
		} else if (isPullAndBear) {
			ret = 3;
		} else if (isBershka) {
			ret = 4;
		} else if (isNewBalance) {
			ret = 11;
		} else if (isLevis) {
			ret = 12;
		} else if (isAdidas) {
			ret = 1;
		} else if (isNike)
			ret = 10;
		return ret;
	}

	public String getSelectedGender() {
		String ret = "H";

		if (isFemale) {
			ret = "M";
		}
		return ret;
	}

	public boolean isFemale() {
		return isFemale;
	}

	public void setFemale(boolean isFemale) {
		this.isFemale = isFemale;
	}

	public boolean isDress() {
		return isDress;
	}

	public boolean isTshirt() {
		return isTshirt;
	}

	public boolean isJeans() {
		return isJeans;
	}

	public boolean isShoes() {
		return isShoes;
	}

	public void setDress(boolean isDress) {
		this.isDress = isDress;
	}

	public void setTshirt(boolean isTshirt) {
		this.isTshirt = isTshirt;
	}

	public void setJeans(boolean isJeans) {
		this.isJeans = isJeans;
	}

	public void setShoes(boolean isShoes) {
		this.isShoes = isShoes;
	}

	public boolean isZara() {
		return isZara;
	}

	public boolean isHM() {
		return isHM;
	}

	public boolean isPullAndBear() {
		return isPullAndBear;
	}

	public boolean isBershka() {
		return isBershka;
	}

	public boolean isNewBalance() {
		return isNewBalance;
	}

	public boolean isLevis() {
		return isLevis;
	}

	public boolean isAdidas() {
		return isAdidas;
	}

	public boolean isNike() {
		return isNike;
	}

	public void setZara(boolean isZara) {
		this.isZara = isZara;
	}

	public void setHM(boolean isHM) {
		this.isHM = isHM;
	}

	public void setPullAndBear(boolean isPullAndBear) {
		this.isPullAndBear = isPullAndBear;
	}

	public void setBershka(boolean isBershka) {
		this.isBershka = isBershka;
	}

	public void setNewBalance(boolean isNewBalance) {
		this.isNewBalance = isNewBalance;
	}

	public void setLevis(boolean isLevis) {
		this.isLevis = isLevis;
	}

	public void setAdidas(boolean isAdidas) {
		this.isAdidas = isAdidas;
	}

	public void setNike(boolean isNike) {
		this.isNike = isNike;
	}

}
