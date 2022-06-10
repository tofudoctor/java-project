import javax.swing.*;
import java.util.*;
import java.awt.EventQueue;
public class Student extends Member{
    //private int count;
    //constructor
    public Student(String name, String password, String email){
        super(name, password, email);
        setCount(0);
        setIden("Student");
    }
    //service methods
    //functional methods
    public String toString(){
        String s="你好，";
        s += getName();
        s += " 同學\n";
        return s;
    }
    public void gui(){
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_Student frame = new Gui_Student();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
        /*String operation[] = {"借書", "還書", "搜尋", "紀錄", "離開"}; 
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
        else if(operation_option == 3){
            String s = "您借了:";
            for(Book it:books){
                s += it.getName();
                s += "\n";
            }
            JOptionPane.showMessageDialog(null, s);
            return true;
        }
        else{
            return false;
        }*/
    }
}
