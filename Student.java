public class Student extends Member{
    private int count;
    public Student(String name, String password, int count){
        super(name, password);
        setCount(count);
    }
    
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void borrow_book(Book b){
        books.add(b);
    }
    public void return_book(Book b){
        books.remove(b);
    }
}
