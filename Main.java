import java.util.*;
import java.io.*;
import javax.swing.*;
public class Main{
    static HashMap<String, User> users = new HashMap<String, User>();
    static TreeMap<String, Book> books = new TreeMap<String, Book>();
    public static void init()throws IOException{
        //iden name ps email
        File doc1 = new File("users.txt");
        Scanner scanner = new Scanner(doc1);
        while (scanner.hasNextLine()){
            String tmp = scanner.nextLine();
            String tmps[] = tmp.split(" ");
            if(tmps[0].equals("Admin")){
                users.put(tmps[3], new Admin(tmps[1], tmps[2], tmps[3]));
            }
            else if(tmps[0].equals("Student")){
                users.put(tmps[3], new Student(tmps[1], tmps[2], tmps[3]));
            }
            else if(tmps[0].equals("Teacher")){
                users.put(tmps[3], new Teacher(tmps[1], tmps[2], tmps[3]));
            }
            else if(tmps[0].equals("Staff")){
                users.put(tmps[3], new Staff(tmps[1], tmps[2], tmps[3]));
            }
        }
        //isbn bookname author publish page status year day email
        File doc2 = new File("books.txt");
        scanner = new Scanner(doc2);
        while (scanner.hasNextLine()){
            String tmp = scanner.nextLine();
            String tmps[] = tmp.split(" ");
            if(tmps[5].equals("false"))
                books.put(tmps[0], new Book(tmps[0], tmps[1], tmps[2], tmps[3], tmps[4], false, Integer.parseInt(tmps[6]), Integer.parseInt(tmps[7]),tmps[8]));
            else{
                books.put(tmps[0], new Book(tmps[0], tmps[1], tmps[2], tmps[3], tmps[4], true, Integer.parseInt(tmps[6]), Integer.parseInt(tmps[7]),tmps[8]));
                if(users.get(tmps[8]) instanceof Student){
                    Student s = (Student)users.get(tmps[8]);
                    s.books.add(books.get(tmps[0]));
                }
                else if(users.get(tmps[8]) instanceof Teacher){
                    Teacher s = (Teacher)users.get(tmps[8]);
                    s.books.add(books.get(tmps[0]));
                }
                else if(users.get(tmps[8]) instanceof Staff){
                    Staff s = (Staff)users.get(tmps[8]);
                    s.books.add(books.get(tmps[0]));
                }
                
            } 
        }
    }
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
    public static void add_user()throws IOException{
        String identification[] = {"管理員", "學生", "老師", "職員"}; 
        int identification_option = JOptionPane.showOptionDialog(null, "請選擇身分", null, 1, 1, null, identification, null);
        if(identification_option == 0){//admin
            String new_name = JOptionPane.showInputDialog(null, "請輸入您的名字:");
            String new_email = JOptionPane.showInputDialog(null, "請輸入您的E-mail:");
            String new_password = JOptionPane.showInputDialog(null, "請輸入您的密碼:");
            users.put(new_email, new Admin(new_name, new_password, new_email));
            FileWriter filewriter = new FileWriter("users.txt", true);
            filewriter.write("Admin "+new_name+" "+new_password+" "+new_email+ "\r\n");
            filewriter.close();
        }
        else if(identification_option == 1){//student
            String new_name = JOptionPane.showInputDialog(null, "請輸入您的名字:");
            String new_email = JOptionPane.showInputDialog(null, "請輸入您的E-mail:");
            String new_password = JOptionPane.showInputDialog(null, "請輸入您的密碼:");
            users.put(new_email, new Student(new_name, new_password, new_email));
            FileWriter filewriter = new FileWriter("users.txt", true);
            filewriter.write("Student "+new_name+" "+new_password+" "+new_email+ "\r\n");
            filewriter.close();
        }
        else if(identification_option == 2){//teacher
            String new_name = JOptionPane.showInputDialog(null, "請輸入您的名字:");
            String new_email = JOptionPane.showInputDialog(null, "請輸入您的E-mail:");
            String new_password = JOptionPane.showInputDialog(null, "請輸入您的密碼:");
            users.put(new_email, new Teacher(new_name, new_password, new_email));
            FileWriter filewriter = new FileWriter("users.txt", true);
            filewriter.write("Teacher "+new_name+" "+new_password+" "+new_email+ "\r\n");
            filewriter.close();
        }
        else {//staff
            String new_name = JOptionPane.showInputDialog(null, "請輸入您的名字:");
            String new_email = JOptionPane.showInputDialog(null, "請輸入您的E-mail:");
            String new_password = JOptionPane.showInputDialog(null, "請輸入您的密碼:");
            users.put(new_email, new Staff(new_name, new_password, new_email));
            FileWriter filewriter = new FileWriter("users.txt", true);
            filewriter.write("Staff "+new_name+" "+new_password+" "+new_email+ "\r\n");
            filewriter.close();
        }
    }
    public static void save()throws IOException{
        FileWriter filewriter = new FileWriter("books.txt");
        for(Map.Entry<String, Book> it:books.entrySet()){
            filewriter.write(it.getValue().getIsbn()+" "+it.getValue().getName()+" "+it.getValue().getAuthor()+" "+it.getValue().getPublisher()+" "+it.getValue().getPage()+" "+it.getValue().getLend()+" "+it.getValue().getReturn_year()+" "+it.getValue().getReturn_day()+" "+it.getValue().getWho()+"\r\n");
        }
        filewriter.close();
    } 
    public static void main(String[] args)throws IOException{
        init();
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
        save();
    } 
}