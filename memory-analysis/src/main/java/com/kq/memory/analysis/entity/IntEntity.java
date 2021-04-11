package com.kq.memory.analysis.entity;

/**
 * IntEntity
 *
 * @author kq
 * @date 2021/4/10 14:05
 * @since 1.0.0
 */
public class IntEntity {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "IntEntity{" +
                "id=" + id +
                '}';
    }
}
