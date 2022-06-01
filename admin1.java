public class admin extends User{
  //登入
  public Admin(String name, String password){
    super(name, password);
  }
  Object[] options = {"新增書籍","刪除書籍","編輯書籍","查詢書籍"};
  int response = JOptionPane.showOptionDialog(null,"選擇管理員操作","")