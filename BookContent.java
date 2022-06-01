public class BookContent{
    
    //設定變數
    private String bookname;
    private String author;
    private String publisher;
    private String type;
    private boolean borrowed;
    private String page;

    //書本的建構子
    public BookContent(String name,String auther,String publisher,String type,String page){
 	 this.name=name;
	 this.author = author;
	 this.publisher = publisher;
	 this.type = type;
	 this.page = page;
    }

    //服務方法
    public void setBookname(String name){
	 this.name=name;
    }
    public String getBookname(){
	 return name;
    }


    public void setPublisher(){
	 this.publisher=publisher;
    }
    public String getPublisher(){
	 return publisher;
    }

    pub1ic void setAuthor(String author){
	 this.author=author;
    }
    public String getAuthor(){
	 return author;
    }

    public void setType(String type){
	 this.type=type;
    }
    public String getType(){
	 return type;
    }

    public void setBorrowed(boolean Borrowed){
	 this.borrowed=borrowed;
    }
    public boolean getBorrowed(){
	 return borrowed;
    }
   
    public void setPage(int page){
	 this.page=page;
    }
    public String getPage(){
	 return page;
    }
}

    