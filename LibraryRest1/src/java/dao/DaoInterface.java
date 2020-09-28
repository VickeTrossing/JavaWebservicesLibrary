
package dao;

import entities.Book;
import java.util.List;


public interface DaoInterface {
    
        
    void addBook(Book b);
    void editBook(Book b);
    void removeBook(Integer id);
    
    List<Book> findAll();
    
    Book findById(Integer id);
    Book findByName(String name);
    Book findByAuthor(String author);
}
