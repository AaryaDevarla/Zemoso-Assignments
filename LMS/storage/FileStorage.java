package LMS.storage;

import java.io.*;
import java.util.*;

import LMS.Book;
import LMS.logger.ILogger;



/*
    We are implementing various different storing techniques.
    2 of which are MySQL storage and File storage.
*/

interface FileStorageProperties{
    String URL = "Books.txt";
}

public class FileStorage implements IStorage, FileStorageProperties{

    ILogger logger;

    FileStorage(ILogger logger)
    {
        this.logger = logger;
    }

    public List<Book> fetch()
    {
        List<Book> listOfBooks = new ArrayList<>();
        ObjectInputStream objectReader = null;

        try{
            File file = new File(FileStorageProperties.URL);

            if(!file.exists())
                return listOfBooks;
                
            objectReader = new ObjectInputStream(new FileInputStream(file));

            while(true)
                {
                    Book readBook = (Book)objectReader.readObject();
                    if(readBook == null)
                        break;

                    listOfBooks.add(readBook);
                }
            
            objectReader.close();
        }

        catch(EOFException e)
        {
            
        }

        catch(Exception e)
        {
            this.logger.log(e.getMessage());
        }
    
        return listOfBooks;
    }

    @Override
    public void store(List<Book> listOfBooks)
    {
        try{

            ObjectOutputStream objectWriter = new ObjectOutputStream(new FileOutputStream(new File(URL)));

            for(Book book : listOfBooks)
                objectWriter.writeObject(book);

            objectWriter.close();
        }

        catch(Exception e)
        {
            this.logger.log(e.getMessage());
        }
    }
}
