import java.util.*;
import javax.swing.*;
public class Main{
    static HashMap<String, User> users = new HashMap<String, User>();
    static HashMap<String, Book> books = new HashMap<String, Book>();
    public static Book search(){
        String isbn = JOptionPane.showInputDialog(null, "請輸入要搜尋的書籍的isbn:");
        Book b = books.get(isbn);
        if(b != null){
            JOptionPane.showMessageDialog(null, b);
            return b;
        }
        else{
            JOptionPane.showMessageDialog(null, "查無此書!");
            return b;
        }
    }
    public static void add_user(){
        String identification[] = {"管理員", "學生", "老師", "職員"}; 
        int identification_option = JOptionPane.showOptionDialog(null, "請選擇身分", null, 1, 1, null, identification, null);
        if(identification_option == 0){//admin
            String new_name = JOptionPane.showInputDialog(null, "請輸入您的名字:");
            String new_email = JOptionPane.showInputDialog(null, "請輸入您的E-mail:");
            String new_password = JOptionPane.showInputDialog(null, "請輸入您的密碼:");
            users.put(new_email, new Admin(new_name, new_password, new_email));
        }
        else if(identification_option == 1){//student
            String new_name = JOptionPane.showInputDialog(null, "請輸入您的名字:");
            String new_email = JOptionPane.showInputDialog(null, "請輸入您的E-mail:");
            String new_password = JOptionPane.showInputDialog(null, "請輸入您的密碼:");
            users.put(new_email, new Student(new_name, new_password, new_email));
        }
        else if(identification_option == 2){//teacher
            String new_name = JOptionPane.showInputDialog(null, "請輸入您的名字:");
            String new_email = JOptionPane.showInputDialog(null, "請輸入您的E-mail:");
            String new_password = JOptionPane.showInputDialog(null, "請輸入您的密碼:");
            users.put(new_email, new Teacher(new_name, new_password, new_email));
        }
        else {//staff
            String new_name = JOptionPane.showInputDialog(null, "請輸入您的名字:");
            String new_email = JOptionPane.showInputDialog(null, "請輸入您的E-mail:");
            String new_password = JOptionPane.showInputDialog(null, "請輸入您的密碼:");
            users.put(new_email, new Staff(new_name, new_password, new_email));
        }
    }
    public static void main(String[] args){
        while(true){
            String email = JOptionPane.showInputDialog(null, "請輸入您的E-mail:");
            if(email == null){
                break;
            }
            if(users.containsKey(email)){
                String password = JOptionPane.showInputDialog(null, "請輸入您的密碼:");
                System.out.print(users.get(email).getPassword());
                if(users.get(email).getPassword().equals(password)){
                    //login success
                    JOptionPane.showMessageDialog(null, "登入成功");
                    while(users.get(email).gui());
                }
                else{
                    JOptionPane.showMessageDialog(null, "密碼錯誤!");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "查無此帳號!");
                int new_account_option = JOptionPane.showConfirmDialog(null, "要創立新帳號嗎?");
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