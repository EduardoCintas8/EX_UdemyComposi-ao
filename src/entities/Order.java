package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static final DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	private static final DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	private LocalDateTime moment;
	private OrderStatus status;
	
	
	private Client client;
	private List<OrderItem> itens = new ArrayList<>();

	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Order() {

	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void addItem(OrderItem item) {
		itens.add(item);
	}

	public void removeItem(OrderItem item) {
		itens.remove(item);
	}
	public double total() {
		double sum = 0.0;
		for (OrderItem item : itens) {
			sum += item.subTotal();
		}
		return sum;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order Moment: ");
		sb.append(fmt1.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client.getName() + " ");
		sb.append(fmt2.format(client.getBirthDate())+ " - ");
		sb.append(client.getEmail() +"\n");
		sb.append("Ordem items");
		for(OrderItem item : itens) {
			sb.append(item + "\n");
		}
		sb.append("Total price: ");
		sb.append( total());
		
		return sb.toString();
	}
}



