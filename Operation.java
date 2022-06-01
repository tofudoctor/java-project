import javax.swing.JOptionPane;
import java.util.ArrayList;
public class Operation{
  //新增書籍
  public void AddBook(Booklist booklist){
	//輸入書本資訊
	JOptionPane.showMessageDialog(null,"正在新增書籍資訊","新增書籍");
	String Bookname = JOptionPaneshowInputDialog("請輸入書名");
	String author = JOptionPaneshowInputDialog("請輸入作者");
	String publisher = JOptionPaneshowInputDialog("請輸入出版商");
	String type = JOptionPaneshowInputDialog("請輸入型別");
	String page = JOptionPaneshowInputDialog("請輸入頁數");

	BookContent bc = new BookContent(Bookname,author,publisher,type,page);
	booklist.add(bc);
  }

  //刪除書籍
  public void DeleteBook(Booklist booklist){
	JOptionPane.showMessageDialog(null,"正在編刪除書籍資訊","刪除書籍");
	String String Bookname = JOptionPaneshowInputDialog("請輸入書名");
     
 