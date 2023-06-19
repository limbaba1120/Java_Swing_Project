package store;

import mgr.Manageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import facade.UIData;

public class Item implements Manageable, UIData {
    public int neededTime;
    String size;
    String[] eachSize;

    public String itemName;
    public String code;
    public int price;
    public int stock;
	public char location;
    
    
    
    public void read(Scanner scan) {
    	code = scan.next();
        itemName = scan.next();
        price = scan.nextInt();
        stock = scan.nextInt();
        location = scan.next().charAt(0);
    }
    
    public boolean matches(String kwd) {
        if (itemName.contains(kwd))
            return true;
        if (kwd.length() > 2 && code.contains(kwd))
            return true;
        return false;
    }

    public boolean matches(String[] kwdArr) {
        for (String kwd : kwdArr) {
            if (!matches(kwd))
                return false;
        }
        return true;
    }

    public void print() { // Item
    	System.out.format("[%s] %s (%d원) ", 
				code, itemName, price);
        System.out.println();
         
    }
    
	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
	}
	@Override
	public String[] getUiTexts() {
		// TODO Auto-generated method stub
		String[] texts = new String[5];
		texts[0] = code;
		texts[1] = itemName;
		texts[2] = ""+price;
		texts[3] = ""+stock;
		texts[4] = ""+location;
		//수정했음
		return texts;
	}
}