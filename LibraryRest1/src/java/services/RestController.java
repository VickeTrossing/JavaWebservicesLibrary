
package services;

import dao.DaoInterface;
import entities.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("entities.book")
public class RestController {
    @Inject
    DaoInterface bdao;
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void createBook(Book b){
        bdao.addBook(b);
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Book> getAll(){
        return bdao.findAll();
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void edit(@PathParam("id") Integer id, Book b){
        bdao.editBook(b);
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Book getById(@PathParam("id") Integer id){
        return bdao.findById(id);
    }
    
    /*@GET
    @Path("{name}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Book getByName(@PathParam("name") String name){
        return bdao.findByName(name);
    }
    
    @GET
    @Path("{author}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Book getByAuthor(@PathParam("author") String author){
        return bdao.findByName(author);
    }*/
    
    @DELETE
    @Path("{id}")
    public void deleteById(@PathParam("id") Integer id){
        bdao.removeBook(id);
    }
}
