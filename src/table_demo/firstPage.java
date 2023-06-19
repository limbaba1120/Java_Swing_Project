package table_demo;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
 
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import table_demo.Login.FrameDragListener;

import java.awt.Font;

public class firstPage extends JFrame {
	
	private CardLayout card;
    private JPanel pnlFirst;
    private JLabel lblImg, text;
    
    
    private JButton btnLogin, btnExit, btnOrder;
    
    public static final Color mainBlue = new Color(123, 154, 204);
    public static final Color mainPink = new Color(252, 246, 245);
    public static final Color gray = new Color(240, 240, 240);
    
    FrameDragListener frameDragListener;
    
    public firstPage() {
        // Frame을 상속받았다
        setLayout(card = new CardLayout());
        
        // 윈도우창의 상단메뉴 해제
        setUndecorated(true);
        
        // 해제한 후에는 창의 이동이 안된다.
        // 반드시  MouseEvent로 Drag 이동을 구현해줘야함 
        frameDragListener = new FrameDragListener(this);
        
        createComponent();
        addComponent();
        addListener();
        
        setSize(978, 600);
        setVisible(true);
        setResizable(false);
        
        //프로그램 실행시 화면 가운데에서 시작하도록 한다.
        setLocationRelativeTo(null);
    }
    
public void createComponent() {
        
        // 첫번째 화면 컴포넌트 생성
        pnlFirst = new JPanel(null); // 레이아웃 해제
        pnlFirst.setBackground(mainPink);
        
        Image img = Toolkit.getDefaultToolkit().getImage("icecream.png");
        Icon icon = new ImageIcon(img);
        lblImg = new JLabel(icon);
        
        
        btnLogin = new JButton("관리자 로그인");
        btnLogin.setForeground(gray);
        btnLogin.setBorderPainted(false);
        btnLogin.setBackground(mainBlue);
        
        btnOrder = new JButton("주문하기");
        btnOrder.setForeground(gray);
        btnOrder.setBorderPainted(false);
        btnOrder.setBackground(mainBlue);
        
        text = new JLabel("ICE-CREAM SHOP", SwingConstants.CENTER);
        Font font = new Font("Britannic Bold", Font.PLAIN, 30);
        text.setFont(font);
        
       
        img = Toolkit.getDefaultToolkit().getImage("icon.png ");
        img = img.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        icon = new ImageIcon(img);
        btnExit = new JButton(icon);
        btnExit.setBackground(Color.gray);
        btnExit.setBounds(953, 0, 25, 25);
        
        
    }
 
    public void addComponent() {
        // 첫번째 화면 컴포넌트 부착
        lblImg.setBounds(245, 100, 500, 300);
        pnlFirst.add(lblImg);
        
        text.setBounds(328, 20, 338, 100);
        pnlFirst.add(text);
        
        
        JPanel pnlLogin = new JPanel(new GridLayout(5,1,5,5));
        pnlLogin.setBackground(mainPink);
        pnlLogin.add(btnOrder);
        pnlLogin.add(btnLogin);
        pnlLogin.setSize(340, 200);
        pnlLogin.setLocation(330,450);
        pnlFirst.add(pnlLogin);
        pnlFirst.add(btnExit);
        
        add(pnlFirst);
    }
 
    public void addListener() {
        //윈도우 닫기버튼 이벤트 처리
        btnExit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                
            }
        });
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.last(firstPage.this.getContentPane());
                dispose();
                new Login();
            }
            
        });
        
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.last(firstPage.this.getContentPane());
                dispose();
                new GUIMain();
            }
        });
        
        //화면에 마우스 이벤트 처리를 통해 드래그 이동을 구현한다. 
        addMouseListener(frameDragListener);
        addMouseMotionListener(frameDragListener);
        
 
    }
    
      public static class FrameDragListener extends MouseAdapter {
 
            private final JFrame frame;
            private Point mouseDownCompCoords = null;
 
            public FrameDragListener(JFrame frame) {
                this.frame = frame; 
            }
 
            public void mouseReleased(MouseEvent e) {
                mouseDownCompCoords = null;
            }
 
            public void mousePressed(MouseEvent e) {
                mouseDownCompCoords = e.getPoint();
            }
 
            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                frame.setLocation(currCoords.x - mouseDownCompCoords.x, currCoords.y - mouseDownCompCoords.y);
            }
        }
 
    public static void main(String[] args) {
        new firstPage();
    }
}
