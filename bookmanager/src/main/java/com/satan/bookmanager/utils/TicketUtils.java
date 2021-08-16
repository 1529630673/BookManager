package com.satan.bookmanager.utils;

import com.satan.bookmanager.entity.Ticket;
import org.joda.time.DateTime;

/**
 * @author: Satan
 * @description:
 * @date: 2021-08-11 12:14
 **/
public class TicketUtils {

    public static Ticket next(int uid){

        Ticket ticket = new Ticket();
        ticket.setTicket(UuidUtils.next());
        ticket.setUserId(uid);
        //设置t票过期时间
        DateTime expiredTime = new DateTime();
        expiredTime = expiredTime.plusMonths(3);
        ticket.setExpiredAt(expiredTime.toDate());

        return ticket;
    }
}
