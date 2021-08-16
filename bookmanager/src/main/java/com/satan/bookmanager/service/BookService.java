package com.satan.bookmanager.service;

import com.satan.bookmanager.dao.BookDao;
import com.satan.bookmanager.entity.Book;
import com.satan.bookmanager.model.enums.BookStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Book)表服务接口
 *
 * @author makejava
 * @since 2021-08-10 12:39:31
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public List<Book> getAllBooks() {
        return bookDao.selectAll();
    }

    public int addBooks(Book book) {
        return bookDao.addBook(book);
    }

    public void deleteBooks(int id) {
        bookDao.updateBookStatus(id, BookStatusEnum.DELETE.getValue());
    }

    public void recoverBooks(int id){
        bookDao.updateBookStatus(id,BookStatusEnum.NORMAL.getValue());
    }

}