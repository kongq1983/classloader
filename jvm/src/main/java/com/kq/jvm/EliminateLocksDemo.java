package com.kq.jvm;

import com.kq.jvm.entity.Employee;

/**
 * 锁消除例子
 * -XX:+EliminateLocks
 * -XX:-EliminateLocks
 * @author kq
 * @date 2021-04-13 15:46
 * @since 2020-0630
 */
public class EliminateLocksDemo {

    public static void  add(){

        Employee e = new Employee();
        // 不同module不行
//        com.kq.entity.Employee e = new com.kq.entity.Employee();
        synchronized (e) {
            e.setId(1l);
            e.setName("锁消除");
        }
    }



    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        for(int i=0;i<100000000;i++) {
            add();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("spent time "+(endTime-startTime)+"ms");

    }

}
