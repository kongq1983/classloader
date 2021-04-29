package com.kq.memory.analysis.memory;

import com.kq.memory.analysis.entity.IntEntity;
import com.kq.memory.util.MarkUtl;
import org.openjdk.jol.info.ClassLayout;

/**
 *
 *
 * lock:
 * //    [ptr             | 00]  locked             ptr points to real header on stack
 * //    [header      | 0 | 01]  unlocked           regular object header
 * //    [ptr             | 10]  monitor            inflated lock (header is wapped out)
 * //    [ptr             | 11]  marked             used by markSweep to mark an object
 * //                                               not valid at any other time
 * @author kq
 * @date 2021-04-29 14:28
 * @since 2020-0630
 */
public class SynchronizedDemo  {

    public static void main(String[] args) {

        IntEntity intEntity = new IntEntity();

        System.out.println(ClassLayout.parseInstance(intEntity).toPrintable());

        // unused:25 hash:31 -->| unused:1   age:4    biased_lock:1 lock:2 (normal object)
        // JavaThread*:54 epoch:2 unused:1   age:4    biased_lock:1 lock:2 (biased object)

        // 0x0000 0000 02cb f588
        synchronized (intEntity) {

//            unused:25 hash:31 -->| unused:1   age:4    biased_lock:1 lock:2 (normal object)
//            0x0000000000000001

//            System.out.println(Long.toBinaryString());

            System.out.println(ClassLayout.parseInstance(intEntity).toPrintable());
            System.out.println("Mark = "+Long.toBinaryString(MarkUtl.getMark(intEntity))+"  length="+Long.toBinaryString(MarkUtl.getMark(intEntity)).length()+" hex="+Long.toHexString(MarkUtl.getMark(intEntity)));
            System.out.println("intEntity.hashcode="+intEntity.hashCode()+"  二进制="+Integer.toBinaryString(intEntity.hashCode())+" length="+Integer.toBinaryString(intEntity.hashCode()).length());
        }


    }


    public static void main1(String[] args) {
        // 46921096
        long mark = Long.parseLong("0000000002cbf588",16);
        System.out.println(mark);
        System.out.println(mark+" 二进制: \n" + Long.toBinaryString(mark) + " \n length:"+Long.toBinaryString(mark).length());

        System.out.println("445884362 二进制: \n"+Long.toBinaryString(445884362) );
    }

    // 10    11001011 11110101  10001000
    // 11010 10010011 10100111  11001010
}
