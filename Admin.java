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
        String isbn = JOptionPane.showInputDialog(null, "請輸入isbn:");
        String name = JOptionPane.showInputDialog(null, "請輸入書名:");
        String author = JOptionPane.showInputDialog(null, "請輸入作者:");
        String publisher = JOptionPane.showInputDialog(null, "請輸入出版社:");
	    String page = JOptionPane.showInputDialog("請輸入頁數");
        Main.books.put(isbn, new Book(isbn, name, author, publisher, page));
        FileWriter filewriter = new FileWriter("books.txt", true);
        filewriter.write(isbn+" "+name+" "+author+" "+publisher+" "+page+"\r\n");
        filewriter.close();
    }

    //delete books 
    public void delete_book(){
        String isbn = JOptionPane.showInputDialog(null, "請輸入要刪除書籍的isbn:");
        if(Main.books.get(isbn) == null){
            JOptionPane.showMessageDialog(null, "查無此書!\n無法刪除!");
        }
        else{
            Main.books.remove(isbn);
            
        }
    }
    //edit books
    public void modify(){
        String isbn = JOptionPane.showInputDialog(null, "請輸入要修改書籍的isbn:");
        if(Main.books.get(isbn) == null){
            JOptionPane.showMessageDialog(null, "查無此書!\n無法修改!");
        }
        else{
            Main.books.remove(isbn);
        }
    }
    public String toString(){
        String s="你好，";
        s += getName();
        s += " 管理員\n";
        return s;
    }
    public boolean gui()throws IOException{
        String operation[] = {"新增", "刪除", "搜尋", "離開"}; 
        int operation_option = JOptionPane.showOptionDialog(null, this.toString()+"請選擇功能", null, 1, 1, null, operation, null);
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
