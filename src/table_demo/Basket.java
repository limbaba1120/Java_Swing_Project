package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Basket extends JPanel {
	TableSelectionDemo tableDemo = new TableSelectionDemo();

	void setupbasket(JTable basketTable,DefaultTableModel basketModel, JPanel right) {
		Font font = new Font("맑은 고딕", Font.BOLD, 20);

		JButton order = new JButton("주문하기");
		JButton delete = new JButton("삭제");
		JButton coupon = new JButton("냉장고위치");
		JButton detail = new JButton("주문상세");

		order.setBorderPainted(false); 
		order.setFocusPainted(false);
		delete.setBorderPainted(false); 
		delete.setFocusPainted(false); 
		coupon.setBorderPainted(false); 
		coupon.setFocusPainted(false); 
		detail.setBorderPainted(false); 
		detail.setFocusPainted(false); 
		
		order.setBackground(Color.GRAY); 
		delete.setBackground(Color.GRAY); 
		coupon.setBackground(Color.GRAY);
		detail.setBackground(Color.GRAY); 
		order.setForeground(Color.white); 
		delete.setForeground(Color.white); 
		coupon.setForeground(Color.white);
		detail.setForeground(Color.white);
		
		order.setFont(font);
		delete.setFont(font);
		coupon.setFont(font);
		detail.setFont(font);

		right.add(order);
		right.add(delete);
		right.add(coupon);
		right.add(detail);

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("삭제")) {
					tableDemo.deleteBasket(basketTable, basketModel);
				}
			}
		});
		order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("주문하기")) {
					tableDemo.addBasket();
				}
			}
		});
		coupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("냉장고위치")) {
					tableDemo.basketLocation();
				}
			}
		});
		detail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("주문상세")) {
					tableDemo.basketDetail();
				}
			}
		});
	}

}