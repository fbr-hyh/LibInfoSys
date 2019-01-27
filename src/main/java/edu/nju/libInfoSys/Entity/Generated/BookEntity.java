package edu.nju.libInfoSys.Entity.Generated;

import javax.persistence.*;

@Entity
@Table(name = "Book", schema = "libinfo")
public class BookEntity {
    private String bookId;
    private String bookName;
    private double bookPrice;
    private int bookStatus;

    @Id
    @Column(name = "bookId")
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "bookName")
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Basic
    @Column(name = "bookPrice")
    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Basic
    @Column(name = "bookStatus")
    public int getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(int bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookEntity that = (BookEntity) o;

        if (Double.compare(that.bookPrice, bookPrice) != 0) return false;
        if (bookStatus != that.bookStatus) return false;
        if (bookId != null ? !bookId.equals(that.bookId) : that.bookId != null) return false;
        if (bookName != null ? !bookName.equals(that.bookName) : that.bookName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = bookId != null ? bookId.hashCode() : 0;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        temp = Double.doubleToLongBits(bookPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + bookStatus;
        return result;
    }
}
