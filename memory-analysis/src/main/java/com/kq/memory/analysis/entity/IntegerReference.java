package com.kq.memory.analysis.entity;

/**
 * @author kq
 * @date 2021-04-13 9:51
 * @since 2020-0630
 */
public class IntegerReference {

    private IntegerEntity integerEntity;

    public IntegerEntity getIntegerEntity() {
        return integerEntity;
    }

    public void setIntegerEntity(IntegerEntity integerEntity) {
        this.integerEntity = integerEntity;
    }

    @Override
    public String toString() {
        return "IntegerReference{" +
                "integerEntity=" + integerEntity +
                '}';
    }
}
