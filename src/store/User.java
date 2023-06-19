package store;

import mgr.Manageable;

import java.util.ArrayList;
import java.util.Scanner;


public class User implements Manageable{

    String id;
    static public int userId = 1;
    int coupon;
    int price;
    String pwd;
    int point;
    static public ArrayList<Order> shoppingList = new ArrayList<>();
    static public ArrayList<Order> nowShoppingList = new ArrayList<>();
    @Override
    public void read(Scanner scan) {
    }
    @Override
    public void print() { //��ٱ��� ���
        System.out.printf("[%s] ", id);
        for(Order ord:shoppingList) {
            System.out.print("\t");
            ord.print(false);
        }
    }
    @Override
    public boolean matches(String kwd) {
        if (kwd.length() == 0)
            return true;
        if(kwd.contentEquals(""+id))
            return true;
        for (Order od: shoppingList)
           if (od.matches(kwd)) // �ֹ�id���� ��ġ
              return true;
        return false;
    }
}