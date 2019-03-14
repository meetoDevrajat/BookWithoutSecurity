package com.cts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.dao.BookDao;
import com.cts.entity.Book;
@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	@Transactional
	public void saveBook(Book book) {
		System.out.println("ID IN SERVICE SAVE"+book.getId());
		bookDao.saveBook(book);
		
		
	}

	@Override
	@Transactional
	public List<Book> listallBooks() {
		// TODO Auto-generated method stub
		
		System.out.println("I m In book service");
		return bookDao.listBook();
	}

	@Override
	@Transactional
	public Book getBook(int theId) {
		// TODO Auto-generated method stub
		Book book=bookDao.getBook(theId);
		return book;
	}

	@Override
	@Transactional
	public void deleteBook(int theId) {
		
		bookDao.deleteBook(theId);
	}



}
