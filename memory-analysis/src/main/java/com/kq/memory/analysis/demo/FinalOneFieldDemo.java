package com.kq.memory.analysis.demo;

import com.kq.memory.analysis.entity.FinalMoreField;
import com.kq.memory.analysis.entity.FinalOneField;
import com.kq.memory.analysis.entity.NormalLongField;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author kq
 * @date 2021-04-29 11:23
 * @since 2020-0630
 */
public class FinalOneFieldDemo {

    public static void main(String[] args) {

        longPrepare();
//        otherPrepare();
    }

    public static void longPrepare(){
        System.out.println(ClassLayout.parseInstance(new FinalOneField()).toPrintable());
        System.out.println(ClassLayout.parseInstance(new NormalLongField()).toPrintable());
    }

    public static void otherPrepare(){

        // 16个字节  8 个mark 4 个kclass  4 个补齐
        System.out.println(ClassLayout.parseInstance(new Object()).toPrintable());
        // 16个字节  8 个mark 4 个kclass  4 个补齐  忽略final的
        System.out.println(ClassLayout.parseInstance(new FinalOneField()).toPrintable());

        System.out.println(ClassLayout.parseInstance(new FinalMoreField()).toPrintable());

    }

}
