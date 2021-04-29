package com.kq.memory.analysis.entity;

import com.kq.memory.analysis.demo.Student;

/**
 * @author kq
 * @date 2021-04-29 13:33
 * @since 2020-0630
 */
public class FinalMoreField {

    public final long id = 12345678l;
    public final String OK = "100000";
    private final Student stu1 = new Student();
    public final Student stu = new Student();

}
