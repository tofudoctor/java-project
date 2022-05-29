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
            JOptionPane.showMessageDialog(null, "請輸入超過八個字元!!!");
        }
        else{
            this.password = password;
        }
    }
     
}
