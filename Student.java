import javax.swing.*;
import java.util.*;
public class Student extends Member{
    private int count;
    //constructor
    public Student(String name, String password, String email){
        super(name, password, email);
        setCount(0);
    }
    //service methods
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    //functional methods
    public void borrow_book(){
        String isbn = JOptionPane.showInputDialog(null, "請輸入要借的書籍的isbn:");
        if(this.count<=10){
            Calendar now =  Calendar.getInstance();
            books.add(Main.books.get(isbn));
            this.count++;
            Main.books.get(isbn).setLend(true);
            Main.books.get(isbn).setLend_date(now);
            now.add(Calendar.DATE,5);
            Main.books.get(isbn).setReturn_date(now);
            JOptionPane.showMessageDialog(null, "借書成功\n還書日期為: "+now.get(Calendar.DATE)+"天後");
        }
        else{
            JOptionPane.showMessageDialog(null, "最多借10本!!!");
        }
    }
    public void return_book(){
        Calendar now =  Calendar.getInstance();
        String isbn = JOptionPane.showInputDialog(null, "請輸入要還的書籍的isbn:");
        books.remove(Main.books.get(isbn));
        this.count--;
        if(Main.books.get(isbn).day_difference(now, Main.books.get(isbn).getReturn_date()) > 5){// overdue
            JOptionPane.showMessageDialog(null, "逾期!\n請繳罰金!");
        }
        JOptionPane.showMessageDialog(null, "還書成功");
        Main.books.get(isbn).setLend(false);
        Main.books.get(isbn).setLend_date(null);
        Main.books.get(isbn).setReturn_date(null);
    }
    public String toString(){
        String s="你好，";
        s += getName();
        s += " 學生\n";
        return s;
    }
    public boolean gui(){
        String operation[] = {"借書", "還書", "搜尋", "離開"}; 
        int operation_option = JOptionPane.showOptionDialog(null, this.toString()+"請選擇功能", null, 1, 1, null, operation, null);
        if(operation_option == 0){
            borrow_book();
            return true;
        }
        else if(operation_option == 1){
            return_book();
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
