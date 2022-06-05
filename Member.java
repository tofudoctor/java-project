import java.util.*;
public abstract class Member extends User{
    protected ArrayList<Book> books = new ArrayList<Book>();
    protected int count;
    //constructor
    public Member(String name, String password, String email){
        super(name, password, email);
    }
    //functional methods
    
}
