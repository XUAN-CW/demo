/**
 * @author XUAN
 * @date 2021/3/17 - 16:49
 * @references
 * @purpose
 * @errors
 */
public class Book {
    String title;
    String author;

    public Book() {
    }
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
