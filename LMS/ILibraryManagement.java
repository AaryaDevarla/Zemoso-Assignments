package LMS;

/* 
    
    We create interfaces which are essential for the Library Management System (LMS). (IBookAdd, IBookDelete, IBookView)
    
    We implement those interfaces to another interface (ILibraryManagement) so if a new version of LMS is created 
    they should implement this to work smoothly.

*/

interface IBookAdd{
    boolean add(Book book);
}

interface IBookDelete{
    boolean delete(Book book);
}

interface IBookView{
    void view(Book book);
}

// Marker Interface
public interface ILibraryManagement extends IBookAdd, IBookDelete{}
