
package dao;

import entities.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BookDao implements DaoInterface{
    
    @PersistenceContext(name = "TRestPU")
  EntityManager em;
  
  @Override
  public void addBook(Book b){
      em.persist(b);
  }
  
  @Override
  public void editBook(Book b){
      em.merge(b);
  }
  
  @Override
  public List<Book> findAll(){
      return em.createQuery("Select b from Book b").getResultList();
  }
  
   @Override 
    public Book findById(Integer id){
       return em.find(Book.class, id);
   }
    
    @Override
    public Book findByName(String name){
        return em.find(Book.class, name);
    }
    
    @Override
    public Book findByAuthor(String author){
        return em.find(Book.class, author);
    }

    @Override
    public void removeBook(Integer id){
        em.remove(em.find(Book.class, id));
    }
    
}
