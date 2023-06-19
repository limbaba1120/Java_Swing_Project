package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import facade.DataEngineInterface;
import store.BarMgr;
import store.CornMgr;
import store.JujubarMgr;
import store.OrderMgr;
import store.OrderedItemMgr;
import store.SandMgr;
import store.Store;

public class GUIMain {
	public GUIMain() {
		Store store = Store.getInstance();
		store.run();
		startGUI();
	}

	public static void startGUI() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	static JFrame mainFrame = new JFrame("ICE CREAM SHOP");

	private static JPanel mainMenuPanels[][] = new JPanel[2][4];
	static String paneNameArr[] = {"¹Ù", "ÂéÂé¹Ù", "ÄÜ", "»÷µå"};

	private static void createAndShowGUI() {
		mainFrame.setBounds(100, 100, 900, 600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTabbedPane jtab = new JTabbedPane();
		jtab.setBackground(Color.gray);
		jtab.setForeground(Color.white);
		for (int i = 0; i < 4; i++) {
			setupItemPane(paneNameArr[i]);
			jtab.add(paneNameArr[i], mainMenuPanels[0][i]);
		}
		setupOrderPane();
		jtab.add("Àå¹Ù±¸´Ï", orderPane);
		jtab.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				photoPane.removeAll();
			}
		});
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image img = toolkit.getImage("icecream.png");
		mainFrame.setIconImage(img);
		mainFrame.getContentPane().add(jtab);
		mainFrame.pack();
		mainFrame.setVisible(true);
		mainFrame.setBounds(100, 100, 1200, 900);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(false);
	}

	private static Container backgroundPane = mainFrame.getContentPane();
	static JPanel photoPane = new JPanel(new BorderLayout());
	private static JScrollPane scroll;
	private static ButtonGroup bg = new ButtonGroup();

	private static void setupItemPane(String type) {
		
		photoPane.setBackground(Color.DARK_GRAY); 
		DataEngineInterface paneMgrArr[] = {BarMgr.getInstance(), JujubarMgr.getInstance(), 
				CornMgr.getInstance(), SandMgr.getInstance(),
				}; 
		int paneItemSize[] = {9, 6, 6, 6};//12};
		for (int i = 0; i < 4; i++) {
			TableSelectionDemo itemTable = new TableSelectionDemo();
			mainMenuPanels[1][i] = new JPanel(new GridLayout(3, 3, 20, 20));
			mainMenuPanels[0][i] = new JPanel(new BorderLayout());
			itemTable.addComponentsToPane(paneMgrArr[i]);
			TopPanel itemTop = new TopPanel();
			itemTop.setupTopPane(itemTable);
			itemTop.setBackground(Color.GRAY);
			mainMenuPanels[0][i].add(itemTop, BorderLayout.NORTH);
			mainMenuPanels[1][i].setBackground(Color.white);
			scroll = new JScrollPane(mainMenuPanels[1][i], 
					ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scroll.getVerticalScrollBar().setUnitIncrement(18);
			mainMenuPanels[0][i].add(scroll, BorderLayout.CENTER);
			mainMenuPanels[0][i].add(itemTable, BorderLayout.CENTER);
			mainMenuPanels[0][i].add(scroll, BorderLayout.CENTER);
			itemTable.setVisible(false);
			backgroundPane.add(mainMenuPanels[0][i], BorderLayout.CENTER);

			int row = 0;

			JToggleButton btns[] = new JToggleButton[paneItemSize[i]];
			for (int j = 0; j < paneItemSize[i]; j++) {
				btns[j] = setButtonImage(itemTable.tableModel, row);
				row++;
			}
			for (JToggleButton btn : btns) {
				bg.add(btn);
				mainMenuPanels[1][i].add(btn);
			}
		}
	}

	static JPanel orderPane;
	static JPanel center = new JPanel(new BorderLayout());
	static DefaultTableModel basketModel;
	static JTable basketTable;
	static DefaultTableModel orderModel;
	static JTable orderTable;
	static JLabel price;
	static JPanel timePane = new JPanel(new FlowLayout());
	static JPanel pricePane = new JPanel(new FlowLayout());
	static JScrollPane scrollPane;
	static JPanel imagePane = new JPanel(new GridLayout(1, 1));

	@SuppressWarnings("serial")
	private static void setupOrderPane() {
		basketModel = new DefaultTableModel(OrderedItemMgr.getInstance().getColumnNames(), 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		basketTable = new JTable(basketModel);
		orderModel = new DefaultTableModel(OrderMgr.getInstance().getColumnNames(), 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		orderModel.setRowCount(0);
		orderTable = new JTable(orderModel);
		orderPane = new JPanel(new BorderLayout());
		basketTable.setFillsViewportHeight(false);
		basketTable.setBackground(Color.GRAY);
		basketTable.setForeground(Color.white);
		orderPane.setBackground(Color.GRAY);
		basketTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		orderTable.setFillsViewportHeight(false);
		orderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		orderTable.setBackground(Color.GRAY);
		JScrollPane scroll1 = new JScrollPane(orderTable);
		orderPane.add(timePane, BorderLayout.NORTH);
		orderPane.add(scroll1, BorderLayout.SOUTH);
		JScrollPane scroll2 = new JScrollPane(basketTable);
		Basket basket = new Basket();
		JPanel right = new JPanel(new GridLayout(4, 1));
		basket.setupbasket(basketTable, basketModel, right);
		JLabel price = new JLabel("±Ý¾×: ");
		scrollPane = new JScrollPane(imagePane, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		imagePane.setBackground(Color.white);
		pricePane.add(price);
		center.add(scroll2);
		center.add(scrollPane);
		center.add(pricePane, BorderLayout.SOUTH);
		orderPane.add(right, BorderLayout.LINE_END);
		orderPane.add(center, BorderLayout.CENTER);
		scroll2.setVisible(false);
	}

	static JToggleButton nowOrderButton;
	static boolean isSelectedOrder = false;
	static String nowCode;
	static int nowRow;

	private static JToggleButton setButtonImage(DefaultTableModel model, int row) {
		JTable table = new JTable(
				);
		table.setModel(model);
		String name;
		String price;
		String code;
		name = (String) table.getValueAt(row, 1);
		price = (String) table.getValueAt(row, 2);
		code = (String) table.getValueAt(row, 0);
		ImageIcon image = new ImageIcon("MENU/" + name + ".jpg");
		Image image2 = image.getImage();
		Image i4 = image2.getScaledInstance(200, 260, java.awt.Image.SCALE_SMOOTH);
		ImageIcon i5 = new ImageIcon(i4);
		JToggleButton b = new JToggleButton(name + " " + price + "¿ø", i5);
		b.setHorizontalTextPosition(SwingConstants.CENTER);
		b.setVerticalTextPosition(SwingConstants.BOTTOM);
		b.setBorderPainted(false);
		b.setFocusPainted(false);
		b.setBackground(Color.white);
		b.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent ev) {
				if (ev.getStateChange() == ItemEvent.SELECTED) {
					TableSelectionDemo.menuName = name;
					nowOrderButton = b;
					isSelectedOrder = true;
					nowCode = code;
					nowRow = row;
				} else if (ev.getStateChange() == ItemEvent.DESELECTED) {
					TableSelectionDemo.menuName = "";
					nowCode = "";
					isSelectedOrder = false;
				}
			}
		});
		return b;
	}
}