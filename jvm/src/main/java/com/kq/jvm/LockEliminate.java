package com.kq.jvm;


import com.kq.jvm.entity.Employee;

/**
 * Lockliminate
 * 锁消除
 * @author kq
 * @date 2021/4/11 15:36
 * @since 1.0.0
 */
public class LockEliminate{

    public Employee ee;

    public void  addEmployee(){

        Employee e = new Employee();

        synchronized (e) {
            e.setId(1l);
            e.setName("锁消除");
        }

//        System.out.println(e);

    }

    public Employee  getEmployee(){
        Employee e = new Employee();

        synchronized (e) {
            e.setId(1l);
            e.setName("锁消除");
        }

        System.out.println(e);

        return e;

    }

    public void  setEmployee(){
        Employee e = new Employee();

        synchronized (e) {
            e.setId(1l);
            e.setName("锁消除");
        }

        System.out.println(e);

        this.ee = e;

    }

    public void f() {
        Object hollis = new Object();
        synchronized(hollis) {
            System.out.println(hollis);
        }
    }

}
