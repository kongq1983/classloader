package com.kq.jvm;

import com.kq.jvm.entity.Employee;

/**
 *
 *   逃逸分析：
 *  * -XX:+DoEscapeAnalysis
 *  * -XX:+DoEscapeAnalysis
 *  *
 *  * 标量替换：
 *  * -XX:+EliminateAllocations可以开启标量替换
 *  * -XX:+PrintEliminateAllocations查看标量替换情况
 *
 *
 *  锁消除：
 *  * -XX:+EliminateLocks
 *
 *  -server -XX:+PrintGC -Xms15M -Xmn15M -XX:+PrintCommandLineFlags -XX:+DoEscapeAnalysis　-XX:+EliminateAllocations -XX:+EliminateLocks
 *
 * @author kq
 * @date 2021-04-13 16:12
 * @since 2020-0630
 */
public class OnStackDemo {

    public static void alloc(){
        Employee e = new Employee();
//        e.setId(1l);
        e.setId(1l);
        e.setName("test");
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        for(int i=0;i<100000000;i++) {
            alloc();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("spent time = "+(endTime-startTime)+"ms");
    }

}
