package com.satan.bookmanager.dao;

import com.satan.bookmanager.entity.Ticket;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


/**
 * (Ticket)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-10 12:39:43
 */
@Mapper
public interface TicketDao {

    String table_name = "Ticket";
    String insert_field = "user_id,ticket,expired_at";
    String select_field = "id,"+insert_field;

    @Insert({"insert into",table_name,"(",insert_field,") values (#{userId},#{ticket},#{expiredAt})"})
    int addTicket(Ticket ticket);

    @Select({"select",select_field,"from",table_name,"where user_id=#{uid}"})
    Ticket selectByUserId(int uid);

    @Select({"select",select_field,"from",table_name,"where ticket=#{t}"})
    Ticket selectByTicket(String t);

    @Delete({"delete",select_field,"from",table_name,"where id=#{tid}"})
    void deleteTicketById(int tid);

    @Delete({"delete",select_field,"from",table_name,"where ticket=#{t}"})
    void deleteByTicket(String t);

}