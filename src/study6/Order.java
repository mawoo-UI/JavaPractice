package study6;

import java.time.LocalDate;
import java.util.List;

class Order {
	private String id;
	private String customerName;
	private List<Product> products;
	private LocalDate orderDate;
	
	public Order(String id, String customerName, List<Product> products, LocalDate orderDate ) {
		this.id = id;
		this.customerName = customerName;
		this.products = products;
		this.orderDate = orderDate;
	}
	
	public String getId() { return id;}
	public String getCustomerName() { return customerName;}
	public List<Product> getProducts() { return products;}
	public LocalDate getOrderDate() { return orderDate;}

	public double getTotalPrice() {
		return products.stream().mapToDouble(Product::getPrice).sum();
	}
	
	@Override
	public String toString() {
		return "Order[id =" + id + ", customer=" + customerName + ", orderDate=" + orderDate + "]";
	}
}
