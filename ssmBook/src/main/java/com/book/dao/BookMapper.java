package com.book.dao;



import com.book.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    public List<Book> selectBooks();
    public Book selectBookByNo(String no);
    public void deleteBook(String no);
    public void addBook(Book book);
    public void updateBook(Book book);
    List<Book> getBooksByPage(@Param("start") int start, @Param("pageSize") int pageSize);
}
