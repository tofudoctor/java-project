import javax.swing.*;
import java.util.*;
public class Staff extends Member{
    private int count;
    //constructor
    public Staff(String name, String password, String email){
        super(name, password, email);
        setIden("Staff");
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
        if(this.count<2){
            Calendar now =  Calendar.getInstance();
            now.add(Calendar.DATE,5);
            Main.books.get(isbn).setLend(true);
            Main.books.get(isbn).setReturn_day(now.get(Calendar.DAY_OF_YEAR));
            Main.books.get(isbn).setReturn_year(now.get(Calendar.YEAR));
            Main.books.get(isbn).setWho(this.getEmail());
            books.add(Main.books.get(isbn));
            this.count++;
            JOptionPane.showMessageDialog(null, "�ɮѦ��\\n�ٮѤ����: "+5+"�ѫ�");
        }
        else{
            JOptionPane.showMessageDialog(null, "�̦h��2��!!!");
        }
    }
    public void return_book(){
        Calendar now = Calendar.getInstance();
        String isbn = JOptionPane.showInputDialog(null, "�п�J�n�٪����y��isbn:");
        books.remove(Main.books.get(isbn));
        this.count--;
        int day= now.get(Calendar.DAY_OF_YEAR);
        int year = now.get(Calendar.YEAR);
        if(Main.books.get(isbn).day_difference(day, Main.books.get(isbn).getReturn_day(), year, Main.books.get(isbn).getReturn_year()) < 0){// overdue
            JOptionPane.showMessageDialog(null, "�O��!\n��ú�@��!");
        }
        JOptionPane.showMessageDialog(null, "�ٮѦ��\");
        Main.books.get(isbn).setLend(false);
        Main.books.get(isbn).setReturn_day(0);
        Main.books.get(isbn).setReturn_year(0);
    }
    public String toString(){
        String s="�A�n�A";
        s += getName();
        s += "\n";
        return s;
    }
    public boolean gui(){
        String operation[] = {"�ɮ�", "�ٮ�", "�j�M","����", "���}"}; 
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
        else if(operation_option == 3){
            String s = "�z�ɤF:";
            for(Book it:books){
                s += it.getName();
                s += "\n";
            }
            JOptionPane.showMessageDialog(null, s);
            return true;
        }
        else{
            return false;
        }
    }
}
