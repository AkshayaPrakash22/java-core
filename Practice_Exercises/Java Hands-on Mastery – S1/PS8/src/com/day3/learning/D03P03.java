package com.day3.learning;
import java.util.Date;
import java.util.Objects;
import java.util.TreeSet;

class Book implements Comparable<Book> {
     int bookId;
     String title;
     double price;
     String publicationDate;
     String author;

    public Book(int bookId, String title, double price, String publicationDate, String author) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.publicationDate = publicationDate;
        this.author = author;
    }

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", price=" + price + ", publicationDate="
				+ publicationDate + ", author=" + author + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, bookId, price, publicationDate, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && bookId == other.bookId
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(publicationDate, other.publicationDate) && Objects.equals(title, other.title);
	}
   
	@Override
    public int compareTo(Book other) {
        return Integer.compare(this.bookId, other.bookId);
    }
   
}

public class D03P03 {
	
	public static void main(String[] args) {
        // Predefined information of 5 book details
        TreeSet<Book> bookSet = new TreeSet<>();
        bookSet.add(new Book(1001, "Python Learning", 715.0, "2/2/2020", "Martin C.Brown"));
        bookSet.add(new Book(1002, "Modern Mainframe", 295.0, "19/5/1997", "Sharad"));
        bookSet.add(new Book(1003, "Java Programming", 523.0,"12/11/1984", "Gilad Bracha"));
        bookSet.add(new Book(1004, "Read c++", 295.0, "19/11/1984", "Henry Harvin"));
        bookSet.add(new Book(1005, ".Net Platform", 3497.0, "6/3/1984", "Mark J.Price"));

        // Print all the book details
        for (Book book : bookSet) {
            System.out.println(book.bookId + "  " + book.title + "  " + book.price + "  " + book.publicationDate + "  " + book.author);
        }
    }

}
