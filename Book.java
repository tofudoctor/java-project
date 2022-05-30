public class Book {
    private String isbn;
    private String name;
    private String author;
    private String publisher;
    private boolean lend;

    //constructor
    public Book(String isbn, String name, String author, String publisher) {
        setIsbn(isbn);
        setName(name);
        setAuthor(author);
        setPublisher(publisher);
        setLend(false);
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
    //functional methods
    public String toString(){
        String s="書名: ";
        s += getName();
        s += "\n作者: ";
        s += getAuthor();
        s += "\nIsbn: ";
        s += getIsbn();
        s += "\n出版商: ";
        s += getPublisher();
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
