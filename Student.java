import javax.swing.*;
public class Student extends Member{
    private int count;
    public Student(String name, String password){
        super(name, password);
        setCount(0);
    }
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void borrow_book(Book b){
        if(count<=10){
            books.add(b);
            count++;
        }
        else{
            JOptionPane.showMessageDialog(null, "³Ì¦h­É10¥»!!!");
        }
    }
    public void return_book(Book b){
        books.remove(b);
        count--;
    }
}
