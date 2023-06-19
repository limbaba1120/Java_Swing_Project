package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DetailBasket {
	String[] content;
	JFrame frame = new JFrame("ICECREAM BASKET");
	JLabel[] contentLabel = new JLabel[5];
	JPanel pane = new JPanel(new GridLayout(0,1));
	JButton button = new JButton("확인");

	DetailBasket(String[] content) {
		this.content = content;
	}

	void detail() {
		pane.setBackground(Color.darkGray);

		contentLabel[0] = new JLabel("상품명: " + content[1]);
		contentLabel[1] = new JLabel("가격: " + content[2]);
		contentLabel[2] = new JLabel("남은개수: " + content[3]);
		contentLabel[3] = new JLabel("냉장고: " + content[4]);
		
		contentLabel[0].setHorizontalAlignment(JLabel.CENTER);
		contentLabel[1].setHorizontalAlignment(JLabel.CENTER);
		contentLabel[2].setHorizontalAlignment(JLabel.CENTER);
		contentLabel[3].setHorizontalAlignment(JLabel.CENTER);

		for (int i = 0; i < 4; i++) {
			contentLabel[i].setForeground(Color.white);
			pane.add(contentLabel[i]);
		}
		
		button.setBorderPainted(false);
		button.setFocusPainted(false);
		button.setBackground(Color.gray);
		button.setForeground(Color.white);
		
		pane.add(button);
		frame.setBounds(850, 450, 300, 100);
		frame.add(pane);
		frame.setUndecorated(true);
		frame.setSize(300, 140);
		frame.setVisible(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("확인")) {
					frame.dispose();
				}
			}
		});
	}
}
