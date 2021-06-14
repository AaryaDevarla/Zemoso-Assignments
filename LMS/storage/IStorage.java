package LMS.storage;

/* 

    This file consists of classes and interfaces regarding how to store the data.

    Since there are many ways to store the data, it can be Database-MySQL, or in files.
    
    For that reason, we are using a common interface so that when the implementation is given it 
    implement necessary methods.

*/

// Marker Interface
public interface IStorage extends IStorageFetch, IStorageStore{
}
