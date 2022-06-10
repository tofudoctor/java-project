import javax.swing.*;
import java.util.*;
import java.awt.EventQueue;
public class Staff extends Member{
    //private int count;
    //constructor
    public Staff(String name, String password, String email){
        super(name, password, email);
        setIden("Staff");
    }
    //service methods
    //functional methods
    public String toString(){
        String s="§A¦n¡A";
        s += getName();
        s += "\n";
        return s;
    }
    public void gui(){
        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui_Staff frame = new Gui_Staff();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
