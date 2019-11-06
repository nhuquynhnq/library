package org.o7planning.sbjdbc.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.o7planning.sbjdbc.Repository.SachRepository;
import org.o7planning.sbjdbc.dao.BookDao;
import org.o7planning.sbjdbc.model.HibernateUntil;
import org.o7planning.sbjdbc.model.books;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.boot.model.source.internal.hbm.Helper;
import org.hibernate.query.Query;


@Service
public class SachServiceImpl implements SachServices
{
	@Autowired
    private SachRepository sachRepository;
	@Autowired
    private BookDao bookDAO;

    @Override
    public Iterable<books> findAll() {
        return sachRepository.findAll();
    }

    @Override
    public books searchBook(String book) {
    	books result = sachRepository.findBybooknameLike(book);
    	//System.out.print(result.getBookname());
        return sachRepository.findBybooknameLike(book);
    }
    @Override
    public List<books> searchType(String type) {
    	
    	//System.out.print(result.getBookname());
        return sachRepository.findBybooktypeLike(type);
    }
    @Override
    public books searchNameType(String book,String type) {
    	books result = sachRepository.findbookByNameType(book, type);
    	//System.out.print(result.getBookname());
        return sachRepository.findbookByNameType(book, type);
    }

    @Override
  
    public Optional<books> findBookById(Integer id) {
        return sachRepository.findById(id);
    }


    @Override
    public void saveBook(books contact) {
     sachRepository.save(contact);
    }

    @Override
    public void deleteBook(Integer id) {
    	sachRepository.deleteById(id);
    }
    @Override
    public void updateBook(Integer id,int number) {
    	sachRepository.updateBook(id,number);
    }

	@Override
 //   @Transactional
    public books findById(Integer categoryId) {
		Session session = HibernateUntil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {  
        	 transaction = session.beginTransaction();
            Query  query =  session.createQuery("from books where id = :Id");
            query.setParameter("Id", categoryId);
            books obj = (books)query.uniqueResult();
            session.flush();
            transaction.commit();
            return obj;
        } catch (Exception ex) {
        	if (transaction != null) {
                transaction.rollback();
               
            }
            ex.printStackTrace();
        }
        return null;
        
    }
}
