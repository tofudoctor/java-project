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
import java.awt.event.*;
import java.io.*;

public class Login extends JFrame {
	//JFrame frame = new JFrame();
	public JPanel contentPane;
	public final JPanel loginpanel = new JPanel();
	public JTextField emailtextfield;
	public JPasswordField passwordfield;
	public JTextField remailtextfield;
	public JPasswordField rpasswordfield;
	public JTextField nametextfield;

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
	public Login() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent event) {
				try{
					Main.save();
    				System.exit(0);
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		});
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

		JLabel eye = new JLabel("");
		eye.setIcon(new ImageIcon("Images/eye.png"));
		eye.setBounds(522, 233, 39, 32);
		loginpanel.add(eye);
		eye.setVisible(true);
		contentPane.setLayout(null);

		JLabel eye1 = new JLabel("");
		eye1.setIcon(new ImageIcon("Images/eye1.png"));
		eye1.setBounds(522, 233, 39, 32);
		loginpanel.add(eye1);
		eye1.setVisible(false);
		contentPane.setLayout(null);


		eye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eye1.setVisible(true);
				eye.setVisible(false);
				passwordfield.setEchoChar((char)0);
			}
		});
		eye1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				eye1.setVisible(false);
				eye.setVisible(true);
				passwordfield.setEchoChar('*');
			}
		});

		
		JLabel welcome = new JLabel("");
		welcome.setIcon(new ImageIcon("Images/login.png"));
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
					JOptionPane.showMessageDialog(null, Main.users.get(email)+"登入成功");
					dispose();
					try {
						Main.loginemail = email;
						Main.users.get(email).gui();
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
		sidebarpic1.setIcon(new ImageIcon("Images/find.png"));
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
		sidebarpic2.setIcon(new ImageIcon("Images/register.png"));
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
		sidebarpic3.setIcon(new ImageIcon("Images/home1.png"));
		sidebar3.add(sidebarpic3);
		
		JLabel sidebar3label = new JLabel("\u56DE\u9996\u9801");
		sidebar3label.setForeground(Color.WHITE);
		sidebar3label.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		sidebar3label.setBounds(97, 0, 213, 53);
		sidebar3.add(sidebar3label);
		//isbnsearch
		JPanel sidebar4 = new JPanel();
		
		sidebar4.setLayout(null);
		sidebar4.setBackground(new Color(109, 70, 107));
		sidebar4.setBounds(0, 215, 300, 53);
		sidebar.add(sidebar4);
		
		JLabel sidebarpic4 = new JLabel("");
		sidebarpic4.setIcon(new ImageIcon("Images/isbnsearch.png"));
		sidebarpic4.setBounds(40, 10, 47, 43);
		sidebar4.add(sidebarpic4);
		
		JLabel sidebar4label = new JLabel("\u4EE5ISBN\u641C\u5C0B");
		sidebar4label.setForeground(Color.WHITE);
		sidebar4label.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		sidebar4label.setBounds(97, 0, 213, 53);
		sidebar4.add(sidebar4label);
		sidebar4.setVisible(false);

		//回首頁
		JPanel sidebar5 = new JPanel();
		sidebar5.setLayout(null);
		sidebar5.setBackground(new Color(109, 70, 107));
		sidebar5.setBounds(0, 319, 300, 53);
		sidebar.add(sidebar5);
		//home find
		JLabel sidebarpic5 = new JLabel(new ImageIcon("Images/home2.png"));
		sidebarpic5.setBounds(40, 10, 47, 43);
		sidebar5.add(sidebarpic5);
		
		JLabel sidebar5label = new JLabel("\u56DE\u9996\u9801");
		sidebar5label.setForeground(Color.WHITE);
		sidebar5label.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		sidebar5label.setBounds(97, 0, 213, 53);
		sidebar5.add(sidebar5label);
		sidebar5.setVisible(false);
		//contains search
		JPanel sidebar6 = new JPanel();
		sidebar6.setLayout(null);
		sidebar6.setBackground(new Color(109, 70, 107));
		sidebar6.setBounds(0, 268, 300, 53);
		sidebar.add(sidebar6);
		
		JLabel sidebarpic6 = new JLabel(new ImageIcon("Images/consearch.png"));
		sidebarpic6.setBounds(40, 10, 47, 43);
		sidebar6.add(sidebarpic6);
		
		JLabel sidebar6label = new JLabel("\u4EE5\u540D\u5B57\u641C\u5C0B");
		sidebar6label.setForeground(Color.WHITE);
		sidebar6label.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		sidebar6label.setBounds(97, 0, 213, 53);
		sidebar6.add(sidebar6label);
		sidebar6.setVisible(false);

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

		JPanel registerpanel = new JPanel();
		registerpanel.setBackground(Color.WHITE);
		registerpanel.setBounds(300, 0, 646, 511);
		contentPane.add(registerpanel);
		registerpanel.setLayout(null);
		registerpanel.setVisible(false);

		remailtextfield = new JTextField();
		remailtextfield.setForeground(new Color(0, 0, 0));
		remailtextfield.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		remailtextfield.setBounds(138, 185, 373, 21);
		remailtextfield.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(109, 70, 107)));
		remailtextfield.setOpaque(false);
		registerpanel.add(remailtextfield);
		remailtextfield.setColumns(30);
		
		rpasswordfield = new JPasswordField();
		rpasswordfield.setColumns(20);
		rpasswordfield.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		rpasswordfield.setBounds(138, 244, 373, 21);
		rpasswordfield.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(109, 70, 107)));
		rpasswordfield.setOpaque(false);
		registerpanel.add(rpasswordfield);

		nametextfield = new JTextField();
		nametextfield.setForeground(new Color(0, 0, 0));
		nametextfield.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		nametextfield.setBounds(138, 302, 373, 21);
		nametextfield.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(109, 70, 107)));
		nametextfield.setOpaque(false);
		registerpanel.add(nametextfield);
		nametextfield.setColumns(30);

		JLabel lblName = new JLabel("name");
		lblName.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblName.setBounds(138, 261, 108, 31);
		registerpanel.add(lblName);
		contentPane.setLayout(null);

		JLabel remaillabel = new JLabel("E-mail");
		remaillabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		remaillabel.setBounds(138, 144, 108, 31);
		registerpanel.add(remaillabel);
		
		JLabel rlblPassword = new JLabel("Password");
		rlblPassword.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		rlblPassword.setBounds(138, 203, 108, 31);
		registerpanel.add(rlblPassword);

		JLabel lblNewLabel = new JLabel("\u8EAB\u5206");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		lblNewLabel.setBounds(138, 333, 49, 19);
		registerpanel.add(lblNewLabel);
		contentPane.setLayout(null);


		String identification[] = {"管理員", "學生", "老師", "職員"}; 
		JComboBox comboBox = new JComboBox(identification);
		comboBox.setBounds(217, 333, 294, 29);
		registerpanel.add(comboBox);
		
		JButton registerbutton = new JButton("\u8A3B\u518A");
		registerbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{
					String new_email = remailtextfield.getText();
					String new_name = nametextfield.getText();
					String new_password = new String(rpasswordfield.getPassword());
					if(Main.users.get(new_email) == null){
						if(comboBox.getSelectedIndex() == 0){//admin
							Main.users.put(new_email, new Admin(new_name, new_password, new_email));
							FileWriter filewriter = new FileWriter("users.txt", true);
							filewriter.write("Admin "+new_name+" "+new_password+" "+new_email+ "\r\n");
							filewriter.close();
						}
						else if(comboBox.getSelectedIndex() == 1){//student
							Main.users.put(new_email, new Student(new_name, new_password, new_email));
							FileWriter filewriter = new FileWriter("users.txt", true);
							filewriter.write("Student "+new_name+" "+new_password+" "+new_email+ "\r\n");
							filewriter.close();
						}
						else if(comboBox.getSelectedIndex() == 2){//teacher
							Main.users.put(new_email, new Teacher(new_name, new_password, new_email));
							FileWriter filewriter = new FileWriter("users.txt", true);
							filewriter.write("Teacher "+new_name+" "+new_password+" "+new_email+ "\r\n");
							filewriter.close();
						}
						else {//staff
							Main.users.put(new_email, new Staff(new_name, new_password, new_email));
							FileWriter filewriter = new FileWriter("users.txt", true);
							filewriter.write("Staff "+new_name+" "+new_password+" "+new_email+ "\r\n");
							filewriter.close();
						}
						JOptionPane.showMessageDialog(null, "註冊成功!");
					}
					else{
						JOptionPane.showMessageDialog(null, "您的E-mail已被註冊過!");
					}
					remailtextfield.setText("");
					nametextfield.setText("");
					rpasswordfield.setText("");
				}
				catch(Exception io){
					io.printStackTrace();
				}
			}
		});
		registerbutton.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		registerbutton.setBounds(264, 389, 117, 31);
		registerbutton.setBackground(Color.WHITE);
		registerpanel.add(registerbutton);


		JPanel rdecorateout_1 = new JPanel();
		rdecorateout_1.setBounds(-187, 328, 280, 280);
		//decorateout_1.setOpaque(false);
		registerpanel.add(rdecorateout_1);
		rdecorateout_1.setLayout(null);
		
		JPanel rdecoratein_1 = new JPanel();
		//decoratein_1.setOpaque(false);
		rdecoratein_1.setBackground(Color.WHITE);
		rdecoratein_1.setBounds(10, 10, 260, 260);
		rdecorateout_1.add(rdecoratein_1);
		rdecoratein_1.setLayout(null);
		
		JPanel rdecorateout_6 = new JPanel();
		rdecorateout_6.setBounds(145, 0, 86, 44);
		rdecoratein_1.add(rdecorateout_6);
		rdecorateout_6.setLayout(null);
		
		JPanel rdecoratein_6 = new JPanel();
		rdecoratein_6.setBackground(Color.WHITE);
		rdecoratein_6.setBounds(10, 0, 66, 34);
		rdecorateout_6.add(rdecoratein_6);
		
		JPanel rdecorateout_2 = new JPanel();
		rdecorateout_2.setLayout(null);
		rdecorateout_2.setBounds(354, 430, 226, 121);
		registerpanel.add(rdecorateout_2);
		
		JPanel rdecoratein_2 = new JPanel();
		rdecoratein_2.setBackground(Color.WHITE);
		rdecoratein_2.setBounds(10, 10, 206, 101);
		rdecorateout_2.add(rdecoratein_2);
		
		JPanel rdecorateout_3 = new JPanel();
		rdecorateout_3.setLayout(null);
		rdecorateout_3.setBounds(-32, 287, 86, 78);
		registerpanel.add(rdecorateout_3);
		
		JPanel rdecoratein_3 = new JPanel();
		rdecoratein_3.setBackground(Color.WHITE);
		rdecoratein_3.setBounds(10, 10, 66, 58);
		rdecorateout_3.add(rdecoratein_3);
		
		JPanel rdecorateout_4 = new JPanel();
		rdecorateout_4.setLayout(null);
		rdecorateout_4.setBounds(530, -27, 86, 160);
		registerpanel.add(rdecorateout_4);
		
		JPanel rdecoratein_4 = new JPanel();
		rdecoratein_4.setBackground(Color.WHITE);
		rdecoratein_4.setBounds(10, 10, 66, 140);
		rdecorateout_4.add(rdecoratein_4);
		
		JPanel rdecorateout_5 = new JPanel();
		rdecorateout_5.setLayout(null);
		rdecorateout_5.setBounds(100, 45, 49, 50);
		registerpanel.add(rdecorateout_5);
		
		JPanel rdecoratein_5 = new JPanel();
		rdecoratein_5.setBackground(Color.WHITE);
		rdecoratein_5.setBounds(10, 10, 29, 30);
		rdecorateout_5.add(rdecoratein_5);
		contentPane.setLayout(null);

		JLabel rwelcome = new JLabel("");
		rwelcome.setIcon(new ImageIcon("Images/login.png"));
		rwelcome.setFont(new Font("微軟正黑體", Font.BOLD, 60));
		rwelcome.setBounds(292, 63, 60, 70);
		registerpanel.add(rwelcome);
	    
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
				registerpanel.setVisible(false);
				findpanel.setVisible(true);
				sidebar2.setVisible(false);
				sidebar3.setVisible(false);
				sidebar4.setVisible(true);
				sidebar5.setVisible(true);
				sidebar6.setVisible(true);
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
			@Override
			public void mouseClicked(MouseEvent e) {
				loginpanel.setVisible(false);
				registerpanel.setVisible(true);
				findpanel.setVisible(false);
				sidebar4.setVisible(false);
				sidebar2.setVisible(true);
				sidebar3.setVisible(true);
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
				registerpanel.setVisible(false);
				findpanel.setVisible(false);
				sidebar4.setVisible(false);
				sidebar2.setVisible(true);
				sidebar3.setVisible(true);
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
		sidebar5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(sidebar5);
			}
			public void mouseExited(MouseEvent e) {
				resetcolor(sidebar5);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				loginpanel.setVisible(true);
				findpanel.setVisible(false);
				sidebar4.setVisible(false);
				sidebar2.setVisible(true);
				sidebar3.setVisible(true);
				sidebar5.setVisible(false);
			}
		});
		sidebar6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(sidebar6);
			}
			public void mouseExited(MouseEvent e) {
				resetcolor(sidebar6);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String s = JOptionPane.showInputDialog(null, "請輸入書本名字(不完整也可以):");
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
					if(it.getValue().getName().contains(s)){
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
					
				}
				if(data.isEmpty()){
					JOptionPane.showMessageDialog(null, "本圖書館沒有名字包含"+ s +"的書!");
				}
				else{
					JTable table = new JTable(data, header);
					JScrollPane findpanel=new JScrollPane(table);
					//findpanel.setBackground(new Color(255, 255, 255));
					table.setBounds(300, 0, 646, 511);
					findpanel.setBounds(298, 0, 660, 540);
					findpanel.setVisible(true);
					getContentPane().add(findpanel);
				}
				
			}
		});
	}
}

