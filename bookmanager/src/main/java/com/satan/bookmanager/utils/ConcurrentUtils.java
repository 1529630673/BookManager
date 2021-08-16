package com.satan.bookmanager.utils;

import com.satan.bookmanager.entity.User;

/**
 * @author: Satan
 * @description:
 * @date: 2021-08-10 13:33
 **/
public class ConcurrentUtils {

    private static ThreadLocal<User> host = new ThreadLocal<>();

    public static User getHost(){
        return host.get();
    }

    public static void setHost(User user) {
        host.set(user);
    }
}
