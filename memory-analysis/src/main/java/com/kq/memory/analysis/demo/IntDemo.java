package com.kq.memory.analysis.demo;

import com.kq.memory.analysis.entity.IntEntity;
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
        System.out.println(ClassLayout.parseInstance(new IntEntity()).toPrintable());
        System.out.println(ClassLayout.parseInstance(new TwoIntEntity()).toPrintable());
    }

}
