package com.cts.dao;

import java.util.List;

import com.cts.entity.Book;

public interface BookDao {
	
	List<Book> listBook();
	public void saveBook(Book book);
	public void deleteBook(int id);
	Book getBook(int id);

	
	

}
