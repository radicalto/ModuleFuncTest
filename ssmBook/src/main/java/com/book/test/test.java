package com.book.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class test {
    public static void main(String[] args) {
        int totalPages = (int) Math.ceil((double) 3 / 2);
        System.out.println(totalPages);
    }
}
