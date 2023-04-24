package es.elorrieta.aam.model.bbdd.pojo.junitSprint1;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import es.elorrieta.aam.model.bbdd.pojo.Brand.Brands;
import es.elorrieta.aam.model.bbdd.pojo.Brand;
import es.elorrieta.aam.model.bbdd.pojo.Product.Category;
import es.elorrieta.aam.model.bbdd.pojo.Shoe;
import es.elorrieta.aam.model.bbdd.pojo.Shoe.ShoesSize;
import es.elorrieta.aam.model.bbdd.pojo.Product;

class ShoeTest {
	private Shoe shoe = null;

	public ShoeTest() {
		shoe = new Shoe();
	}

	@Test
	void constructorTest() {
		assertEquals(shoe.getId(), 0);
		assertEquals(shoe.getPrice(), 0, 0);
		assertEquals(shoe.getImages(), null);
		assertEquals(shoe.getSize(), null);
		assertEquals(shoe.getStock(), 0);
		assertEquals(shoe.getProduct(), null);
	}

	@Test
	void idGetterSetterTest() {
		shoe.setId(111);
		assertEquals(shoe.getId(), 111);

	}

	@Test
	void priceGetterSetterTest() {
		shoe.setPrice(15.49);
		assertEquals(shoe.getPrice(), 0, 15.49);

	}

	@Test
	void imagesGetterSetterTest() {
		File img1 = new File("img1.png");
		File img2 = new File("img2.png");
		List<File> images = new ArrayList<File>();
		images.add(img1);
		images.add(img2);
		shoe.setImages(images);
		assertNotNull(shoe.getImages());
		assertEquals(shoe.getImages().size(), 2);
	}

	@Test
	void sizeGetterSetterTest() {
		shoe.setSize(ShoesSize.D);
		assertEquals(shoe.getSize(), ShoesSize.D);

	}

	@Test
	void stockGetterSetterTest() {
		shoe.setStock(24);
		assertEquals(shoe.getStock(), 24);

	}

	@Test
	void ProdoctGetterSetterTest() {
		Product product = new Product();
		product.setCategory(Category.Shoes);
		product.setId(1222);
		Brand brand = new Brand();
		brand.setValue(Brands.ADIDAS);
		product.setBrand(brand);
		shoe.setProduct(product);
		assertNotNull(shoe.getProduct());
		assertEquals(shoe.getProduct(), product);
		assertEquals(shoe.getProduct().getId(), 1222);
		assertEquals(shoe.getProduct().getBrand().getValue(), Brands.ADIDAS);

	}

	@Test
	void shoeToStringTest() {
		shoe.setId(111);
		shoe.setPrice(15.49);
		File img1 = new File("img1.png");
		File img2 = new File("img2.png");
		List<File> images = new ArrayList<File>();
		images.add(img1);
		images.add(img2);
		shoe.setImages(images);
		shoe.setSize(ShoesSize.D);
		shoe.setStock(24);
		Product product = new Product();
		product.setCategory(Category.Shoes);
		product.setId(1222);
		Brand brand = new Brand();
		brand.setValue(Brands.ADIDAS);
		product.setBrand(brand);
		shoe.setProduct(product);
		String expected = "Shoe [size=D, getId()=111, getPrice()=15.49, getStock()=24, getImages()=[img1.png, img2.png], getProduct()=Product [id=1222, category=Shoes, date=null, productItems=null, brand=Brand [id=0, product=null, value=ADIDAS, employeesManagedStore=null]]]";
		assertEquals(shoe.toString(), expected);
	}

}
