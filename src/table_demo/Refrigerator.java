package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import store.Order;

public class Refrigerator {
   
    public static final Color mainBlue = new Color(123, 154, 204);
    public static final Color mainPink = new Color(252, 246, 245);
    public static final Color gray = new Color(240, 240, 240);
   
   String[] content;
   JFrame frame = new JFrame("ICECREAM BASKET");
   JLabel[] contentLabel = new JLabel[5];
   JPanel pane = new JPanel(new FlowLayout());
   JButton button = new JButton("확인");

   Refrigerator(String[] content) {
      this.content = content;
   }

   void detail() {
      pane.setBackground(mainPink);
      contentLabel[3] = new JLabel("냉장고: " + content[4]);
   
      contentLabel[3].setHorizontalAlignment(JLabel.CENTER);

      switch (content[4]) {
      case "A":
         contentLabel[3] = new JLabel(new ImageIcon("A.png"));
         break;
      case "B":
         contentLabel[3] = new JLabel(new ImageIcon("B.png"));
         break;
      case "C":
         contentLabel[3] = new JLabel(new ImageIcon("C.png"));
         break;
      case "D":
         contentLabel[3] = new JLabel(new ImageIcon("D.png"));
         break;
      }
      
      pane.add(contentLabel[3]);
      button.setBorderPainted(false);
      button.setFocusPainted(false);
      button.setPreferredSize(new Dimension(400,50));
      button.setBackground(mainBlue);
      button.setForeground(Color.white);
      pane.add(button);
      button.setPreferredSize(new Dimension(400,50));
      frame.setBounds(850, 450, 300, 100);
      frame.add(pane);
      frame.setUndecorated(true);
      frame.setSize(350, 365); // 가로, 세로
      frame.setVisible(true);
      frame.setLocation(600,100);
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("확인")) {
               frame.dispose();
            }
         }
      });
   }
}