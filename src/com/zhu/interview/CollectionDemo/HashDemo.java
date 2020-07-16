package com.zhu.interview.CollectionDemo;

import com.zhu.interview.entity.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author Zhu
 * @Date 2020/7/10 21:13
 */
public class HashDemo {
    public static void main(String[] args) {

        Map<Object, Object> map = new HashMap<>();
//
//
//        map.put("AA", "aaaaaaa");
//        map.put("AA", "bbbbbbb");
//


        Person person = new Person(1, "aa");
        Person person1 = new Person(1, "aa");

//        System.out.println(person.hashCode());
//        System.out.println(person1.hashCode());


        map.put(person, person.getName());
//        map.put(person1, person1.getName());
//        map.put(person, person.getName());
//        map.put(person1, person1.getName());
//        map.put(person, person.getName());
//        map.put(person1, person1.getName());
//        map.put(person, person.getName());
//        map.put(person1, person1.getName());
//        map.put(person, person.getName());
//        map.put(person1, person1.getName());
//        map.put(person, person.getName());
//        map.put(person1, person1.getName());
//        map.put(person, person.getName());

//        System.out.println(map.size());
//        Set<Map.Entry<Object, Object>> entries = map.entrySet();
//        System.out.println(entries.size());
//
//        System.out.println(entries.size());
//        System.out.println(map.size());


    }
}
