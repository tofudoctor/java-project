import java.util.*;
public class Book {
    private String isbn;
    private String name;
    private String author;
    private String publisher;
    private String page;
    private Calendar lend_date;
    private Calendar return_date;
    private boolean lend;

    //constructor
    public Book(String isbn, String name, String author, String publisher, String page) {
        setIsbn(isbn);
        setName(name);
        setAuthor(author);
        setPublisher(publisher);
        setLend(false);
	setPage(page);
    }


    //service methods
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }


    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    public boolean getLend() {
        return lend;
    }
    public void setLend(boolean lend) {
        this.lend = lend;
    }


    public String getPage() {
	  return page;
    }
    public void setPage(String page) {
	  this.page=page;
    }


    public Calendar getLend_date() {
        return lend_date;
    }
    public void setLend_date(Calendar lend_date) {
        this.lend_date = lend_date;
    }


    public Calendar getReturn_date() {
        return return_date;
    }
    public void setReturn_date(Calendar return_date) {
        this.return_date = return_date;
    }


    //functional methods
    //Count date difference
    public int day_difference(Calendar c1, Calendar c2){
        int day1= c1.get(Calendar.DAY_OF_YEAR);
        int day2 = c2.get(Calendar.DAY_OF_YEAR);
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        if(year1 == year2){
            return day2-day1;
        }
        else{
            int lap = 0;
            for(int i = year1 ; i < year2 ; i++)
            {
                if((i%4==0 && i%100!=0) || i%400==0) //leap year
                {
                    lap  += 366;
                }
                else //not leap year
                {
                    lap  += 365;
                }
            }
            return lap+day2-day1;
        }
    }

    //Output
    public String toString(){
        String s="書名: ";
        s += getName();
        s += "\n作者: ";
        s += getAuthor();
        s += "\nIsbn: ";
        s += getIsbn();
        s += "\n出版商: ";
        s += getPublisher();
	    s += "\n頁數: ";
        s += getPage();
        s += "\n租借狀態: ";
        if(getLend()){
            s += "已借出";
        }
        else{
            s += "未借出";
        }
        s += "\n";
        return s;
    }    
}
