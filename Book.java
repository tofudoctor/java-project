public class Book {
    private String isbn;
    private String name;
    private String author;
    private String publisher;
    private String page;
    private int return_day;
    private int return_year;
    private String who;
    private boolean lend;

    //constructor
    public Book(String isbn, String name, String author, String publisher, String page, boolean lend, int return_year, int return_day, String who) {
        setIsbn(isbn);
        setName(name);
        setAuthor(author);
        setPublisher(publisher);
        setLend(lend);
	    setPage(page);
        setReturn_day(return_day);
        setReturn_year(return_year);
        setWho(who);
    }
    public Book(String isbn, String name, String author, String publisher, String page, boolean lend) {
        setIsbn(isbn);
        setName(name);
        setAuthor(author);
        setPublisher(publisher);
        setLend(lend);
	    setPage(page);
        setReturn_day(0);
        setReturn_year(0);
        setWho(null);
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
    public int getReturn_day() {
        return return_day;
    }
    public void setReturn_day(int return_day) {
        this.return_day = return_day;
    }
    public int getReturn_year() {
        return return_year;
    }
    public void setReturn_year(int return_year) {
        this.return_year = return_year;
    }
    public String getWho() {
        return who;
    }
    public void setWho(String who) {
        this.who = who;
    }


    //functional methods
    //Count date difference
    public int day_difference(int day_now, int day_return, int year_now, int year_return){
        if(year_now == year_return){
            return day_return-day_now;
        }
        else{
            int lap = 0;
            for(int i = year_now ; i < year_return ; i++)
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
            return lap+day_return-day_now;
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
