package com.kq.memory.analysis.entity;

/**
 * @author kq
 * @date 2021-04-29 11:22
 * @since 2020-0630
 */
public class FinalOneField {

    public char ccc = 'a';
    public char bbb = 'a';
    public final long id = 12345678l;
    public volatile int age;
    public transient int age1;

}
