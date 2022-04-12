package com.patterns.structuralpatterns.composite.before;

public class Client {

	public static void main(String[] args) {
		Item doranBlade = new Item("도란검", 450);
		Item healPotion = new Item("체력 물약", 50);
		
		Bag bag = new Bag();
		bag.add(doranBlade);
		bag.add(healPotion);
		
		Client client = new Client();
		client.printprice(doranBlade);
		client.printprice(bag);
	}

	private void printprice(Item item) {
		System.out.println(item.getPrice());
	}
	
	private void printprice(Bag bag) {
		int sum = bag.getItems().stream().mapToInt(Item::getPrice).sum();
		System.out.println(sum);
	}
}
