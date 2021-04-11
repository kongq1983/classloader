package com.kq.memory.analysis.entity;

/**
 * TwoIntEntity
 *
 * @author kq
 * @date 2021/4/10 14:06
 * @since 1.0.0
 */
public class TwoIntEntity {

    private int id;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TwoIntEntity{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
