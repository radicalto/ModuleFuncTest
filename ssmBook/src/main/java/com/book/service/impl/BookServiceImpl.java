package com.book.service.impl;


import com.book.dao.BookMapper;
import com.book.domain.Book;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> getBooks() {
        return this.bookMapper.selectBooks();
    }

    @Override
    public Book getBookByNo(String no) {
        return this.bookMapper.selectBookByNo(no);
    }

    @Override
    public void deleteBook(String no) {
        this.bookMapper.deleteBook(no);
    }

    @Override
    public void addBook(Book book) {
        this.bookMapper.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        this.bookMapper.updateBook(book);
    }

    @Override
    public List<Book> getBooksByPage(int start, int pageSize) {
        return this.bookMapper.getBooksByPage(start,pageSize);
    }
}
