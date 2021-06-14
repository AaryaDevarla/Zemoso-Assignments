package LMS;

import java.util.List;

import LMS.logger.*;
import LMS.storage.*;

public class LibraryViewer implements IBookView{
    
    IStorageFetch storage;
    public List<Book> listOfBooks;

    public LibraryViewer(String typeOfStorage, ILogger logger)
    {
        this.storage = StorageFactory.getStorage(typeOfStorage, logger);
        this.listOfBooks = this.storage.fetch();
    }

    public void viewAllBooks()
    {
        for(Book book : listOfBooks)
            {
                System.out.println("Name : " + book.getName() + ", Author : " + book.getAuthor());
            }
    }

    public void view(Book book)
    {
        System.out.println("Name : " + book.getName() + " Author : " + book.getAuthor());
    }
}
