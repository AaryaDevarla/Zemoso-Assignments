package LMS.storage;

import java.util.List;
import LMS.Book;

public interface IStorageStore{
    void store(List<Book> listOfBooks);
}
