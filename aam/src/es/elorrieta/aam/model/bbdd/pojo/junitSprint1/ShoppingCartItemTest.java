package es.elorrieta.aam.model.bbdd.pojo.junitSprint1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import es.elorrieta.aam.model.bbdd.pojo.Order;
import org.junit.jupiter.api.Test;

import es.elorrieta.aam.model.bbdd.pojo.ClothesWithoutFootWear.ClothesSize;
import es.elorrieta.aam.model.bbdd.pojo.Product.Category;
import es.elorrieta.aam.model.bbdd.pojo.ShoppingCartItem;
import es.elorrieta.aam.model.bbdd.pojo.ShoppingCart;
import es.elorrieta.aam.model.bbdd.pojo.Dress;
import es.elorrieta.aam.model.bbdd.pojo.Product;

class ShoppingCartItemTest {
	private ShoppingCartItem ShoppingCartItem = null;

	public ShoppingCartItemTest() {
		ShoppingCartItem = new ShoppingCartItem();
	}

	@Test
	void constructorTest() {
		assertEquals(ShoppingCartItem.getId(), 0);
		assertEquals(ShoppingCartItem.getPrice(), 0, 0);
		assertEquals(ShoppingCartItem.getQuantity(), 0);
		assertEquals(ShoppingCartItem.getShoppingCart(), null);
		assertEquals(ShoppingCartItem.getProductItem(), null);

	}

	@Test
	void idGetterSetterTest() {
		ShoppingCartItem.setId(11);
		assertEquals(ShoppingCartItem.getId(), 11);

	}

	@Test
	void priceGetterSetterTest() {
		ShoppingCartItem.setPrice(12.99);
		assertEquals(ShoppingCartItem.getPrice(), 0, 12.99);
	}

	@Test
	void quantityGetterSetterTest() {
		ShoppingCartItem.setQuantity(12);
		assertEquals(ShoppingCartItem.getQuantity(), 12);

	}

	@Test
	void shoppingCartGettersSettersTest() {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setId(11);
		shoppingCart.setTotalPrice(12.4);
		shoppingCart.setDescount(0.5);
		try {
			shoppingCart.setDateOfPurchase(new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2023"));
		} catch (ParseException e) {
			System.out.println("parse error");
		}

		Order order = new Order();
		order.setId(14440);
		shoppingCart.setOrder(order);
		ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
		shoppingCartItem.setId(1222);
		shoppingCartItem.setPrice(12);
		shoppingCartItem.setQuantity(2);
		List<ShoppingCartItem> shoppingCartItems = new ArrayList<ShoppingCartItem>();
		shoppingCartItems.add(shoppingCartItem);
		shoppingCart.setShoppingCartItems(shoppingCartItems);
		ShoppingCartItem.setShoppingCart(shoppingCart);

		assertNotNull(ShoppingCartItem.getShoppingCart());
		assertEquals(ShoppingCartItem.getShoppingCart(), shoppingCart);
		assertEquals(ShoppingCartItem.getShoppingCart().getOrder().getId(), 14440);

	}

	@Test
	void productItemToStringTest() {
		Dress dress = new Dress();
		dress.setId(1222);
		dress.setPrice(12.99);
		Product product = new Product();
		product.setCategory(Category.Dress);
		dress.setProduct(product);
		dress.setSize(ClothesSize.M);
		dress.setStock(12);
		ShoppingCartItem.setProductItem(dress);
		assertNotNull(ShoppingCartItem.getProductItem());
		assertEquals(ShoppingCartItem.getProductItem(), dress);
		assertEquals(ShoppingCartItem.getProductItem().getStock(), 12);
	}

	@Test
	void shoppingCartItemToStringTest() {
		ShoppingCartItem.setId(11);
		ShoppingCartItem.setPrice(12.99);
		ShoppingCartItem.setQuantity(12);
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setId(11);
		shoppingCart.setTotalPrice(12.4);
		shoppingCart.setDescount(0.5);
		try {
			shoppingCart.setDateOfPurchase(new SimpleDateFormat("dd/MM/yyyy").parse("29/04/2023"));
		} catch (ParseException e) {
			System.out.println("parse error");
		}

		Order order = new Order();
		order.setId(14440);
		shoppingCart.setOrder(order);
		ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
		shoppingCartItem.setId(1222);
		shoppingCartItem.setPrice(12);
		shoppingCartItem.setQuantity(2);
		List<ShoppingCartItem> shoppingCartItems = new ArrayList<ShoppingCartItem>();
		shoppingCartItems.add(shoppingCartItem);
		shoppingCart.setShoppingCartItems(shoppingCartItems);
		ShoppingCartItem.setShoppingCart(shoppingCart);
		Dress dress = new Dress();
		dress.setId(1222);
		dress.setPrice(12.99);
		Product product = new Product();
		product.setCategory(Category.Dress);
		dress.setProduct(product);
		dress.setSize(ClothesSize.M);
		dress.setStock(12);
		ShoppingCartItem.setProductItem(dress);
		String expected = "ShoppingCartItem [id=11, price=12.99, quantity=12, shoppingCart=ShoppingCart [id=11, totalPrice=12.4, descount=0.5, dateOfPurchase=Sat Apr 29 00:00:00 CEST 2023, order=Order [id=14440, deliveryDate=null, orderDate=null, totalPrice=0.0, status=null, payment=null, shoppingCart=null, customer=null, address=null, EmployeeManagedOrders=null], shoppingCartItems=[ShoppingCartItem [id=1222, price=12.0, quantity=2, shoppingCart=null, productItem=null]]], productItem=ClothesWithoutFootWear [size=M]]";
		assertEquals(ShoppingCartItem.toString(), expected);
	}
}
