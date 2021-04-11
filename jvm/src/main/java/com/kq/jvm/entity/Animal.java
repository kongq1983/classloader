package com.kq.jvm.entity;

/**
 * Animal
 *
 * @author kq
 * @date 2021/4/11 22:58
 * @since 1.0.0
 */
public class Animal {

    private long id;
    private Long pid;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
//        return "Animal{" +
//                "id=" + id +
//                ", pid=" + pid +
//                ", name='" + name + '\'' +
//                '}';
        final StringBuilder sb = new StringBuilder("Animal{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
