package cn.shaoxiongdu;

import java.util.Objects;

/**
 * ClassName : Student
 * (c)CopyRight 2021/4/12 All rights reserved to ShaoxiongDu<shaoxiongdu.dev@gmail.com>
 */
public class Student {

    private String name;



    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
