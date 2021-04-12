package com.kq.jvm;

import com.kq.jvm.entity.Animal;
import com.kq.jvm.entity.Employee;

/**
 * OnStackTest
 * 逃逸对象测试
 *　服务器模式：
 * -server
 *
 * -XX:+PrintGC -Xms15M -Xmn15M
 * -XX:+PrintGC -Xms15M -Xmn15M -XX:+DoEscapeAnalysis
 *
 * -server　-XX:+DoEscapeAnalysis　-XX:+EliminateAllocations -XX:+PrintGC
 *
 * 逃逸分析：
 * -XX:+DoEscapeAnalysis
 * -XX:+DoEscapeAnalysis
 *
 * 标量替换：
 * -XX:+EliminateAllocations可以开启标量替换
 * -XX:+PrintEliminateAllocations查看标量替换情况
 *
 * 锁消除：
 * -XX:+EliminateLocks
 *
 * 打印JVM配置参数的命令
 *
 * java -XX:+PrintCommandLineFlags -version
 *
 *
 * -server -XX:+PrintGC -Xms15M -Xmn15M -XX:+PrintCommandLineFlags -XX:+DoEscapeAnalysis　-XX:+EliminateAllocations -XX:+EliminateLocks
 *
 * 命令分析
 * jps
 * 2809 OnStackTest
 * 2810 Jps
 * ➜  ~ jmap -histo 2809\
 *
 * 结论 同个module下，参数有效情况下，在栈中分配，不同module在堆中分配内存
 *
 * @author kq
 * @date 2021/4/11 15:58
 * @since 1.0.0
 */
public class OnStackTest {

    public static void alloc(){
        Animal e = new Animal();
//        e.setId(1l);
        e.setPid(1l);
        e.setName("test");

    }

    public static void alloc1(){
        Employee e = new Employee();
//        e.setId(1l);
        e.setId(1l);
        e.setName("test");

    }

    public static void alloc2(){
        com.kq.entity.Employee1 e = new com.kq.entity.Employee1();
//        e.setId(1l);
        e.setId(1l);
        e.setName("test");
    }

    public static void alloc3(){ //栈
        com.kq.entity.Employee2 e = new com.kq.entity.Employee2();
//        e.setId(1l);
        e.setId(1l);
        e.setName("test");

    }

    public static void alloc4(){ // 堆
        com.kq.entity.Employee4 e = new com.kq.entity.Employee4();
//        e.setId(1l);
        e.setId(1l);
        e.setName("test");

    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        for(int i=0;i<100000000;i++) {
//            alloc2();
//            alloc3();
            alloc4();
//            alloc1();
//            alloc1();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("spent time = "+(endTime-startTime)+"ms");

    }


}
