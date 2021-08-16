package com.satan.bookmanager.interceptor;

import com.satan.bookmanager.entity.Ticket;
import com.satan.bookmanager.entity.User;
import com.satan.bookmanager.service.TicketService;
import com.satan.bookmanager.service.UserService;
import com.satan.bookmanager.utils.ConcurrentUtils;
import com.satan.bookmanager.utils.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author: Satan
 * @description:
 * @date: 2021-08-14 11:16
 **/
@Component
public class HostInfoInterceptor implements HandlerInterceptor {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    /**
     * 为注入host信息
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        String t = CookieUtils.getCookie("t",request);
        if (!StringUtils.isEmpty(t)){
            Ticket ticket = ticketService.getTicket(t);
            if (ticket != null&&ticket.getExpiredAt().after(new Date())){
                User host = userService.getUser(ticket.getUserId());
                ConcurrentUtils.setHost(host);
            }
        }
        return true;
    }
}
