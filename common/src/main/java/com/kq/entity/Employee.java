package com.kq.entity;

/**
 * Employee
 *
 * @author kq
 * @date 2019-12-02
 */
public class Employee {

    private Long id;
    private String name;

    public void showMessage(){
        System.out.println("---  Employee id="+id+" name="+name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id='").append(id).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
