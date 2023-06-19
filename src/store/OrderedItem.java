package store;

import java.util.Scanner;

import facade.UIData;
import mgr.Manageable;

public class OrderedItem implements Manageable, UIData {
	Order order;
	Item item;

	OrderedItem(Order order, Item item, Scanner scan) {
		this.item = item;
		this.order = order;
	}
	public int subTotal() {
		return item.price * 1;
	}
	public void print() {
		System.out.format("[%s] %d원 x 1개 = %d원\n", 
				item.itemName, item.price, subTotal());
	}
	@Override
	public void read(Scanner scan) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean matches(String kwd) {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String[] getUiTexts() { 
		// TODO Auto-generated method stub
		String[] texts = new String[5];
		texts[0] = item.code;
		texts[1] = item.itemName;
		texts[2] = ""+item.price;
		texts[3] = ""+item.stock;
		texts[4] = ""+item.location;
		//수정했음
		return texts;
	}
}