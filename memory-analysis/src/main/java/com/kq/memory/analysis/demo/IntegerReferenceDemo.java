package com.kq.memory.analysis.demo;

import com.kq.memory.analysis.entity.IntegerReference;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author kq
 * @date 2021-04-13 9:52
 * @since 2020-0630
 */
public class IntegerReferenceDemo {

    // 不设置或者  -XX:+UseCompressedOops

    //        0   8                                               (object header: mark)            0x0000000000000001 (non-biasable; age: 0)
    //        8   4                                               (object header: class)           0x000000001bee3850
    //        16   4   com.kq.memory.analysis.entity.IntegerEntity IntegerReference.integerEntity   null

    // -XX:-UseCompressedOops 关闭指针压缩 都是8

    //        0   8                                               (object header: mark)            0x0000000000000001 (non-biasable; age: 0)
    //        8   8                                               (object header: class)           0x000000001bee3850
    //        16   8   com.kq.memory.analysis.entity.IntegerEntity IntegerReference.integerEntity   null


    public static void main(String[] args) {

        IntegerReference integerReference = new IntegerReference();
        // 8(mark)+4(class) +4(IntegerReference.integerEntity)
        System.out.println(ClassLayout.parseInstance(integerReference).toPrintable()); // 16 (IntegerReference.integerEntity=4)

        Student student = new Student();
        integerReference.setStudent(student);
        // 8(mark)+4(class) +4(IntegerReference.integerEntity)
        System.out.println(ClassLayout.parseInstance(integerReference).toPrintable());

        student.setId(1L);
        student.setName("kong");
        student.setAge(18);
        student.setAddress("zhejiang");
        // 8(mark)+4(class) +4(IntegerReference.integerEntity)
        System.out.println(ClassLayout.parseInstance(integerReference).toPrintable());

        // 结论，默认不管对setStudent赋值不赋值 都是4(指针压缩)
    }

}
