package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		System.out.println("Enter client data:");
		System.out.print("Name:");
		String name = sc.nextLine();
		System.out.print("Email:");
		String email = sc.nextLine();
		System.out.print("Birth date (DD-MMYYYY):");
		String stringDate = sc.next();
		LocalDate birthDate = LocalDate.parse(stringDate, fmt);
		
		

		Client client = new Client(name, email, birthDate);

		System.out.println();
		System.out.println("Enter order data:");
		System.out.println("Status: (PENDING_PAYMENT/PROCESSING/SHIPPED/DELIVERED) ");
		String Ostatus = sc.next().toUpperCase();
		OrderStatus status = OrderStatus.valueOf(Ostatus);
		LocalDateTime moment = LocalDateTime.now();
		Order ordem = new Order(moment, status, client);

		System.out.println("How many items to this order?");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Enter #" + (i+1) + " item data:");
			sc.nextLine();
			System.out.print("Product name:");
			String productName = sc.nextLine();
			System.out.print("Product price:");
			Double productPrice = sc.nextDouble();
			
			Product product = new Product(productName, productPrice);
			
			System.out.print("Quantity: ");
			Integer quantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, product);
			
			ordem.addItem(orderItem);
				
		}

		System.out.println("ORDER SUMMARY:");
		System.out.println(ordem.toString());
		sc.close();
	}

}
