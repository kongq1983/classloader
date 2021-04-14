package com.kq.memory.analysis.demo;

import com.kq.memory.analysis.entity.ArrayEntity;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author kq
 * @date 2021-04-13 14:00
 * @since 2020-0630
 */
public class ArrayIntDemo {

    public static void main(String[] args) {
        ArrayEntity entity = new ArrayEntity();
        System.out.println(ClassLayout.parseInstance(entity).toPrintable());

        int[] array = {1,2,3,4,5,6};
        entity.setArray(array);
        System.out.println(ClassLayout.parseInstance(entity).toPrintable());

        System.out.println(ClassLayout.parseInstance(array).toPrintable());


    }

}
