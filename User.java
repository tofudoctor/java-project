import javax.swing.*;
public class User {
    protected String name;
    protected String password;
    public User(String name, String password){
        setName(name);
        setPassword(password);
    }
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
        if(password.length() <= 8){
            JOptionPane.showMessageDialog(null, "�п�J�W�L�K�Ӧr��!!!");
        }
        else{
            this.password = password;
        }
    }
     
}
