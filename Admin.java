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
import java.io.*;
public class Admin extends User{
    
    //constructor
    public Admin(String name, String password, String email){
        super(name, password, email);
        setIden("Admin");
    }

    
    //functional methods
    public void add_book()throws IOException{
        String isbn = JOptionPane.showInputDialog(null, "�п�Jisbn:");
        String name = JOptionPane.showInputDialog(null, "�п�J�ѦW:");
        String author = JOptionPane.showInputDialog(null, "�п�J�@��:");
        String publisher = JOptionPane.showInputDialog(null, "�п�J�X����:");
	  String page = JOptionPane.showInputDialog("�п�J����");
        Main.books.put(isbn, new Book(isbn, name, author, publisher, page, false, 0, 0, null));
        FileWriter filewriter = new FileWriter("books.txt", true);
        filewriter.write(isbn+" "+name+" "+author+" "+publisher+" "+page+"\r\n");
        filewriter.close();
    }

    //delete books 
    public void delete_book(){
        String isbn = JOptionPane.showInputDialog(null, "�п�J�n�R�����y��isbn:");
        if(Main.books.get(isbn) == null){
            JOptionPane.showMessageDialog(null, "�d�L����!\n�L�k�R��!");
        }
        else{
            Main.books.remove(isbn);
            
        }
    }
    //edit books
    public void modify(){
        String isbn = JOptionPane.showInputDialog(null, "�п�J�n�ק���y��isbn:");
        if(Main.books.get(isbn) == null){
            JOptionPane.showMessageDialog(null, "�d�L����!\n�L�k�ק�!");
        }
        else{
		Main.books.remove(isbn);
		add_book();
        }
    }
    public String toString(){
        String s="�A�n�A";
        s += getName();
        s += " �޲z��\n";
        return s;
    }
    public void gui()throws IOException{
        
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

        /*String operation[] = {"�s�W", "�R��", "�j�M", "�s��" ,"���}"}; 
        int operation_option = JOptionPane.showOptionDialog(null, this.toString()+"�п�ܥ\��", null, 1, 1, null, operation, null);
        if(operation_option == 0){
            add_book();
            return true;
        }
        else if (operation_option == 1){
            delete_book();
            return true;
        }
        else if (operation_option == 2){
            Main.search();
            return true;
        }
	  else if (operation_option == 3){
		modify();
		return true;
	  }
        else{
            return false;
        }*/
    }
}
