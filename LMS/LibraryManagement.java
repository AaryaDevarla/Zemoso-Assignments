package LMS;

import java.util.List;

import LMS.logger.*;
import LMS.storage.*;

/*
    In this file, we implement ILibraryManagement interface based on the given behaviour of add, delete methods.
*/

public class LibraryManagement implements ILibraryManagement
{
    List<Book> listOfBooks;
    IStorage storage;

    public LibraryManagement(String typeOfStorage, ILogger logger)
    {
        this.storage = StorageFactory.getStorage(typeOfStorage, logger);
        listOfBooks = this.storage.fetch();
    }

    public boolean add(Book book)
    {
        listOfBooks.add(book);
        return true;
    }

    public boolean delete(Book book)
    {
        int index = findBookIndex(book.name, book.author);
        if(index == -1)
            return false;

        listOfBooks.remove(index);
        return true;
    }

    protected int findBookIndex(String name, String author)
    {
        for(int i=0;i<listOfBooks.size();i++)
            if(name.equals(listOfBooks.get(i).name) && author.equals(listOfBooks.get(i).author))
                return i;

        return -1;
    }

    public void saveData()
    {
        this.storage.store(listOfBooks);
    }
}