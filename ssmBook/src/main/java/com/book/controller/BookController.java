package com.book.controller;


import com.book.domain.Book;
import com.book.service.BookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/toBooks")
    public String book(HttpServletRequest  request, @RequestParam(defaultValue = "1") int pageNum) {
        int pageSize = 2; // 每页显示的记录数
        List<Book> booksAll = bookService.getBooks();
        List<Book> bookList = bookService.getBooksByPage((pageNum-1)*pageSize,pageSize);
        int size = booksAll.size();// 总记录数
        // 计算总页数
        int totalPages = (int) Math.ceil((double) size / pageSize);
        request.setAttribute("bookList", bookList);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", pageNum);
        return "books";
    }

    @RequestMapping("/doDeleteBook")
    public String doDeleteBook(HttpServletRequest request) {
        String no = request.getParameter("no");
        bookService.deleteBook(no);
        return "redirect:toBooks";
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(Book book) {
        return "addBook";
    }

    @RequestMapping("/doAddBook")
    public String doAddBook(Book book) {
        bookService.addBook(book);
        return "redirect:toBooks";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(HttpServletRequest request) {
        String no = request.getParameter("no");
        Book book = bookService.getBookByNo(no);
        request.setAttribute("book", book);
        return "updateBook";
    }

    @RequestMapping("/doUpdateBook")
    public String doUpdateBook(Book book) {
        bookService.updateBook(book);
        return "redirect:toBooks";
    }

//    @RequestMapping("/list")
//    @ResponseBody
//    public PageInfo<Book> selectByPage(@RequestParam int pageIndex, @RequestParam int pageSize) {
//        PageHelper.startPage(pageIndex,pageSize);
//        List<Book> demoList = bookService.getBooks();
//        PageInfo<Book> pageInfo = new PageInfo<Book>(demoList);
//        return pageInfo;
//    }

}
