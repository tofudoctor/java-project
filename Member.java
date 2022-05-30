import java.util.*;
import javax.swing.*;
public abstract class Member extends User{
    protected ArrayList<Book> books = new ArrayList<Book>();
    
    //constructor
    public Member(String name, String password, String email){
        super(name, password, email);
    }
    //functional methods
    
}
