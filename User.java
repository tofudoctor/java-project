import javax.swing.*;
import java.io.*;
import java.util.*;
public abstract class User {
    public ArrayList<Book> books = new ArrayList<Book>();
    public ArrayList<Book> record = new ArrayList<Book>();
    protected  String name;
    protected static String email;
    protected String password;
    protected String iden;
    protected int count;
    //constructor
    public User(String name, String password, String email){
        setName(name);
        setPassword(password);
        setEmail(email);
    }
    //service methods
    public  String getName() {
        return name;
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        if(password.length() <= 3){
            JOptionPane.showMessageDialog(null, "請輸入超過3個字元!!!");
        }
        else{
            this.password = password;
        }
    }
    public static String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getIden() {
        return iden;
    }
    public void setIden(String iden) {
        this.iden = iden;
    }
    //functional methods
    public abstract void gui()throws IOException; 
}
