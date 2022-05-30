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
        String isbn = JOptionPane.showInputDialog(null, "�п�J�n�ɪ����y��isbn:");
        if(this.count<=10){
            books.add(Main.books.get(isbn));
            this.count++;
            JOptionPane.showMessageDialog(null, "�ɮѦ��\");
        }
        else{
            JOptionPane.showMessageDialog(null, "�̦h��10��!!!");
        }
    }
    public void return_book(){
        String isbn = JOptionPane.showInputDialog(null, "�п�J�n�٪����y��isbn:");
        books.remove(Main.books.get(isbn));
        this.count--;
        JOptionPane.showMessageDialog(null, "�ٮѦ��\");
    }
    public String toString(){
        String s="�A�n�A";
        s += getName();
        s += " �ǥ�\n";
        return s;
    }
    public boolean gui(){
        String operation[] = {"�ɮ�", "�ٮ�", "�j�M", "���}"}; 
        int operation_option = JOptionPane.showOptionDialog(null, this.toString()+"�п�ܥ\��", null, 1, 1, null, operation, null);
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
