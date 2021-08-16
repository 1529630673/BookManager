package com.satan.bookmanager.utils;

import java.util.UUID;

/**
 * @author: Satan
 * @description:
 * @date: 2021-08-11 12:13
 **/
public class UuidUtils {

    public static String next(){
        return UUID.randomUUID().toString().replace("-","a");
    }
}
