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

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        for(int i=0;i<100000000;i++) {
            alloc1();
//            alloc1();
//            alloc1();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("spent time = "+(endTime-startTime)+"ms");

    }


}
