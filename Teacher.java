import javax.swing.*;
import java.util.*;
import java.awt.EventQueue;
public class Teacher extends Member{
    //private int count;
    //constructor
    public Teacher(String name, String password, String email){
        super(name, password, email);
        setIden("Teacher");
    }
    //service methods
    //functional methods
    public String toString(){
        String s="你好，";
        s += getName();
        s += " 老師\n";
        return s;
    }
    public void gui(){
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_Teacher frame = new Gui_Teacher();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
