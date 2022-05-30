import javax.swing.*;
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
            books.add(Main.books.get(isbn));
            this.count++;
            JOptionPane.showMessageDialog(null, "借書成功");
        }
        else{
            JOptionPane.showMessageDialog(null, "最多借10本!!!");
        }
    }
    public void return_book(){
        String isbn = JOptionPane.showInputDialog(null, "請輸入要還的書籍的isbn:");
        books.remove(Main.books.get(isbn));
        this.count--;
        JOptionPane.showMessageDialog(null, "還書成功");
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
