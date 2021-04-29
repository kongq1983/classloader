package com.kq.memory.analysis.demo;

import com.kq.memory.analysis.entity.FinalMoreField;
import com.kq.memory.analysis.entity.FinalOneField;
import com.kq.memory.analysis.entity.StatEntity;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author kq
 * @date 2021-04-29 11:23
 * @since 2020-0630
 */
public class StaticFieldDemo {

    public static void main(String[] args) {

        System.out.println(ClassLayout.parseInstance(new StatEntity()).toPrintable());

    }

}
