import java.util.Scanner;
import java.util.Arrays;
class Item {
	private String pname;
	private int quantity;
	private double price;
	public Item(String pname,int quantity, Double price) {
		this.pname = pname;
		this.quantity = quantity;
		this.price = price;
	}
	public Item(String pname, int quantity) {
		this.pname = pname;
		this.quantity = quantity;
		this.price = 0;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getpname() {
		return this.pname;
	}
	public int getquantity() {
		return this.quantity;
	}
	public double getprice() {
		return this.price;
	}
}
class ShoppingCart {
	public Item[] catalog;
	public Item[] cart;
	public int cartcount;
	public int catalogcount;
	public ShoppingCart() {
		catalog = new Item[10];
		catalogcount = 0;
		cart = new Item[10];
		cartcount = 0;
	}
	public void addToCatalog(Item item) {
		catalog[catalogcount++] = item;
	}
	public void addToCart(Item item) {
		cart[cartcount++] = item;
	}
	public void removeFromCart(Item item) {
		int position = 0,flag = 1;
		for (int i = 0; i < cartcount; i++) {
			if (cart[i].getpname().equals(item.getpname())) {
				cart[i].setQuantity(cart[i].getquantity() + item.getquantity());
				if (cart[i].getquantity() == 0) {
					position = i;
					flag = 1;
					break;
				}
			}
		}
		if (flag == 1) {
			for (int i = position; i < cartcount; i++) {
				cart[i] = cart[i+1];
			}
			cart[cartcount - 1] = null;
			cartcount--;
		}
	}
	public void showCart() {
		for(int i = 0; i < cartcount; i++) {
			System.out.println(cart[0].getpname() + " "
				+ cart[i].getquantity());
		}
	}
	public void showCatalog() {
		for(int i = 0; i < cartcount; i++) {
			System.out.println(catalog[i].getpname() + " " + catalog[i].getquantity()
				+ " " + catalog[i].getprice());
		}
	}
	public double getTotalAmount() {
		double total = 0;
		for(int i = 0; i < cartcount; i++) {
			for (int j = 0; j < catalogcount; j++) {
				if(catalog[j].getpname().equals
					(cart[i].getpname())) {
					total += catalog[j].getprice() * cart[i].getquantity();
				}
			}
		}
		return total;
	}
	public double getPayableAmount() {
		double amount = getTotalAmount();
		//Disc
		amount += (amount/100) * 15;
		return amount;
	}
	public void applyCoupon() {

	}
	public void printInvoice() {
		System.out.println("Name   quantity   Price");
		for (int i = 0; i < cartcount; i++) {
			for (int j = 0; j < catalogcount; j++) {
				if (cart[i].getpname().equals(catalog[j].getpname())) {
					System.out.println(cart[i].getpname() + " " + cart[i].getquantity() + " " + cart[i].getprice());
				}
			}
		}
		System.out.println("Total:" + getTotalAmount());
		System.out.println("Disc%:" + "0.0");
		System.out.println("Tax:" + getTotalAmount() * 0.15);
		System.out.println("Payable amount:" + getPayableAmount());
	}
}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ShoppingCart scart = new ShoppingCart();
		while(sc.hasNext()) {
			String input = sc.nextLine();
			String[] tokens = input.split(" ");
			switch(tokens[0]) {
				case "Item":
				String[] data = tokens[1].split(",");
				scart.addToCatalog(new Item(data[0], Integer.parseInt(data[1]),Double.parseDouble(data[2])));
				break;
				case "catalog":
				scart.showCatalog();
				break;
				case "add":
				data = tokens[1].split(",");
				scart.addToCart(new Item(data[0], Integer.parseInt(data[1])));
				break;
				case "show":
				scart.showCart();
				break;
				case "totalAmount":
				System.out.println(scart.getTotalAmount());
				break;
				case "remove":
				data = tokens[1].split(",");
				scart.removeFromCart(new Item(data[0], Integer.parseInt(data[1])));
				break;
				case "payableAmount":
				System.out.println(scart.getPayableAmount());
				break;
				case "print":
				scart.printInvoice();
				break;

			}
		}
		//int testCases = Integer.parseInt(scan.nextLine());
		
	}
}