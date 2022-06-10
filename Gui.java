import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.*;
import java.awt.event.*;

public class Gui extends JFrame {

	private JPanel contentPane;
	public JTextField book_name;
	public JTextField author_name;
	public JTextField publisher_name;
	public JTextField pages;
	public JTextField isbn_code;
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
	public Gui() throws IOException{
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


		//add
		JPanel addbookpanel = new JPanel();
		addbookpanel.setBackground(Color.WHITE);
		addbookpanel.setBounds(300, 0, 646, 511);
		contentPane.add(addbookpanel);
		addbookpanel.setLayout(null);
		addbookpanel.setVisible(false);
		
		JPanel decorateout_1 = new JPanel();
		decorateout_1.setBounds(-208, 315, 280, 280);
		//decorateout_1.setOpaque(false);
		addbookpanel.add(decorateout_1);
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
		decorateout_2.setBounds(439, 427, 226, 121);
		addbookpanel.add(decorateout_2);
		
		JPanel decoratein_2 = new JPanel();
		decoratein_2.setBackground(Color.WHITE);
		decoratein_2.setBounds(10, 10, 206, 101);
		decorateout_2.add(decoratein_2);
		
		JPanel decorateout_3 = new JPanel();
		decorateout_3.setLayout(null);
		decorateout_3.setBounds(-53, 274, 86, 78);
		addbookpanel.add(decorateout_3);
		
		JPanel decoratein_3 = new JPanel();
		decoratein_3.setBackground(Color.WHITE);
		decoratein_3.setBounds(10, 10, 66, 58);
		decorateout_3.add(decoratein_3);
		
		JPanel decorateout_4 = new JPanel();
		decorateout_4.setLayout(null);
		decorateout_4.setBounds(579, -62, 86, 160);
		addbookpanel.add(decorateout_4);
		
		JPanel decoratein_4 = new JPanel();
		decoratein_4.setBackground(Color.WHITE);
		decoratein_4.setBounds(10, 10, 66, 140);
		decorateout_4.add(decoratein_4);
		
		JPanel decorateout_5 = new JPanel();
		decorateout_5.setLayout(null);
		decorateout_5.setBounds(149, 20, 49, 50);
		addbookpanel.add(decorateout_5);
		
		JPanel decoratein_5 = new JPanel();
		decoratein_5.setBackground(Color.WHITE);
		decoratein_5.setBounds(10, 10, 29, 30);
		decorateout_5.add(decoratein_5);
		contentPane.setLayout(null);
		
		book_name = new JTextField();
		book_name.setForeground(new Color(0, 0, 0));
		book_name.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		book_name.setBounds(93, 100, 450, 25);
		book_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(109, 70, 107)));
		book_name.setOpaque(false);
		addbookpanel.add(book_name);
		book_name.setColumns(30);
        
		author_name= new JTextField();
		author_name.setForeground(new Color(0, 0, 0));
		author_name.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		author_name.setBounds(93, 167, 450, 25);
		author_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(109, 70, 107)));
		author_name.setOpaque(false);
		addbookpanel.add(author_name);
		author_name.setColumns(30);
		
		publisher_name= new JTextField();
		publisher_name.setForeground(new Color(0, 0, 0));
		publisher_name.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		publisher_name.setBounds(93, 239, 450, 25);
		publisher_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(109, 70, 107)));
		publisher_name.setOpaque(false);
		addbookpanel.add(publisher_name);
		publisher_name.setColumns(30);
		
		pages= new JTextField();
		pages.setForeground(new Color(0, 0, 0));
		pages.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		pages.setBounds(93, 306, 450, 25);
		pages.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(109, 70, 107)));
		pages.setOpaque(false);
		addbookpanel.add(pages);
		pages.setColumns(30);
		
		isbn_code= new JTextField();
		isbn_code.setForeground(new Color(0, 0, 0));
		isbn_code.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		isbn_code.setBounds(93, 375, 450, 25);
		isbn_code.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(109, 70, 107)));
		isbn_code.setOpaque(false);
		addbookpanel.add(isbn_code);
		isbn_code.setColumns(30);
        
        JLabel bookname = new JLabel("\u66F8\u540D");
        bookname.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
        bookname.setBounds(93, 73, 48, 33);
        addbookpanel.add(bookname);
        
        JLabel author = new JLabel("\u4F5C\u8005");
        author.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
        author.setBounds(93, 135, 48, 33);
        addbookpanel.add(author);
        
        JLabel publisher = new JLabel("\u51FA\u7248\u5546");
        publisher.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
        publisher.setBounds(92, 204, 72, 33);
        addbookpanel.add(publisher);
        
        JLabel page = new JLabel("\u9801\u6578");
        page.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
        page.setBounds(93, 274, 48, 33);
        addbookpanel.add(page);
        
        JLabel isbn = new JLabel("isbn\u78BC");
        isbn.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
        isbn.setBounds(93, 338, 71, 33);
        addbookpanel.add(isbn);
        
        JButton addbutton = new JButton("\u65B0\u589E\u66F8\u7C4D");
		addbutton.setBackground(Color.WHITE);
        addbutton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e)  {
				String operation[] = {"是", "否"}; 
        		int operation_option = JOptionPane.showOptionDialog(null, "是否確定新增?", null, 1, 2, null, operation, null);
				if(operation_option == 0){
					String name = book_name.getText(); 
					String isbn = isbn_code.getText(); 
					String author = author_name.getText(); 
					String publisher = publisher_name.getText(); 
					String page = pages.getText(); 
					System.out.println(name);
					System.out.println("added");
					Main.books.put(isbn, new Book(isbn, name, author, publisher, page, false, 0, 0, null));
					JOptionPane.showMessageDialog(null, "新增成功!");
					book_name.setText("");
					author_name.setText("");
					publisher_name.setText("");
					pages.setText("");
					isbn_code.setText("");
				}
				else{
					JOptionPane.showMessageDialog(null, "新增失敗!");
				}	
        	}
        });
        addbutton.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
        addbutton.setBounds(243, 438, 141, 37);
        addbookpanel.add(addbutton);


		//delete
		JPanel deletebookpanel = new JPanel();
		deletebookpanel.setBackground(Color.WHITE);
		deletebookpanel.setBounds(300, 0, 646, 511);
		getContentPane().add(deletebookpanel);
		deletebookpanel.setLayout(null);
		deletebookpanel.setVisible(false);


		JPanel ddecorateout_1 = new JPanel();
		ddecorateout_1.setBounds(-208, 315, 280, 280);
		//decorateout_1.setOpaque(false);
		deletebookpanel.add(ddecorateout_1);
		ddecorateout_1.setLayout(null);
		
		JPanel ddecoratein_1 = new JPanel();
		//decoratein_1.setOpaque(false);
		ddecoratein_1.setBackground(Color.WHITE);
		ddecoratein_1.setBounds(10, 10, 260, 260);
		ddecorateout_1.add(ddecoratein_1);
		ddecoratein_1.setLayout(null);
		
		JPanel ddecorateout_6 = new JPanel();
		ddecorateout_6.setBounds(145, 0, 86, 44);
		ddecoratein_1.add(ddecorateout_6);
		ddecorateout_6.setLayout(null);
		
		JPanel ddecoratein_6 = new JPanel();
		ddecoratein_6.setBackground(Color.WHITE);
		ddecoratein_6.setBounds(10, 0, 66, 34);
		ddecorateout_6.add(ddecoratein_6);
		
		JPanel ddecorateout_2 = new JPanel();
		ddecorateout_2.setLayout(null);
		ddecorateout_2.setBounds(439, 427, 226, 121);
		deletebookpanel.add(ddecorateout_2);
		
		JPanel ddecoratein_2 = new JPanel();
		ddecoratein_2.setBackground(Color.WHITE);
		ddecoratein_2.setBounds(10, 10, 206, 101);
		ddecorateout_2.add(ddecoratein_2);
		
		JPanel ddecorateout_3 = new JPanel();
		ddecorateout_3.setLayout(null);
		ddecorateout_3.setBounds(-53, 274, 86, 78);
		deletebookpanel.add(ddecorateout_3);
		
		JPanel ddecoratein_3 = new JPanel();
		ddecoratein_3.setBackground(Color.WHITE);
		ddecoratein_3.setBounds(10, 10, 66, 58);
		ddecorateout_3.add(ddecoratein_3);
		
		JPanel ddecorateout_4 = new JPanel();
		ddecorateout_4.setLayout(null);
		ddecorateout_4.setBounds(579, -62, 86, 160);
		deletebookpanel.add(ddecorateout_4);
		
		JPanel ddecoratein_4 = new JPanel();
		ddecoratein_4.setBackground(Color.WHITE);
		ddecoratein_4.setBounds(10, 10, 66, 140);
		ddecorateout_4.add(ddecoratein_4);
		
		JPanel ddecorateout_5 = new JPanel();
		ddecorateout_5.setLayout(null);
		ddecorateout_5.setBounds(149, 20, 49, 50);
		deletebookpanel.add(ddecorateout_5);
		
		JPanel ddecoratein_5 = new JPanel();
		ddecoratein_5.setBackground(Color.WHITE);
		ddecoratein_5.setBounds(10, 10, 29, 30);
		ddecorateout_5.add(ddecoratein_5);


		disbn_code = new JTextField();
		disbn_code.setForeground(new Color(0, 0, 0));
		disbn_code.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		disbn_code.setBounds(93, 239, 450, 25);
		disbn_code.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(109, 70, 107)));
		disbn_code.setOpaque(false);
		deletebookpanel.add(disbn_code);
		disbn_code.setColumns(30);

		JLabel disbn = new JLabel("isbn\u78BC");
        disbn.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
        disbn.setBounds(92, 204, 72, 33);
        deletebookpanel.add(disbn);

		JButton deletebutton = new JButton("\u522A\u9664\u66F8\u7C4D");
		deletebutton.setBackground(Color.WHITE);
        deletebutton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
				String isbn = disbn_code.getText();
				if(Main.books.get(isbn) == null){
					JOptionPane.showMessageDialog(null, "查無此書!\n無法刪除!");
				}
				else{
					String operation[] = {"是", "否"}; 
					int operation_option = JOptionPane.showOptionDialog(null, "是否確定刪除?", null, 1, 2, null, operation, null);
					if(operation_option == 0){
						Main.books.remove(isbn);
						JOptionPane.showMessageDialog(null, "刪除成功!");
						disbn_code.setText("");
					}
					else{
						JOptionPane.showMessageDialog(null, "刪除失敗!");
					}	
					
				}
				
        	}
        });
        deletebutton.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
        deletebutton.setBounds(243, 438, 141, 37);
        deletebookpanel.add(deletebutton);

		//modify
		JPanel modifybookpanel = new JPanel();
		modifybookpanel.setBackground(Color.WHITE);
		modifybookpanel.setBounds(300, 0, 646, 511);
		getContentPane().add(modifybookpanel);
		modifybookpanel.setLayout(null);
		modifybookpanel.setVisible(false);


		JPanel mdecorateout_1 = new JPanel();
		mdecorateout_1.setBounds(-208, 315, 280, 280);
		//decorateout_1.setOpaque(false);
		modifybookpanel.add(mdecorateout_1);
		mdecorateout_1.setLayout(null);
		
		JPanel mdecoratein_1 = new JPanel();
		//decoratein_1.setOpaque(false);
		mdecoratein_1.setBackground(Color.WHITE);
		mdecoratein_1.setBounds(10, 10, 260, 260);
		mdecorateout_1.add(mdecoratein_1);
		mdecoratein_1.setLayout(null);
		
		JPanel mdecorateout_6 = new JPanel();
		mdecorateout_6.setBounds(145, 0, 86, 44);
		mdecoratein_1.add(mdecorateout_6);
		mdecorateout_6.setLayout(null);
		
		JPanel mdecoratein_6 = new JPanel();
		mdecoratein_6.setBackground(Color.WHITE);
		mdecoratein_6.setBounds(10, 0, 66, 34);
		mdecorateout_6.add(mdecoratein_6);
		
		JPanel mdecorateout_2 = new JPanel();
		mdecorateout_2.setLayout(null);
		mdecorateout_2.setBounds(439, 427, 226, 121);
		modifybookpanel.add(mdecorateout_2);
		
		JPanel mdecoratein_2 = new JPanel();
		mdecoratein_2.setBackground(Color.WHITE);
		mdecoratein_2.setBounds(10, 10, 206, 101);
		mdecorateout_2.add(mdecoratein_2);
		
		JPanel mdecorateout_3 = new JPanel();
		mdecorateout_3.setLayout(null);
		mdecorateout_3.setBounds(-53, 274, 86, 78);
		modifybookpanel.add(mdecorateout_3);
		
		JPanel mdecoratein_3 = new JPanel();
		mdecoratein_3.setBackground(Color.WHITE);
		mdecoratein_3.setBounds(10, 10, 66, 58);
		mdecorateout_3.add(mdecoratein_3);
		
		JPanel mdecorateout_4 = new JPanel();
		mdecorateout_4.setLayout(null);
		mdecorateout_4.setBounds(579, -62, 86, 160);
		modifybookpanel.add(mdecorateout_4);
		
		JPanel mdecoratein_4 = new JPanel();
		mdecoratein_4.setBackground(Color.WHITE);
		mdecoratein_4.setBounds(10, 10, 66, 140);
		mdecorateout_4.add(mdecoratein_4);
		
		JPanel mdecorateout_5 = new JPanel();
		mdecorateout_5.setLayout(null);
		mdecorateout_5.setBounds(149, 20, 49, 50);
		modifybookpanel.add(mdecorateout_5);
		
		JPanel mdecoratein_5 = new JPanel();
		mdecoratein_5.setBackground(Color.WHITE);
		mdecoratein_5.setBounds(10, 10, 29, 30);
		mdecorateout_5.add(mdecoratein_5);
		
		
		mbook_name = new JTextField();
		mbook_name.setForeground(new Color(0, 0, 0));
		mbook_name.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		mbook_name.setBounds(93, 100, 450, 25);
		mbook_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(109, 70, 107)));
		mbook_name.setOpaque(false);
		modifybookpanel.add(mbook_name);
		mbook_name.setColumns(30);
        
		mauthor_name= new JTextField();
		mauthor_name.setForeground(new Color(0, 0, 0));
		mauthor_name.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		mauthor_name.setBounds(93, 167, 450, 25);
		mauthor_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(109, 70, 107)));
		mauthor_name.setOpaque(false);
		modifybookpanel.add(mauthor_name);
		mauthor_name.setColumns(30);
		
		mpublisher_name= new JTextField();
		mpublisher_name.setForeground(new Color(0, 0, 0));
		mpublisher_name.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		mpublisher_name.setBounds(93, 239, 450, 25);
		mpublisher_name.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(109, 70, 107)));
		mpublisher_name.setOpaque(false);
		modifybookpanel.add(mpublisher_name);
		mpublisher_name.setColumns(30);
		
		mpages= new JTextField();
		mpages.setForeground(new Color(0, 0, 0));
		mpages.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		mpages.setBounds(93, 306, 450, 25);
		mpages.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(109, 70, 107)));
		mpages.setOpaque(false);
		modifybookpanel.add(mpages);
		mpages.setColumns(30);
		
		misbn_code= new JTextField();
		misbn_code.setForeground(new Color(0, 0, 0));
		misbn_code.setFont(new Font("微軟正黑體", Font.PLAIN, 16));
		misbn_code.setBounds(93, 375, 450, 25);
		misbn_code.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(109, 70, 107)));
		misbn_code.setOpaque(false);
		modifybookpanel.add(misbn_code);
		misbn_code.setColumns(30);
        
        JLabel mbookname = new JLabel("\u66F8\u540D");
        mbookname.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
        mbookname.setBounds(93, 73, 48, 33);
        modifybookpanel.add(mbookname);
        
        JLabel mauthor = new JLabel("\u4F5C\u8005");
        mauthor.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
        mauthor.setBounds(93, 135, 48, 33);
        modifybookpanel.add(mauthor);
        
        JLabel mpublisher = new JLabel("\u51FA\u7248\u5546");
        mpublisher.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
        mpublisher.setBounds(92, 204, 72, 33);
        modifybookpanel.add(mpublisher);
        
        JLabel mpage = new JLabel("\u9801\u6578");
        mpage.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
        mpage.setBounds(93, 274, 48, 33);
        modifybookpanel.add(mpage);
        
        JLabel misbn = new JLabel("isbn\u78BC");
        misbn.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
        misbn.setBounds(93, 338, 71, 33);
        modifybookpanel.add(misbn);
        
        JButton modifybutton = new JButton("\u4FEE\u6539\u66F8\u7C4D");
		modifybutton.setBackground(Color.WHITE);
        modifybutton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
				String name = mbook_name.getText(); 
				String isbn = misbn_code.getText(); 
        		String author = mauthor_name.getText(); 
        		String publisher = mpublisher_name.getText(); 
	    		String page = mpages.getText();
				if(Main.books.get(isbn) == null){
					JOptionPane.showMessageDialog(null, "查無此書!\n無法修改!");
				}
				else{
					String operation[] = {"是", "否"}; 
					int operation_option = JOptionPane.showOptionDialog(null, "是否確定修改?", null, 1, 2, null, operation, null);
					if(operation_option == 0){
						if(name.equals("")) name = Main.books.get(isbn).getName();
						if(author.equals("")) author = Main.books.get(isbn).getAuthor();
						if(publisher.equals("")) publisher = Main.books.get(isbn).getPublisher();
						if(page.equals("")) page = Main.books.get(isbn).getPage();
						Main.books.put(isbn, new Book(isbn, name, author, publisher, page, false, 0, 0, null));
						JOptionPane.showMessageDialog(null, "修改成功!");
						mbook_name.setText("");
						mauthor_name.setText("");
						mpublisher_name.setText("");
						mpages.setText("");
						misbn_code.setText("");
					}
					else{
						JOptionPane.showMessageDialog(null, "修改失敗!");
					}
				}
        		
        	}
        });
        modifybutton.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
        modifybutton.setBounds(243, 438, 141, 37);
        modifybookpanel.add(modifybutton);
		

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
		teamlabel.setBounds(40, 50, 227, 60);
		sidebar.add(teamlabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 134, 280, 19);
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
				addbookpanel.setVisible(false);
				modifybookpanel.setVisible(false);
				deletebookpanel.setVisible(false);
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
		sidebarsearch.setBounds(0, 163, 300, 53);
		sidebar.add(sidebarsearch);
		
		JLabel sidebarpic1 = new JLabel(new ImageIcon("Images/find.png"));
		sidebarpic1.setBounds(40, 10, 47, 43);
		sidebarsearch.add(sidebarpic1);
		
		JLabel findlabel = new JLabel("\u67E5\u8A62\u66F8\u7C4D");
		findlabel.setForeground(Color.WHITE);
		findlabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		findlabel.setBounds(97, 0, 161, 53);
		sidebarsearch.add(findlabel);
		
		JPanel sidebaradd = new JPanel();
		sidebaradd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(sidebaradd);
			}
			public void mouseExited(MouseEvent e) {
				resetcolor(sidebaradd);
			}
			public void mouseClicked(MouseEvent e) {
				addbookpanel.setVisible(true);
				modifybookpanel.setVisible(false);
				deletebookpanel.setVisible(false);
				findpanel.setVisible(false);
			}
		});
		sidebaradd.setLayout(null);
		sidebaradd.setBackground(new Color(109, 70, 107));
		sidebaradd.setBounds(0, 215, 300, 53);
		sidebar.add(sidebaradd);
		
		JLabel sidebarpic2 = new JLabel(new ImageIcon("Images/add.png"));
		sidebarpic2.setBounds(40, 10, 47, 43);
		sidebaradd.add(sidebarpic2);
		
		JLabel borrowlabel = new JLabel("\u65B0\u589E\u66F8\u7C4D");
		borrowlabel.setForeground(Color.WHITE);
		borrowlabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		borrowlabel.setBounds(97, 0, 161, 53);
		sidebaradd.add(borrowlabel);
		
		JPanel sidebardelete = new JPanel();
		sidebardelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(sidebardelete);
			}
			public void mouseExited(MouseEvent e) {
				resetcolor(sidebardelete);
			}
			public void mouseClicked(MouseEvent e) {
				addbookpanel.setVisible(false);
				modifybookpanel.setVisible(false);
				deletebookpanel.setVisible(true);
				findpanel.setVisible(false);
			}
		});
		sidebardelete.setLayout(null);
		sidebardelete.setBackground(new Color(109, 70, 107));
		sidebardelete.setBounds(0, 268, 300, 53);
		sidebar.add(sidebardelete);
		
		JLabel sidebarpic3 = new JLabel(new ImageIcon("Images/delete.png"));
		sidebarpic3.setBounds(40, 10, 47, 43);
		sidebardelete.add(sidebarpic3);
		
		JLabel deletelabel = new JLabel("\u522A\u9664\u66F8\u7C4D");
		deletelabel.setForeground(Color.WHITE);
		deletelabel.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		deletelabel.setBounds(97, 0, 203, 53);
		sidebardelete.add(deletelabel);
		
		JPanel sidebarmodify = new JPanel();
		sidebarmodify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setcolor(sidebarmodify);
			}
			public void mouseExited(MouseEvent e) {
				resetcolor(sidebarmodify);
			}
			public void mouseClicked(MouseEvent e) {
				addbookpanel.setVisible(false);
				modifybookpanel.setVisible(true);
				deletebookpanel.setVisible(false);
				findpanel.setVisible(false);
			}
		});
		sidebarmodify.setLayout(null);
		sidebarmodify.setBackground(new Color(109, 70, 107));
		sidebarmodify.setBounds(0, 319, 300, 53);
		sidebar.add(sidebarmodify);
		
		JLabel sidebarpic4 = new JLabel(new ImageIcon("Images/modify.png"));
		sidebarpic4.setBounds(40, 10, 47, 43);
		sidebarmodify.add(sidebarpic4);
		
		JLabel sidebarlabelmodify = new JLabel("\u4FEE\u6539\u66F8\u7C4D");
		sidebarlabelmodify.setForeground(Color.WHITE);
		sidebarlabelmodify.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		sidebarlabelmodify.setBounds(97, 0, 213, 53);
		sidebarmodify.add(sidebarlabelmodify);
		

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
						addbookpanel.setVisible(false);
						modifybookpanel.setVisible(false);
						deletebookpanel.setVisible(false);
						findpanel.setVisible(false);
						dispose();
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									login mainframe = new login();
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
		sidebarlogout.setBounds(0, 371, 300, 53);
		sidebar.add(sidebarlogout);
		
		JLabel sidebarpic5 = new JLabel(new ImageIcon("Images/logout.png"));
		sidebarpic5.setBounds(40, 10, 47, 43);
		sidebarlogout.add(sidebarpic5);
		
		JLabel sidebarlabellogout = new JLabel("\u767B\u51FA");
		sidebarlabellogout.setForeground(Color.WHITE);
		sidebarlabellogout.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		sidebarlabellogout.setBounds(97, 0, 213, 53);
		sidebarlogout.add(sidebarlabellogout);
		
		JPanel sidebarisbnsearch = new JPanel();
		sidebarisbnsearch.setVisible(false);
		sidebarisbnsearch.setLayout(null);
		sidebarisbnsearch.setBackground(new Color(109, 70, 107));
		sidebarisbnsearch.setBounds(0, 215, 300, 53);
		sidebar.add(sidebarisbnsearch);
		
		JLabel sidebarpic6 = new JLabel("");
		sidebarpic6.setIcon(new ImageIcon("Images/isbnsearch.png"));
		sidebarpic6.setBounds(40, 10, 47, 43);
		sidebarisbnsearch.add(sidebarpic6);
		
		/*JLabel sidebarlabelisbnsearsh = new JLabel("\u4EE5ISBN\u641C\u5C0B(\u8F03\u5FEB)");
		sidebarlabelisbnsearsh.setForeground(Color.WHITE);
		sidebarlabelisbnsearsh.setFont(new Font("微軟正黑體", Font.BOLD, 24));
		sidebarlabelisbnsearsh.setBounds(97, 0, 213, 53);
		sidebarisbnsearch.add(sidebarlabelisbnsearsh);
		sidebarisbnsearch.setVisible(false);*/
	}
}
