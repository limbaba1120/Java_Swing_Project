package table_demo;

import javax.swing.JLabel;
import javax.swing.JPanel;

import facade.UIData;
import store.Order;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class OptionDialog extends javax.swing.JDialog {
	String[] itemDetails;
	String[] ingredient;
	JLabel details[] = new JLabel[5];
	Order ord;
	String size;
	int extraprice;
	OptionDialog op = this;
	JFrame window = new JFrame("Size Selection");
	TableSelectionDemo table;

	OptionDialog(String[] texts, Order od, TableSelectionDemo table) {
		itemDetails = texts;
		ord = od;
		this.table = table;
	}

	void setup() {
		JPanel pane = new JPanel(new FlowLayout());
		pane.setBackground(Color.darkGray); 
		details[4] = new JLabel("¡÷πÆ ");
		details[4].setForeground(Color.white);
		pane.add(details[4]);

		JButton S = new JButton("O");
		S.setBorderPainted(false);
		S.setFocusPainted(false); 
		S.setBackground(Color.gray);
		S.setForeground(Color.white);
		JButton M = new JButton("X");
		M.setBorderPainted(false); 
		M.setFocusPainted(false);
		M.setBackground(Color.gray);
		M.setForeground(Color.white);
		pane.add(S);
		pane.add(M);

		window.setBounds(850, 450, 300, 100);
		window.add(pane);
		window.setUndecorated(true);
		window.setSize(300, 38);
		window.setVisible(true);

		S.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("O")) {
					size = "O";
					window.dispose();
					table.addOrder(size);
				}
			}
		});
		M.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getActionCommand().equals("X")) {
					size = "X";
					window.dispose();
				}
			}
		});
	
	}

	

}