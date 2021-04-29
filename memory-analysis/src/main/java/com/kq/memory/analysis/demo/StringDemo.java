package com.kq.memory.analysis.demo;

import org.openjdk.jol.info.ClassLayout;

/**
 *  * -XX:+UseCompressedOops (open)
 *  * -XX:-UseCompressedOops (close)
 * @author kq
 * @date 2021-04-13 13:45
 * @since 2020-0630
 */
public class StringDemo {

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance("abc").toPrintable());
        System.out.println(ClassLayout.parseInstance("hello world").toPrintable());
    }

//    OFF  SZ     TYPE DESCRIPTION               VALUE
//            0   8          (object header: mark)     0x0000000000000001 (non-biasable; age: 0)
//            8   4          (object header: class)    0xf80002da
//            12   4   char[] String.value              [a, b, c]
//            16   4      int String.hash               0
//            20   4          (object alignment gap)
//    Instance size: 24 bytes
//    Space losses: 0 bytes internal + 4 bytes external = 4 bytes total


//    OFF  SZ     TYPE DESCRIPTION               VALUE
//            0   8          (object header: mark)     0x0000000000000001 (non-biasable; age: 0)
//            8   8          (object header: class)    0x000000001c1f8f78
//            16   8   char[] String.value              [a, b, c]
//            24   4      int String.hash               0
//            28   4          (object alignment gap)
//    Instance size: 32 bytes
//    Space losses: 0 bytes internal + 4 bytes external = 4 bytes total

}
