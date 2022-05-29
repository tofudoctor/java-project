import java.util.*;
public class Member extends User{
    protected ArrayList<Book> books = new ArrayList<Book>();
    public Member(String name, String password){
        super(name, password);
    }
}
