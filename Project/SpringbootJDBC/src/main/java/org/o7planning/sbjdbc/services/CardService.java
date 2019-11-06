package org.o7planning.sbjdbc.services;

import java.util.List;
import java.util.Optional;

import org.o7planning.sbjdbc.model.cardbook;

public interface CardService {
	
	Iterable<cardbook> findAll();

    List<cardbook> search(String q);

   
    public cardbook findById(Integer categoryId);
    
    public cardbook findByUserId(Integer categoryId,int status);
    void saveCard(cardbook contact);

    void deleteCard(Integer  id);
    public cardbook findId(Integer id);
    public cardbook findCard(Integer id);
    public void updateCard(Integer id,int number);
  
}
