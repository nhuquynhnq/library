package org.o7planning.sbjdbc.services;

import java.util.List;
import java.util.Optional;

import org.o7planning.sbjdbc.model.books;
import org.springframework.stereotype.Repository;

public interface SachServices {
	Iterable<books> findAll();

    books searchBook(String book);
    List<books> searchType(String type);
    books searchNameType(String book,String type);
   // books search(String book,String type);

    Optional<books> findBookById(Integer id);
    public books findById(Integer Id);

    void saveBook(books contact);

    void deleteBook(Integer  id);
    void updateBook(Integer id,int number);
}
