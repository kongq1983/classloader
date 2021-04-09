package com.kq.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author kq
 * @date 2021-04-09 11:15
 * @since 2020-0630
 */
public class StartUpNew {

    public static final String CLASS_PATH = "E:\\githubproject\\classloader\\common\\target\\classes";

    // 动态切换主线程的ClassLoader
    static ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);

    public static void main(String[] args) throws Exception {

        StartUpNew startUpNew = new StartUpNew();

        Thread mainThread = Thread.currentThread();
        scheduledThreadPoolExecutor.scheduleAtFixedRate(startUpNew.mainThread(mainThread),1,5, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(2);

        int i = 0 ;

        while(true){
//            MyClassLoader mcl = new MyClassLoader() ;
//            System.out.println(mcl.getParent());

            System.out.println("start mcl="+Thread.currentThread().getContextClassLoader());
            MyClassLoader mcl = (MyClassLoader)Thread.currentThread().getContextClassLoader();
            System.out.println("after mcl="+mcl);

            Class<?> personClass =  mcl.findClass("com.kq.entity.Employee");

            printClassLoader(personClass);

            Method[] methods = personClass.getDeclaredMethods();

//            for(Method m : methods) {
//                Parameter[] ps = m.getParameters();
//
//                for(Parameter p : ps) {
//                    System.out.println("method:"+m.getName()+" parameter="+p.getName());
//                }
//
//            }

            try {
                Object person =  personClass.newInstance() ;

                //设置name属性
                Method setIdMethod = personClass.getMethod("setId",Long.class);
                setIdMethod.invoke(person,1l);

                //设置name属性
                Method setNameMethod = personClass.getMethod("setName",String.class);
                setNameMethod.invoke(person,"king");

                Method sayHelloMethod = personClass.getMethod("showMessage") ;
                sayHelloMethod.invoke(person) ;
                System.out.println(++i);
            } catch (InstantiationException e1) {
                e1.printStackTrace();
            } catch (IllegalAccessException e1) {
                e1.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(5000) ;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private Runnable mainThread(Thread thread) throws Exception{

//        final ClassLoader classLoader = getClassLoader();
        System.out.println("********************************************************");
        Runnable runnable = ()->{
            MyClassLoader classLoader = new MyClassLoader() ;
            System.out.println("************************定时*******************************");
            thread.setContextClassLoader(classLoader);
        };

        return runnable;
    }

    private ClassLoader getClassLoader() throws Exception{
        MyClassLoader mcl = new MyClassLoader() ;
//        System.out.println(mcl.getParent());
//        Class<?> personClass =  mcl.findClass("com.kq.entity.Employee");

        return mcl;

    }

    private static void printClassLoader(Class clazz){


        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println("start classLoader="+classLoader);
        while(classLoader!=null) {

            classLoader = classLoader.getParent();
            System.out.println("classLoader="+classLoader);
        }


    }

}
