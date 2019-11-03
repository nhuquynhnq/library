package org.o7planning.sbjdbc.services;

import java.util.List;
import java.util.Optional;

import org.o7planning.sbjdbc.model.books;
import org.springframework.stereotype.Repository;

public interface SachServices {
	Iterable<books> findAll();

    List<books> search(String q);

    Optional<books> findBookById(Integer id);
    public books findById(Integer categoryId);

    void saveBook(books contact);

    void deleteBook(Integer  id);
    void updateBook(Integer id,int number);
}
