package com.satan.bookmanager.service;

import com.satan.bookmanager.dao.TicketDao;
import com.satan.bookmanager.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * (Ticket)表服务接口
 *
 * @author makejava
 * @since 2021-08-10 12:39:43
 */
@Service
public class TicketService {

    @Autowired
    private TicketDao ticketDao;

    public void addTicket(Ticket t) {
        ticketDao.addTicket(t);
    }

    public Ticket getTicket(int uid) {
        return ticketDao.selectByUserId(uid);
    }

    public Ticket getTicket(String t){
        return ticketDao.selectByTicket(t);
    }

    public void deleteTicket(int tid){
        ticketDao.deleteTicketById(tid);
    }

    public void deleteTicket(String t){
        ticketDao.deleteByTicket(t);
    }


}