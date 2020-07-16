package com.zhu.interview.entity;

/**
 * @Author Zhu
 * @Date 2020/7/10 21:21
 */
public class Person {

    private Integer id;

    private String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {

        return 1;
    }

//    @Override
//    public boolean equals(Object obj) {
//        return true;
//    }


    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
