package entities;

public class OrderItem {

	private Integer quantity;
	private Double price;

	private Product product; 

	public OrderItem() {
	}

	public OrderItem(Integer quantity, Double price, Product product) {
		this.price = price;
		this.quantity = quantity;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public double subTotal() {
		return quantity * price;
	}

	@Override
	public String toString() {
		return product.getName() + ", R$: " + String.format("%.2f", product.getPrice()) + ", quantity " + quantity + ", Subtotal: "
			+ subTotal();
	}

}


