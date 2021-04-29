package com.kq.memory.util;

import org.openjdk.jol.vm.VM;
import org.openjdk.jol.vm.VirtualMachine;

/**
 * @author kq
 * @date 2021-04-29 15:07
 * @since 2020-0630
 */
public class MarkUtl {

    /**
     * 这里都以64的虚拟机
     * @param instance
     * @return
     */
    public static long getMark(Object instance) {
        VirtualMachine vm = VM.current();
        long mark = vm.getLong(instance, 0);
        return mark;
    }

}
