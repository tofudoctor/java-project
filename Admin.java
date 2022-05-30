import javax.swing.*;
public class Admin extends User{
    
    //constructor
    public Admin(String name, String password, String email){
        super(name, password, email);
    }
    //functional methods
    public void add_book(){
        String isbn = JOptionPane.showInputDialog(null, "請輸入isbn:");
        String name = JOptionPane.showInputDialog(null, "請輸入書名:");
        String author = JOptionPane.showInputDialog(null, "請輸入作者:");
        String publisher = JOptionPane.showInputDialog(null, "請輸入出版社:");
        Main.books.put(isbn, new Book(isbn, name, author, publisher));
    }
    public void delete_book(){
        String isbn = JOptionPane.showInputDialog(null, "請輸入要刪除書籍的isbn:");
        if(Main.books.get(isbn) == null){
            JOptionPane.showMessageDialog(null, "查無此書!\n無法刪除!");
        }
        else{
            Main.books.remove(isbn);
        }
    }
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
    public boolean gui(){
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
