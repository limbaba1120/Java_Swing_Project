package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TopPanel extends JPanel {
	
	void setupTopPane(TableSelectionDemo tableDemo) {
		JPanel topPane = new JPanel();
		add(topPane);
		topPane.setBackground(Color.GRAY);
		JButton detail = new JButton("상세보기");
		detail.setBorderPainted(false); 
		detail.setFocusPainted(false); 
		detail.setBackground(Color.white);
		topPane.add(detail);
		JButton order = new JButton("주문하기");
		order.setBorderPainted(false); 
		order.setFocusPainted(false); 
		order.setBackground(Color.black);
		order.setForeground(Color.white);
		topPane.add(order);
		
		detail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("상세보기")) {
					tableDemo.showDetail();
				}
			}
		});
		order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("주문하기")) {
					tableDemo.callOption();
				}
			}
		});

	}
}
