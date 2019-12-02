package com.kq.classloader;

/**
 * PathTest
 *
 * @author kq
 * @date 2019-12-02
 */
public class PathTest {

    public static void main(String[] args) {

        String name = "com.kq.classloader.MyClassLoader";

        String classPath = MyClassLoader.class.getResource("/").getPath();
        System.out.println("classPath="+classPath);
        String fileName = name.replace(".", "/") + ".class" ;
        System.out.println("fileName="+fileName);
    }

}
