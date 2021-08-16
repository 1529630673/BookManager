package com.satan.bookmanager.model.enums;

/**
 * @author: Satan
 * @description:
 * @date: 2021-08-10 13:11
 **/
public enum BookStatusEnum {
    NORMAL(0),//正常
    DELETE(1),//删除
    RECOMMENDED(2),//推荐
    ;
    private int value;

    BookStatusEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
