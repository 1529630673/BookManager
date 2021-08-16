package com.satan.bookmanager.controller;

import com.satan.bookmanager.entity.Book;
import com.satan.bookmanager.entity.User;
import com.satan.bookmanager.service.BookService;
import com.satan.bookmanager.service.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


/**
 * (Book)表控制层
 *
 * @author makejava
 * @since 2021-08-10 12:39:31
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private HostHolder hostHolder;

    @RequestMapping(path = {"/index"},method = RequestMethod.GET)
    public String bookList (Model model) {
        User host = hostHolder.getUser();
        if (host != null) {
            model.addAttribute("host",host);
        }
        loadAllBooksView(model);
        return "book/books";
    }

    @RequestMapping(path = {"/books/add"},method = RequestMethod.POST)
    public String addBook(){
        return "book/addBook";
    }

    @RequestMapping(path = {"/books/add/do"},method = RequestMethod.POST)
    public String doAddBook(@RequestParam("name") String name,@RequestParam("author") String author,@RequestParam("price") String price){
        Book book =new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setPrice(price);
        bookService.addBooks(book);

        return "redirect:/index";
    }

    @RequestMapping(path = {"/books/{bookId:[0-9]+}/delete"},method = RequestMethod.GET)
    public String deleteBook(@PathVariable("bookId") int bookId){
        bookService.deleteBooks(bookId);
        return "redirect:/index";
    }

    @RequestMapping(path = {"/books/{bokId:[0-9]+}/recover"},method = RequestMethod.GET)
    public String recoverBook(@PathVariable("bokId") int bookId){
        return "redirect:/index";
    }

    /**
     * 为model加载所有的book
     */
    private void loadAllBooksView(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
    }
}