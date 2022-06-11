import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import static java.lang.Math.abs;

public class Gui_Staff extends JFrame {

	private JPanel contentPane;
	public JTextField borrow_isbn;
	public JTextField mbook_name;
	public JTextField mauthor_name;
	public JTextField mpublisher_name;
	public JTextField mpages;
	public JTextField misbn_code;
	public JTextField disbn_code;
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
	public Gui_Staff() throws IOException{
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
		contentPane.setLayout(null);


		//home
		JPanel homepanel = new JPanel();
		homepanel.setBackground(Color.WHITE);
		homepanel.setBounds(300, 0, 646, 511);
		contentPane.add(homepanel);
		homepanel.setLayout(null);
		homepanel.setVisible(true);
		
		JPanel decorateout_1 = new JPanel();
		decorateout_1.setBounds(-172, 425, 280, 280);
		//decorateout_1.setOpaque(false);
		homepanel.add(decorateout_1);
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
		decorateout_2.setBounds(335, 450, 226, 121);
		homepanel.add(decorateout_2);
		
		JPanel decoratein_2 = new JPanel();
		decoratein_2.setBackground(Color.WHITE);
		decoratein_2.setBounds(10, 10, 206, 101);
		decorateout_2.add(decoratein_2);
		
		JPanel decorateout_3 = new JPanel();
		decorateout_3.setLayout(null);
		decorateout_3.setBounds(-17, 384, 86, 78);
		homepanel.add(decorateout_3);
		
		JPanel decoratein_3 = new JPanel();
		decoratein_3.setBackground(Color.WHITE);
		decoratein_3.setBounds(10, 10, 66, 58);
		decorateout_3.add(decoratein_3);
		
		JPanel decorateout_4 = new JPanel();
		decorateout_4.setLayout(null);
		decorateout_4.setBounds(522, -89, 86, 160);
		homepanel.add(decorateout_4);
		
		JPanel decoratein_4 = new JPanel();
		decoratein_4.setBackground(Color.WHITE);
		decoratein_4.setBounds(10, 10, 66, 140);
		decorateout_4.add(decoratein_4);
		
		JPanel decorateout_5 = new JPanel();
		decorateout_5.setLayout(null);
		decorateout_5.setBounds(91, 25, 49, 50);
		homepanel.add(decorateout_5);
		
		JPanel decoratein_5 = new JPanel();
		decoratein_5.setBackground(Color.WHITE);
		decoratein_5.setBounds(10, 10, 29, 30);
		decorateout_5.add(decoratein_5);
		
		
		Vector<String> headerperson = new Vector<String>();
		Vector<Vector<String>> dataperson = new Vector<Vector<String>>();
				headerperson.add("ISBN");
				headerperson.add("名字");
				headerperson.add("作者");
				headerperson.add("出版社");
				headerperson.add("頁數");
				headerperson.add("狀態");
				headerperson.add("期限/還書日期");
				for(Book it:Main.users.get(Main.loginemail).record){
					Vector<String> tmp = new Vector<String>();
					tmp.add(it.getIsbn());
					tmp.add(it.getName());
					tmp.add(it.getAuthor());
					tmp.add(it.getPublisher());
					tmp.add(it.getPage());
					if(it.getLend()){
						tmp.add("尚未歸還");
					}
					else{
						tmp.add("已歸還");
					}
					tmp.add(Book.date(it.getReturn_day(), it.getReturn_year()));
					dataperson.add(tmp);
				}
		for(Book it:Main.users.get(Main.loginemail).books){
			Vector<String> tmp = new Vector<String>();
			tmp.add(it.getIsbn());
			tmp.add(it.getName());
			tmp.add(it.getAuthor());
			tmp.add(it.getPublisher());
			tmp.add(it.getPage());
			if(it.getWho().equals(Main.loginemail)){
				tmp.add("尚未歸還");
			}
			else{
				tmp.add("已歸還");
			}
			tmp.add(Book.date(it.getReturn_day(), it.getReturn_year()));
			dataperson.add(tmp);
		}
		JTable state = new JTable(dataperson,headerperson);
		JScrollPane indicate= new JScrollPane(state);
		state.setBounds(148, 111, 419, 245);
	    indicate.setBounds(0, 107, 646, 220);
	    indicate.setVisible(true);
		homepanel.add(indicate);


		JLabel Openline = new JLabel("歡迎"+Main.users.get(Main.loginemail).getName()+"職員");
		Openline.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		Openline.setBounds(224, 47, 300, 50);
		homepanel.add(Openline);
		contentPane.setLayout(null);
		Openline.setFocusable(true);


		JLabel isbnNewLabel = new JLabel("ISBN");
		isbnNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		isbnNewLabel.setBounds(141, 337, 86, 21);
		homepanel.add(isbnNewLabel);
		
		borrow_isbn= new JTextField();
		borrow_isbn.setForeground(new Color(0, 0, 0));
		borrow_isbn.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		borrow_isbn.setBounds(141, 363, 405, 21);
		borrow_isbn.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(109, 70, 107)));
		borrow_isbn.setOpaque(false);
		homepanel.add(borrow_isbn);
		borrow_isbn.setColumns(30);
	
        
        JLabel enterisbn = new JLabel("isbn\u78BC");
        enterisbn.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
        enterisbn.setBounds(92, 204, 72, 33);
        homepanel.add(enterisbn);


		JButton borrowbook = new JButton();
		borrowbook.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e)  {
				String operation[] = {"是", "否"}; 
        		int operation_option = JOptionPane.showOptionDialog(null, "是否確定借書?", null, 1, 2, null, operation, null);
				if(operation_option == 0){
					String name = borrow_isbn.getText(); 
					if(Main.books.get(name) == null){
						JOptionPane.showMessageDialog(null, "此書不存在\n無法借閱!");
					}
					else if(Main.books.get(name).getLend()){
						JOptionPane.showMessageDialog(null, "此書已借出\n無法借閱!");
					}
					else{
						System.out.println(name);
						System.out.println("added");
						if(Main.users.get(Main.loginemail).getCount()<3){
							Calendar now =  Calendar.getInstance();
							now.add(Calendar.DATE,10);
							Main.books.get(name).setLend(true);
							Main.books.get(name).setReturn_day(now.get(Calendar.DAY_OF_YEAR));
							Main.books.get(name).setReturn_year(now.get(Calendar.YEAR));
							Main.books.get(name).setWho(Main.loginemail);
							Main.users.get(Main.loginemail).books.add(Main.books.get(name));
							Main.users.get(Main.loginemail).count++;
							JOptionPane.showMessageDialog(null, "借書成功\n還書日期為: "+Book.date(now.get(Calendar.DAY_OF_YEAR), now.get(Calendar.YEAR)));
						}
						else{
							JOptionPane.showMessageDialog(null, "最多借3本!!!");
						}
					}
					
					borrow_isbn.setText("");
				}
				else{
					JOptionPane.showMessageDialog(null, "借書失敗!");
				}	
        	}
        });
		borrowbook.setText("\u501F\u66F8");
		borrowbook.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		borrowbook.setBackground(Color.WHITE);
		borrowbook.setBounds(141, 399, 117, 31);
		homepanel.add(borrowbook);
		
		JButton extendbook = new JButton();
		extendbook.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e)  {
				String operation[] = {"是", "否"}; 
        		int operation_option = JOptionPane.showOptionDialog(null, "是否確定續借?", null, 1, 2, null, operation, null);
				if(operation_option == 0){
					Calendar now = Calendar.getInstance();
					String name = borrow_isbn.getText(); 
					int day= now.get(Calendar.DAY_OF_YEAR);
					int year = now.get(Calendar.YEAR);
					if(Main.books.get(name).day_difference(day, Main.books.get(name).getReturn_day(), year, Main.books.get(name).getReturn_year()) < 0){// overdue
						JOptionPane.showMessageDialog(null, "逾期"+abs(Main.books.get(name).day_difference(day, Main.books.get(name).getReturn_day(), year, Main.books.get(name).getReturn_year()))+"天!\n請繳罰金"+(abs(Main.books.get(name).day_difference(day, Main.books.get(name).getReturn_day(), year, Main.books.get(name).getReturn_year()))*10)+"元!\n無法續借!\n請盡速還書");
					}
					else if(Main.books.get(name).getWho().equals(Main.loginemail)){
						System.out.println(name);
						System.out.println("ext");
						if(Main.books.get(name).getReturn_day()+10>365){
							Main.books.get(name).setReturn_day(Main.books.get(name).getReturn_day()+10);
							Main.books.get(name).setReturn_year(Main.books.get(name).getReturn_year()+1);
						}
						else{
							Main.books.get(name).setReturn_day(Main.books.get(name).getReturn_day()+10);
							//Main.books.get(name).setReturn_year(0);
						}
						JOptionPane.showMessageDialog(null, "續借成功\n還書日期為: "+Book.date(Main.books.get(name).getReturn_day(), Main.books.get(name).getReturn_year()));
					}
					else{
						JOptionPane.showMessageDialog(null, "您尚未借閱此書!");
					}
					borrow_isbn.setText("");
				}
				else{
					JOptionPane.showMessageDialog(null, "續借失敗!");
				}	
        	}
        });
		extendbook.setText("\u7E8C\u501F");
		extendbook.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		extendbook.setBackground(Color.WHITE);
		extendbook.setBounds(429, 399, 117, 31);
		homepanel.add(extendbook);
		
		JButton returnbook = new JButton();
		returnbook.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e)  {
				String operation[] = {"是", "否"}; 
        		int operation_option = JOptionPane.showOptionDialog(null, "是否確定還書?", null, 1, 2, null, operation, null);
				if(operation_option == 0){
					Calendar now = Calendar.getInstance();
					String name = borrow_isbn.getText(); 
					if(Main.books.get(name).getWho().equals(Main.loginemail)){
						System.out.println(name);
						System.out.println("return");
						int day= now.get(Calendar.DAY_OF_YEAR);
						int year = now.get(Calendar.YEAR);
						if(Main.books.get(name).day_difference(day, Main.books.get(name).getReturn_day(), year, Main.books.get(name).getReturn_year()) < 0){// overdue
							JOptionPane.showMessageDialog(null, "逾期"+abs(Main.books.get(name).day_difference(day, Main.books.get(name).getReturn_day(), year, Main.books.get(name).getReturn_year()))+"天!\n請繳罰金"+(abs(Main.books.get(name).day_difference(day, Main.books.get(name).getReturn_day(), year, Main.books.get(name).getReturn_year())*10)+"元!"));
						}
						Main.users.get(Main.loginemail).books.remove(Main.books.get(name));
						Main.users.get(Main.loginemail).count--;
						JOptionPane.showMessageDialog(null, "還書成功");
						Main.books.get(name).setLend(false);
						Main.books.get(name).setReturn_day(0);
						Main.books.get(name).setReturn_year(0);
						Main.books.get(name).setWho(null);
						Main.users.get(Main.loginemail).record.add(new Book(Main.books.get(name).getIsbn(), Main.books.get(name).getName(), Main.books.get(name).getAuthor(), Main.books.get(name).getPublisher(), Main.books.get(name).getPage(), false, year, day,Main.loginemail));
						try{
							FileWriter filewriter = new FileWriter("record.txt", true);
							filewriter.write(Main.books.get(name).getIsbn()+" "+Main.books.get(name).getName()+" "+Main.books.get(name).getAuthor()+" "+Main.books.get(name).getPublisher()+" "+Main.books.get(name).getPage()+" "+false+" "+year+" "+day+" "+Main.loginemail+"\r\n");
							filewriter.close();
						}
						catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "您並未借閱此書!");
					}
					borrow_isbn.setText("");
				}
				else{
					JOptionPane.showMessageDialog(null, "還書失敗!");
				}	
        	}
        });
		returnbook.setText("\u9084\u66F8");
		returnbook.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		returnbook.setBackground(Color.WHITE);
		returnbook.setBounds(286, 399, 117, 31);
		homepanel.add(returnbook);


		//find
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
	    findpanel.setVisible(true);
	    getContentPane().add(findpanel);
		



		//sidebar
		JPanel sidebar = new JPanel();
		sidebar.setLayout(null);
		sidebar.setBackground(new Color(65, 34, 52));
		sidebar.setBounds(0, 0, 300, 511);
		contentPane.add(sidebar);
		
		JLabel teamlabel = new JLabel("\u5716\u66F8\u9928\u7BA1\u7406\u7CFB\u7D71");
		teamlabel.setForeground(Color.WHITE);
		teamlabel.setFont(new Font("微軟正黑體", Font.BOLD, 30));
		teamlabel.setBounds(40, 34, 227, 60);
		sidebar.add(teamlabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 92, 280, 19);
		sidebar.add(separator);
		
		JPanel sidebarsearch = new JPanel();
		sidebarsearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(sidebarsearch);
			}
			public void mouseExited(MouseEvent e) {
				resetcolor(sidebarsearch);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				homepanel.setVisible(false);
				
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
				table.setBounds(300, 0, 646, 511);
				findpanel.setBounds(298, 0, 660, 540);
				findpanel.setVisible(true);
				getContentPane().add(findpanel);
			}
		});
		sidebarsearch.setLayout(null);
		sidebarsearch.setBackground(new Color(109, 70, 107));
		sidebarsearch.setBounds(0, 110, 300, 53);
		sidebar.add(sidebarsearch);
		
		JLabel sidebarpic1 = new JLabel(new ImageIcon("Images/find.png"));
		sidebarpic1.setBounds(40, 10, 47, 43);
		sidebarsearch.add(sidebarpic1);
		
		JLabel findlabel = new JLabel("\u67E5\u8A62\u66F8\u7C4D");
		findlabel.setForeground(Color.WHITE);
		findlabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		findlabel.setBounds(97, 0, 203, 53);
		sidebarsearch.add(findlabel);
		

		JPanel sidebarisbnsearch = new JPanel();
		sidebarisbnsearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(sidebarisbnsearch);
			}
			public void mouseExited(MouseEvent e) {
				resetcolor(sidebarisbnsearch);
			}
			public void mouseClicked(MouseEvent e) {
				homepanel.setVisible(false);
				
				findpanel.setVisible(true);
				Main.search();
			}
		});
		sidebarisbnsearch.setLayout(null);
		sidebarisbnsearch.setBackground(new Color(109, 70, 107));
		sidebarisbnsearch.setBounds(0, 162, 300, 53);
		sidebar.add(sidebarisbnsearch);

		JLabel sidebarpic6 = new JLabel("");
		sidebarpic6.setIcon(new ImageIcon("Images/isbnsearch.png"));
		sidebarpic6.setBounds(40, 10, 47, 43);
		sidebarisbnsearch.add(sidebarpic6);

		JLabel sidebarlabelisbnsearsh = new JLabel("\u4EE5ISBN\u641C\u5C0B");
		sidebarlabelisbnsearsh.setForeground(Color.WHITE);
		sidebarlabelisbnsearsh.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		sidebarlabelisbnsearsh.setBounds(97, 0, 203, 53);
		sidebarisbnsearch.add(sidebarlabelisbnsearsh);
		sidebarisbnsearch.setVisible(true);


		JPanel sidebarconsearch = new JPanel();
		sidebarconsearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(sidebarconsearch);
			}
			public void mouseExited(MouseEvent e) {
				resetcolor(sidebarconsearch);
			}
			public void mouseClicked(MouseEvent e) {
				homepanel.setVisible(false);
				//findpanel.setVisible(false);
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
					JScrollPane findpanelcon=new JScrollPane(table);
					//findpanel.setBackground(new Color(255, 255, 255));
					table.setBounds(300, 0, 646, 511);
					findpanelcon.setBounds(298, 0, 660, 540);
					findpanelcon.setVisible(true);
					getContentPane().add(findpanelcon);
				}
			}
		});
		sidebarconsearch.setLayout(null);
		sidebarconsearch.setBackground(new Color(109, 70, 107));
		sidebarconsearch.setBounds(0, 215, 300, 53);
		sidebar.add(sidebarconsearch);

		JLabel sidebarpic7 = new JLabel("");
		sidebarpic7.setIcon(new ImageIcon("Images/consearch.png"));
		sidebarpic7.setBounds(40, 10, 47, 43);
		sidebarconsearch.add(sidebarpic7);

		JLabel sidebarlabelconsearsh = new JLabel("\u4EE5\u540D\u5B57\u641C\u5C0B");
		sidebarlabelconsearsh.setForeground(Color.WHITE);
		sidebarlabelconsearsh.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		sidebarlabelconsearsh.setBounds(97, 0, 203, 53);
		sidebarconsearch.add(sidebarlabelconsearsh);
		sidebarconsearch.setVisible(true);



		JPanel sidebarhome = new JPanel();
		sidebarhome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(sidebarhome);
			}
			public void mouseExited(MouseEvent e) {
				resetcolor(sidebarhome);
			}
			public void mouseClicked(MouseEvent e) {
				findpanel.setVisible(false);
				Vector<String> headerperson = new Vector<String>();
				Vector<Vector<String>> dataperson = new Vector<Vector<String>>();
				headerperson.add("ISBN");
				headerperson.add("名字");
				headerperson.add("作者");
				headerperson.add("出版社");
				headerperson.add("頁數");
				headerperson.add("狀態");
				headerperson.add("期限/還書日期");
				for(Book it:Main.users.get(Main.loginemail).record){
					System.out.println(it);
					Vector<String> tmp = new Vector<String>();
					tmp.add(it.getIsbn());
					tmp.add(it.getName());
					tmp.add(it.getAuthor());
					tmp.add(it.getPublisher());
					tmp.add(it.getPage());
					if(it.getLend()){
						tmp.add("尚未歸還");
					}
					else{
						tmp.add("已歸還");
					}
					tmp.add(Book.date(it.getReturn_day(), it.getReturn_year()));
					
					dataperson.add(tmp);
					
				}
				for(Book it:Main.users.get(Main.loginemail).books){
					Vector<String> tmp = new Vector<String>();
					tmp.add(it.getIsbn());
					tmp.add(it.getName());
					tmp.add(it.getAuthor());
					tmp.add(it.getPublisher());
					tmp.add(it.getPage());
					if(it.getWho().equals(Main.loginemail)){
						tmp.add("尚未歸還");
					}
					else{
						tmp.add("已歸還");
					}
					tmp.add(Book.date(it.getReturn_day(), it.getReturn_year()));
					dataperson.add(tmp);
					System.out.println(dataperson);
				}
				JTable state1 = new JTable(dataperson,headerperson);
				JScrollPane indicate1= new JScrollPane(state1);
				state1.setBounds(148, 111, 419, 245);
				indicate1.setBounds(0, 107, 646, 220);
				indicate1.setVisible(true);
				homepanel.add(indicate1);
				homepanel.setVisible(true);
			}
		});
		sidebarhome.setLayout(null);
		sidebarhome.setBackground(new Color(109, 70, 107));
		sidebarhome.setBounds(0, 268, 300, 53);
		sidebar.add(sidebarhome);
		
		JLabel sidebarpic2 = new JLabel(new ImageIcon("Images/home1.png"));
		sidebarpic2.setBounds(40, 10, 47, 43);
		sidebarhome.add(sidebarpic2);
		
		JLabel homelabel = new JLabel("首頁");
		homelabel.setForeground(Color.WHITE);
		homelabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		homelabel.setBounds(97, 0, 161, 53);
		sidebarhome.add(homelabel);
		

		JPanel sidebarlogout = new JPanel();
		sidebarlogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(sidebarlogout);
			}
			public void mouseExited(MouseEvent e) {
				resetcolor(sidebarlogout);
			}
			public void mouseClicked(MouseEvent e) {
				String operation[] = {"是", "否"}; 
					int operation_option = JOptionPane.showOptionDialog(null, "是否確定登出?", null, 1, 2, null, operation, null);
					if(operation_option == 0){
						JOptionPane.showMessageDialog(null, "登出成功!");
						homepanel.setVisible(false);
						findpanel.setVisible(false);
						dispose();
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Login mainframe = new Login();
									mainframe.setVisible(true);
									Main.save();
									/*while(mainframe.control){
										mainframe.setVisible(true);
									}*/
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
					else{
						JOptionPane.showMessageDialog(null, "登出失敗!");
					}
			}
		});
		sidebarlogout.setLayout(null);
		sidebarlogout.setBackground(new Color(109, 70, 107));
		sidebarlogout.setBounds(0, 319, 300, 53);
		sidebar.add(sidebarlogout);
		
		JLabel sidebarpic5 = new JLabel(new ImageIcon("Images/logout.png"));
		sidebarpic5.setBounds(40, 10, 47, 43);
		sidebarlogout.add(sidebarpic5);
		
		JLabel sidebarlabellogout = new JLabel("\u767B\u51FA");
		sidebarlabellogout.setForeground(Color.WHITE);
		sidebarlabellogout.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		sidebarlabellogout.setBounds(97, 0, 213, 53);
		sidebarlogout.add(sidebarlabellogout);
		
		JPanel sidebarperson = new JPanel();
		sidebarperson.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(sidebarperson);
			}
			public void mouseExited(MouseEvent e) {
				resetcolor(sidebarperson);
			}
			public void mouseClicked(MouseEvent e) {
				String s="姓名: ";
				s+=Main.users.get(Main.loginemail).getName();
				s+="\n帳號: ";
				s+=Main.loginemail;
				s+="\n密碼: ";
				s+=Main.users.get(Main.loginemail).getPassword();
				s+="\n身分: 職員\n目前已借閱";
				s+=Main.users.get(Main.loginemail).getCount();
				s+="本書";
				JOptionPane.showMessageDialog(null, s);
			}
		});
		sidebarperson.setLayout(null);
		sidebarperson.setBackground(new Color(109, 70, 107));
		sidebarperson.setBounds(0, 370, 300, 53);
		sidebar.add(sidebarperson);
		
		JLabel sidebarpic8 = new JLabel(new ImageIcon("Images/register.png"));
		sidebarpic8.setBounds(40, 10, 47, 43);
		sidebarperson.add(sidebarpic8);
		
		JLabel sidebarlabelperson = new JLabel("個人資料");
		sidebarlabelperson.setForeground(Color.WHITE);
		sidebarlabelperson.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		sidebarlabelperson.setBounds(97, 0, 213, 53);
		sidebarperson.add(sidebarlabelperson);
	}
}

