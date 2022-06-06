import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.*;
import javax.swing.*;

public class login extends JFrame {
	//JFrame frame = new JFrame();
	private JPanel contentPane;
	private final JPanel loginpanel = new JPanel();
	private JTextField emailtextfield;
	private JPasswordField passwordfield;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	void setcolor(JPanel panel){
		panel.setBackground(new Color(196, 147, 176));
	}
	void resetcolor(JPanel panel){
		panel.setBackground(new Color(109, 70, 107));
	}
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		loginpanel.setBackground(new Color(255, 255, 255));
		loginpanel.setBounds(300, 0, 646, 511);
		contentPane.add(loginpanel);
		loginpanel.setLayout(null);
		
		emailtextfield = new JTextField();
		emailtextfield.setForeground(new Color(0, 0, 0));
		emailtextfield.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		emailtextfield.setBounds(138, 185, 373, 21);
		emailtextfield.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(109, 70, 107)));
		emailtextfield.setOpaque(false);
		loginpanel.add(emailtextfield);
		emailtextfield.setColumns(30);
		
		passwordfield = new JPasswordField();
		passwordfield.setColumns(20);
		passwordfield.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		passwordfield.setBounds(138, 244, 373, 21);
		passwordfield.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(109, 70, 107)));
		passwordfield.setOpaque(false);
		loginpanel.add(passwordfield);
		
		JLabel welcome = new JLabel("");
		welcome.setIcon(new ImageIcon("login.png"));
		welcome.setFont(new Font("微軟正黑體", Font.BOLD, 60));
		welcome.setBounds(292, 63, 60, 70);
		loginpanel.add(welcome);
		
		JButton loginbutton = new JButton("\u767B\u5165");
		loginbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String email = emailtextfield.getText();
				System.out.println(email);
				String ps = new String(passwordfield.getPassword());
				if(Main.users.get(email) == null){
					JOptionPane.showMessageDialog(null, "帳號不存在");
				}
				else if(Main.users.containsKey(email) && Main.users.get(email).getPassword().equals(ps)){
					JOptionPane.showMessageDialog(null, "登入成功");
					dispose();
					try {
						while(Main.users.get(email).gui());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "帳號或密碼錯誤!");
				}
			}
		});
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginbutton.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		loginbutton.setBounds(264, 312, 117, 31);
		loginbutton.setBackground(Color.WHITE);
		loginpanel.add(loginbutton);
		
		JLabel emaillabel = new JLabel("E-mail");
		emaillabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		emaillabel.setBounds(138, 144, 108, 31);
		loginpanel.add(emaillabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblPassword.setBounds(138, 203, 108, 31);
		loginpanel.add(lblPassword);
		
		JPanel decorateout_1 = new JPanel();
		decorateout_1.setBounds(-187, 328, 280, 280);
		//decorateout_1.setOpaque(false);
		loginpanel.add(decorateout_1);
		decorateout_1.setLayout(null);
		
		JPanel decoratein_1 = new JPanel();
		//decoratein_1.setOpaque(false);
		decoratein_1.setBackground(Color.WHITE);
		decoratein_1.setBounds(10, 10, 260, 260);
		decorateout_1.add(decoratein_1);
		decoratein_1.setLayout(null);
		
		JPanel decorateout_6 = new JPanel();
		decorateout_6.setBounds(145, 0, 86, 44);
		decoratein_1.add(decorateout_6);
		decorateout_6.setLayout(null);
		
		JPanel decoratein_6 = new JPanel();
		decoratein_6.setBackground(Color.WHITE);
		decoratein_6.setBounds(10, 0, 66, 34);
		decorateout_6.add(decoratein_6);
		
		JPanel decorateout_2 = new JPanel();
		decorateout_2.setLayout(null);
		decorateout_2.setBounds(354, 430, 226, 121);
		loginpanel.add(decorateout_2);
		
		JPanel decoratein_2 = new JPanel();
		decoratein_2.setBackground(Color.WHITE);
		decoratein_2.setBounds(10, 10, 206, 101);
		decorateout_2.add(decoratein_2);
		
		JPanel decorateout_3 = new JPanel();
		decorateout_3.setLayout(null);
		decorateout_3.setBounds(-32, 287, 86, 78);
		loginpanel.add(decorateout_3);
		
		JPanel decoratein_3 = new JPanel();
		decoratein_3.setBackground(Color.WHITE);
		decoratein_3.setBounds(10, 10, 66, 58);
		decorateout_3.add(decoratein_3);
		
		JPanel decorateout_4 = new JPanel();
		decorateout_4.setLayout(null);
		decorateout_4.setBounds(530, -27, 86, 160);
		loginpanel.add(decorateout_4);
		
		JPanel decoratein_4 = new JPanel();
		decoratein_4.setBackground(Color.WHITE);
		decoratein_4.setBounds(10, 10, 66, 140);
		decorateout_4.add(decoratein_4);
		
		JPanel decorateout_5 = new JPanel();
		decorateout_5.setLayout(null);
		decorateout_5.setBounds(100, 45, 49, 50);
		loginpanel.add(decorateout_5);
		
		JPanel decoratein_5 = new JPanel();
		decoratein_5.setBackground(Color.WHITE);
		decoratein_5.setBounds(10, 10, 29, 30);
		decorateout_5.add(decoratein_5);
		contentPane.setLayout(null);
		

		JPanel sidebar = new JPanel();
		sidebar.setBounds(0, 0, 300, 511);
		contentPane.add(sidebar);
		sidebar.setBackground(new Color(65, 34, 52));
		sidebar.setLayout(null);
		
		JLabel teamlabel = new JLabel("\u5716\u66F8\u9928\u7BA1\u7406\u7CFB\u7D71");
		teamlabel.setForeground(Color.WHITE);
		teamlabel.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		teamlabel.setBounds(40, 50, 227, 60);
		sidebar.add(teamlabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 134, 280, 19);
		sidebar.add(separator);
		
		
		JPanel sidebar1 = new JPanel();
		
		sidebar1.setBounds(0, 163, 300, 53);
		sidebar1.setBackground(new Color(109, 70, 107));
		sidebar.add(sidebar1);
		sidebar1.setLayout(null);
		
		JLabel sidebarpic1 = new JLabel("");
		sidebarpic1.setIcon(new ImageIcon("find.png"));
		sidebarpic1.setBounds(40, 10, 47, 43);
		sidebar1.add(sidebarpic1);
		
		JLabel sidebar1label = new JLabel("\u67E5\u8A62\u66F8\u7C4D");
		sidebar1label.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		sidebar1label.setForeground(Color.WHITE);
		sidebar1label.setBounds(97, 0, 213, 53);
		sidebar1.add(sidebar1label);
		
		JPanel sidebar2 = new JPanel();
		
		sidebar2.setLayout(null);
		sidebar2.setBackground(new Color(109, 70, 107));
		sidebar2.setBounds(0, 215, 300, 53);
		sidebar.add(sidebar2);
		
		JLabel sidebarpic2 = new JLabel("");
		sidebarpic2.setIcon(new ImageIcon("register.png"));
		sidebarpic2.setBounds(40, 10, 47, 43);
		sidebar2.add(sidebarpic2);
		
		JLabel sidebar2label = new JLabel("\u8A3B\u518A\u65B0\u5E33\u865F");
		sidebar2label.setForeground(Color.WHITE);
		sidebar2label.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		sidebar2label.setBounds(97, 0, 213, 53);
		sidebar2.add(sidebar2label);

		JPanel sidebar3 = new JPanel();
		sidebar3.setLayout(null);
		sidebar3.setBackground(new Color(109, 70, 107));
		sidebar3.setBounds(0, 268, 300, 53);
		sidebar.add(sidebar3);
		
		JLabel sidebarpic3 = new JLabel("");
		sidebarpic3.setBounds(40, 10, 47, 43);
		sidebarpic3.setIcon(new ImageIcon("home.png"));
		sidebar3.add(sidebarpic3);
		
		JLabel sidebar3label = new JLabel("\u56DE\u9996\u9801");
		sidebar3label.setForeground(Color.WHITE);
		sidebar3label.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		sidebar3label.setBounds(97, 0, 213, 53);
		sidebar3.add(sidebar3label);

		JPanel sidebar4 = new JPanel();
		
		sidebar4.setLayout(null);
		sidebar4.setBackground(new Color(109, 70, 107));
		sidebar4.setBounds(0, 215, 300, 53);
		sidebar.add(sidebar4);
		
		JLabel sidebarpic4 = new JLabel("");
		sidebarpic4.setIcon(new ImageIcon("isbnsearch.png"));
		sidebarpic4.setBounds(40, 10, 47, 43);
		sidebar4.add(sidebarpic4);
		
		JLabel sidebar4label = new JLabel("\u4EE5ISBN\u641C\u5C0B(\u8F03\u5FEB)");
		sidebar4label.setForeground(Color.WHITE);
		sidebar4label.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		sidebar4label.setBounds(97, 0, 213, 53);
		sidebar4.add(sidebar4label);
		sidebar4.setVisible(false);

		Vector<String> header = new Vector<String>();
		header.add("ISBN");
		header.add("名字");
		header.add("作者");
		header.add("出版社");
		header.add("頁數");
		header.add("狀態");
		Vector<Vector<String>> data = new Vector<Vector<String>>();
	    //String [][] data={{"akash","20"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"}};
		for(Map.Entry<String, Book> it:Main.books.entrySet()){
			Vector<String> tmp = new Vector<String>();
			tmp.add(it.getValue().getIsbn());
			tmp.add(it.getValue().getName());
			tmp.add(it.getValue().getAuthor());
			tmp.add(it.getValue().getPublisher());
			tmp.add(it.getValue().getPage());
			if(it.getValue().getLend()){
				tmp.add("已借出");
			}
			else{
				tmp.add("未借出");
			}
			data.add(tmp);
		}
		JTable table = new JTable(data, header);
	    JScrollPane findpanel=new JScrollPane(table);
		//findpanel.setBackground(new Color(255, 255, 255));
		table.setBounds(300, 0, 646, 511);
	    findpanel.setBounds(298, 0, 660, 540);
	    findpanel.setVisible(false);
	    getContentPane().add(findpanel);
	    
	    
		sidebar1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(sidebar1);
			}
			public void mouseExited(MouseEvent e) {
				resetcolor(sidebar1);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				loginpanel.setVisible(false);
				findpanel.setVisible(true);
				sidebar2.setVisible(false);
				sidebar4.setVisible(true);
			}
		});
		sidebar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(sidebar2);
			}
			public void mouseExited(MouseEvent e) {
				resetcolor(sidebar2);
			}
		});
		sidebar3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(sidebar3);
			}
			public void mouseExited(MouseEvent e) {
				resetcolor(sidebar3);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				loginpanel.setVisible(true);
				findpanel.setVisible(false);
				sidebar4.setVisible(false);
				sidebar2.setVisible(true);
			}
		});
		sidebar4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(sidebar4);
			}
			public void mouseExited(MouseEvent e) {
				resetcolor(sidebar4);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Main.search();
			}
		});
	}
}

