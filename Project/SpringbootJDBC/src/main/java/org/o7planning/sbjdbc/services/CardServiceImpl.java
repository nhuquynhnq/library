package org.o7planning.sbjdbc.services;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.o7planning.sbjdbc.Repository.CardRepository;
import org.o7planning.sbjdbc.model.HibernateUntil;
import org.o7planning.sbjdbc.model.cardbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CardServiceImpl implements CardService{
	@Autowired
    private CardRepository cardRepository;
	

    @Override
    public Iterable<cardbook> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public List<cardbook> search(String q) {
        return cardRepository.findBybooknameLike(q);
    }

    

    @Override
    public void saveCard(cardbook contact) {
     cardRepository.save(contact);
    }
    @Override
    public void deleteCard(Integer id) {
    	cardRepository.deleteById(id);
    }
    @Override
    //  
       public cardbook findByUserId(Integer categoryId,int status) {
    	  return cardRepository.findByIdUser(categoryId,status);
    }

	@Override
 //   @Transactional
    public cardbook findById(Integer categoryId) {
		Session session = HibernateUntil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {  
        	 transaction = session.beginTransaction();
            Query  query =  session.createQuery("from cardbook where id = :Id");
            query.setParameter("Id", categoryId);
            cardbook obj = (cardbook)query.uniqueResult();
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
