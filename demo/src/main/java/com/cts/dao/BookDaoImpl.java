package com.cts.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cts.entity.Book;
@Repository("BookDao")
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Book> listBook() {
		// TODO Auto-generated method stub
		System.out.println("Hello"+sessionFactory);
		System.out.println("From Dao List");
		
		Session session  = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Book> cq = cb.createQuery(Book.class);
		Root<Book> root = cq.from(Book.class);
		
		cq.select(root);
		Query query  = session.createQuery(cq);
		return  query.getResultList();
		
		

		
	}

	@Override

	public void saveBook(Book book) {
		System.out.println("ID IN SAVE UPDATE "+book.getId());
		sessionFactory.getCurrentSession().saveOrUpdate(book);
		System.out.println("Data Saved");
		
	}

	@Override
	public void deleteBook(int id) {
		Session session  = sessionFactory.getCurrentSession();
		Book theBook = session.get(Book.class, id);
		session.delete(theBook);

		
	}
	
	@Override
	public Book getBook(int id){
		Session session  = sessionFactory.getCurrentSession();
		Book theBook = session.get(Book.class, id);
		
		return theBook;
	}

}
