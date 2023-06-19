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
		Font font = new Font("���� ���", Font.BOLD, 20);

		JButton order = new JButton("�ֹ��ϱ�");
		JButton delete = new JButton("����");
		JButton coupon = new JButton("�������ġ");
		JButton detail = new JButton("�ֹ���");

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
				if (e.getActionCommand().equals("����")) {
					tableDemo.deleteBasket(basketTable, basketModel);
				}
			}
		});
		order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("�ֹ��ϱ�")) {
					tableDemo.addBasket();
				}
			}
		});
		coupon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("�������ġ")) {
					tableDemo.basketLocation();
				}
			}
		});
		detail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("�ֹ���")) {
					tableDemo.basketDetail();
				}
			}
		});
	}

}