package com.satan.bookmanager.service;

import com.satan.bookmanager.entity.User;
import com.satan.bookmanager.utils.ConcurrentUtils;
import org.springframework.stereotype.Service;

/**
 * @author: Satan
 * @description:
 * @date: 2021-08-10 13:31
 **/
@Service
public class HostHolder {

    public User getUser() {
        return ConcurrentUtils.getHost();
    }

    public void setUser(User user) {
        ConcurrentUtils.setHost(user);
    }
}
