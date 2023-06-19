package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import store.Item;

public class DetailDialog extends javax.swing.JDialog {
	String[] itemDetails;
	String[] ingredient;
	String[] reviews;
	JLabel details[] = new JLabel[20];
	String[] revStr=new String[5];
	Item item;
	DetailDialog(String[] texts,  Item item) {
		super(GUIMain.mainFrame);
		itemDetails = texts;
		
		this.item=item;
	}

	void setup() {
		setTitle("상품상세보기");

		JPanel lpane = new JPanel(new GridLayout(3, 2));
		ImageIcon icon = new ImageIcon("그림4.png");
		JPanel pane = new JPanel(new BorderLayout()) {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null); 

				Dimension d = getSize();
				g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null); 
			}
		};
		JPanel rpane = new JPanel();

		Font font = new Font("맑은 고딕", Font.BOLD, 20); 
		Font font1 = new Font("맑은 고딕", Font.BOLD, 15);
		
		details[0] = new JLabel("상품코드: " + itemDetails[0]);
		details[1] = new JLabel("상품명: " + itemDetails[1]);
		details[2] = new JLabel("가격: " + itemDetails[2]);
		details[3] = new JLabel("개수: " + itemDetails[3]);
		details[4] = new JLabel("냉장고:" + itemDetails[4]);	
		int index=0;

		
		JLabel photo = new JLabel(new ImageIcon("MENU/" + itemDetails[1] + ".jpg"));

		rpane.setOpaque(false);
		lpane.setOpaque(false);
		photo.setPreferredSize(new Dimension(350, 350)); 
		details[0].setHorizontalAlignment(JLabel.CENTER);
		details[1].setHorizontalAlignment(JLabel.CENTER);
		details[2].setHorizontalAlignment(JLabel.CENTER);
		details[3].setHorizontalAlignment(JLabel.CENTER);
		details[4].setHorizontalAlignment(JLabel.CENTER);
		
		details[0].setFont(font);
		details[1].setFont(font);
		details[2].setFont(font);
		details[3].setFont(font);
		details[4].setFont(font);
		
		details[0].setForeground(Color.white);
		details[1].setForeground(Color.white);
		details[2].setForeground(Color.white);
		details[3].setForeground(Color.white);
		details[4].setForeground(Color.white);
		
		
		JLabel photo1 = new JLabel();
		switch (itemDetails[4]) {
		case "A":
			photo1 = new JLabel(new ImageIcon("A.png"));
			break;
		case "B":
			photo1 = new JLabel(new ImageIcon("B.png"));
			break;
		case "C":
			photo1 = new JLabel(new ImageIcon("C.png"));
			break;
		case "D":
			photo1 = new JLabel(new ImageIcon("D.png"));
			break;
		}
	
		
		lpane.add(details[0]);
		lpane.add(details[1]);
		lpane.add(details[2]);
		lpane.add(details[3]);
		lpane.add(details[4]);
		
	
		
		
		
		
		photo1.setPreferredSize(new Dimension(450,250));
		photo1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		photo1.setBackground(new Color(0,2,13));
		photo1.setForeground(Color.white);
//		photo1.enable(false);
		
		JPanel scroll=new JPanel(new BorderLayout()) {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, null); // 이미지 원래사이즈로 넣기

                Dimension d = getSize();
                g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null); // 컴포넌트 사이즈에 맞게
            }
        };
        scroll.add(photo1);
		scroll.setBorder(BorderFactory.createEmptyBorder(5,0,0,5));
		
		
		pane.add(lpane,BorderLayout.CENTER);
		pane.add(scroll,BorderLayout.EAST);
//		pane.add(photo1,BorderLayout.AFTER_LINE_ENDS);
		pane.add(photo, BorderLayout.WEST);

		this.setMinimumSize(new Dimension(1250, 450)); // 대화상자 크기 설정
		this.setLocation(365, 540);
		this.setResizable(false);// 크기 조절 불가
		setContentPane(pane);
	}
	
	
}