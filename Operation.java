import javax.swing.JOptionPane;
import java.util.ArrayList;
public class Operation{
  //�s�W���y
  public void AddBook(Booklist booklist){
	//��J�ѥ���T
	JOptionPane.showMessageDialog(null,"���b�s�W���y��T","�s�W���y");
	String Bookname = JOptionPaneshowInputDialog("�п�J�ѦW");
	String author = JOptionPaneshowInputDialog("�п�J�@��");
	String publisher = JOptionPaneshowInputDialog("�п�J�X����");
	String type = JOptionPaneshowInputDialog("�п�J���O");
	String page = JOptionPaneshowInputDialog("�п�J����");

	BookContent bc = new BookContent(Bookname,author,publisher,type,page);
	booklist.add(bc);
  }

  //�R�����y
  public void DeleteBook(Booklist booklist){
	JOptionPane.showMessageDialog(null,"���b�s�R�����y��T","�R�����y");
	String String Bookname = JOptionPaneshowInputDialog("�п�J�ѦW");
     
 