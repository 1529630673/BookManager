package com.satan.bookmanager.biz;

import com.satan.bookmanager.entity.Ticket;
import com.satan.bookmanager.entity.User;
import com.satan.bookmanager.model.exception.LoginRegisterException;
import com.satan.bookmanager.service.TicketService;
import com.satan.bookmanager.service.UserService;
import com.satan.bookmanager.utils.ConcurrentUtils;
import com.satan.bookmanager.utils.MD5;
import com.satan.bookmanager.utils.TicketUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: Satan
 * @description:
 * @date: 2021-08-11 12:23
 **/
@Service
public class LoginBiz {

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    /**
     * 登录逻辑，先检查邮箱和密码，然后更新t票。
     * @return 返回最新t票
     * @throws Exception 账号密码错误
     */
    public String login(String email,String password)throws Exception{
        User user = userService.getUser(email);

        //登录信息检查
        if (user == null){
            throw new LoginRegisterException("邮箱不存在");
        }
        if (!StringUtils.equals(MD5.next(password),user.getPassword())){
            throw new LoginRegisterException("密码不正确");
        }

        //检查ticket
        Ticket t = ticketService.getTicket(user.getId());
        //如果没有t票，生成一个
        if (t == null){
            t= TicketUtils.next(user.getId());
            ticketService.addTicket(t);
            return t.getTicket();
        }
        //是否过期
        if (t.getExpiredAt().before(new Date())){
            //删除
            ticketService.deleteTicket(user.getId());
        }
        t=TicketUtils.next(user.getId());
        ticketService.addTicket(t);

        ConcurrentUtils.setHost(user);
        return t.getTicket();
    }

    /**
     * 用户退出登录，只需要删除数据库中用户的t票
     * @param t
     */
    public void logout(String t){
        ticketService.deleteTicket(t);
    }

    /**
     * 注册一个用户，并返回用户t票
     *
     * @return 用户当前的t票
     */
    public String register(User user) throws Exception{
        //信息检查
        if (userService.getUser(user.getEmail())!=null){
            throw new LoginRegisterException("用户邮箱已经存在！");
        }

        //密码加密
        String plain = user.getPassword();
        String md5 = MD5.next(plain);
        user.setPassword(md5);
        //数据库添加用户
        userService.addUser(user);

        //生成用户t票
        Ticket ticket = TicketUtils.next(user.getId());
        //数据库添加t票
        ticketService.addTicket(ticket);

        ConcurrentUtils.setHost(user);
        return ticket.getTicket();
    }
}
