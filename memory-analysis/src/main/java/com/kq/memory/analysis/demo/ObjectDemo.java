package com.kq.memory.analysis.demo;

import org.openjdk.jol.info.ClassLayout;

/**
 * ObjectDemo
 *  * -XX:+UseCompressedOops (open)
 *  * -XX:-UseCompressedOops (close)
 * @author kq
 * @date 2021/4/10 13:59
 * @since 1.0.0

 */
public class ObjectDemo {

    public static void main(String[] args) {
//        开启指针压缩时，markword占用8bytes,类型指针占用8bytes，共占用16bytes;
//
//        未开启指针压缩时，markword占用8bytes , 类型指针占用4bytes,但由于java内存地址按照8bytes对齐,
//                长度必须是8的倍数，因此会从12bytes补全到16bytes;
        ClassLayout layout = ClassLayout.parseInstance(new Object());
        System.out.println(layout.toPrintable());
    }

}
