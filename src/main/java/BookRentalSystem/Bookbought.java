
package BookRentalSystem;

public class Bookbought extends AbstractEvent {

    private Long id;
    private String bookName;
    private Long qyt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public Long getQyt() {
        return qyt;
    }

    public void setQyt(Long qyt) {
        this.qyt = qyt;
    }
}
