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
import java.awt.Font;
 
public class Login extends JFrame {
 
    private CardLayout card;
    private JPanel pnlFirst;
    
    // ù��° ȭ���� ������Ʈ 
    private JTextField tfUserId;
    private JPasswordField tfpassword;
    private JButton btnLogin, btnExit, btnBack;
    private JLabel lblImg, lblInfo, text;
    
    public static final Color mainBlue = new Color(123, 154, 204);
    public static final Color mainPink = new Color(252, 246, 245);
    public static final Color gray = new Color(240, 240, 240);
    
     FrameDragListener frameDragListener;
   
     public Login() {
        // Frame�� ��ӹ޾Ҵ�
        setLayout(card = new CardLayout());
        
        // ������â�� ��ܸ޴� ����
        setUndecorated(true);
        
        // ������ �Ŀ��� â�� �̵��� �ȵȴ�.
        // �ݵ��  MouseEvent�� Drag �̵��� ����������� 
        frameDragListener = new FrameDragListener(this);
        
        createComponent();
        addComponent();
        addListener();
        
        setSize(978, 600);
        setVisible(true);
        setResizable(false);
        
        //���α׷� ����� ȭ�� ������� �����ϵ��� �Ѵ�.
        setLocationRelativeTo(null);
    }
    
    public void createComponent() {
        
        // ù��° ȭ�� ������Ʈ ����
        pnlFirst = new JPanel(null); // ���̾ƿ� ����
        pnlFirst.setBackground(mainPink);
        
        Image img = Toolkit.getDefaultToolkit().getImage("coolpic.jpg");
        Icon icon = new ImageIcon(img);
        lblImg = new JLabel(icon);
        
        text = new JLabel("ADMIN", SwingConstants.CENTER);
        
        Font font = new Font("Britannic Bold", Font.PLAIN, 30);
        
        text.setFont(font);
        
        tfUserId = new JTextField("  ���̵� �Է����ּ���.");
        tfUserId.setBackground(gray);
        tfpassword = new JPasswordField();
        tfpassword.setBackground(gray);
//        tfpassword.setText("�� �� �� ȣ ");
        
        btnLogin = new JButton("�α���");
        btnLogin.setForeground(gray);
        btnLogin.setBorderPainted(false);
        btnLogin.setBackground(mainBlue);
        
       
        img = Toolkit.getDefaultToolkit().getImage("C:/Users/YIHOEUN/eclipse-workspace/SwingProject/image/btnExit.png");
        img = img.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        icon = new ImageIcon(img);
        btnExit = new JButton(icon);
        btnExit.setBackground(mainPink);
        btnExit.setBorderPainted(false);
        btnExit.setBounds(953, 0, 25, 25);
        
        img = Toolkit.getDefaultToolkit().getImage("C:/Users/YIHOEUN/eclipse-workspace/SwingProject/image/btnBack.png");
        img = img.getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        icon = new ImageIcon(img);
        
        btnBack = new JButton(icon);
        btnBack.setBackground(mainPink);
        btnBack.setBounds(928, 0, 25, 25);
        
    }
 
    public void addComponent() {
        // ù��° ȭ�� ������Ʈ ����
        lblImg.setBounds(425, 100, 150, 150);
        pnlFirst.add(lblImg);
        text.setBounds(328, 240, 338, 100);
        pnlFirst.add(text);
        
        
        JPanel pnlLogin = new JPanel(new GridLayout(5,1,5,5));
        pnlLogin.setBackground(mainPink);
        pnlLogin.add(tfUserId);
        pnlLogin.add(tfpassword);
        pnlLogin.add(btnLogin);
        pnlLogin.setSize(340, 200);
        pnlLogin.setLocation(330,350);
        pnlFirst.add(pnlLogin);
        pnlFirst.add(btnExit);
        pnlFirst.add(btnBack);
        
        add(pnlFirst);
    }
 
    public void addListener() {
        //������ �ݱ��ư �̺�Ʈ ó��
        btnExit.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                
            }
        });
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.last(Login.this.getContentPane());
            }
        });
        
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                card.last(Login.this.getContentPane());
                dispose();
                new firstPage();
            }
        });
        
        //ȭ�鿡 ���콺 �̺�Ʈ ó���� ���� �巡�� �̵��� �����Ѵ�. 
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
 
}
