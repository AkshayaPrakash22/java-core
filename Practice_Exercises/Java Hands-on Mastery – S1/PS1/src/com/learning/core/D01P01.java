package com.learning.core;

import java.util.Scanner;

public class D01P01 {

	public static Book createBooks() {
		Book book = new Book();
		Scanner s = new Scanner(System.in);
		book.setBook_title(s.nextLine());
		book.setBook_price(s.nextFloat());
		return book;
	}

	public static void showBooks(Book b1) {
		System.out.format("Book Title:" + b1.getBook_title() + " and Price:%.2f", b1.getBook_price());
	}

	public static void main(String[] args) {
		Book b1 = createBooks();
		showBooks(b1);

	}

}
