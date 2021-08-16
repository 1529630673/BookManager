package com.satan.bookmanager.dao;

import com.satan.bookmanager.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (Book)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-10 12:39:31
 */
@Mapper
public interface BookDao {

    String table_name = " book ";
    String insert_field = " name, author, price ";
    String select_field = " id, status, " + insert_field;

    @Select({"select", select_field, "from", table_name})
    List<Book> selectAll();

    @Insert({"insert into", table_name, "(", insert_field, ") values (#{name},#{author},#{price})"})
    int addBook(Book book);

    @Update({"update ", table_name, " set status=#{status} where id=#{id}"})
    void updateBookStatus(@Param("id") int id, @Param("status") int status);

}