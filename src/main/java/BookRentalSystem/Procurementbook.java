package BookRentalSystem;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Procurementbook_table")
public class Procurementbook {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String bookName;
    private Date regdate;
    private String qty;

    @PostPersist
    public void onPostPersist(){
        Bookbought bookbought = new Bookbought();
        BeanUtils.copyProperties(this, bookbought);
        bookbought.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        BookRentalSystem.external.BookManagement bookManagement = new BookRentalSystem.external.BookManagement();
        // mappings goes here
        ProcurementbookApplication.applicationContext.getBean(BookRentalSystem.external.BookManagementService.class)
            .bookRegistration(bookManagement);


    }


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
    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }




}
