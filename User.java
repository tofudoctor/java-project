import javax.swing.*;
public abstract class User {
    protected String name;
    protected String email;
    protected String password;
    //constructor
    public User(String name, String password, String email){
        setName(name);
        setPassword(password);
        setEmail(email);
    }
    //service methods
    public String getName() {
        return name;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    //functional methods
    public abstract boolean gui(); 
}
