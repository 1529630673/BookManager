package com.satan.bookmanager.dao;

import com.satan.bookmanager.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-10 12:39:49
 */
@Mapper
public interface UserDao {

    String table_name = "user";
    String insert_field = "name,email,password";
    String select_field = "id,"+insert_field;

    @Insert({"insert into",table_name,"(",insert_field,") values (#{name},#{email},#{password})"})
    int addUser(User user);

    @Select({"select",select_field,"from",table_name,"where id=#{id}"})
    User selectById(int id);

    @Select({"select",select_field,"from",table_name,"where name=#{name}"})
    User selectByName(String name);

    @Select({"select",select_field,"from",table_name,"where email=#{email}"})
    User selectByEmail(String email);

    @Update({"update",table_name,"set password=#{password} where id=#{id}"})
    void updatePassword(User user);


}