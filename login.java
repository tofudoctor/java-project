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

import javax.swing.*;

public class login extends JFrame {
	//JFrame frame = new JFrame();
	private JPanel contentPane;
	private final JPanel bgpanel = new JPanel();
	private JTextField emailtextfield;
	private JPasswordField passwordfield;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		bgpanel.setBackground(new Color(255, 255, 255));
		bgpanel.setBounds(0, 0, 961, 521);
		contentPane.add(bgpanel);
		bgpanel.setLayout(null);
		
		JPanel sidebar = new JPanel();
		sidebar.setBounds(0, 0, 300, 511);
		sidebar.setBackground(new Color(65, 34, 52));
		bgpanel.add(sidebar);
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
		sidebar1label.setBounds(97, 0, 161, 53);
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
		sidebar2label.setBounds(97, 0, 161, 53);
		sidebar2.add(sidebar2label);
		
		emailtextfield = new JTextField();
		emailtextfield.setForeground(new Color(0, 0, 0));
		emailtextfield.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		emailtextfield.setBounds(442, 203, 373, 21);
		emailtextfield.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(109, 70, 107)));
		emailtextfield.setOpaque(false);
		bgpanel.add(emailtextfield);
		emailtextfield.setColumns(30);
		
		passwordfield = new JPasswordField();
		passwordfield.setColumns(20);
		passwordfield.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		passwordfield.setBounds(442, 262, 373, 21);
		passwordfield.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(109, 70, 107)));
		passwordfield.setOpaque(false);
		bgpanel.add(passwordfield);
		
		JLabel welcome = new JLabel("");
		welcome.setIcon(new ImageIcon("login.png"));
		welcome.setFont(new Font("微軟正黑體", Font.BOLD, 60));
		welcome.setBounds(596, 81, 60, 70);
		bgpanel.add(welcome);
		
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
		loginbutton.setBounds(568, 330, 117, 31);
		loginbutton.setBackground(Color.WHITE);
		bgpanel.add(loginbutton);
		
		JLabel emaillabel = new JLabel("E-mail");
		emaillabel.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		emaillabel.setBounds(442, 162, 108, 31);
		bgpanel.add(emaillabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblPassword.setBounds(442, 221, 108, 31);
		bgpanel.add(lblPassword);
		
		JPanel decorateout_1 = new JPanel();
		decorateout_1.setBounds(117, 346, 280, 280);
		//decorateout_1.setOpaque(false);
		bgpanel.add(decorateout_1);
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
		decorateout_2.setBounds(642, 454, 226, 121);
		bgpanel.add(decorateout_2);
		
		JPanel decoratein_2 = new JPanel();
		decoratein_2.setBackground(Color.WHITE);
		decoratein_2.setBounds(10, 10, 206, 101);
		decorateout_2.add(decoratein_2);
		
		JPanel decorateout_3 = new JPanel();
		decorateout_3.setLayout(null);
		decorateout_3.setBounds(272, 305, 86, 78);
		bgpanel.add(decorateout_3);
		
		JPanel decoratein_3 = new JPanel();
		decoratein_3.setBackground(Color.WHITE);
		decoratein_3.setBounds(10, 10, 66, 58);
		decorateout_3.add(decoratein_3);
		
		JPanel decorateout_4 = new JPanel();
		decorateout_4.setLayout(null);
		decorateout_4.setBounds(834, -67, 86, 160);
		bgpanel.add(decorateout_4);
		
		JPanel decoratein_4 = new JPanel();
		decoratein_4.setBackground(Color.WHITE);
		decoratein_4.setBounds(10, 10, 66, 140);
		decorateout_4.add(decoratein_4);
		
		JPanel decorateout_5 = new JPanel();
		decorateout_5.setLayout(null);
		decorateout_5.setBounds(364, 101, 49, 50);
		bgpanel.add(decorateout_5);
		
		JPanel decoratein_5 = new JPanel();
		decoratein_5.setBackground(Color.WHITE);
		decoratein_5.setBounds(10, 10, 29, 30);
		decorateout_5.add(decoratein_5);
	}
}

