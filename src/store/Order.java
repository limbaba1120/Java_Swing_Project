package store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import facade.UIData;

import java.util.Calendar;
import mgr.Manageable;

public class Order implements Manageable, UIData {
	 static public int orderId=1;
	 public int orderNum=orderId;
	 int n;
	 public User user=new User();   
	 boolean payed;
	 String date;
	 String code;
	 int wait=0;
	 public String time;
	 public String size;
	 public Item item=new Item();
	 public List<OrderedItem> orderedItemList=new ArrayList<>();
	 static public ArrayList<Order> orderList=new ArrayList<>(); 
	 public void read(Scanner scan) {
		
	}
	 public void read(String[] rowTexts, Item item) {
		 Scanner scan=new Scanner(System.in);
		 code=rowTexts[0];
		 this.item=(Item)Store.itemMgr.find(item.code);
		 orderedItemList.add(new OrderedItem(this, this.item, scan));
	 }
	
	public boolean matches(String kwd) {
		if (kwd.length() == 0)
			return true;
		if (("" + orderId).equals(kwd))
		    return true;
		for (OrderedItem od: orderedItemList)
			if (od.item.matches(kwd))
				return true;
		if (user.id.contentEquals(kwd))
			return true;
		return false;
    }
	public boolean matches(String[] kwdArr) {
		for (String kwd: kwdArr) {
			if (!matches(kwd))
				return false;
		}
		return true;
	}
	public void print() {
		print(false);
	}
	void print(boolean bDetail) { 		
		Calendar now=Calendar.getInstance();
		int hour=now.get(Calendar.HOUR_OF_DAY);
		int min=now.get(Calendar.MINUTE);
		int sec=now.get(Calendar.SECOND);
		
		System.out.format("[주문아이디:%2d] ", orderId);
		if (!payed)
			System.out.printf(" (결재대기)");
		System.out.println();
		for (OrderedItem od: orderedItemList) {
			System.out.print("\t");	
			od.print();
			wait+=od.item.neededTime;
		}
		if(wait+min>=60) {
			min=wait+min-60;
			hour++;
		}
		else
			min=wait+min;
		System.out.printf("\t주문완료 예상 시간: %d시 %d분 %d초\n", hour, min, sec);
	}
	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
	}
	@Override
	public String[] getUiTexts() {
		// TODO Auto-generated method stub
		String[] texts = new String[5];
		texts[0] = ""+orderId;
		texts[1] = item.itemName;
		texts[2] = ""+item.price;
		texts[3] = ""+item.location;
		texts[4] = "";
		return texts;
	}
}