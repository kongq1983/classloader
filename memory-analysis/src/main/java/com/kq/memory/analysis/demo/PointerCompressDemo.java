package com.kq.memory.analysis.demo;

/**
 * 指针压缩demo
 * -XX:+UseCompressedOops (open)
 * -XX:-UseCompressedOops (close)
 * @author kq
 * @date 2021-04-13 9:33
 * @since 2020-0630
 */
public class PointerCompressDemo {

//     为什么要进行指针压缩？
//     1.在64位平台的HotSpot中使用32位指针，内存使用会多出1.5倍左右，使用较大指针在主内存和缓存之间移动数据，占用较大宽带，同时GC也会承受较大压力
//     2.为了减少64位平台下内存的消耗，启用指针压缩功能
//     3.在jvm中，32位地址表示4G个对象的指针，在4G-32G堆内存范围内，可以通过编码、解码方式进行优化，使得jvm可以支持更大的内存配置
//     4.堆内存小于4G时，不需要启用指针压缩，jvm会直接去除高32位地址，即使用低虚拟地址空间
//     5.堆内存大于32G时，压缩指针会失效，会强制使用64位(即8字节)来对java对象寻址，这就会出现1的问题，所以堆内存不要大于32G为好


}
