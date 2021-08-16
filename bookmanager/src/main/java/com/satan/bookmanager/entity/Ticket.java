package com.satan.bookmanager.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Ticket)实体类
 *
 * @author makejava
 * @since 2021-08-10 12:39:43
 */
public class Ticket implements Serializable {
    
    private Object id;
    
    private Integer userId;
    
    private String ticket;
    
    private Date expiredAt;


    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Date getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
    }

}