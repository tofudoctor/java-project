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
        Main.books.put(isbn, new Book(isbn, name, author, publisher, page));
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
        }
    }
    public String toString(){
        String s="�A�n�A";
        s += getName();
        s += " �޲z��\n";
        return s;
    }
    public boolean gui()throws IOException{
        String operation[] = {"�s�W", "�R��", "�j�M", "���}"}; 
        int operation_option = JOptionPane.showOptionDialog(null, this.toString()+"�п�ܥ\��", null, 1, 1, null, operation, null);
        if(operation_option == 0){
            add_book();
            return true;
        }
        else if(operation_option == 1){
            delete_book();
            return true;
        }
        else if(operation_option == 2){
            Main.search();
            return true;
        }
        else{
            return false;
        }
    }
}
