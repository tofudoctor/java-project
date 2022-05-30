import java.util.*;
import javax.swing.*;
public class Main{
    static HashMap<String, User> users = new HashMap<String, User>();
    static HashMap<String, Book> books = new HashMap<String, Book>();
    public static Book search(){
        String isbn = JOptionPane.showInputDialog(null, "�п�J�n�j�M�����y��isbn:");
        Book b = books.get(isbn);
        if(b != null){
            JOptionPane.showMessageDialog(null, b);
            return b;
        }
        else{
            JOptionPane.showMessageDialog(null, "�d�L����!");
            return b;
        }
    }
    public static void add_user(){
        String identification[] = {"�޲z��", "�ǥ�", "�Ѯv", "¾��"}; 
        int identification_option = JOptionPane.showOptionDialog(null, "�п�ܨ���", null, 1, 1, null, identification, null);
        if(identification_option == 0){//admin
            String new_name = JOptionPane.showInputDialog(null, "�п�J�z���W�r:");
            String new_email = JOptionPane.showInputDialog(null, "�п�J�z��E-mail:");
            String new_password = JOptionPane.showInputDialog(null, "�п�J�z���K�X:");
            users.put(new_email, new Admin(new_name, new_password, new_email));
        }
        else if(identification_option == 1){//student
            String new_name = JOptionPane.showInputDialog(null, "�п�J�z���W�r:");
            String new_email = JOptionPane.showInputDialog(null, "�п�J�z��E-mail:");
            String new_password = JOptionPane.showInputDialog(null, "�п�J�z���K�X:");
            users.put(new_email, new Student(new_name, new_password, new_email));
        }
        else if(identification_option == 2){//teacher
            String new_name = JOptionPane.showInputDialog(null, "�п�J�z���W�r:");
            String new_email = JOptionPane.showInputDialog(null, "�п�J�z��E-mail:");
            String new_password = JOptionPane.showInputDialog(null, "�п�J�z���K�X:");
            users.put(new_email, new Teacher(new_name, new_password, new_email));
        }
        else {//staff
            String new_name = JOptionPane.showInputDialog(null, "�п�J�z���W�r:");
            String new_email = JOptionPane.showInputDialog(null, "�п�J�z��E-mail:");
            String new_password = JOptionPane.showInputDialog(null, "�п�J�z���K�X:");
            users.put(new_email, new Staff(new_name, new_password, new_email));
        }
    }
    public static void main(String[] args){
        while(true){
            String email = JOptionPane.showInputDialog(null, "�п�J�z��E-mail:");
            if(email == null){
                break;
            }
            if(users.containsKey(email)){
                String password = JOptionPane.showInputDialog(null, "�п�J�z���K�X:");
                System.out.print(users.get(email).getPassword());
                if(users.get(email).getPassword().equals(password)){
                    //login success
                    JOptionPane.showMessageDialog(null, "�n�J���\");
                    while(users.get(email).gui());
                }
                else{
                    JOptionPane.showMessageDialog(null, "�K�X���~!");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "�d�L���b��!");
                int new_account_option = JOptionPane.showConfirmDialog(null, "�n�Х߷s�b����?");
                if(new_account_option == 0){//yes
                    add_user();
                }
                else{//no cancel
                    continue;
                }
            }
        }
    } 
}