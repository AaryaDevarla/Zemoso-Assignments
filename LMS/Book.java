package LMS;

import java.io.Serializable;

/*
    This is a Java Bean.
    It's only work is store data.
*/

public class Book implements Serializable{
    String name;
    String author;
    
    public Book(String name, String author){
        this.name = name;
        this.author = author;
    }

    public String getName()
    {
        return this.name;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String toString()
    {
        return "[Name:"+this.name+",Author:"+this.author+"]";
    }
}