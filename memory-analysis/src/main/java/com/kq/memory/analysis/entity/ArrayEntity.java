package com.kq.memory.analysis.entity;

import java.util.Arrays;

/**
 * @author kq
 * @date 2021-04-13 13:59
 * @since 2020-0630
 */
public class ArrayEntity {

    private int[] array;

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "ArrayEntity{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
