package com.kq.memory.analysis.demo;

import com.kq.memory.analysis.entity.IntEntity;
import com.kq.memory.analysis.entity.IntegerEntity;
import com.kq.memory.analysis.entity.IntegerReference;
import com.kq.memory.analysis.entity.TwoIntEntity;
import org.openjdk.jol.info.ClassLayout;

/**
 * IntDemo
 *
 * @author kq
 * @date 2021/4/10 14:07
 * @since 1.0.0
 */
public class IntDemo {

    public static void main(String[] args) {
        // int
        System.out.println(ClassLayout.parseInstance(new IntEntity()).toPrintable()); // 16
        //integer
        System.out.println(ClassLayout.parseInstance(new IntegerEntity()).toPrintable()); // 16
        System.out.println(ClassLayout.parseInstance(new TwoIntEntity()).toPrintable()); // 16+4 +4(padding) = 24
        System.out.println(ClassLayout.parseInstance(new IntegerReference()).toPrintable()); //
    }

}
