import javax.swing.*;
public class Teacher extends Member{
    private int count;
    //constructor
    public Teacher(String name, String password, String email){
        super(name, password, email);
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
        if(this.count<=20){
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
        s += " �Ѯv\n";
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
            return_book();Main.search();
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
