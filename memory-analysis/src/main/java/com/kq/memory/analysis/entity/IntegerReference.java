package com.kq.memory.analysis.entity;

import com.kq.memory.analysis.demo.Student;

/**
 * 整个文件8的倍数
 * @author kq
 * @date 2021-04-13 9:51
 * @since 2020-0630
 */
public class IntegerReference {

    /** 4个字节  */
    private int id;
    /** 默认4个字节  指针压缩关闭 8个字节  */
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "IntegerReference{" +
                "id=" + id +
                ", student=" + student +
                '}';
    }
}
