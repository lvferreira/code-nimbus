package demopack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Product {
	String name;
	int price;
	int stock;

	public Product(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "{" + "\"name\": \"" + name + "\"" + ", \"price\": " + price + ", \"stock\": " + stock + "}";
	}
}

public class InventoryManagement {

	public static List<Product> sortProducts(List<Product> products, String sortKey, boolean ascending) {
		Collections.sort(products, new Comparator<Product>() {
			@Override
			public int compare(Product p1, Product p2) {
				switch (sortKey) {
				case "name":
					return p1.name.compareTo(p2.name);
				case "price":
					return Integer.compare(p1.price, p2.price);
				case "stock":
					return Integer.compare(p1.stock, p2.stock);
				default:
					throw new IllegalArgumentException("Invalid sort key");
				}
			}
		});

		if (!ascending) {
			Collections.reverse(products);
		}

		return products;
	}

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product("Product A", 100, 5));
		products.add(new Product("Product B", 200, 3));
		products.add(new Product("Product C", 50, 10));

		String sortKey = "price";
		boolean ascending = false;

		List<Product> sortedProducts = sortProducts(products, sortKey, ascending);
		for (Product product : sortedProducts) {
			System.out.println(product);
		}
	}
}
