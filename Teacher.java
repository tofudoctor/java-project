import javax.swing.*;
public class Teacher extends Member{
    private int count;
    public Teacher(String name, String password){
        super(name, password);
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void borrow_book(Book b){
        if(count<=20){
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
